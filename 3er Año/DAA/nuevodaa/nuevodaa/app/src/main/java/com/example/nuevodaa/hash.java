package com.example.nuevodaa;

import java.util.Enumeration;
import java.util.Hashtable;

public class hash {
    Hashtable<Integer, String> tablaUsuarios = new Hashtable<Integer, String>();
    public static void añadirElemento(Hashtable<Integer, String> tablaUsuarios){
        tablaUsuarios.put(1,"Matias Egaña");
        tablaUsuarios.put(3,"Eric Jeltsch");
    }
    public static boolean buscarElemento(int contraseña, String nombre,Hashtable<Integer, String> tablaUsuarios){
        Enumeration<Integer> eI = tablaUsuarios.keys();
        Enumeration<String> eS = tablaUsuarios.elements();
        int contraseñaAux;
        String nombreAux;
        boolean buscador = false;
        do {
            contraseñaAux = (Integer)eI.nextElement();
            nombreAux = (String)eS.nextElement();
            if(nombreAux.equals(nombre) && contraseñaAux==contraseña){
                buscador = true;
            }
        }while(eI.hasMoreElements());
        if(buscador == true){
            return true;
        }
        else{
            return false;
        }
    }
}
