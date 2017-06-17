package com.example.matias.lav5tp.PKG_SecondActivity;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.example.matias.lav5tp.PKG_Conexion.HiloCargarUsuario;
import com.example.matias.lav5tp.PKG_Conexion.HiloTraerUsuarios;
import com.example.matias.lav5tp.PKG_SecondActivity.Entidades.Usuario;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by matias on 29/04/2017.
 */

public class SecondActivity_Controlador implements Handler.Callback {

    SecondActivity_Listener guardar_Listener;
    SecondActivity actividad;
    Usuario nuevoUsuario;

    public SecondActivity_Controlador(SecondActivity_Listener l){

        this.guardar_Listener= l;
    }

    public SecondActivity_Listener getMiListener(){
        return guardar_Listener;
    }


    public void validarUsuario(String nombre, String apellido, String dni, String mail, String clave, String reingrese, SecondActivity actividad){
        this.actividad=actividad;
        nuevoUsuario = new Usuario(nombre,apellido, dni, mail, clave);
        if (validarMail(mail)) {
            if(clavesIguales(clave, reingrese))
            {
                Handler h = new Handler(this);
                HiloTraerUsuarios miHilo = new HiloTraerUsuarios(h);
                Thread hilo1 = new Thread(miHilo);
                hilo1.start();
            }
            else
            {
                Toast.makeText(actividad.getApplicationContext(), "Las claves no coinciden", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(actividad.getApplicationContext(), "El tipo de mail no es valido", Toast.LENGTH_LONG).show();
        }
    }

    public boolean validarMail(String mail)
    {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = mail;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean clavesIguales(String s1, String s2)
    {
        if(s1.matches(s2)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean handleMessage(Message msg) {

        if(msg.arg1==200){
            List<Usuario> listUsuario=(List<Usuario>) msg.obj;


            try{
                for (Usuario u1: listUsuario) {
                    if(u1.getDni().equals(nuevoUsuario.getDni())){
                        throw new Exception();
                    }
                }
                Handler h2 = new Handler(this);
                HiloCargarUsuario miHilo2 = new HiloCargarUsuario(h2, nuevoUsuario);
                Thread hilo2 = new Thread(miHilo2);
                hilo2.start();

            }catch (Exception e){
                Toast.makeText(actividad.getApplicationContext(), "El DNI ya esta registrado", Toast.LENGTH_LONG).show();
            }

        }
        if (msg.arg1==404)
        {
            Toast.makeText(actividad.getApplicationContext(), "Error al chequear usuarios existentes", Toast.LENGTH_LONG).show();
        }
        if (msg.arg2==200){
            Toast.makeText(actividad.getApplicationContext(), "Se ha guardado exitosamente", Toast.LENGTH_LONG).show();
            actividad.finish();
        }
        if (msg.arg2==404)
        {
            Toast.makeText(actividad.getApplicationContext(), "Error al conectar", Toast.LENGTH_LONG).show();
        }


        return true;
    }
}
