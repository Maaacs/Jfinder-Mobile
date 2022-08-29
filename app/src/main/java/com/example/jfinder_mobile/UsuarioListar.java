package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;


public class UsuarioListar extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_listar);

        UsuarioDAO usrDAO = new UsuarioDAO(this);

        final ListView listaDeUsuarios = (ListView) findViewById(R.id.lista);
        final ArrayList<Usuario> listaUsuarios = usrDAO.todosUsuarios();

        ArrayAdapter<Usuario> arrayAdapter = new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1, listaUsuarios);
        listaDeUsuarios.setAdapter(arrayAdapter);


    }
}