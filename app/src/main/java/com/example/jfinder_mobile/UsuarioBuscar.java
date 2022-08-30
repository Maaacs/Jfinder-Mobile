package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UsuarioBuscar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_buscar);
    }

    public void btnbuscar(View view) {
        EditText cpf = (EditText) findViewById(R.id.cpf_editText);
        TextView nome_txt = (TextView) findViewById(R.id.nomeText);
        TextView sobrenome_txt = (TextView) findViewById(R.id.sobrenomeText);
        TextView cpf_txt = (TextView) findViewById(R.id.cpfText);
        TextView cargo_txt = (TextView) findViewById(R.id.cargoText);

        String cpf_num = cpf.getText().toString();
        UsuarioDAO p = new UsuarioDAO(this);
        Usuario usr = p.buscarUsuario(cpf_num);

        if (usr == null) {
            nome_txt.setText("Não encontrado");
            sobrenome_txt.setText("Não encontrado");
            cpf_txt.setText(0);
            cargo_txt.setText("Não encontrado");
            Toast.makeText(this, "ErrOR", Toast.LENGTH_SHORT).show();

        } else {

            nome_txt.setText(usr.getPrimeiroNome());
            sobrenome_txt.setText(usr.getUltimoNome());
            cpf_txt.setText(usr.getCPF());
            cargo_txt.setText(usr.getCargo());
            Toast.makeText(this, "Usuário encontrado!", Toast.LENGTH_SHORT).show();

        }
    }
}