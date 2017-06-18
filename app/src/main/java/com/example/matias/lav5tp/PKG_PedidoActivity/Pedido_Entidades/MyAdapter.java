package com.example.matias.lav5tp.PKG_PedidoActivity.Pedido_Entidades;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Productos;
import com.example.matias.lav5tp.PKG_PedidoActivity.IServices;
import com.example.matias.lav5tp.R;

import java.util.List;

/**
 * Created by matias on 30/04/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<ViewHolder>{

    private List<Productos> list;
    private IServices listener;

    public MyAdapter(List<Productos>lst, IServices listener){
        this.list=lst;
        this.listener=listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pedido, parent, false);
        ViewHolder holder = new ViewHolder(v, listener);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Productos p= list.get(position);
        holder.setTxtDescripcion(p.getDescripcion());
        holder.setTxtValor(p.getValor().toString());
        holder.setPosicion(position);
        if(p.getBitesImagen()!=null) {
            holder.setImagen(p.getBitesImagen());
        }
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}
