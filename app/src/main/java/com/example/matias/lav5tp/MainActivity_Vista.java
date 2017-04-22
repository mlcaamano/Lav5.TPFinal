package com.example.matias.lav5tp;

import android.content.Intent;
import android.widget.Button;

/**
 * Created by matias on 22/04/2017.
 */

public class MainActivity_Vista implements ILanzar {

    private MainActivity actividad;
    private Button btnIngresar;
    private Button btnRegistrarme;
    private MainActivity_Controlador controlador;

    public void setControlador(MainActivity_Controlador cont){
        this.controlador= cont;
        btnRegistrarme.setOnClickListener(controlador.getMiListener());
    }

    public MainActivity_Vista(MainActivity a)
    {
        this.actividad=a;

        btnIngresar= (Button) actividad.findViewById(R.id.btnIngresar);
        btnRegistrarme= (Button) actividad.findViewById(R.id.btnResgistrarme);
    }

    @Override
    public void lanzarActivity(){
        Intent i = new Intent(actividad, SecondActivity.class);
        actividad.startActivity(i);
    }

}
