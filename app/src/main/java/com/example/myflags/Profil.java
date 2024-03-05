package com.example.myflags;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        Button modif=findViewById(R.id.modif);

        modif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Profil.this,modifinfo.class);
                startActivity(intent);
                finish();
            }
        });

        ImageButton fleche=findViewById(R.id.fleche);

        fleche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Profil.this,principalActivity.class);
                startActivity(intent);
                finish();
            }
        });
        TextView fil=findViewById(R.id.filiere);
        TextView niv=findViewById(R.id.nivo);
        TextView lang=findViewById(R.id.langue);
        SharedPreferences preferences1=getSharedPreferences("filiere",MODE_PRIVATE);
        SharedPreferences preferences2=getSharedPreferences("nivo",MODE_PRIVATE);
        SharedPreferences preferences3=getSharedPreferences("langue",MODE_PRIVATE);
        fil.setText(preferences1.getString("filiere",""));
        niv.setText(preferences2.getString("nivo",""));
        lang.setText(preferences3.getString("langue"," "));


    }
}