package com.example.matias.lav5tp.PKG_Conexion;

import android.os.Handler;
import android.os.Message;

import com.example.matias.lav5tp.PKG_SecondActivity.Entidades.Usuario;

import org.json.JSONObject;

/**
 * Created by matias on 14/06/2017.
 */

public class HiloCargarUsuario implements Runnable {

    private Handler h;
    private Message miMensaje;
    private ConexionInternet miConexion;

    private Usuario nuevoUsuario;

    public HiloCargarUsuario(Handler h, Usuario u1) {
        this.h = h;
        this.nuevoUsuario=u1;
    }

    @Override
    public void run() {
        miConexion= ConexionInternet.getConexionInternet();
        miMensaje= new Message();

        try{


            //String obj = "{'nombre':"+nuevoUsuario.getNombre()+"'apellido':"+nuevoUsuario.getApellido()+"'dni':"+nuevoUsuario.getDni()+"'mail':"+nuevoUsuario.getMail()+"'clave':"+nuevoUsuario.getClave()+"}"

            JSONObject obj = new JSONObject();
            //obj.put("usuarios", nuevoUsuario);

            obj.put("nombre", nuevoUsuario.getNombre().toString());
            obj.put("apellido", nuevoUsuario.getApellido().toString());
            obj.put("dni", nuevoUsuario.getDni().toString());
            obj.put("mail", nuevoUsuario.getMail());
            obj.put("clave", nuevoUsuario.getClave());


            if(miConexion.postDataByPost(ConexionInternet.obtenerIP()+"/usuarios/nuevo", obj)){
                miMensaje.arg2=200;
            }
            else{
                miMensaje.arg2=404;
            }
        }catch (Exception e){
            e.printStackTrace();
            miMensaje.arg2=404;
        }
        h.sendMessage(miMensaje);
    }


}
