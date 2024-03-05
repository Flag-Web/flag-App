package com.example.myflags;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Onglet2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){
        View view= inflater.inflate(R.layout.fragment_deux,container,false);
        TextView textView=view.findViewById(R.id.texte);
        TextView textView2=view.findViewById(R.id.texte2);

        //TextView textView3=view.findViewById(R.id.texte3);
        Drawable back=getResources().getDrawable(R.drawable.bordures,getContext().getTheme());
        LinearLayout vie=view.findViewById(R.id.view3);
        afficher("Matière.txt",textView);
        afficher("Conseils.txt",textView2);
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl("gs://my-flags.appspot.com");
        StorageReference fileRef = storageRef.child("Liens.txt");
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
                            String htmlLink="<a href="+line+">"+line+"</a>";
                            sb.append(htmlLink);
                            sb.append("<br>");
                        }
                        br.close();
                        fis.close();
                        ViewGroup.LayoutParams layoutParams =new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        TextView textView1=new TextView(getContext());
                        textView1.setLayoutParams(layoutParams);
                        textView1.setText(Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY));
                        textView1.setBackground(back);
                        vie.addView(textView1);

                        textView1.setClickable(true);

                        textView1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String url=Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY).toString();
                                Intent intent=new Intent(getActivity(),WebActivity.class);
                                intent.putExtra("lienr",Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY).toString());
                                startActivity(intent);
                            }
                        });
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
