package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class DocumentoRelatorio extends AppCompatActivity {
    Spinner relatorioDocumentos;
    Spinner tipoBuscar;
    private SQLiteDatabase bancoDeDados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_relatorio);
        getSupportActionBar().hide(); // esconde a barra de título do app (toolbar)


        relatorioDocumentos = (Spinner) findViewById(R.id.spinnerDocumentos);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.relatorio_documentos_array, android.R.layout.simple_spinner_item);
        relatorioDocumentos.setAdapter(adapter);

        DocumentoDAO docDAO = new DocumentoDAO(this);

        final ListView listaDeDocumentos = (ListView) findViewById(R.id.lista);
        final ArrayList<Documento> listaDocumentos = docDAO.todosDocumentos();
        ArrayAdapter<Documento> arrayAdapter = new ArrayAdapter<Documento>(this, android.R.layout.simple_list_item_1, listaDocumentos);
        listaDeDocumentos.setAdapter(arrayAdapter);

    }


    public ArrayList<Documento> consultaPorDiferentesEntradas(View view) {
        String selecionador = relatorioDocumentos.getSelectedItem().toString();
        DocumentoDAO doc = new DocumentoDAO(this);
        EditText itemBusca = (EditText) findViewById(R.id.itemBusca);
        String itemAserBuscado = itemBusca.getText().toString();

        if (selecionador.equals("Tipo")){
            System.out.println("Achei o primeiro!");

            if(doc.buscarPorTipo(itemAserBuscado) == null){
                System.out.println("Não encontrado");
            }else{
                System.out.println("Encontrei!");

                DocumentoDAO docDAO = new DocumentoDAO(this);
                final ListView listaDeDocumentos = (ListView) findViewById(R.id.lista);
                final ArrayList<Documento> listaDocumentos = docDAO.buscarPorTipo(itemAserBuscado);

                ArrayAdapter<Documento> arrayAdapter = new ArrayAdapter<Documento>(this, android.R.layout.simple_list_item_1, listaDocumentos);
                listaDeDocumentos.setAdapter(arrayAdapter);

            }

        }
        else if(selecionador.equals("Interessado")){
            System.out.println("Achei o terceiro!");
            if(doc.buscarPorInteressado(itemAserBuscado) == null){
                System.out.println("Não encontrado");
            }else{
                System.out.println("Encontrei!");

                DocumentoDAO docDAO = new DocumentoDAO(this);
                final ListView listaDeDocumentos = (ListView) findViewById(R.id.lista);
                final ArrayList<Documento> listaDocumentos = docDAO.buscarPorInteressado(itemAserBuscado);

                ArrayAdapter<Documento> arrayAdapter = new ArrayAdapter<Documento>(this, android.R.layout.simple_list_item_1, listaDocumentos);
                listaDeDocumentos.setAdapter(arrayAdapter);

            }
        }
        else if(selecionador.equals("Palavra-chave")){
            System.out.println("Achei o quarto!");

            if(doc.buscarPorPalavraChave(itemAserBuscado) == null){
                System.out.println("Não encontrado");
            }else{
                System.out.println("Encontrei!");

                DocumentoDAO docDAO = new DocumentoDAO(this);
                final ListView listaDeDocumentos = (ListView) findViewById(R.id.lista);
                final ArrayList<Documento> listaDocumentos = docDAO.buscarPorPalavraChave(itemAserBuscado);

                ArrayAdapter<Documento> arrayAdapter = new ArrayAdapter<Documento>(this, android.R.layout.simple_list_item_1, listaDocumentos);
                listaDeDocumentos.setAdapter(arrayAdapter);

            }
        }else if(selecionador.equals("Ano")){

            if(doc.buscarPorAno(itemAserBuscado) == null){
                System.out.println("Não encontrado");
            }else{
                System.out.println("Encontrei!");

                DocumentoDAO docDAO = new DocumentoDAO(this);
                final ListView listaDeDocumentos = (ListView) findViewById(R.id.lista);
                final ArrayList<Documento> listaDocumentos = docDAO.buscarPorAno(itemAserBuscado);

                ArrayAdapter<Documento> arrayAdapter = new ArrayAdapter<Documento>(this, android.R.layout.simple_list_item_1, listaDocumentos);
                listaDeDocumentos.setAdapter(arrayAdapter);

            }
        }
        return null;
    }
}