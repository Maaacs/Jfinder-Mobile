package com.example.jfinder_mobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class UsuarioDAO {
    private SQLiteDatabase bancoDeDados; //objeto que faz a conexão com o banco de dados

    public UsuarioDAO(Context context) {
        this.bancoDeDados = (new BancoDeDados(context)).getWritableDatabase();
        //abre conexão com o BD
    }



    public Usuario buscarUsuario(String cpf) {
        Usuario usr = null;
        String sqlQuery = "SELECT * FROM Userdetails WHERE cpf = '" + cpf + "'";
        Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

        if (cursor.moveToNext()) {
            usr = new Usuario(cursor.getString(0), cursor.getString(1), cursor.getString(2),(cursor.getString(3)));
        }
        cursor.close();
        return usr;
    }


    public boolean addUsuario(Usuario p) {
        try {
            String sqlCmd = "INSERT INTO Userdetails VALUES ('" + p.getPrimeiroNome() + "', '" + p.getUltimoNome() + "', '" + p.getCPF() + "', '" + p.getCargo() + "')";
            this.bancoDeDados.execSQL(sqlCmd);
            return true;
        } catch (SQLException e) {
            Log.e("JfinderBD", e.getMessage());
            return false;
        }
    }

    public ArrayList<Usuario> todosUsuarios() {

        try {
            ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
            Usuario p;
            String sqlQuery = "SELECT * FROM Userdetails";
            Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

            while (cursor.moveToNext()) {
                p = new Usuario(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                listaUsuarios.add(p);
            }
            cursor.close();
            return listaUsuarios;
        } catch (Exception e) {
            return null;
        }
    }


    public void removerUsuario(String cpf) {
        try {
            String com = "DELETE FROM Userdetails WHERE cpf = '" + cpf + "'";
            this.bancoDeDados.execSQL(com);
        } catch (SQLException e) {
            Log.e("JfinderBD", e.getMessage());
        }
    }


}
