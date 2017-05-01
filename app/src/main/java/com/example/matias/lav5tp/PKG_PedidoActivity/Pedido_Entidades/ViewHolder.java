package com.example.matias.lav5tp.PKG_PedidoActivity.Pedido_Entidades;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.matias.lav5tp.PKG_PedidoActivity.IServices;
import com.example.matias.lav5tp.R;

/**
 * Created by matias on 30/04/2017.
 */

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView txtDescripcion;
    private TextView txtValor;
    private ImageButton btnImgBorrar;
    private IServices listener;
    private int posicion;

    public ViewHolder (View v, IServices listener){

        super(v);
        txtDescripcion = (TextView) v.findViewById(R.id.txtDescripcionPedido);
        txtValor = (TextView) v.findViewById(R.id.txtPrecioPedido);
        btnImgBorrar = (ImageButton) v.findViewById(R.id.imgBorrar);
        this.listener=listener;

        btnImgBorrar.setOnClickListener(this);
    }

    public void setTxtDescripcion(String descripcion){
        this.txtDescripcion.setText(descripcion);
    }

    public  void  setTxtValor(String valor){
        this.txtValor.setText(valor);
    }

    public void setPosicion(int pos){
        this.posicion=pos;
    }

    @Override
    public void onClick(View v) {
        listener.IBorrarItem(posicion);
    }
}
