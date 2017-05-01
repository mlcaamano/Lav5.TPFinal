package com.example.matias.lav5tp.PKG_MenuActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.MyAdapter;
import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Productos;
import com.example.matias.lav5tp.PKG_PedidoActivity.PedidoActivity;
import com.example.matias.lav5tp.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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

    private ImageButton btnImgSumar;

    private List<Productos> listaPedidos;

    Float valorDelPedido = Float.valueOf("0");
    Integer cantidadDeItems=Integer.valueOf("0");

    public void setMiControlador(MenuActivity_Controlador cont){
        this.miControlador=cont;
        btnBebidas.setOnClickListener(miControlador.getListener());
        btnmenus.setOnClickListener(miControlador.getListener());
        btnSnacks.setOnClickListener(miControlador.getListener());
        btnEnviarPedido.setOnClickListener(miControlador.getListener());
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
        listaPedidos = new ArrayList<Productos>();


    }

    public void cargarListPedido(){

        //Pasar a mi pedido

//        SharedPreferences prefs = actividad.getSharedPreferences("ArchivoList", actividad.MODE_PRIVATE);
//
//        Gson gson = new Gson();
//        String json = prefs.getString("lista", "");
//        Type type = new TypeToken<List<Productos>>(){}.getType();
//        listaPedidos= gson.fromJson(json, type);
//
//        for (Productos p : listaPedidos) {
//            valorDelPedido= valorDelPedido + Float.valueOf(p.getValor());
//            cantidadDeItems= cantidadDeItems + Integer.valueOf(1);
//        }
//        txtImporteTotal.setText(valorDelPedido.toString());
//        txtCantidadPedidos.setText(cantidadDeItems.toString());
    }

    public void agregarItemListaDePedido(int posicion, String tipoDeLista){

        if(tipoDeLista.equals("Bebidas"))
        {
            listaPedidos.add(miModelo.listBedidas.get(posicion));
            valorDelPedido= valorDelPedido + Float.valueOf(miModelo.listBedidas.get(posicion).getValor());
            cantidadDeItems= cantidadDeItems + Integer.valueOf(1);
        }
        else if(tipoDeLista.equals("Menus"))
        {
            listaPedidos.add(miModelo.listMenus.get(posicion));
            valorDelPedido= valorDelPedido + Float.valueOf(miModelo.listMenus.get(posicion).getValor());
            cantidadDeItems= cantidadDeItems + Integer.valueOf(1);
        }
        else if(tipoDeLista.equals("Snacks"))
        {
            listaPedidos.add(miModelo.listSnacks.get(posicion));
            valorDelPedido= valorDelPedido + Float.valueOf(miModelo.listSnacks.get(posicion).getValor());
            cantidadDeItems= cantidadDeItems + Integer.valueOf(1);
        }

//        SharedPreferences prefs = actividad.getSharedPreferences("ArchivoList", actividad.MODE_PRIVATE);
//        SharedPreferences.Editor editor = prefs.edit();
//
//        String json = new Gson().toJson(listaPedidos);
//        editor.putString("lista", json);
//        editor.commit();

        txtImporteTotal.setText(valorDelPedido.toString());
        txtCantidadPedidos.setText(cantidadDeItems.toString());

    }

    public void lanzarPedido(){

        if(listaPedidos.isEmpty())
        {
            Toast.makeText(actividad.getApplicationContext(), "Debe agregar item a para ponerlos en el pedido", Toast.LENGTH_SHORT).show();
        }
        else{
            SharedPreferences prefs = actividad.getSharedPreferences("ArchivoList", actividad.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            String json = new Gson().toJson(listaPedidos);
            editor.putString("lista", json);
            editor.commit();
            i= new Intent(actividad, PedidoActivity.class);
            actividad.startActivity(i);
        }
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
            adapter = new MyAdapter(miModelo.listBedidas, this, "Bebidas");
            rcv.setAdapter(adapter);
            rcv.setLayoutManager(layoutManager);
        }
        else if(ref== R.id.btnMenus)
        {
            layoutManager= new LinearLayoutManager(actividad);
            rcv = (RecyclerView) actividad.findViewById(R.id.rcvProductos);
            adapter = new MyAdapter(miModelo.listMenus, this, "Menus");
            rcv.setAdapter(adapter);
            rcv.setLayoutManager(layoutManager);
        }
        else if(ref== R.id.btnSnacks)
        {
            layoutManager= new LinearLayoutManager(actividad);
            rcv = (RecyclerView) actividad.findViewById(R.id.rcvProductos);
            adapter = new MyAdapter(miModelo.listSnacks, this, "Snacks");
            rcv.setAdapter(adapter);
            rcv.setLayoutManager(layoutManager);
        }
        else if (ref== R.id.btnEnviarPedido)
        {
            lanzarPedido();
        }

    }

    @Override
    public void onItemClick(int posicion, String tipoDeLista) {
        //Toast.makeText(actividad.getApplicationContext(), tipoDeLista, Toast.LENGTH_LONG).show();
        agregarItemListaDePedido(posicion, tipoDeLista);
    }
}
