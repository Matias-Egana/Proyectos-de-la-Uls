package com.example.nuevodaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class RespuestaCorta extends AppCompatActivity {
    private TextView tnumero,tpregunta;
    private EditText erespuesta;
    private Button bs;
    ArrayList<respuestaCortaModelo> arrayRespuestaCorta;
    private int posActual = 0, puntajeActual = 0,intento = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta_corta);
        tnumero = findViewById(R.id.txtnumerorc);
        tpregunta = findViewById(R.id.txtPreguntarc);
        erespuesta = findViewById(R.id.editrc);
        bs = findViewById(R.id.botonSiguienterc);
        arrayRespuestaCorta = new ArrayList<>();
        agregarrespuestacorta(arrayRespuestaCorta);
        setVistarc(posActual);
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(erespuesta.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Error debe ingresar una respuesta",Toast.LENGTH_LONG).show();
                }
                else{
                    if(erespuesta.getText().toString().equalsIgnoreCase(arrayRespuestaCorta.get(posActual).getRespuestaCorta().trim())){
                        erespuesta.setText("");
                        puntajeActual++;
                    }
                    erespuesta.setText("");
                    intento++;
                    posActual++;
                    setVistarc(posActual);
                }
            }
        });
    }
    private void mostrarPuntaje(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View bottonSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.puntaje,(LinearLayout)findViewById(R.id.puntajeLayout));
        TextView tpuntaje = bottonSheetView.findViewById(R.id.txtIngrese);
        Button bregistrar = bottonSheetView.findViewById(R.id.bRegistar);
        tpuntaje.setText("Tu puntaje es:\n"+puntajeActual+"/3");
        bregistrar.setOnClickListener(v -> {
            sheetRegistro();
        });
       bottomSheetDialog.setCancelable(false);
       bottomSheetDialog.setContentView(bottonSheetView);
       bottomSheetDialog.show();
    }
     public void sheetRegistro(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View bottonSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.registro,(LinearLayout)findViewById(R.id.registroLayout));
        Button bregistro = bottonSheetView.findViewById(R.id.bRegistrar);
        EditText eNombre,eApellido;
        eNombre =  bottonSheetView.findViewById(R.id.editNombre);
        eApellido  =  bottonSheetView.findViewById(R.id.editApellido);
        bregistro.setOnClickListener(v -> {
               //     Toast.makeText(getApplicationContext(), "presione el boton", Toast.LENGTH_LONG).show();
                        Sqlite miBase = new Sqlite(getApplicationContext(),"admin",null,1);
                        SQLiteDatabase db = miBase.getWritableDatabase();
                        ContentValues cv = new ContentValues();
                        cv.put("Nombre",eNombre.getText().toString());
                        cv.put("Apellido",eApellido.getText().toString());
                        cv.put("Tpregunta","Respuesta Corta");
                        cv.put("Puntaje",puntajeActual);
                        db.insert("alumnos",null,cv);

                        db.close();
                        eNombre.setText("");
                        eApellido.setText("");
                        Toast.makeText(getApplicationContext(), "Registrado con exito", Toast.LENGTH_LONG).show();
                        bottomSheetDialog.dismiss();
                        Intent i = new Intent(getApplicationContext(),selecciondePreguntas.class);
                        startActivity(i);
                        finish();
            });
            bottomSheetDialog.setCancelable(false);
            bottomSheetDialog.setContentView(bottonSheetView);
            bottomSheetDialog.show();
    }
    private void setVistarc(int posActual) {
        if (intento <= 3) {
            tnumero.setText("Número de pregunta: " + intento + "/3");
            tpregunta.setText(arrayRespuestaCorta.get(posActual).getPregunta());
        }
        else{
            mostrarPuntaje();
        }
    }
    private void agregarrespuestacorta(ArrayList<respuestaCortaModelo> arrayRespuestaCorta) {
        arrayRespuestaCorta.add(new respuestaCortaModelo("¿Cual es la capital de alemania?","Berlin"));
        arrayRespuestaCorta.add(new respuestaCortaModelo("¿Cual es la capital de mexico?","Ciudad de mexico"));
        arrayRespuestaCorta.add(new respuestaCortaModelo("¿Cual es la capital de chile?","Santiago"));
    }
}