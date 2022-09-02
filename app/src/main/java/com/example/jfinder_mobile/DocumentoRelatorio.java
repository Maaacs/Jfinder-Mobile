package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class DocumentoRelatorio extends AppCompatActivity {
    Spinner relatorioDocumentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_relatorio);
        getSupportActionBar().hide(); // esconde a barra de título do app (toolbar)


        relatorioDocumentos = (Spinner) findViewById(R.id.spinnerUsuarios);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.relatorio_documentos_array, android.R.layout.simple_spinner_item);
        relatorioDocumentos.setAdapter(adapter);


        DocumentoDAO docDAO = new DocumentoDAO(this);

        final ListView listaDeDocumentos = (ListView) findViewById(R.id.lista);
        final ArrayList<Documento> listaDocumentos = docDAO.todosDocumentos();

        ArrayAdapter<Documento> arrayAdapter = new ArrayAdapter<Documento>(this, android.R.layout.simple_list_item_1, listaDocumentos);
        listaDeDocumentos.setAdapter(arrayAdapter);
    }
}