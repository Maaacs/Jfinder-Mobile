package com.example.jfinder_mobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BancoDeDados extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Jfinder.db";


    private static final String SQL_CREATE_TABLES = "CREATE TABLE Userdetails (nome TEXT primary key, sobrenome TEXT, cpf TEXT, cargo TEXT)";
    private static final String SQL_POPULATE_TABLES = "INSERT INTO Userdetails VALUES ('Spider', 'Man', '90238213', 'Heroi')";
    private static final String SQL_DELETE_TABLES = "DROP TABLE IF EXISTS Userdetails";

    public BancoDeDados(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLES);
        db.execSQL(SQL_POPULATE_TABLES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLES);
        onCreate(db);
    }

}
