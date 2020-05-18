package com.example.batapp;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ConectorBD {
    static final String NOMBRE_BD = "BatApp";
    private VillanosSQLiteHelper dbHelper;
    private SQLiteDatabase db;

    public ConectorBD (Context ctx){
        dbHelper = new VillanosSQLiteHelper(ctx, NOMBRE_BD, null, 1);
    }

    public ConectorBD abrir() throws SQLException{
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void cerrar(){
        if(db!=null) db.close();
    }

    public void insertarVillano(String alias, String nombre, String apellido){
        String consultaSQL = "INSERT INTO Villanos VALUES('"+alias+"','"+nombre+"','"+apellido+"')";
        db.execSQL(consultaSQL);
    }

    public Cursor listarVillanos(){
        return db.rawQuery("SELECT * FROM Villanos", null);
    }
}
