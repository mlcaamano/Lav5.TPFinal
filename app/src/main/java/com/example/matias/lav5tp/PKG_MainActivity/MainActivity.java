package com.example.matias.lav5tp.PKG_MainActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.matias.lav5tp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide(); //Oculta el menu

        MainActivity_Modelo miModelo= new MainActivity_Modelo();
        MainActivity_Vista miVista = new MainActivity_Vista(this, miModelo);
        MainActivity_Controlador miControlador = new MainActivity_Controlador((new MainActivity_Listener(miVista)));
        miVista.setControlador(miControlador);
    }
}
