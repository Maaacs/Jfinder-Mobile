package com.example.jfinder_mobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDados extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Jfinder.db";


    private static final String SQL_CREATE_TABLE_USER = "CREATE TABLE Usuariosdb (nome TEXT, sobrenome TEXT, cpf TEXT primary key, cargo TEXT)";
    private static final String SQL_POPULATE_TABLES = "INSERT INTO Usuariosdb VALUES ('Jonas', 'Lima', '90238213256', 'Professor')";
    private static final String SQL_DELETE_TABLE_USER = "DROP TABLE IF EXISTS Usuariosdb";

    private static final String SQL_CREATE_TABLE_DOC = "CREATE TABLE Documentosdb (numeroUnicoReferencia TEXT primary key, tipoDeDocumento TEXT, interessado TEXT , " +
            "tipoDeArmazenamento TEXT, dataArquivamento TEXT, descriçãoDocumento TEXT, localCompletoDeArmazenamento TEXT)";
    private static final String SQL_POPULATE_TABLE_DOC = "INSERT INTO Documentosdb VALUES ('444', 'Relatório Individual de Trabalho', 'Professor', 'Fisico' , '10/08/2022' , 'Documento referente à relatório individual de professor' , 'Armário 4, Gaveta 2, Pasta 1')";
    private static final String SQL_DELETE_TABLE_DOC = "DROP TABLE IF EXISTS Documentosdb";

    public BancoDeDados(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_USER);
        db.execSQL(SQL_POPULATE_TABLES);
        db.execSQL(SQL_CREATE_TABLE_DOC);
        db.execSQL(SQL_POPULATE_TABLE_DOC);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLE_USER);
        db.execSQL(SQL_DELETE_TABLE_DOC);
        onCreate(db);
    }

}
