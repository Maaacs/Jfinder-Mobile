package com.example.jfinder_mobile;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DocumentoDAO {
    private SQLiteDatabase bancoDeDados; //objeto que faz a conexão com o banco de dados

    public DocumentoDAO(Context context) {
        this.bancoDeDados = (new BancoDeDados(context)).getWritableDatabase();//inicia conexão com o BD
    }




    public ArrayList<Documento> todosDocumentos() {
        try {
            ArrayList<Documento> listaDocumentos = new ArrayList<Documento>();
            Documento d;
            String sqlQuery = "SELECT * FROM Documentosdb";
            Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

            while (cursor.moveToNext()) {
                d = new Documento(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
                listaDocumentos.add(d);
            }
            cursor.close();
            return listaDocumentos;
        } catch (Exception e) {
            return null;
        }
    }


}
