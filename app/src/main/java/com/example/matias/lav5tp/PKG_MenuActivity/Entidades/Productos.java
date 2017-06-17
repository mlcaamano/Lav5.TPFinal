package com.example.matias.lav5tp.PKG_MenuActivity.Entidades;

/**
 * Created by matias on 30/04/2017.
 */

public class Productos {
    private String tipoProducto;
    private String imagen;
    private String descripcion;
    private Float valor;
    private  byte[] bitesImagen=null;

    public Productos(String img, String desc, Float val, String tipo){
        this.imagen= img;
        this.descripcion=desc;
        this.valor=val;
        this.tipoProducto=tipo;
    }

    public Productos(String img, String desc, Float val){
        this.imagen= img;
        this.descripcion=desc;
        this.valor=val;
    }



    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
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

    public void setBitesImagen(byte[] array){
        this.bitesImagen=array;
    }

    public byte[] getBitesImagen() {
        return bitesImagen;
    }

}
