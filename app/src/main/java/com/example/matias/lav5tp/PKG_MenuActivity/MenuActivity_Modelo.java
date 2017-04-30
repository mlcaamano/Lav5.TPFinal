package com.example.matias.lav5tp.PKG_MenuActivity;

import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Bebidas;
import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Menus;
import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Productos;
import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Snacks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matias on 30/04/2017.
 */

public class MenuActivity_Modelo {

    List<Productos> listBedidas;
    List<Productos> listMenus;
    List<Productos> listSnacks;

    public MenuActivity_Modelo(){

        listBedidas = new ArrayList<Productos>();
        listMenus = new ArrayList<Productos>();
        listSnacks = new ArrayList<Productos>();

        listBedidas.add(new Bebidas("", "Saborizada", Float.valueOf("18")));
        listBedidas.add(new Bebidas("", "Gaseosa", Float.valueOf("20")));
        listBedidas.add(new Bebidas("", "Agua", Float.valueOf("15")));

        listMenus.add(new Menus("", "Milanesa", Float.valueOf("35")));
        listMenus.add(new Menus("", "Hamburguesa", Float.valueOf("35")));
        listMenus.add(new Menus("", "Pancho", Float.valueOf("15")));

        listSnacks.add(new Snacks("", "Papas Fritas", Float.valueOf("20")));
        listSnacks.add(new Snacks("", "Chicitos", Float.valueOf("20")));
        listSnacks.add(new Snacks("", "Palito salados", Float.valueOf("20")));
    }


}
