package com.example.matias.lav5tp.PKG_Conexion;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Productos;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matias on 17/06/2017.
 */

public class HiloTraerProductos implements Runnable {

    Handler h;
    ConexionInternet miConexion;
    Message miMensaje;

    public HiloTraerProductos(Handler h) {
        this.h = h;
    }

    @Override
    public void run() {
        miConexion= ConexionInternet.getConexionInternet();
        miMensaje= new Message();
        List<Productos> listProductos = new ArrayList<>();

        try{
            String s = new String(miConexion.getBytesDataByGet(ConexionInternet.obtenerIP()+"/productos/"));
            JSONArray array = new JSONArray(s);
            for(int i=0; i<array.length(); i++){
                JSONObject obj = array.getJSONObject(i);
                listProductos.add(new Productos(obj.getString("imagen"), obj.getString("nombre"), Float.valueOf(obj.getString("precio")), obj.getString("tipoMenu")));
            }

            if (listProductos.isEmpty())
            {
                miMensaje.arg1=404;
            }
            else
            {
                miMensaje.obj = listProductos;
                miMensaje.arg1=200;
            }
            h.sendMessage(miMensaje);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
