package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class Login extends AppCompatActivity {
    private ImageView BotaoSobre;
    BancoDeDados db = new BancoDeDados(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide(); // esconde a barra de título do app (toolbar)


        BotaoSobre = findViewById(R.id.sobre);
        BotaoSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextActivity = new Intent(getApplicationContext(), Sobre.class);
                startActivity(nextActivity);
            }
        });
    }

    public boolean verificarLogin() {
        EditText nome = (EditText) findViewById(R.id.edit_usuario);
        EditText senha = (EditText) findViewById(R.id.edit_senha);
        String user = nome.getText().toString();
        String password = senha.getText().toString();

        if(db.Login(user, password)){
            return true;
        }else {
            System.out.println(user);
            System.out.println(password);
            return false;
        }
    }


    public void entrarBtn(View view) {
        EditText nome = (EditText) findViewById(R.id.edit_usuario);
        EditText senha = (EditText) findViewById(R.id.edit_senha);
        String user = nome.getText().toString();
        String password = senha.getText().toString();

        if(user.matches("") && password.matches("")){
            Toast.makeText(this, "Insira os dados!", Toast.LENGTH_SHORT).show();
        }else{
            if (verificarLogin()){
                Intent nextActivity = new Intent(getApplicationContext(), NavigationMenu.class);
                startActivity(nextActivity);
            }else{
                System.out.println("poxaa");
                Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show();

            }
        }


    }

    public void sairBtn(View view) {
        finish();
        System.exit(0);
    }
}