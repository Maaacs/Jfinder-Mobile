package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/*Tela de Login*/
public class MainActivity extends AppCompatActivity {
    private Button BotaoParaEntrar;
    private ImageView BotaoSobre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide(); // esconde a barra de título do app (toolbar)

        BotaoParaEntrar = findViewById(R.id.botao_entrar);
        BotaoSobre = findViewById(R.id.sobre);
        BotaoParaEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextActivity = new Intent(getApplicationContext(), NavigationMenu.class);
                startActivity(nextActivity);
            }
        });

        BotaoSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextActivity = new Intent(getApplicationContext(), Sobre.class);
                startActivity(nextActivity);
            }
        });


    }
}