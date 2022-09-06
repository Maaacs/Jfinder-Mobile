package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UsuarioBuscar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_buscar);
        getSupportActionBar().hide(); // esconde a barra de título do app (toolbar)
    }

    public void btnbuscar(View view) {
        EditText cpf = (EditText) findViewById(R.id.cpf_editText);
/*        TextView nome_txt = (TextView) findViewById(R.id.nomeText);
        TextView sobrenome_txt = (TextView) findViewById(R.id.sobrenomeText);
        TextView cpf_txt = (TextView) findViewById(R.id.cpfText);
        TextView cargo_txt = (TextView) findViewById(R.id.cargoText);*/

        String cpfBusca = cpf.getText().toString();

        String cpf_num = cpf.getText().toString();
        UsuarioDAO p = new UsuarioDAO(this);
        Usuario usr = p.buscarUsuario(cpf_num);

        if (cpfBusca.matches("")) {
            Toast.makeText(this, "Insira o CPF!", Toast.LENGTH_SHORT).show();
        }
        else {
            if (usr == null) {
/*                nome_txt.setText("Não encontrado");
                sobrenome_txt.setText("Não encontrado");
                cpf_txt.setText("Não encontrado");
                cargo_txt.setText("Não encontrado");*/
                Toast.makeText(this, "Usuário não encontrado!", Toast.LENGTH_SHORT).show();

            } else {

/*                nome_txt.setText(usr.getPrimeiroNome());
                sobrenome_txt.setText(usr.getUltimoNome());
                cpf_txt.setText(usr.getCPF());
                cargo_txt.setText(usr.getCargo());*/

                EditText cpfUsr = (EditText) findViewById(R.id.cpf_editText);
                String cpf_user = cpfUsr.getText().toString();
                UsuarioDAO userDAO = new UsuarioDAO(this);
                final ListView listaDeUsuario = (ListView) findViewById(R.id.lista);
                final ArrayList<Usuario> listaUsuario = userDAO.buscarUsuarioLista(cpf_user);


                ArrayAdapter<Usuario> arrayAdapter = new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1,listaUsuario);
                listaDeUsuario.setAdapter(arrayAdapter);


                Toast.makeText(this, "Usuário encontrado!", Toast.LENGTH_SHORT).show();
            }

        }
    }
}