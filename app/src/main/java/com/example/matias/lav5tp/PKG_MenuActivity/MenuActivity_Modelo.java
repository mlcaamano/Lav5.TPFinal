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

        listBedidas.add(new Bebidas("1", "Saborizada", Float.valueOf("18")));
        listBedidas.add(new Bebidas("1", "Gaseosa", Float.valueOf("20")));
        listBedidas.add(new Bebidas("1", "Agua", Float.valueOf("15")));

        listMenus.add(new Menus("1", "Milanesa", Float.valueOf("35")));
        listMenus.add(new Menus("1", "Hamburguesa", Float.valueOf("35")));
        listMenus.add(new Menus("1", "Pancho", Float.valueOf("15")));

        listSnacks.add(new Snacks("1", "Papas Fritas", Float.valueOf("20")));
        listSnacks.add(new Snacks("1", "Chicitos", Float.valueOf("20")));
        listSnacks.add(new Snacks("1", "Palito salados", Float.valueOf("20")));

    }


}
