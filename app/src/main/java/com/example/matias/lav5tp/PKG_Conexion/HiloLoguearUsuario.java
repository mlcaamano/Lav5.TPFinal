package com.example.matias.lav5tp.PKG_Conexion;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by matias on 04/06/2017.
 */

public class HiloLoguearUsuario implements Runnable {

    private Handler h;
    private Message miMensaje;
    private ConexionInternet miConexion;

    private String mail;
    private String clave;

    public HiloLoguearUsuario(Handler h, String mail, String clave) {
        this.h = h;
        this.mail = mail;
        this.clave = clave;

    }

    @Override
    public void run() {
        miConexion= ConexionInternet.getConexionInternet();
        miMensaje= new Message();
        try{
            String s = new String(miConexion.getBytesDataByGet("http://192.168.0.9:3000/usuarios/" + mail + "/" + clave));
            Log.d("Estado", s);
            if(s.contains("Validado")){
                miMensaje.arg1= 200;
            }
            h.sendMessage(miMensaje);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}

