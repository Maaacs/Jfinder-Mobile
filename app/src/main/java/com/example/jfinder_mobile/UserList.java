package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Currency;


public class UserList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> nome, sobrenome, cpf, cargo;
    /*BancoDeDados DB;*/
    UsuarioDAO DB;
    ReyclerUsuariosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        DB = new UsuarioDAO(this);
        /*DB = new BancoDeDados(this);*/
        nome = new ArrayList<>();
        sobrenome = new ArrayList<>();
        cpf = new ArrayList<>();
        cargo = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerview);

        adapter = new ReyclerUsuariosAdapter(this, nome, sobrenome, cpf, cargo);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata()
    {
        Cursor cursor = (Cursor) DB.todosUsuarios();
        if(cursor.getCount()==0)
        {
            Toast.makeText(UserList.this, "No Entry Exists" , Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
                nome.add(cursor.getString(0));
                sobrenome.add(cursor.getString(1));
                cpf.add(cursor.getString(2));
                cargo.add(cursor.getString(3));
            }
        }
    }
}