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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class vf extends AppCompatActivity {
    ArrayList<vfModelo> arrayvf;
    private TextView tnumero,tpregunta;
    private Button bs;
    private RadioButton bv,bf;
    private int posActual = 0, puntajeActual = 0,intento = 1;
    ArrayList <String> arregloRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vf);
        tnumero = findViewById(R.id.txtnumerovf);
        tpregunta = findViewById(R.id.txtPreguntavf);
        bf = findViewById(R.id.radioFalso);
        bv = findViewById(R.id.radioVerdadero);
        bs = findViewById(R.id.botonSiguientevf);
        arrayvf = new ArrayList<>();
        agregarvf(arrayvf);
        setVistavf(posActual);
        bs.setOnClickListener(v -> {
            boolean respuestacorrecta;
            if(bv.isChecked()){
                respuestacorrecta = true;
                if(respuestacorrecta == arrayvf.get(posActual).isVerdadero()){
                    puntajeActual++;
                    intento++;
                    posActual++;
                    setVistavf(posActual);
                }
                else{
                    intento++;
                    posActual++;
                    setVistavf(posActual);
                }
            }

            if(bf.isChecked()){
                 respuestacorrecta= false;
                if(respuestacorrecta == arrayvf.get(posActual).isVerdadero()){
                    puntajeActual++;
                    intento++;
                    posActual++;
                    setVistavf(posActual);
                }
                else {
                intento++;
                posActual++;
                setVistavf(posActual);
                }
            }
            if(!bv.isChecked() && !bf.isChecked()){
                Toast.makeText(getApplicationContext(),"Error selecciones una opcion antes del presionar siguiente",Toast.LENGTH_LONG).show();
                setVistavf(posActual);
            }
        });

    }

    private void setVistavf(int posActual) {
        if(intento <= 3){
            tnumero.setText("Número de pregunta: "+intento+"/3");
            tpregunta.setText(arrayvf.get(posActual).getPregunta());
        }
        else{
            mostrarPuntaje();
        }
    }
    public void agregarvf(ArrayList<vfModelo> arrayvf){
        arrayvf.add(new vfModelo("El descubrimiento de america fue el año 1492",true));
        arrayvf.add(new vfModelo("El ingles proviene del latin",false));
        arrayvf.add(new vfModelo("El pais con más habitantes es china",true));

    }

    private void mostrarPuntaje() {
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
                //    Toast.makeText(getApplicationContext(), "presione el boton", Toast.LENGTH_LONG).show();
                        Sqlite miBase = new Sqlite(getApplicationContext(),"admin",null,1);
                        SQLiteDatabase db = miBase.getWritableDatabase();
                        ContentValues cv = new ContentValues();
                        cv.put("Nombre",eNombre.getText().toString());
                        cv.put("Apellido",eApellido.getText().toString());
                        cv.put("Tpregunta","Verdadero o falso");
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

}
