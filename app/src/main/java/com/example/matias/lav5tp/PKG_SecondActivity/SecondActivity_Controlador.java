package com.example.matias.lav5tp.PKG_SecondActivity;

import com.example.matias.lav5tp.PKG_MainActivity.MainActivity_Listener;

/**
 * Created by matias on 29/04/2017.
 */

public class SecondActivity_Controlador {

    SecondActivity_Listener guardar_Listener;

    public SecondActivity_Controlador(SecondActivity_Listener l){

        this.guardar_Listener= l;
    }

    public SecondActivity_Listener getMiListener(){
        return guardar_Listener;
    }
}
