package com.example.matias.lav5tp.PKG_MenuActivity.Entidades;

import android.content.SharedPreferences;

import com.example.matias.lav5tp.PKG_PedidoActivity.PedidoActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matias on 17/06/2017.
 */

public class ListaPedido {
    private static List<Productos> listPedidos;

    private ListaPedido() {
    }

    public static List<Productos> getListPedidos(PedidoActivity actividad){
        if(listPedidos==null){
            listPedidos= new ArrayList<Productos>();
        }
        return listPedidos;
    }

    public void agregarProducto(Productos p){
        listPedidos.add(p);
    }

    public void borrarProducto(int posicion){
        listPedidos.remove(posicion);
    }

    public void vaciarLista(){
        listPedidos.clear();
    }

}
