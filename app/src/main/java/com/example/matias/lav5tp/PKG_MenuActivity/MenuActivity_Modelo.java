package com.example.matias.lav5tp.PKG_MenuActivity;

import android.content.SharedPreferences;

import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Bebidas;
import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Menus;
import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Productos;
import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Snacks;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.type;

/**
 * Created by matias on 30/04/2017.
 */

public class MenuActivity_Modelo {

    List<Productos> listBedidas;
    List<Productos> listMenus;
    List<Productos> listSnacks;

    List<Productos> listPedidos;

    public MenuActivity_Modelo(){

        listBedidas = new ArrayList<Productos>();
        listMenus = new ArrayList<Productos>();
        listSnacks = new ArrayList<Productos>();

    }

    public List<Productos> getListBedidas() {
        return listBedidas;
    }

    public void setListBedidas(List<Productos> listBedidas) {
        this.listBedidas = listBedidas;
    }

    public List<Productos> getListMenus() {
        return listMenus;
    }

    public void setListMenus(List<Productos> listMenus) {
        this.listMenus = listMenus;
    }

    public List<Productos> getListSnacks() {
        return listSnacks;
    }

    public void setListSnacks(List<Productos> listSnacks) {
        this.listSnacks = listSnacks;
    }
}
