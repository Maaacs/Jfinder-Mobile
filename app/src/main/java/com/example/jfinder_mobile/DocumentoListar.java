package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DocumentoListar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_listar);

        DocumentoDAO docDAO = new DocumentoDAO(this);

        final ListView listaDeDocumentos = (ListView) findViewById(R.id.listaDocumentos);
        final ArrayList<Documento> listaDocumentos = docDAO.todosDocumentos();

        ArrayAdapter<Documento> arrayAdapter = new ArrayAdapter<Documento>(this, android.R.layout.simple_list_item_1, listaDocumentos);
        listaDeDocumentos.setAdapter(arrayAdapter);

    }
}