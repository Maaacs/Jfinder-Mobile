package com.example.jfinder_mobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UsuarioCadastro extends AppCompatActivity {
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_cadastro);
    }

    public void bntInserir(View view){
        EditText nomeTXT = (EditText) findViewById(R.id.nome);
        EditText sobrenomeTXT = (EditText) findViewById(R.id.sobrenome);
        EditText cpfTXT = (EditText) findViewById(R.id.cpf);
        EditText cargoTXT = (EditText) findViewById(R.id.cargo);

        Usuario usuarios = new Usuario(nomeTXT.getText().toString(), sobrenomeTXT.getText().toString(), cpfTXT.getText().toString(), cargoTXT.getText().toString());

        UsuarioDAO uDAO = new UsuarioDAO(this);

        if (uDAO.addUsuario(usuarios)){//adiciona produto em uDAO
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Usuario adicionado com sucesso");

            builder.setMessage("Nome: " + nomeTXT.getText().toString() + "\nSobrenome: " + sobrenomeTXT.getText().toString() + "\n CPF: " +
                    cpfTXT.getText().toString() + "\n Cargo: " + cargoTXT.getText().toString());
            builder.setPositiveButton("Positivo", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(UsuarioCadastro.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();
                }
            });

            alerta = builder.create();
            //Exibe
            alerta.show();

        }else {
            Toast.makeText(UsuarioCadastro.this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
        }
    }


}
