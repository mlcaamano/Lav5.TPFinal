package com.example.matias.lav5tp.PKG_SecondActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.matias.lav5tp.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().hide(); //Oculta el menu

        //Modelo
        SecondActivity_Vista miVista= new SecondActivity_Vista(this);
        SecondActivity_Controlador miControlador = new SecondActivity_Controlador(new SecondActivity_Listener(miVista));
        miVista.setControlador(miControlador);

    }
}
