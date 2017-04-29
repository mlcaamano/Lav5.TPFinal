package com.example.matias.lav5tp;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        btnIngresar.setOnClickListener(controlador.getMiListener());
    }

    public MainActivity_Vista(MainActivity a)
    {
        this.actividad=a;

        btnIngresar= (Button) actividad.findViewById(R.id.btnIngresar);
        btnRegistrarme= (Button) actividad.findViewById(R.id.btnResgistrarme);
    }

    @Override
    public void lanzarActivity(int ref){
        Intent i;

        if(ref==R.id.btnResgistrarme)
        {
            i= new Intent(actividad, SecondActivity.class);
            actividad.startActivity(i);
        }
        else if (ref==R.id.btnIngresar){
            EditText mailEditText = (EditText) actividad.findViewById(R.id.edMail);
            String edMail = mailEditText.getText().toString();
            EditText claveEditText= (EditText) actividad.findViewById(R.id.edClave);
            String edClave= claveEditText.getText().toString();

            if (edMail.equals("") || edClave.equals("")) {
                Toast mensaje = Toast.makeText(actividad.getApplicationContext(), "Los campos deben estar completos", Toast.LENGTH_LONG);
                mensaje.show();
            }
            else if(mailEditText.getText().toString().equals("algo@gmail.com") && claveEditText.getText().toString().equals("123")){
                i= new Intent(actividad, MenuActivity.class);
                actividad.startActivity(i);
            }


        }
    }

}
