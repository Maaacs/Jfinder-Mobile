package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DocumentoBuscar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_buscar);
        getSupportActionBar().hide(); // esconde a barra de título do app (toolbar)
    }

    public void btnbuscar(View view) {
        EditText Nreferencia = (EditText) findViewById(R.id.num_referencia);

        TextView tipoDeDocumentoText = (TextView) findViewById(R.id.tipoDeDocumentoText);
        TextView interessadoText = (TextView) findViewById(R.id.interessadoText);
        TextView tipoDeArmazenamentoText = (TextView) findViewById(R.id.tipoDeArmazenamentoText);
        TextView dataArquivamentoText = (TextView) findViewById(R.id.dataArquivamentoText);
        TextView localDeArmazenamentoText = (TextView) findViewById(R.id.localDeArmazenamentoText);
        TextView descricaoText = (TextView) findViewById(R.id.descricaoText);

        String NumeRefBusca = Nreferencia.getText().toString();
        String numeroUnicoReferenciaCadastra = Nreferencia.getText().toString();
        String tipoDeDocumentoCadastra = tipoDeDocumentoText.getText().toString();
        String interessadoCadastra = interessadoText.getText().toString();
        String tipoDeArmazenamentoCadastra = tipoDeArmazenamentoText.getText().toString();
        String dataArquivamentoCadastra = dataArquivamentoText.getText().toString();
        String descriçãoDocumentoCadastra = descricaoText.getText().toString();
        String localCompletoDeArmazenamentoCadastra = localDeArmazenamentoText.getText().toString();

        String num_referencia = Nreferencia.getText().toString();
        DocumentoDAO d = new DocumentoDAO(this);
        Documento doc = d.buscarDocumento(num_referencia);

        if (NumeRefBusca.matches("")) {
            Toast.makeText(this, "Insira o N° de referência!", Toast.LENGTH_SHORT).show();
        }else{
            if (doc == null) {
                tipoDeDocumentoText.setText("Não encontrado");
                interessadoText.setText("Não encontrado");
                tipoDeArmazenamentoText.setText("Não encontrado");
                dataArquivamentoText.setText("--/--/--");
                localDeArmazenamentoText.setText("Não encontrado");
                descricaoText.setText("Não encontrado");

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



    }
}