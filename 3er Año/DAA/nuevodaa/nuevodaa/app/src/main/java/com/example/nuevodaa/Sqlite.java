package com.example.nuevodaa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Sqlite extends SQLiteOpenHelper {
    String tabla1 ="CREATE TABLE alumnos(Id INTEGER PRIMARY KEY AUTOINCREMENT ,Nombre Text,Apellido Text,Tpregunta Text,Puntaje Integer)";

    public Sqlite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(tabla1);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists alumnos");
            db.execSQL(tabla1);
        }
}
