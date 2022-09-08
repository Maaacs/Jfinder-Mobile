package com.example.jfinder_mobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DocumentoRemover extends AppCompatActivity {
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_remover);
        getSupportActionBar().hide(); // esconde a barra de título do app (toolbar)

        DocumentoDAO docDAO = new DocumentoDAO(this);

        final ListView listaDeDocumentos = (ListView) findViewById(R.id.lista);
        final ArrayList<Documento> listaDocumentos = docDAO.todosDocumentos();

        ArrayAdapter<Documento> arrayAdapter = new ArrayAdapter<Documento>(this, android.R.layout.simple_list_item_1, listaDocumentos);
        listaDeDocumentos.setAdapter(arrayAdapter);

    }

    public void btnremover(View view) {

        EditText numRef = (EditText) findViewById(R.id.NumReferencia_editText);
        DocumentoDAO doc = new DocumentoDAO(this);

        Documento documento = doc.buscarDocumento(numRef.getText().toString());

        if (documento == null) {
            Toast.makeText(DocumentoRemover.this, "Documento não encontrado!", Toast.LENGTH_SHORT).show();

        } else {
            doc.removerDocumento(documento.getNumeroUnicoReferencia());

            //atualizar em tempo real a listview
            final ListView listaDeDocumentos = (ListView) findViewById(R.id.lista);
            final ArrayList<Documento> listaDocumentos = doc.todosDocumentos();
            ArrayAdapter<Documento> arrayAdapter = new ArrayAdapter<Documento>(this, android.R.layout.simple_list_item_1, listaDocumentos);
            listaDeDocumentos.setAdapter(arrayAdapter);


            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Documento removido com sucesso!");
            builder.setMessage("Documento: " + documento.getTipoDeDocumento());

            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    /*Toast.makeText(DocumentoRemover.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();*/
                }
            });

            alerta = builder.create();
            //Exibe
            alerta.show();

        }
    }
}