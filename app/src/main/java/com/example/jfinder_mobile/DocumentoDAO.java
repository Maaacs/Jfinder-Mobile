package com.example.jfinder_mobile;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DocumentoDAO {
    private SQLiteDatabase bancoDeDados; //objeto que faz a conexão com o banco de dados

    public DocumentoDAO(Context context) {
        this.bancoDeDados = (new BancoDeDados(context)).getWritableDatabase();//inicia conexão com o BD
    }



    public boolean addDocumento(Documento d) {
        try {
            String sqlCmd = "INSERT INTO Documentosdb VALUES ('" + d.getNumeroUnicoReferencia() + "', '" + d.getTipoDeDocumento() + "', '" + d.getInteressado()  + "', '" + d.getTipoDeArmazenamento() + "', '" + d.getDataArquivamento() + "', '" + d.getDescriçãoDocumento() + "', '" + d.getLocalCompletoDeArmazenamento() + "')";
            this.bancoDeDados.execSQL(sqlCmd);
            return true;
        } catch (SQLException e) {
            Log.e("JfinderBD", e.getMessage());
            return false;
        }
    }


    public Documento buscarDocumento(String numeroUnicoReferencia) {
        Documento doc = null;
        String sqlQuery = "SELECT * FROM Documentosdb WHERE numeroUnicoReferencia = '" + numeroUnicoReferencia + "'";
        Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

        if (cursor.moveToNext()) {
            doc = new Documento(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3) , cursor.getString(4), cursor.getString(5), (cursor.getString(6)));
        }
        cursor.close();
        return doc;
    }

    public void removerDocumento(String numeroUnicoReferencia) {
        try {
            String com = "DELETE FROM Documentosdb WHERE numeroUnicoReferencia = '" + numeroUnicoReferencia + "'";
            this.bancoDeDados.execSQL(com);
        } catch (SQLException e) {
            Log.e("JfinderBD", e.getMessage());
        }
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
