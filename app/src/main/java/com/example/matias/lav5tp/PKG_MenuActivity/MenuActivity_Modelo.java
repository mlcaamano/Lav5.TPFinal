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
//
//        listBedidas.add(new Bebidas("http://i1251.photobucket.com/albums/hh560/Beatlesrock2020/aqua.jpg", "Saborizada", Float.valueOf("18")));
//        listBedidas.add(new Bebidas("http://mla-s2-p.mlstatic.com/coca-cola-600cm3-12u-distribuidora-bebidas-9356-MLA20015167033_122013-F.jpg", "Gaseosa", Float.valueOf("20")));
//        listBedidas.add(new Bebidas("http://www.ribasmith.com/rimith/images/imgsprod/431050220-c.jpg", "Agua", Float.valueOf("15")));
//
//        listMenus.add(new Menus("https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/Milanesa_napolitana_%281%29.jpg/220px-Milanesa_napolitana_%281%29.jpg", "Milanesa", Float.valueOf("35")));
//        listMenus.add(new Menus("http://static.tvazteca.com/imagenes/2015/22/hamburguesa-1984023.jpg", "Hamburguesa", Float.valueOf("35")));
//        listMenus.add(new Menus("https://http2.mlstatic.com/S_723511-MLA20570914154_022016-O.jpg", "Pancho", Float.valueOf("15")));
//
//        listSnacks.add(new Snacks("https://s-media-cache-ak0.pinimg.com/736x/65/73/da/6573dac5b8bbdff16c12ad3b40613e92.jpg", "Papas Fritas", Float.valueOf("20")));
//        listSnacks.add(new Snacks("https://images01.olx-st.com/ui/50/48/92/21/o_1476366518_803707c886683469f6f82ea1b7648e2b.jpg", "Chicitos", Float.valueOf("20")));
//        listSnacks.add(new Snacks("https://http2.mlstatic.com/palitos-salados-x-5kg-D_NQ_NP_410021-MLA20677743230_042016-F.jpg", "Palito salados", Float.valueOf("20")));

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
