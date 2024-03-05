package com.example.myflags;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Onglet1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle saveInstanceState){
        View view= inflater.inflate(R.layout.fragment_un,container,false);
        //RecyclerView recyclerView=view.findViewById(R.id.listcour);
        TextView textView=view.findViewById(R.id.texte);
        TextView textView2=view.findViewById(R.id.texte2);

        /*AdaptCours adaptCours= new AdaptCours(cours);
        recyclerView.setAdapter(adaptCours);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));*/
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        /*CollectionReference coursRef=db.collection("cours");
        DocumentReference programRef=coursRef.document("programme");
        //Query query=programRef.whereEqualTo("id","prog");
        programRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String contenu=documentSnapshot.getString("contenu");
                textView.setText(contenu);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("TAG","Erreur lors de la récupération du document,e");
            }
        });*/

        afficher("Programme.txt",textView);
        afficher("Actu.txt",textView2);
        return view;
    }
    void afficher(String fichier,TextView textView){
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl("gs://my-flags.appspot.com");
        StorageReference fileRef = storageRef.child(fichier);

        try {
            final File localFile = File.createTempFile("file", "txt");
            fileRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    try {
                        FileInputStream fis = new FileInputStream(localFile);
                        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

                        StringBuilder sb = new StringBuilder();
                        String line;
                        while ((line = br.readLine()) != null) {
                            sb.append(line);
                            sb.append("\n");
                        }
                        br.close();
                        fis.close();
                        textView.setText(sb.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.e("Tag", "erreur de téléchargement", e);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
