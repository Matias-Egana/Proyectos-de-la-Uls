package com.example.nuevodaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Hashtable;

public class loginPrincipal extends AppCompatActivity {
    EditText eNombre,eContraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_principal);
        eNombre = findViewById(R.id.txtNombrelogin);
        eContraseña = findViewById(R.id.txtContraseñalogin);
    }
    public void loginIngresar(View view){
        Hashtable<Integer, String> tablaUsuarios= new Hashtable<Integer, String>();
        hash.añadirElemento(tablaUsuarios);

        boolean verificador =false;
        if(eContraseña.getText().toString().isEmpty()||eNombre.getText().toString().isEmpty()) {
            Toast.makeText(this, "Error no pueden quedar Campos Vacios", Toast.LENGTH_LONG).show();
        }
        else{
            verificador = hash.buscarElemento(Integer.parseInt(eContraseña.getText().toString()), eNombre.getText().toString(), tablaUsuarios);
            if (verificador == true) {
                Toast.makeText(this, "Ingresado Correctamente", Toast.LENGTH_LONG).show();
                eContraseña.setText("");
                eNombre.setText("");
                Intent i = new Intent(this,MostrarRegistros.class);
                startActivity(i);
                finish();
            } else {
                Toast.makeText(this, "Error Nombre y/o Contraseña Incorrectos", Toast.LENGTH_LONG).show();
                eContraseña.setText("");
                eNombre.setText("");
            }
        }
    }
    public void volverLogin(View view){
        Intent i = new Intent(this,selecciondePreguntas.class);
        startActivity(i);
        finish();
    }
}