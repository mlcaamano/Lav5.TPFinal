package com.example.matias.lav5tp.PKG_PedidoActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matias.lav5tp.PKG_Conexion.HiloRegistrarPedidos;
import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.ListaPedido;
import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.Productos;
import com.example.matias.lav5tp.PKG_MenuActivity.Entidades.UsuarioLogueado;
import com.example.matias.lav5tp.PKG_MenuActivity.MenuActivity;
import com.example.matias.lav5tp.PKG_PedidoActivity.Pedido_Entidades.MyAdapter;
import com.example.matias.lav5tp.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matias on 01/05/2017.
 */

public class PedidoActivity_Vista implements IServices, Handler.Callback {

    private PedidoActivity actividad;
    private PedidoActivity_Controlador miControlador;
    private Intent i;

    private Button btnConfirmarPedido;
    private Button btnVolverAlMenu;
    private TextView txtTotalPedido;

    RecyclerView rcv;
    MyAdapter adapter;

    private List<Productos> listaPedido;

    private Float valorDelPedido = Float.valueOf("0");
    private Integer cantidadDeItems=Integer.valueOf("0");


    public PedidoActivity_Vista(PedidoActivity act){
        this.actividad=act;
        btnConfirmarPedido=(Button) actividad.findViewById(R.id.btnConfirmarPedido);
        btnVolverAlMenu = (Button) actividad.findViewById(R.id.btnVolverAlMenu);
        txtTotalPedido= (TextView) actividad.findViewById(R.id.txtTotalPedido);
        listaPedido= new ArrayList<Productos>();
        cargarListPedido();
    }

    public  void setMiControlador(PedidoActivity_Controlador cont){
        this.miControlador=cont;
        btnConfirmarPedido.setOnClickListener(miControlador.getListener());
        btnVolverAlMenu.setOnClickListener(miControlador.getListener());
        cargarRecycleView();
    }

    public void cargarRecycleView(){
        adapter= new MyAdapter(listaPedido, this);
        rcv= (RecyclerView) actividad.findViewById(R.id.rcvProductosPedidos);
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(new LinearLayoutManager(actividad));
    }

    public void cerrarSesion(){
        SharedPreferences pref = actividad.getSharedPreferences("ArchivoDatos", actividad.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString("mail","");
        editor.putString("clave", "");
        editor.commit();
        cerrarActivity();
    }

    public void cerrarActivity(){
        Intent i = new Intent(actividad, MenuActivity.class);
        actividad.startActivity(i);
        actividad.finish();
    }

    public void cargarListPedido(){
        listaPedido= ListaPedido.getListPedidos();
        cargarMontoCantidad();
    }

    public void cargarMontoCantidad(){
        valorDelPedido = Float.valueOf("0");
        cantidadDeItems = 0;
        for (Productos p : listaPedido) {
            valorDelPedido= valorDelPedido + Float.valueOf(p.getValor());
            cantidadDeItems= cantidadDeItems + Integer.valueOf(1);
        }

        txtTotalPedido.setText(valorDelPedido.toString());
    }

    public void confirmarPedido(){
        Handler h = new Handler(this);
        HiloRegistrarPedidos hilo1 = new HiloRegistrarPedidos(h, UsuarioLogueado.getUsuarioActivo().getMail().toString(), listaPedido);
        Thread miHilo = new Thread(hilo1);
        miHilo.start();
    }

    @Override
    public void ILanzarPedido(int ref) {
        if(ref== R.id.btnConfirmarPedido){
            confirmarPedido();
        }
        if(ref== R.id.btnVolverAlMenu){
            cerrarActivity();
        }
    }

    @Override
    public void IBorrarItem(int posicion) {
        listaPedido.remove(posicion);
        cargarMontoCantidad();
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean handleMessage(Message msg) {
        if(msg.arg1==200){
            Toast.makeText(actividad.getApplicationContext(), "Se ha confirmado la venta de "+ cantidadDeItems.toString() +" item/s por un total $" + valorDelPedido.toString(), Toast.LENGTH_LONG).show();
            ListaPedido.vaciarLista();
            cerrarActivity();
        }
        if(msg.arg2==404){
            Toast.makeText(actividad.getApplicationContext(), "Error al conectar", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}
