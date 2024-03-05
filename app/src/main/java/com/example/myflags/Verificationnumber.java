package com.example.myflags;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;

public class Verificationnumber extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificationnumber);

        String TAG="Verificationnumber";
        Button envoyer=findViewById(R.id.envoyer);
        ImageView log=findViewById(R.id.log);
        Intent intent=getIntent();
        String numero=getIntent().getStringExtra("numero");
        String filiere=getIntent().getStringExtra("filiere");
        String nivo=getIntent().getStringExtra("nivo");
        String langue=getIntent().getStringExtra("langue");
        Map<String,Object> utilisateur=new HashMap<>();

        envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }

    }
