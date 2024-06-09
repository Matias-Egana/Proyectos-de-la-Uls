package com.example.nuevodaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class selecciondePreguntas extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionde_preguntas);
    }
    public void seleccionVF(View view){
        Intent i = new Intent(this, vf.class);
        startActivity(i);
        finish();

    }
    public void seleccionMultiple(View view){
        Intent i = new Intent(this, SeleccionMultiple.class);
        startActivity(i);
        finish();

    }
    public void seleccionRespuestaCorta(View view){
        Intent i = new Intent(this, RespuestaCorta.class);
        startActivity(i);
        finish();
    }
    public void login(View view){
        Intent i = new Intent(this, loginPrincipal.class);
        startActivity(i);
        finish();
    }
}