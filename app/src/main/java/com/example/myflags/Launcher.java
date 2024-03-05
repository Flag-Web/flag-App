package com.example.myflags;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myflags.Mabase;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;


public class Launcher extends AppCompatActivity {
    Mabase maBase;
    SQLiteDatabase database;
    Intent intent2;
    Intent intent;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        animateLogo();
        animateSlogan();

    }
        private void animateLogo(){
        ImageView logo=findViewById(R.id.logo);
        AnimationSet logoAnimation=(AnimationSet)AnimationUtils.loadAnimation(this,R.anim.bas_animation);
        logo.startAnimation(logoAnimation);
        simuleLoad();
        }
    private void animateSlogan(){
        TextView slogan=findViewById(R.id.slogan);
        AnimationSet sloganAnimation=(AnimationSet)AnimationUtils.loadAnimation(this,R.anim.haut_animation);
        slogan.startAnimation(sloganAnimation);
        simuleLoad();
    }
        private void simuleLoad(){
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                        String numero = getIntent().getStringExtra("numero");
                        String filiere = getIntent().getStringExtra("filiere");
                        String nivo = getIntent().getStringExtra("niveau");
                        String langue = getIntent().getStringExtra("langue");
                    SharedPreferences sharedPreferences=getSharedPreferences("MyPref",MODE_PRIVATE);
                    boolean isConnect=sharedPreferences.getBoolean("isLoggedIn",false);
                    if(isConnect){
                        intent = new Intent(Launcher.this, principalActivity.class);
                        startActivity(intent);
                        finish();

                    }
                    else {
                        Log.d("TAG","pas user");
                        intent = new Intent(Launcher.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            },3000);

        }

}