package com.example.matias.lav5tp.PKG_MenuActivity.Entidades;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matias.lav5tp.PKG_MenuActivity.IServices;
import com.example.matias.lav5tp.PKG_MenuActivity.MenuActivity_Controlador;
import com.example.matias.lav5tp.R;

import java.util.List;

/**
 * Created by matias on 30/04/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<ViewHolder>{

    private List<Productos> list;
    private IServices listener;
    String tipoDeLista;

    public MyAdapter(List<Productos>lst, IServices listener, String tipo){
        this.list=lst;
        this.listener=listener;
        this.tipoDeLista=tipo;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        ViewHolder holder = new ViewHolder(v, listener, this.tipoDeLista);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Productos p= list.get(position);
        holder.setTxtDescripcion(p.getDescripcion());
        holder.setTxtValor(p.getValor().toString());
        holder.setPosicion(position);
        holder.setImagen(p.getBitesImagen());
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}
