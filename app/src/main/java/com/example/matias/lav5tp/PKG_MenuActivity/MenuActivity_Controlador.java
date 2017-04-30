package com.example.matias.lav5tp.PKG_MenuActivity;

/**
 * Created by matias on 30/04/2017.
 */

public class MenuActivity_Controlador {

    MenuActivity_Listener listener;

    public MenuActivity_Controlador (MenuActivity_Listener miListener){
        this.listener=miListener;
    }

    public MenuActivity_Listener getListener(){
        return listener;
    }

}
