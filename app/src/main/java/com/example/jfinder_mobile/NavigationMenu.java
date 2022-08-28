package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.jfinder_mobile.databinding.ActivityNavigationMenuBinding;

public class NavigationMenu extends AppCompatActivity {

    ActivityNavigationMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigationMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new UsuariosFragment());
        getSupportActionBar().hide(); // esconde a barra de título do app (toolbar)


        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.usuarios_menu:
                    replaceFragment(new UsuariosFragment());
                    break;
                case R.id.documentos_menu:
                    replaceFragment(new DocumentosFragment());
                    break;
                case R.id.relatorios_menu:
                    replaceFragment(new RelatoriosFragment());
                    break;
            }

            return true;
        });



    }

    private void replaceFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_frame, fragment);
        fragmentTransaction.commit();
    }


}
