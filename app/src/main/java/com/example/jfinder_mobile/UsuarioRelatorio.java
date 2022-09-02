package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class UsuarioRelatorio extends AppCompatActivity {

    Spinner relatorioUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_relatorio);
        getSupportActionBar().hide(); // esconde a barra de título do app (toolbar)


        relatorioUsuarios = (Spinner) findViewById(R.id.spinnerUsuarios);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.relatorio_usuarios_array, android.R.layout.simple_spinner_item);
        relatorioUsuarios.setAdapter(adapter);


        UsuarioDAO usrDAO = new UsuarioDAO(this);

        final ListView listaDeUsuarios = (ListView) findViewById(R.id.lista);
        final ArrayList<Usuario> listaUsuarios = usrDAO.todosUsuarios();

        ArrayAdapter<Usuario> arrayAdapter = new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1, listaUsuarios);
        listaDeUsuarios.setAdapter(arrayAdapter);
    }
}