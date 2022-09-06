package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DocumentoAlterar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_alterar);
        getSupportActionBar().hide(); // esconde a barra de título do app (toolbar)
    }

    public void bntBuscar(View view) {
        EditText Nreferencia = (EditText) findViewById(R.id.num_referencia2);

        TextView tipoDeDocumentoText = (TextView) findViewById(R.id.tipoDeDocumento2);
        TextView interessadoText = (TextView) findViewById(R.id.interessado2);
        TextView tipoDeArmazenamentoText = (TextView) findViewById(R.id.tipoDeArmazenamento2);
        TextView dataArquivamentoText = (TextView) findViewById(R.id.dataArquivamento2);
        TextView localDeArmazenamentoText = (TextView) findViewById(R.id.localDeArmazenamento2);
        TextView descricaoText = (TextView) findViewById(R.id.descricaoDocumento2);



        String num_referencia = Nreferencia.getText().toString();
        DocumentoDAO d = new DocumentoDAO(this);
        Documento doc = d.buscarDocumento(num_referencia);


        if (doc == null) {
/*          tipoDeDocumentoText.setText("Não encontrado");
            interessadoText.setText("Não encontrado");
            tipoDeArmazenamentoText.setText("Não encontrado");
            dataArquivamentoText.setText("--/--/--");
            localDeArmazenamentoText.setText("Não encontrado");
            descricaoText.setText("Não encontrado");*/

            Toast.makeText(this, "Documento não encontrado!", Toast.LENGTH_SHORT).show();

        } else {
            tipoDeDocumentoText.setText(doc.getTipoDeDocumento());
            interessadoText.setText(doc.getInteressado());
            tipoDeArmazenamentoText.setText(doc.getTipoDeArmazenamento());
            dataArquivamentoText.setText(doc.getDataArquivamento());
            localDeArmazenamentoText.setText(doc.getLocalCompletoDeArmazenamento());
            descricaoText.setText(doc.getDescriçãoDocumento());
            Toast.makeText(this, "Documento encontrado!", Toast.LENGTH_SHORT).show();

        }
    }

    public void btnalterar(View view) {

        TextView num_referencia = (TextView) findViewById(R.id.num_referencia2);
        TextView tipoDeDocumentoText = (TextView) findViewById(R.id.tipoDeDocumento2);
        TextView interessadoText = (TextView) findViewById(R.id.interessado2);
        TextView tipoDeArmazenamentoText = (TextView) findViewById(R.id.tipoDeArmazenamento2);
        TextView dataArquivamentoText = (TextView) findViewById(R.id.dataArquivamento2);
        TextView localDeArmazenamentoText = (TextView) findViewById(R.id.localDeArmazenamento2);
        TextView descricaoText = (TextView) findViewById(R.id.descricaoDocumento2);


        String tipoDeDocumentoCadastra = tipoDeDocumentoText.getText().toString();
        String interessadoCadastra = interessadoText.getText().toString();
        String tipoDeArmazenamentoCadastra = tipoDeArmazenamentoText.getText().toString();
        String dataArquivamentoCadastra = dataArquivamentoText.getText().toString();
        String descriçãoDocumentoCadastra = descricaoText.getText().toString();
        String localCompletoDeArmazenamentoCadastra = localDeArmazenamentoText.getText().toString();

        DocumentoDAO d = new DocumentoDAO(this);

        if (tipoDeDocumentoCadastra.matches("") || interessadoCadastra.matches("") || tipoDeArmazenamentoCadastra.matches("") || dataArquivamentoCadastra.matches("") || descriçãoDocumentoCadastra.matches("") || localCompletoDeArmazenamentoCadastra.matches("")){
            Toast.makeText(this, "Dados incompletos!", Toast.LENGTH_SHORT).show();
        }else{

            if (d.alterarDocumento(tipoDeDocumentoText.getText().toString(), interessadoText.getText().toString(), tipoDeArmazenamentoText.getText().toString(), dataArquivamentoText.getText().toString(), localDeArmazenamentoText.getText().toString(), descricaoText.getText().toString(), num_referencia.getText().toString())) {
                Toast.makeText(DocumentoAlterar.this, "Sucesso!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(DocumentoAlterar.this, "Tente novamente!", Toast.LENGTH_SHORT).show();
            }
        }

    }
}