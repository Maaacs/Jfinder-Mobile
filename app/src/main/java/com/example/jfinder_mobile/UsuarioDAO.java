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
        this.bancoDeDados = (new BancoDeDados(context)).getWritableDatabase();//inicia conexão com o BD
    }



    public boolean addUsuario(Usuario p) {
        try {
            String sqlCmd = "INSERT INTO Usuariosdb VALUES ('" + p.getPrimeiroNome() + "', '" + p.getUltimoNome() + "', '" + p.getCPF() + "', '" + p.getCargo() + "')";
            this.bancoDeDados.execSQL(sqlCmd);
            return true;
        } catch (SQLException e) {
            Log.e("JfinderBD", e.getMessage());
            return false;
        }
    }


    public Usuario buscarUsuario(String cpf) {
        Usuario usr = null;
        String sqlQuery = "SELECT * FROM Usuariosdb WHERE cpf = '" + cpf + "'";
        Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

        if (cursor.moveToNext()) {
            usr = new Usuario(cursor.getString(0), cursor.getString(1), cursor.getString(2),(cursor.getString(3)));
        }
        cursor.close();
        return usr;
    }


    public void removerUsuario(String cpf) {
        try {
            String com = "DELETE FROM Usuariosdb WHERE cpf = '" + cpf + "'";
            this.bancoDeDados.execSQL(com);
        } catch (SQLException e) {
            Log.e("JfinderBD", e.getMessage());
        }
    }

    public boolean alterarUsuario(String nome, String sobrenome, String cargo, String cpf) {
        try {
            String cmd = "UPDATE Usuariosdb SET nome ='" + nome + "', sobrenome = '" + sobrenome + "', cargo = '" + cargo + "' WHERE cpf = '" + cpf + "'";
            this.bancoDeDados.execSQL(cmd);
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
            String sqlQuery = "SELECT * FROM Usuariosdb";
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


    public ArrayList<Usuario> buscarPorNome(String nome){

        try {
            ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
            Usuario u;
            String sqlQuery = "SELECT * FROM Usuariosdb WHERE nome LIKE '%"+ nome +"%' ";

            Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

            while (cursor.moveToNext()) {
                u = new Usuario(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                listaUsuarios.add(u);
            }
            cursor.close();
            return listaUsuarios;

        }catch (Exception e){
            return null;
        }
    }

    public ArrayList<Usuario> buscarPorSobrenome(String sobre){

        try {
            ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
            Usuario u;
            String sqlQuery = "SELECT * FROM Usuariosdb WHERE sobrenome LIKE '%"+ sobre +"%' ";

            Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

            while (cursor.moveToNext()) {
                u = new Usuario(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                listaUsuarios.add(u);
            }
            cursor.close();
            return listaUsuarios;

        }catch (Exception e){
            return null;
        }
    }

    public ArrayList<Usuario> buscarPorCargo(String carg){

        try {
            ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
            Usuario u;
            String sqlQuery = "SELECT * FROM Usuariosdb WHERE cargo LIKE '%"+ carg +"%' ";

            Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

            while (cursor.moveToNext()) {
                u = new Usuario(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                listaUsuarios.add(u);
            }
            cursor.close();
            return listaUsuarios;

        }catch (Exception e){
            return null;
        }
    }

    public ArrayList<Usuario> buscarUsuarioLista(String cpf) {

        try {
            ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
            Usuario usr;
            String sqlQuery = "SELECT * FROM Usuariosdb WHERE cpf = '" + cpf + "'";
            Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

            if (cursor.moveToNext()) {
                usr = new Usuario(cursor.getString(0), cursor.getString(1), cursor.getString(2),(cursor.getString(3)));
                listaUsuarios.add(usr);
            }
            cursor.close();
            return listaUsuarios;
        } catch (Exception e) {
            return null;
        }
    }


}
