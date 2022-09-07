package com.example.jfinder_mobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

public class BancoDeDados extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Jfinder.db";


    private static final String SQL_CREATE_TABLE_USER = "CREATE TABLE Usuariosdb (nome TEXT, sobrenome TEXT, cpf TEXT primary key, cargo TEXT)";
    private static final String SQL_POPULATE_TABLES_USER = "INSERT INTO Usuariosdb VALUES ('Eronildo', 'Braga', '90238213256', 'Professor')";
    private static final String SQL_POPULATE2_TABLES_USER = "INSERT INTO Usuariosdb VALUES ('Marcos', 'Junior', '8233217156', 'Aluno')";
    private static final String SQL_DELETE_TABLE_USER = "DROP TABLE IF EXISTS Usuariosdb";

    private static final String SQL_CREATE_TABLE_DOC = "CREATE TABLE Documentosdb (numeroUnicoReferencia TEXT primary key, tipoDeDocumento TEXT, interessado TEXT , tipoDeArmazenamento TEXT, dataArquivamento TEXT, localCompletoDeArmazenamento TEXT, descriçãoDocumento TEXT)";
    private static final String SQL_POPULATE_TABLE_DOC = "INSERT INTO Documentosdb VALUES ('45891', 'Relatório Individual de Trabalho', 'Professor', 'Fisico' , '10/08/2022' , 'Armário 4, Gaveta 2, Pasta 1', 'Documento referente à relatório individual de professor.' )";
    private static final String SQL_POPULATE2_TABLE_DOC = "INSERT INTO Documentosdb VALUES ('55192', 'Portaria dos órgãos superiores referenciando integrantes do instituto', 'Professor', 'Fisico' , '25/01/2022' , 'Armário 4, Gaveta 1, Pasta 1', 'CONSIDERANDO os termos do Processo SEI nº 23105.003202/2022-54, protocolado em 25/01/2022, que trata da promoção funcional do servidor ERONILDO BRAGA, e o Termo de Aprovação que comprova a aprovação dos RITs emitido pelo Chefe do Departamento de Engenharia Agrícola e Solos DEAS/FCA/UFAM em 06/05/2022.' )";

    private static final String SQL_DELETE_TABLE_DOC = "DROP TABLE IF EXISTS Documentosdb";

    public BancoDeDados(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_USER);
        db.execSQL(SQL_POPULATE_TABLES_USER);
        db.execSQL(SQL_POPULATE2_TABLES_USER);
        db.execSQL(SQL_CREATE_TABLE_DOC);
        db.execSQL(SQL_POPULATE2_TABLE_DOC);
        db.execSQL(SQL_POPULATE_TABLE_DOC);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLE_USER);
        db.execSQL(SQL_DELETE_TABLE_DOC);
        onCreate(db);
    }

    public boolean Login(String username, String password){
        String user = "user";
        String pass = "123";
        if(username.equals(user) && password.equals(pass)){
            return true;
        }else{
            return false;
        }
    }


}
