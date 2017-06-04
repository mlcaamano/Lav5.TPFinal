package com.example.matias.lav5tp.PKG_MainActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.example.matias.lav5tp.PKG_Conexion.HiloLoguearUsuario;
import com.example.matias.lav5tp.PKG_MenuActivity.MenuActivity;

/**
 * Created by matias on 22/04/2017.
 */

public class MainActivity_Controlador implements Handler.Callback{

    private MainActivity_Listener lanzar_Listener;
    private MainActivity actividad;
    private boolean recordar;
    private String mail;
    private String clave;


    public MainActivity_Controlador(MainActivity_Listener l){

        this.lanzar_Listener=l;
    }

    public MainActivity_Listener getMiListener(){
        return lanzar_Listener;
    }

    public void validarLogIn(String textMail, String textClave, boolean recordar, MainActivity actividad){
        this.actividad=actividad;
        this.recordar=recordar;
        this.mail=textMail;
        this.clave=textClave;

        Handler h = new Handler(this);
        HiloLoguearUsuario miHilo = new HiloLoguearUsuario(h , textMail, textClave);
        Thread hilo1 = new Thread(miHilo);
        hilo1.start();

    }

    @Override
    public boolean handleMessage(Message msg) {
        if(msg.arg1==200){
            if (recordar){
                SharedPreferences pref = actividad.getSharedPreferences("ArchivoDatos", actividad.MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit();
                editor.putString("mail",mail.toString());
                editor.putString("clave", clave.toString());
                editor.commit();
            }

            Intent i= new Intent(actividad, MenuActivity.class);
            actividad.startActivity(i);
            actividad.finish();
        }
        else
        {
            Toast mensaje = Toast.makeText(actividad.getApplicationContext(), "Usuario o contraseña incorrecta", Toast.LENGTH_LONG);
            mensaje.show();
        }


        return true;
    }
}
