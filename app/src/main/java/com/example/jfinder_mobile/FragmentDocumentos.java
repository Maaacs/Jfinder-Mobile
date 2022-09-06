package com.example.jfinder_mobile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class FragmentDocumentos extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public FragmentDocumentos() {
        // Required empty public constructor
    }

    public static FragmentDocumentos newInstance(String param1, String param2) {
        FragmentDocumentos fragment = new FragmentDocumentos();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_documentos, container, false);

        Button cadastrarBotao = (Button)view.findViewById(R.id.cadastrar);
        Button removerBotao = (Button)view.findViewById(R.id.remover);
        Button buscarBotao = (Button)view.findViewById(R.id.buscar);
        Button alterarBotao = (Button)view.findViewById(R.id.alterar);
        ImageView sair = (ImageView)view.findViewById(R.id.sair);

        cadastrarBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), DocumentoCadastro.class);
                startActivity(in);
            }
        });

        removerBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), DocumentoRemover.class);
                startActivity(in);
            }
        });

        buscarBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), DocumentoBuscar.class);
                startActivity(in);
            }
        });

        alterarBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), DocumentoAlterar.class);
                startActivity(in);
            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Login.class);
                startActivity(in);
            }
        });

        return view;
    }
}