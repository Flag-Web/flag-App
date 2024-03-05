package com.example.myflags;


import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button connexion=null;
    Mabase database;
    SQLiteDatabase dib;

    public boolean isCameroonian(String phone) {
        String cameroonRegex ="^6[5-9][0-9]{7}$";
        Pattern pattern=Pattern.compile(cameroonRegex);
        Matcher matcher= pattern.matcher(phone);
        return matcher.matches();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences=getSharedPreferences("MyPref",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        SharedPreferences sharedPreferences1=getSharedPreferences("filiere",MODE_PRIVATE);
        SharedPreferences.Editor editor1=sharedPreferences1.edit();
        SharedPreferences sharedPreferences2=getSharedPreferences("nivo",MODE_PRIVATE);
        SharedPreferences.Editor editor2=sharedPreferences2.edit();
        SharedPreferences sharedPreferences3=getSharedPreferences("langue",MODE_PRIVATE);
        SharedPreferences.Editor editor3=sharedPreferences3.edit();
        //SharedPreferences sharedPreferences1=getSharedPreferences("filiere",MODE_PRIVATE);
        //SharedPreferences.Editor editor1=sharedPreferences1.edit();
        database=new Mabase(this);
        /*instances firebase et firestore*/
        FirebaseFirestore db =FirebaseFirestore.getInstance();
        CollectionReference collection1=db.collection("utilisateurs");

        /*récupération des éléments du formulaire*/
        connexion=findViewById(R.id.connexion);
        EditText editnum=findViewById(R.id.numero);
        Spinner spinfil=findViewById(R.id.filiere);
        Spinner spinniv=findViewById(R.id.nivo);
        Spinner spinlang=findViewById(R.id.langue);

        /*en cas de click*/
        View.OnClickListener conListener= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*objet de type map qui contiendra les informations identifiant l'utilisateur dans la base de donnée*/
                Map<String,Object> utilisateur=new HashMap<>();

                String numero = editnum.getText().toString();
                String filiere=spinfil.getSelectedItem().toString();
                String nivo=spinniv.getSelectedItem().toString();
                String langue=spinlang.getSelectedItem().toString();
                if(numero.isEmpty()||numero.length()<9){
                    Toast.makeText(MainActivity.this, "remplissez le numero de téléphone", Toast.LENGTH_SHORT).show();
                    editnum.setError("remplissez le numero de telephone");
                    editnum.requestFocus();
                    return;
                }
                if(numero.equals("694080521")){
                    editnum.setError("pour toi c'est 5000fcfa");
                    Toast.makeText(MainActivity.this, "pour toi c'est 5000fcfa", Toast.LENGTH_SHORT).show();
                    editnum.requestFocus();
                    return;
                }
                if(isCameroonian(numero)){
                    Toast.makeText(MainActivity.this, "Numero valide\n debut de l'authentification", Toast.LENGTH_SHORT).show();
                    Intent intent2=new Intent(MainActivity.this,principalActivity.class);

                    utilisateur.put("numero",numero);
                    utilisateur.put("filiere",filiere);
                    utilisateur.put("niveau",nivo);
                    utilisateur.put("langue",langue);

                    DocumentReference docref=collection1.document(numero);
                    docref.get().addOnCompleteListener(task -> {
                        if(task.isSuccessful()){
                            DocumentSnapshot document =task.getResult();
                            if(document.exists()){
                                //utilisateur présent dans la base de donnée
                                Toast.makeText(MainActivity.this,"connexion",Toast.LENGTH_SHORT);
                                editor.putBoolean("isLoggedIn",true);
                                editor1.putString("filiere",filiere);
                                editor1.apply();
                                editor.apply();
                                editor2.putString("nivo",nivo);
                                editor2.apply();
                                editor3.putString("langue",langue);
                                editor3.apply();
                                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                intent2.putExtra("Exit",true);
                                startActivity(intent2);
                                finishAffinity();
                            }
                            else{
                                docref.set(utilisateur).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(MainActivity.this,"enregistrement",Toast.LENGTH_SHORT);
                                        editor.putBoolean("isLoggedIn",true);
                                        editor.apply();
                                        intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        intent2.putExtra("Exit",true);
                                        startActivity(intent2);
                                        finishAffinity();
                                    }
                                });
                            }
                        }
                        else{
                             Log.d("TAG","l'accès n'a pas donné");
                        }
                    });
                }
                else {
                    editnum.setError("numero invalide");
                    editnum.requestFocus();
                    Toast.makeText(MainActivity.this, "Numero invalide", Toast.LENGTH_SHORT).show();
                }
            }
        };
        /*on lie le bouton de connexion à son écouteur de click*/
        connexion.setOnClickListener(conListener);
    }
}