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

public class UsuarioRelatorio extends AppCompatActivity {

    Spinner relatorioUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_relatorio);
        getSupportActionBar().hide(); // esconde a barra de título do app (toolbar)


        relatorioUsuarios = (Spinner) findViewById(R.id.spinnerUsuarios);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.relatorio_usuarios_array, android.R.layout.simple_spinner_item);
        relatorioUsuarios.setAdapter(adapter);


        UsuarioDAO usrDAO = new UsuarioDAO(this);

        final ListView listaDeUsuarios = (ListView) findViewById(R.id.lista);
        final ArrayList<Usuario> listaUsuarios = usrDAO.todosUsuarios();

        ArrayAdapter<Usuario> arrayAdapter = new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1, listaUsuarios);
        listaDeUsuarios.setAdapter(arrayAdapter);
    }

    public void consultaUsuarioPorDiferentesEntradas(View view) {
        String selecionador = relatorioUsuarios.getSelectedItem().toString();
        UsuarioDAO user = new UsuarioDAO(this);
        EditText itemBusca = (EditText) findViewById(R.id.itemBusca_text);
        String itemAserBuscado = itemBusca.getText().toString();
        System.out.println(itemAserBuscado);

        if(selecionador.equals("Nome")){
            if(itemAserBuscado.matches("")){
                Toast.makeText(this, "Insira a busca!", Toast.LENGTH_SHORT).show();
            }else{
                UsuarioDAO userDAO = new UsuarioDAO(this);
                final ListView listaDeUsuarios = (ListView) findViewById(R.id.lista);
                final ArrayList<Usuario> listaUsuarios = userDAO.buscarPorNome(itemAserBuscado);

                ArrayAdapter<Usuario> arrayAdapter = new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1, listaUsuarios);
                listaDeUsuarios.setAdapter(arrayAdapter);

                if(userDAO.buscarPorNome(itemAserBuscado).size() >= 1){
                    Toast.makeText(this, "Resultados encontrados!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Resultados não encontrados!", Toast.LENGTH_SHORT).show();
                }

            }
        }
        else if (selecionador.equals("Sobrenome")){
            if(itemAserBuscado.matches("")){
                Toast.makeText(this, "Insira a busca!", Toast.LENGTH_SHORT).show();
            }else{
                UsuarioDAO userDAO = new UsuarioDAO(this);
                final ListView listaDeUsuarios = (ListView) findViewById(R.id.lista);
                final ArrayList<Usuario> listaUsuarios = userDAO.buscarPorSobrenome(itemAserBuscado);

                ArrayAdapter<Usuario> arrayAdapter = new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1, listaUsuarios);
                listaDeUsuarios.setAdapter(arrayAdapter);

                if(userDAO.buscarPorSobrenome(itemAserBuscado).size() >= 1){
                    Toast.makeText(this, "Resultados encontrados!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Resultados não encontrados!", Toast.LENGTH_SHORT).show();
                }
            }

        }
        else if (selecionador.equals("Cargo")){
            if(itemAserBuscado.matches("")){
                Toast.makeText(this, "Insira a busca!", Toast.LENGTH_SHORT).show();
            }else{
                UsuarioDAO userDAO = new UsuarioDAO(this);
                final ListView listaDeUsuarios = (ListView) findViewById(R.id.lista);
                final ArrayList<Usuario> listaUsuarios = userDAO.buscarPorCargo(itemAserBuscado);

                ArrayAdapter<Usuario> arrayAdapter = new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1, listaUsuarios);
                listaDeUsuarios.setAdapter(arrayAdapter);

                if(userDAO.buscarPorCargo(itemAserBuscado).size() >= 1){
                    Toast.makeText(this, "Resultados encontrados!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Resultados não encontrados!", Toast.LENGTH_SHORT).show();
                }
            }

        }

    }
}