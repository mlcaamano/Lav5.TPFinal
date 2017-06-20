package com.example.matias.lav5tp.PKG_MenuActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matias.lav5tp.PKG_Conexion.HiloCargarImagenes;
import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Bebidas;
import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.ListaPedido;
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

public class MenuActivity_Vista implements IServices, Handler.Callback {

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
        miControlador.traerProductos();
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

        cargarListPedido();
    }

    public void cargarListPedido(){
        listaPedidos = ListaPedido.getListPedidos();

        for (Productos p : listaPedidos) {
            valorDelPedido= valorDelPedido + Float.valueOf(p.getValor());
            cantidadDeItems= cantidadDeItems + Integer.valueOf(1);
        }
        txtImporteTotal.setText(valorDelPedido.toString());
        txtCantidadPedidos.setText(cantidadDeItems.toString());
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

        txtImporteTotal.setText(valorDelPedido.toString());
        txtCantidadPedidos.setText(cantidadDeItems.toString());

    }

    public void lanzarPedido(){

        if(listaPedidos.isEmpty())
        {
            Toast.makeText(actividad.getApplicationContext(), "Debe agregar item a para ponerlos en el pedido", Toast.LENGTH_SHORT).show();
        }
        else{
            ListaPedido.guardarLista(listaPedidos);
            i= new Intent(actividad, PedidoActivity.class);
            actividad.startActivity(i);
            actividad.finish();
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
            cargarRcvBebidas();
            if(miModelo.listBedidas.get(0).getBitesImagen()==null){
                Handler h = new Handler(this);
                Thread miHilo = new Thread(new HiloCargarImagenes(h, miModelo.listBedidas, "Bebidas"));
                miHilo.start();
            }

        }
        else if(ref== R.id.btnMenus)
        {
            cargarRcvMenus();

            if(miModelo.listMenus.get(0).getBitesImagen()==null) {
                Handler h = new Handler(this);
                Thread miHilo = new Thread(new HiloCargarImagenes(h, miModelo.listMenus, "Menus"));
                miHilo.start();
            }
        }
        else if(ref== R.id.btnSnacks)
        {
            cargarRcvSnacks();

            if(miModelo.listSnacks.get(0).getBitesImagen()==null) {
                Handler h = new Handler(this);
                Thread miHilo = new Thread(new HiloCargarImagenes(h, miModelo.listSnacks, "Snacks"));
                miHilo.start();
            }
        }
        else if (ref== R.id.btnEnviarPedido)
        {
            lanzarPedido();
        }

    }

    public void cargarRcvBebidas(){
        layoutManager= new LinearLayoutManager(actividad);
        rcv = (RecyclerView) actividad.findViewById(R.id.rcvProductos);
        adapter = new MyAdapter(miModelo.listBedidas, this, "Bebidas");
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(layoutManager);
    }

    public void cargarRcvMenus(){
        layoutManager= new LinearLayoutManager(actividad);
        rcv = (RecyclerView) actividad.findViewById(R.id.rcvProductos);
        adapter = new MyAdapter(miModelo.listMenus, this, "Menus");
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(layoutManager);
    }

    public void cargarRcvSnacks(){
        layoutManager= new LinearLayoutManager(actividad);
        rcv = (RecyclerView) actividad.findViewById(R.id.rcvProductos);
        adapter = new MyAdapter(miModelo.listSnacks, this, "Snacks");
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(layoutManager);
    }

    @Override
    public void onItemClick(int posicion, String tipoDeLista) {
        agregarItemListaDePedido(posicion, tipoDeLista);
    }

    @Override
    public boolean handleMessage(Message msg) {
        if(msg.arg1==1){
            miModelo.listBedidas = (List<Productos>) msg.obj;
            cargarRcvBebidas();
        }
        else if(msg.arg1==2){
            miModelo.listMenus = (List<Productos>) msg.obj;
            cargarRcvMenus();
        }
        else if(msg.arg1==3){
            miModelo.listSnacks = (List<Productos>) msg.obj;
            cargarRcvSnacks();
        }
        return true;
    }
}
