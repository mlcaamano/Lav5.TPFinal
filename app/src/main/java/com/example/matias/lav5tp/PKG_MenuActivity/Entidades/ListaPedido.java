package com.example.matias.lav5tp.PKG_MenuActivity.Entidades;

import android.content.SharedPreferences;

import com.example.matias.lav5tp.PKG_PedidoActivity.PedidoActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
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
            SharedPreferences prefs = actividad.getSharedPreferences("ArchivoList", actividad.MODE_PRIVATE);
            Gson gson = new Gson();
            String json = prefs.getString("lista", "");
            Type type = new TypeToken<List<Productos>>(){}.getType();
            listPedidos= gson.fromJson(json, type);
        }

        return listPedidos;
    }

    public static void salvarLista(PedidoActivity actividad, List<Productos> listaPedido){
        SharedPreferences prefs = actividad.getSharedPreferences("ArchivoList", actividad.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        String json = new Gson().toJson(listaPedido);
        editor.putString("lista", json);
        editor.commit();
    }
}
