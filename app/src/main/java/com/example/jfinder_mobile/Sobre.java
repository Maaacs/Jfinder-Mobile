package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Sobre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        getSupportActionBar().hide(); // esconde a barra de título do app (toolbar)
    }
}