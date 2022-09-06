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

    public boolean alterarDocumento(String tipoDeDocumento, String interessado, String tipoDeArmazenamento, String dataArquivamento, String localCompletoDeArmazenamento, String descriçãoDocumento, String numeroUnicoReferencia) {
        try {
            String cmd = "UPDATE Documentosdb SET tipoDeDocumento ='" + tipoDeDocumento + "', interessado = '" + interessado + "', tipoDeArmazenamento = '" + tipoDeArmazenamento + "', dataArquivamento = '" + dataArquivamento + "', localCompletoDeArmazenamento = '" + localCompletoDeArmazenamento + "', descriçãoDocumento = '" + descriçãoDocumento + "' WHERE numeroUnicoReferencia = '" + numeroUnicoReferencia + "'";
            this.bancoDeDados.execSQL(cmd);
            return true;
        } catch (SQLException e) {
            Log.e("JfinderBD", e.getMessage());
            return false;
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

    public ArrayList<Documento> buscarPorAno(String ano){

        try {
            ArrayList<Documento> listaDocumentos = new ArrayList<Documento>();
            Documento d;
            String sqlQuery = "SELECT * FROM Documentosdb WHERE dataArquivamento LIKE '%"+ ano +"' ";

            Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

            while (cursor.moveToNext()) {
                d = new Documento(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
                listaDocumentos.add(d);
            }
            cursor.close();
            return listaDocumentos;

        }catch (Exception e){
            return null;
        }
    }

    public ArrayList<Documento> buscarPorTipo(String tip){

        try {
            ArrayList<Documento> listaDocumentos = new ArrayList<Documento>();
            Documento d;
            String sqlQuery = "SELECT * FROM Documentosdb WHERE tipoDeDocumento LIKE '%"+ tip +"%' ";

            Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

            while (cursor.moveToNext()) {
                d = new Documento(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
                listaDocumentos.add(d);
            }
            cursor.close();
            return listaDocumentos;


        }catch (Exception e){
            System.out.println("aff");
            return null;
        }
    }


    public ArrayList<Documento> buscarPorInteressado(String inte){

        try {
            ArrayList<Documento> listaDocumentos = new ArrayList<Documento>();
            Documento d;
            String sqlQuery = "SELECT * FROM Documentosdb WHERE interessado LIKE '%"+ inte +"%' ";

            Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

            while (cursor.moveToNext()) {
                d = new Documento(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
                listaDocumentos.add(d);
            }
            cursor.close();
            return listaDocumentos;


        }catch (Exception e){
            return null;
        }

    }

    public ArrayList<Documento> buscarPorPalavraChave(String Pchave){

        try {
            ArrayList<Documento> listaDocumentos = new ArrayList<Documento>();
            Documento d;
            String sqlQuery = "SELECT * FROM Documentosdb WHERE descriçãoDocumento LIKE '%"+ Pchave +"%' ";

            Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

            while (cursor.moveToNext()) {
                d = new Documento(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
                listaDocumentos.add(d);
            }
            cursor.close();
            return listaDocumentos;


        }catch (Exception exception){
            return null;
        }

    }

    public ArrayList<Documento> buscarDocumentoLista(String numeroUnicoReferencia) {
        Documento doc = null;
        ArrayList<Documento> documentoLista = new ArrayList<Documento>();
        String sqlQuery = "SELECT * FROM Documentosdb WHERE numeroUnicoReferencia = '" + numeroUnicoReferencia + "'";
        Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

        if (cursor.moveToNext()) {
            doc = new Documento(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3) , cursor.getString(4), cursor.getString(5), (cursor.getString(6)));
            documentoLista.add(doc);
        }
        cursor.close();
        return documentoLista;
    }




}
