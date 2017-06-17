package com.example.matias.lav5tp.PKG_Conexion;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Productos;
import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.UsuarioLogueado;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by matias on 17/06/2017.
 */

public class HiloRegistrarPedidos implements Runnable {

    Handler h;
    ConexionInternet miConexion;
    Message miMensaje;

    String mail;
    List<Productos> listProductos;

    public HiloRegistrarPedidos(Handler h, String mail, List<Productos> listProductos) {
        this.h = h;
        this.mail = mail;
        this.listProductos = listProductos;
    }

    @Override
    public void run() {
        miConexion= ConexionInternet.getConexionInternet();
        miMensaje= new Message();

        try{
            JSONObject obj = new JSONObject();
            obj.put("usuario", UsuarioLogueado.getUsuarioActivo().getMail().toString());

            JSONArray arrayPedidos = new JSONArray();


            for (Productos p:listProductos) {

                Log.d("LLEgo:", p.getTipoProducto().toString()+ " " +p.getDescripcion().toString());
                JSONObject jsonUnPedido = new JSONObject();

                jsonUnPedido.put("tipoMenu", p.getTipoProducto().toString());
                jsonUnPedido.put("nombre", p.getDescripcion().toString());
                jsonUnPedido.put("precio", p.getValor().toString());
                jsonUnPedido.put("imagen", p.getImagen().toString());

                arrayPedidos.put(jsonUnPedido);
            }

            obj.put("pedido", arrayPedidos);

            if(miConexion.postDataByPost(ConexionInternet.obtenerIP()+"/pedidos/nuevo", obj)){
                miMensaje.arg1=200;
            }
            else{
                miMensaje.arg1=404;
            }
        }catch (Exception e){
            e.printStackTrace();
            miMensaje.arg1=404;
        }
        h.sendMessage(miMensaje);
    }
}
