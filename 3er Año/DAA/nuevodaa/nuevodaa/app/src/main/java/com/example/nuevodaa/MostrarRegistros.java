package com.example.nuevodaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MostrarRegistros extends AppCompatActivity {
    String arreglo[];ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_registros);
        MostrarDatos();
        lista = (ListView)findViewById(R.id.listView);
    }
    public void MostrarDatos(){
       Sqlite mibaseHelper = new Sqlite(this,"admin",null,1);
        SQLiteDatabase db = mibaseHelper.getReadableDatabase();
        Cursor c = db.rawQuery("select * from alumnos",null);
        int cantidad = c.getCount();//cantidad de regitros
        arreglo = new String[cantidad];
        int i=0;
        if(c.moveToFirst()){
            do{
                String linea = c.getInt(0)+". Nombre: "+c.getString(1)+" Apellido: "+c.getString(2)+
                        " | Tipo de pregunta: "+c.getString(3)+" | Puntaje: "+c.getInt(4)+"/3";
                arreglo[i] = linea;
                i++;
            }
            while(c.moveToNext());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arreglo);
        ListView listado = (ListView)findViewById(R.id.listView);
        listado.setAdapter(adapter);

    }
    public void MostrarDatosVolver(View view){
        Intent i = new Intent(this,selecciondePreguntas.class);startActivity(i);finish();
    }
}