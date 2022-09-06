package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class DocumentoRelatorio extends AppCompatActivity {
    Spinner relatorioDocumentos;

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
        System.out.println(itemAserBuscado);


        if (selecionador.equals("Tipo")){
            if(itemAserBuscado.matches("")){
                Toast.makeText(this, "Insira a busca!", Toast.LENGTH_SHORT).show();
            }else{

                DocumentoDAO docDAO = new DocumentoDAO(this);
                final ListView listaDeDocumentos = (ListView) findViewById(R.id.lista);
                final ArrayList<Documento> listaDocumentos = docDAO.buscarPorTipo(itemAserBuscado);

                ArrayAdapter<Documento> arrayAdapter = new ArrayAdapter<Documento>(this, android.R.layout.simple_list_item_1, listaDocumentos);
                listaDeDocumentos.setAdapter(arrayAdapter);

                if (docDAO.buscarPorTipo(itemAserBuscado).size() >= 1){
                    Toast.makeText(this, "Resultados encontrados!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Resultados não encontrados!", Toast.LENGTH_SHORT).show();
                }

            }

        }
        else if(selecionador.equals("Interessado")){

            if(itemAserBuscado.matches("")){
                Toast.makeText(this, "Insira a busca!", Toast.LENGTH_SHORT).show();
            }else{

                DocumentoDAO docDAO = new DocumentoDAO(this);
                final ListView listaDeDocumentos = (ListView) findViewById(R.id.lista);
                final ArrayList<Documento> listaDocumentos = docDAO.buscarPorInteressado(itemAserBuscado);

                ArrayAdapter<Documento> arrayAdapter = new ArrayAdapter<Documento>(this, android.R.layout.simple_list_item_1, listaDocumentos);
                listaDeDocumentos.setAdapter(arrayAdapter);

                if (docDAO.buscarPorInteressado(itemAserBuscado).size() >= 1){
                    Toast.makeText(this, "Resultados encontrados!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Resultados não encontrados!", Toast.LENGTH_SHORT).show();
                }

            }
        }
        else if(selecionador.equals("Palavra-chave")){

            if(itemAserBuscado.matches("")){;
                Toast.makeText(this, "Insira a busca!", Toast.LENGTH_SHORT).show();
            }else{
                DocumentoDAO docDAO = new DocumentoDAO(this);
                final ListView listaDeDocumentos = (ListView) findViewById(R.id.lista);
                final ArrayList<Documento> listaDocumentos = docDAO.buscarPorPalavraChave(itemAserBuscado);

                ArrayAdapter<Documento> arrayAdapter = new ArrayAdapter<Documento>(this, android.R.layout.simple_list_item_1, listaDocumentos);
                listaDeDocumentos.setAdapter(arrayAdapter);

                if (docDAO.buscarPorPalavraChave(itemAserBuscado).size() >= 1){
                    Toast.makeText(this, "Resultados encontrados!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Resultados não encontrados!", Toast.LENGTH_SHORT).show();
                }


            }
        }else if(selecionador.equals("Ano")){

            if(itemAserBuscado.matches("")){
                Toast.makeText(this, "Insira a busca!", Toast.LENGTH_SHORT).show();
            }else{

                DocumentoDAO docDAO = new DocumentoDAO(this);
                final ListView listaDeDocumentos = (ListView) findViewById(R.id.lista);
                final ArrayList<Documento> listaDocumentos = docDAO.buscarPorAno(itemAserBuscado);

                ArrayAdapter<Documento> arrayAdapter = new ArrayAdapter<Documento>(this, android.R.layout.simple_list_item_1, listaDocumentos);
                listaDeDocumentos.setAdapter(arrayAdapter);

                if (docDAO.buscarPorAno(itemAserBuscado).size() >= 1){
                    Toast.makeText(this, "Resultados encontrados!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Resultados não encontrados!", Toast.LENGTH_SHORT).show();
                }

            }
        }
        return null;
    }
}