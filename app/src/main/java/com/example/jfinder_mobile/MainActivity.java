package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



import com.example.jfinder_mobile.databinding.ActivityNavigationMenuBinding;

public class MainActivity extends AppCompatActivity {

    ActivityNavigationMenuBinding binding;
    private Button BotaoParaEntrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigationMenuBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide(); // esconde a barra de título do app (toolbar)

        BotaoParaEntrar = findViewById(R.id.botao_entrar);
        BotaoParaEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextActivity = new Intent(getApplicationContext(), NavigationMenu.class);
                startActivity(nextActivity);
            }
        });

    }
}