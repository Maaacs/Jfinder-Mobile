package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide(); // remove a barra de título do app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}