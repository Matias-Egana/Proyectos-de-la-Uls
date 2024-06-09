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

public class SeleccionMultiple extends AppCompatActivity {
    private TextView tnumero,tpregunta;
    private Button ba,bb,bc;
    ArrayList<seleccionModelo> arrayseleccion;
    private int posActual = 0, puntajeActual = 0,intento = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_multiple);
        tnumero = findViewById(R.id.numerotitulo);
        tpregunta = findViewById(R.id.txtPregunta);
        ba = findViewById(R.id.bA);
        bb = findViewById(R.id.bB);
        bc = findViewById(R.id.bC);
        arrayseleccion = new ArrayList<>();
        agregarseleccion(arrayseleccion);
        setVistaselec(posActual);
        ba.setOnClickListener(v -> {
            if(arrayseleccion.get(posActual).getRespuesta().trim().toLowerCase().equals(ba.getText().toString())){
                puntajeActual++;
            }
            intento++;
            posActual++;
            setVistaselec(posActual);
        });
        bb.setOnClickListener(v -> {
            if(arrayseleccion.get(posActual).getRespuesta().trim().toLowerCase().equals(bb.getText().toString())){
                puntajeActual++;
            }
            intento++;
            posActual++;
            setVistaselec(posActual);
        });
        bc.setOnClickListener(v -> {
            if(arrayseleccion.get(posActual).getRespuesta().trim().toLowerCase().equals(bc.getText().toString())){
                puntajeActual++;
            }
            intento++;
            posActual++;
            setVistaselec(posActual);
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
          //  Toast.makeText(getApplicationContext(), "presione el boton", Toast.LENGTH_LONG).show();
            Sqlite miBase = new Sqlite(getApplicationContext(),"admin",null,1);
            SQLiteDatabase db = miBase.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("Nombre",eNombre.getText().toString());
            cv.put("Apellido",eApellido.getText().toString());
            cv.put("Tpregunta","Selección Multiple");
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
    private void setVistaselec(int posActual) {
        if(intento <= 3){
            tnumero.setText("Número de pregunta: "+intento+"/3");
            tpregunta.setText(arrayseleccion.get(posActual).getPregunta());
            ba.setText(arrayseleccion.get(posActual).getOpcionA());
            bb.setText(arrayseleccion.get(posActual).getOpcionB());
            bc.setText(arrayseleccion.get(posActual).getOpcionC());
        }
        else{
            mostrarPuntaje();
        }
    }

    private void agregarseleccion(ArrayList<seleccionModelo> arrayseleccion) {
        arrayseleccion.add(new seleccionModelo("4","¿2+2?","3","4","2"));
        arrayseleccion.add(new seleccionModelo("x^2+4x+4","¿(x+2)^2?","x^2+4x+4","x^2+2^2","2x"));
        arrayseleccion.add(new seleccionModelo("2x","¿x+x?","x^2","2y","2x"));
    }
}