package com.example.matias.lav5tp.PKG_PedidoActivity;

import android.view.View;

import com.example.matias.lav5tp.R;

/**
 * Created by matias on 01/05/2017.
 */

public class PedidoActivity_Listener implements View.OnClickListener {
    IServices listener;

    public PedidoActivity_Listener(IServices l){
        this.listener=l;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btnConfirmarPedido){
            listener.ILanzarPedido(R.id.btnConfirmarPedido);
        }
        if(v.getId()== R.id.btnVolverAlMenu){
            listener.ILanzarPedido(R.id.btnVolverAlMenu);
        }

    }
}
