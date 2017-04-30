package com.example.matias.lav5tp.PKG_MenuActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.MyAdapter;
import com.example.matias.lav5tp.PKG_PedidoActivity.PedidoActivity;
import com.example.matias.lav5tp.R;

/**
 * Created by matias on 30/04/2017.
 */

public class MenuActivity_Vista implements IServices {

    private MenuActivity actividad;
    private MenuActivity_Controlador miControlador;
    private MenuActivity_Modelo miModelo;
    private Intent i;

    RecyclerView.LayoutManager layoutManager;
    RecyclerView rcv;
    MyAdapter adapter;

    private Button btnEnviarPedido;
    private Button btnBebidas;
    private Button btnmenus;
    private Button btnSnacks;
    private TextView txtCantidadPedidos;
    private TextView txtImporteTotal;

    public void setMiControlador(MenuActivity_Controlador cont){
        this.miControlador=cont;
        btnBebidas.setOnClickListener(miControlador.getListener());
        btnmenus.setOnClickListener(miControlador.getListener());
        btnSnacks.setOnClickListener(miControlador.getListener());
    }

    public MenuActivity_Vista(MenuActivity a, MenuActivity_Modelo modelo){

        this.actividad=a;
        this.miModelo=modelo;

        btnEnviarPedido = (Button) actividad.findViewById(R.id.btnEnviarPedido);
        btnBebidas = (Button) actividad.findViewById(R.id.btnBebidas);
        btnmenus = (Button) actividad.findViewById(R.id.btnMenus);
        btnSnacks = (Button) actividad.findViewById(R.id.btnSnacks);
        txtCantidadPedidos = (TextView) actividad.findViewById(R.id.txtCantidadPedidos);
        txtImporteTotal = (TextView) actividad.findViewById(R.id.txtImporteTotal);
    }

    public void lanzarPedido(){
        i= new Intent(actividad, PedidoActivity.class);
        actividad.startActivity(i);
    }

    public void  cerrarSesion(){
        SharedPreferences pref = actividad.getSharedPreferences("ArchivoDatos", actividad.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString("mail","");
        editor.putString("clave", "");
        editor.commit();

        actividad.finish();
    }

    @Override
    public void ILanzar(int ref) {
        if(ref== R.id.btnBebidas)
        {
            layoutManager= new LinearLayoutManager(actividad);
            rcv = (RecyclerView) actividad.findViewById(R.id.rcvProductos);
            adapter = new MyAdapter(miModelo.listBedidas);
            rcv.setAdapter(adapter);
            rcv.setLayoutManager(layoutManager);
        }
        else if(ref== R.id.btnMenus)
        {
            layoutManager= new LinearLayoutManager(actividad);
            rcv = (RecyclerView) actividad.findViewById(R.id.rcvProductos);
            adapter = new MyAdapter(miModelo.listMenus);
            rcv.setAdapter(adapter);
            rcv.setLayoutManager(layoutManager);
        }
        else if(ref== R.id.btnSnacks)
        {
            layoutManager= new LinearLayoutManager(actividad);
            rcv = (RecyclerView) actividad.findViewById(R.id.rcvProductos);
            adapter = new MyAdapter(miModelo.listSnacks);
            rcv.setAdapter(adapter);
            rcv.setLayoutManager(layoutManager);
        }

    }
}
