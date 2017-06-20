package com.example.matias.lav5tp.PKG_MenuActivity;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.example.matias.lav5tp.PKG_Conexion.HiloTraerProductos;
import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Bebidas;
import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Menus;
import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Productos;
import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Snacks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matias on 30/04/2017.
 */

public class MenuActivity_Controlador implements Handler.Callback {

    MenuActivity_Listener listener;
    MenuActivity_Modelo miModelo;
    MenuActivity actividad;



    public MenuActivity_Controlador (MenuActivity_Listener miListener, MenuActivity_Modelo modelo, MenuActivity actividad){
        this.listener=miListener;
        miModelo = modelo;
        this.actividad= actividad;
    }

    public MenuActivity_Listener getListener(){
        return listener;
    }

    public void traerProductos(){

        Handler h = new Handler(this);
        HiloTraerProductos miHilo = new HiloTraerProductos(h);
        Thread hilo1 = new Thread(miHilo);
        hilo1.start();
    }


    @Override
    public boolean handleMessage(Message msg) {

        List<Productos> listProductos = (List<Productos>) msg.obj;
        List<Productos> listBebidas = new ArrayList<>();
        List<Productos> listMenus = new ArrayList<>();
        List<Productos> listSnacks = new ArrayList<>();

        if(msg.arg1==200){
            for (Productos p: listProductos) {
                if(p.getTipoProducto().equals("Bebida")){
                    listBebidas.add(new Bebidas(p.getImagen(), p.getDescripcion(), p.getValor(), p.getTipoProducto()));
                }
                if(p.getTipoProducto().equals("Principal")){
                    listMenus.add(new Menus(p.getImagen(), p.getDescripcion(), p.getValor(), p.getTipoProducto()));
                }
                if(p.getTipoProducto().equals("Snack")){
                    listSnacks.add(new Snacks(p.getImagen(), p.getDescripcion(), p.getValor(), p.getTipoProducto()));
                }
            }
            miModelo.setListBedidas(listBebidas);
            miModelo.setListMenus(listMenus);
            miModelo.setListSnacks(listSnacks);
        }
        if (msg.arg1==404)
        {
            Toast.makeText(actividad.getApplicationContext(), "Error al chequear productos existentes", Toast.LENGTH_LONG).show();
        }
        return true;
    }


}
