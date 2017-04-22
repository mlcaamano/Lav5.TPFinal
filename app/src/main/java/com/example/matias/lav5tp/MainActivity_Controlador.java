package com.example.matias.lav5tp;

/**
 * Created by matias on 22/04/2017.
 */

public class MainActivity_Controlador {

    MainActivity_Listener lanzar_Listener;

    public MainActivity_Controlador(MainActivity_Listener l){

        this.lanzar_Listener=l;
    }

    public MainActivity_Listener getMiListener(){
        return lanzar_Listener;
    }
}
