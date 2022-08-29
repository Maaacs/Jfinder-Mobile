package com.example.jfinder_mobile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageView;


public class UsuariosFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private Button BotaoParaEntrar;

    public UsuariosFragment() {
        // Required empty public constructor
    }

    public static UsuariosFragment newInstance(String param1, String param2) {
        UsuariosFragment fragment = new UsuariosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override /* Sair de um fragment para uma class*/
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_usuarios, container, false);

        Button cadastrarBotao = (Button)view.findViewById(R.id.cadastrar);
        Button removerBotao = (Button)view.findViewById(R.id.remover);
        ImageView sair = (ImageView)view.findViewById(R.id.sair);
        cadastrarBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), CadastroUsuario.class);
                startActivity(in);
            }
        });

        removerBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), RemoverUsuario.class);
                startActivity(in);
            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), MainActivity.class);
                startActivity(in);
            }
        });

        return view;
    }


}