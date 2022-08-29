package com.example.jfinder_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReyclerUsuariosAdapter extends RecyclerView.Adapter<ReyclerUsuariosAdapter.MyViewHolder> {
    private Context context;
    private ArrayList nome_id, sobrenome_id, cpf_id, cargo_id;

    public ReyclerUsuariosAdapter(Context context, ArrayList nome, ArrayList sobrenome, ArrayList cpf, ArrayList cargo) {
        this.context = context;
        this.nome_id = nome;
        this.sobrenome_id = sobrenome;
        this.cpf_id = cpf;
        this.cargo_id = cargo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nome_id.setText(String.valueOf(nome_id.get(position)));
        holder.sobrenome_id.setText(String.valueOf(sobrenome_id.get(position)));
        holder.cpf_id.setText(String.valueOf(cpf_id.get(position)));
        holder.cargo_id.setText(String.valueOf(cargo_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return nome_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nome_id, sobrenome_id, cpf_id, cargo_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome_id = itemView.findViewById(R.id.textnome);
            sobrenome_id = itemView.findViewById(R.id.textsobrenome);
            cpf_id = itemView.findViewById(R.id.textcpf);
            cargo_id = itemView.findViewById(R.id.textcargo);

        }
    }
}
