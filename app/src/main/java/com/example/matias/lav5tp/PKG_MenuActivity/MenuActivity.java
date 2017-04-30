package com.example.matias.lav5tp.PKG_MenuActivity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.matias.lav5tp.R;

public class MenuActivity extends AppCompatActivity {

    MenuActivity_Modelo miModelo;
    MenuActivity_Vista miVista;
    MenuActivity_Controlador miControlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        miModelo = new MenuActivity_Modelo();
        miVista = new MenuActivity_Vista(this, miModelo);
        miControlador= new MenuActivity_Controlador(new MenuActivity_Listener(miVista));
        miVista.setMiControlador(miControlador);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.desplegablemenuactivity,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.verPedido)
        {
            miVista.lanzarPedido();
        }

        if(item.getItemId()==R.id.cerrar)
        {
            miVista.cerrarSesion();
        }


        return super.onOptionsItemSelected(item);
    }
}
