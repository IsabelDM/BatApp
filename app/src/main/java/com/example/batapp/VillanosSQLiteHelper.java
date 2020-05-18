package com.example.batapp;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VillanosSQLiteHelper extends SQLiteOpenHelper {
    String sqlCrearTabla = "CREATE TABLE Villanos(alias TEXT, nombre TEXT, apellido TEXT)";
    public VillanosSQLiteHelper(Context contexto, String nombreBD, SQLiteDatabase.CursorFactory factory,
                                int versionBD){
        super(contexto,nombreBD,factory,versionBD);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        try{
            db.execSQL(sqlCrearTabla);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva){
        try{
            db.execSQL("DROP TABLE IF EXISTS Villanos");
            db.execSQL(sqlCrearTabla);
        } catch ( SQLException e){
            e.printStackTrace();
        }
    }
}
