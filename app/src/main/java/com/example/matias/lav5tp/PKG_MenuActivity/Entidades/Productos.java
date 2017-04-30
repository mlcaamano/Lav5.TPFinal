package com.example.matias.lav5tp.PKG_MenuActivity.Entidades;

/**
 * Created by matias on 30/04/2017.
 */

public class Productos {
    private String imagen;
    private String descripcion;
    private Float valor;

    protected Productos(String img, String desc, Float val){
        this.imagen= img;
        this.descripcion=desc;
        this.valor=val;
    }

    public String getImagen(){
        return this.imagen;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public Float getValor(){
        return this.valor;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }


}
