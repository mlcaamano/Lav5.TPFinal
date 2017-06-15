package com.example.matias.lav5tp.PKG_SecondActivity.Entidades;

/**
 * Created by matias on 14/06/2017.
 */

public class Usuario {
    String nombre;
    String apellido;
    String dni;
    String mail;
    String clave;

    public Usuario(String nombre, String apellido, String dni, String mail, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.mail = mail;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getMail() {
        return mail;
    }

    public String getClave() {
        return clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
