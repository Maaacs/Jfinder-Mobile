package com.example.jfinder_mobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UsuarioAlterar extends AppCompatActivity {

    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_alterar);
        getSupportActionBar().hide(); // esconde a barra de título do app (toolbar)
    }

    public void btnbuscar(View view) {
        EditText cpf = (EditText) findViewById(R.id.cpf);
        TextView nome_txt = (TextView) findViewById(R.id.nome);
        TextView sobrenome_txt = (TextView) findViewById(R.id.sobrenome);
        TextView cpf_txt = (TextView) findViewById(R.id.cpf);
        TextView cargo_txt = (TextView) findViewById(R.id.cargo);

        String cpfBusca = cpf.getText().toString();


        String cpf_num = cpf.getText().toString();
        UsuarioDAO p = new UsuarioDAO(this);
        Usuario usr = p.buscarUsuario(cpf_num);


        if (cpfBusca.matches("")) {
            Toast.makeText(this, "Insira o CPF!", Toast.LENGTH_SHORT).show();
        }else{
            if (usr == null) {
               /* nome_txt.setText("Não encontrado");
                sobrenome_txt.setText("Não encontrado");
                cargo_txt.setText("Não encontrado");*/
                Toast.makeText(this, "Usuário não encontrado!", Toast.LENGTH_SHORT).show();

            } else {
                nome_txt.setText(usr.getPrimeiroNome());
                sobrenome_txt.setText(usr.getUltimoNome());
                cargo_txt.setText(usr.getCargo());
                Toast.makeText(this, "Usuário encontrado!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void btnalterar(View view) {
        TextView cpf_txt = (TextView) findViewById(R.id.cpf);
        TextView nome_txt = (TextView) findViewById(R.id.nome);
        EditText sobrenome_txt = (EditText) findViewById(R.id.sobrenome);
        TextView cargo_txt = (TextView) findViewById(R.id.cargo);

        String nomeBusca = nome_txt.getText().toString();
        String sobrenomeBusca = sobrenome_txt.getText().toString();
        String cargoBusca = cargo_txt.getText().toString();
        String cpf = cpf_txt.getText().toString();

        UsuarioDAO p = new UsuarioDAO(this);

        if (p.buscarUsuario(cpf) != null){
            if (nomeBusca.matches("") || sobrenomeBusca.matches("") || cargoBusca.matches("")) {
                Toast.makeText(this, "Insira todos os dados!", Toast.LENGTH_SHORT).show();
            }else{
                if(p.alterarUsuario(nome_txt.getText().toString(), sobrenome_txt.getText().toString(),cargo_txt.getText().toString(), cpf_txt.getText().toString())){
                    Toast.makeText(UsuarioAlterar.this, "Alterado com sucesso!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(UsuarioAlterar.this, "Insira os dados corretamente!", Toast.LENGTH_SHORT).show();
                }
            }
        }else{
            Toast.makeText(UsuarioAlterar.this, "Insira um CPF válido e realize a busca!", Toast.LENGTH_SHORT).show();
        }

    }
}