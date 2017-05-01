package com.example.matias.lav5tp.PKG_PedidoActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.matias.lav5tp.R;

public class PedidoActivity extends AppCompatActivity {

    PedidoActivity_Modelo miModelo;
    PedidoActivity_Vista miVista;
    PedidoActivity_Controlador miControlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        miModelo= new PedidoActivity_Modelo();
        miVista= new PedidoActivity_Vista(this);
        miControlador=new PedidoActivity_Controlador(new PedidoActivity_Listener(miVista));
        miVista.setMiControlador(miControlador);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.desplegablepedidoactivity,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== R.id.cerrarPedido){
            miVista.cerrarSesion();
        }
        if(item.getItemId() == R.id.limpiarPedido){
            miVista.limpiarListaPedido();
        }
        if(item.getItemId()==R.id.confirmarPedido){
            miVista.confirmarPedido();
        }

        return super.onOptionsItemSelected(item);
    }
}
