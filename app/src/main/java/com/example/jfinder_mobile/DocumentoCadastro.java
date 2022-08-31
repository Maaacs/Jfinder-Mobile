package com.example.jfinder_mobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DocumentoCadastro extends AppCompatActivity {
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_cadastro);
        getSupportActionBar().hide(); // esconde a barra de título do app (toolbar)
    }

    public void bntInserir(View view) {

        EditText numeroUnicoReferenciaTXT = (EditText) findViewById(R.id.numeroReferencia);
        EditText tipoDeDocumentoTXT = (EditText) findViewById(R.id.tipoDeDocumento);
        EditText interessadoTXT = (EditText) findViewById(R.id.interessado);
        EditText tipoDeArmazenamentoTXT = (EditText) findViewById(R.id.tipoDeArmazenamento);
        EditText dataArquivamentoTXT = (EditText) findViewById(R.id.dataArquivamento);
        EditText descriçãoDocumentoTXT = (EditText) findViewById(R.id.descricaoDocumento);
        EditText localCompletoDeArmazenamentoTXT = (EditText) findViewById(R.id.localDeArmazenamento);

        Documento documentos = new Documento(numeroUnicoReferenciaTXT.getText().toString(), tipoDeDocumentoTXT.getText().toString(), interessadoTXT.getText().toString(), tipoDeArmazenamentoTXT.getText().toString(), dataArquivamentoTXT.getText().toString(), descriçãoDocumentoTXT.getText().toString(), localCompletoDeArmazenamentoTXT.getText().toString());
        DocumentoDAO dDAO = new DocumentoDAO(this);

        if(dDAO.addDocumento(documentos)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Documento adicionado com sucesso!");

            builder.setMessage("Nº Referência: " + numeroUnicoReferenciaTXT.getText().toString() + "\nTipo de Documento: " + tipoDeDocumentoTXT.getText().toString() + "\n Interessado: " +
                    interessadoTXT.getText().toString() + "\n Tipo de Armazenamento: " + tipoDeArmazenamentoTXT.getText().toString() + "\n Data de Arquivamento: " + dataArquivamentoTXT.getText().toString() + "\n Local de Armazenamento: " + localCompletoDeArmazenamentoTXT.getText().toString() + "\n Descrição: " + descriçãoDocumentoTXT.getText().toString());
            builder.setPositiveButton("Positivo", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(DocumentoCadastro.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();
                }
            });

            alerta = builder.create();
            //Exibe
            alerta.show();

        }else{
            Toast.makeText(DocumentoCadastro.this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
        }
    }
}