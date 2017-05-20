package com.example.matias.lav5tp.PKG_Conexion;

import android.os.Handler;
import android.os.Message;

import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Productos;

import java.util.List;

/**
 * Created by matias on 20/05/2017.
 */

public class HiloCargarImagenes implements Runnable {

    private Handler h;
    private List<? extends Productos> lista;
    private String tipoLista;
    private Message miMensaje;
    private ConexionInternet miConexion;


    public HiloCargarImagenes(Handler h, List<? extends Productos> list, String tipo){
        this.h=h;
        this.lista=list;
        this.tipoLista=tipo;
    }

    @Override
    public void run() {
        miConexion= ConexionInternet.getConexionInternet();
        miMensaje = new Message();

        try{
            setearTipoLista();
            cargarEnListaImagen();
            h.sendMessage(miMensaje);
        }
        catch (Exception e){

        }
    }

    public void cargarEnListaImagen(){
        for (Productos producto: lista) {
            if(producto.getBitesImagen()==null)
            {
                try{
                    producto.setBitesImagen((byte[]) miConexion.getBytesDataByGet(producto.getImagen()));
                }
                catch (Exception e){

                }
            }
        }

        miMensaje.obj= lista;
    }

    public void setearTipoLista(){
        if(this.tipoLista=="Bebidas"){
            miMensaje.arg1=1;
        }
        else if(this.tipoLista=="Menus"){
            miMensaje.arg1=2;
        }
        else if(this.tipoLista=="Snacks"){
            miMensaje.arg1=3;
        }
    }
}
