package com.example.jfinder_mobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UsuarioRemover extends AppCompatActivity {

    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_remover);
        getSupportActionBar().hide(); // esconde a barra de título do app (toolbar)

        UsuarioDAO usrDAO = new UsuarioDAO(this);

        final ListView listaDeUsuarios = (ListView) findViewById(R.id.lista);
        final ArrayList<Usuario> listaUsuarios = usrDAO.todosUsuarios();

        ArrayAdapter<Usuario> arrayAdapter = new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1, listaUsuarios);
        listaDeUsuarios.setAdapter(arrayAdapter);

    }

    public void btnremover(View view) {
        EditText cpf = (EditText) findViewById(R.id.cpf_editText);
        UsuarioDAO usr = new UsuarioDAO(this);

        Usuario usuario = usr.buscarUsuario(cpf.getText().toString());

        if (usuario == null) {
            Toast.makeText(UsuarioRemover.this, "Não encontrei =(", Toast.LENGTH_SHORT).show();

        } else {
            usr.removerUsuario(usuario.getCPF());

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            //define o titulo
            builder.setTitle("Usuário removido com sucesso");
            //define a mensagem
            builder.setMessage(usuario.getPrimeiroNome() + " foi removido com sucesso!");

            builder.setPositiveButton("Positivo", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(UsuarioRemover.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();
                }
            });

            alerta = builder.create();
            //Exibe
            alerta.show();

        }
    }
}