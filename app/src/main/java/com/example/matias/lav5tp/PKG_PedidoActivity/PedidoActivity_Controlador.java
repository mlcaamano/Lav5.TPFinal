package com.example.matias.lav5tp.PKG_PedidoActivity;

/**
 * Created by matias on 01/05/2017.
 */

public class PedidoActivity_Controlador {

    PedidoActivity_Listener listener;

    public PedidoActivity_Controlador(PedidoActivity_Listener l){
        this.listener=l;
    }

    public  PedidoActivity_Listener getListener(){
        return this.listener;
    }
}
