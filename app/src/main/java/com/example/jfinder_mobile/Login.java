package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;


public class Login extends AppCompatActivity {
    private ImageView BotaoSobre;
    BancoDeDados db = new BancoDeDados(this);
    private ProgressBar bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide(); // esconde a barra de título do app (toolbar)
        bar = findViewById(R.id.progress_bar);


        BotaoSobre = findViewById(R.id.sobre);
        BotaoSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextActivity = new Intent(getApplicationContext(), Sobre.class);
                startActivity(nextActivity);
            }
        });
    }

    public boolean autenticarLogin() {
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

    public void exibirBar(){
        /*bar.setVisibility(true ? View.VISIBLE : View.GONE); outra forma de exirbir a barra*/
        bar.setVisibility(View.VISIBLE);
    }

    private void proxTela(){
        Intent nextActivity = new Intent(getApplicationContext(), NavigationMenu.class);
        /*startActivity(nextActivity, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());*/ // animação
        startActivity(nextActivity);
        finish(); //finaliza a view activity ao trocar para a proxima
    }



    public void entrarBtn(View view) {
        EditText nome = (EditText) findViewById(R.id.edit_usuario);
        EditText senha = (EditText) findViewById(R.id.edit_senha);
        String user = nome.getText().toString();
        String password = senha.getText().toString();


        if(user.matches("") && password.matches("")){
            Toast.makeText(this, "Insira os dados!", Toast.LENGTH_SHORT).show();
        }else{
            if (autenticarLogin()){

                exibirBar();

                new Handler().postDelayed(new Runnable() { //método para adicionar delay na transição de tela
                    @Override
                    public void run() {
                        proxTela();
                    }
                }, 2600);

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