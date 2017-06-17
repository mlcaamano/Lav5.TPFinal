package com.example.matias.lav5tp.PKG_MenuActivity.Entidades;

/**
 * Created by matias on 17/06/2017.
 */

public class UsuarioLogueado {

    private static UsuarioLogueado usuarioActivo;
    private String mail;

    private UsuarioLogueado() {
    }

    public void setUsuarioActivo(String mail){
        this.mail= mail;
    }

    public String getMail(){
        return this.mail;
    }

    public static UsuarioLogueado getUsuarioActivo(){
        if(usuarioActivo==null){
            usuarioActivo = new UsuarioLogueado();
        }
        return usuarioActivo;
    }
}
