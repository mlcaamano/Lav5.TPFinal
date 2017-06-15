package com.example.matias.lav5tp.PKG_Conexion;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.example.matias.lav5tp.PKG_SecondActivity.Entidades.Usuario;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matias on 14/06/2017.
 */

public class HiloTraerUsuarios implements Runnable {

    private Handler h;
    private Message miMensaje;
    private ConexionInternet miConexion;

    public HiloTraerUsuarios(Handler h) {
        this.h = h;
    }

    @Override
    public void run() {
        miConexion= ConexionInternet.getConexionInternet();
        miMensaje= new Message();
        List<Usuario> listUsuario = new ArrayList<>();

        try{
            String s = new String(miConexion.getBytesDataByGet(ConexionInternet.obtenerIP()+"/usuarios/"));
            JSONArray array = new JSONArray(s);
            for(int i=0; i<array.length(); i++){
                JSONObject obj = array.getJSONObject(i);
                listUsuario.add(new Usuario(obj.getString("nombre"), obj.getString("apellido"), obj.getString("dni"), obj.getString("mail"), obj.getString("clave")));
            }


            if (listUsuario.isEmpty())
            {
                miMensaje.arg1=404;
            }
            else
            {
                miMensaje.obj = listUsuario;
                miMensaje.arg1=200;
            }
            h.sendMessage(miMensaje);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
