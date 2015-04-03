package com.deportiva.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by David on 03/04/2015.
 */
public class BaseDatosOpenHelper extends SQLiteOpenHelper {
    String tablaUsuarios ="CREATE TABLE Usuarios(Id INTEGER PRIMARY KEY AUTOINCREMENT, User TEXT NOT NULL, Password TEXT NOT NULL)";

    public BaseDatosOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablaUsuarios);
        db.execSQL("INSERT INTO Usuarios(Id, User, Password) VALUES(1,'admin', '12345')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST Usuarios");
        db.execSQL(tablaUsuarios);
    }

    public boolean testCredentials(BaseDatosOpenHelper baseHelper,String user, String password){
        SQLiteDatabase db = baseHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT count(*)FROM Usuarios WHERE User='"+user+"' AND Password = '"+password+"'",null);

        if(cursor.getCount()<1){
            db.close();
            return false;
        }
        cursor.moveToFirst();
        if(cursor.getInt(0)!=1){
            db.close();
            return false;
        }
        db.close();
        return true;
    }
}