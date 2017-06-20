package com.example.matias.lav5tp.PKG_SecondActivity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matias.lav5tp.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by matias on 29/04/2017.
 */

public class SecondActivity_Vista implements IGuardar {

    private SecondActivity actividad;
    private SecondActivity_Controlador controlador;
    private Intent i;
    private EditText editNombre;
    private EditText editApellido;
    private EditText editDNI;
    private EditText editMail;
    private EditText editClave;
    private EditText editReingrese;
    private FloatingActionButton fabGuardar;

    public void setControlador(SecondActivity_Controlador cont){
        this.controlador= cont;
        fabGuardar.setOnClickListener(controlador.getMiListener());
    }

    public SecondActivity_Vista(SecondActivity a)
    {
        this.actividad=a;
        editNombre=(EditText) actividad.findViewById(R.id.editNombre);
        editApellido=(EditText) actividad.findViewById(R.id.editApellido);
        editDNI=(EditText) actividad.findViewById(R.id.editDNI);
        editMail=(EditText) actividad.findViewById(R.id.editMail);
        editClave=(EditText) actividad.findViewById(R.id.editClave);
        editReingrese=(EditText) actividad.findViewById(R.id.editReingrese);
        fabGuardar = (FloatingActionButton) actividad.findViewById(R.id.btnGuardar2);
    }


    @Override
    public void guadarUsuario() {

        String nombre= editNombre.getText().toString();
        String apellido= editApellido.getText().toString();
        String dni= editDNI.getText().toString();
        String mail= editMail.getText().toString();
        String clave=editClave.getText().toString();
        String reingrese=editReingrese.getText().toString();



        if(nombre.matches("") || apellido.matches("") || dni.matches("") || mail.matches("") || clave.matches("") || reingrese.matches(""))
        {
            Toast.makeText(actividad.getApplicationContext(), "Los campos no deben estar vacios", Toast.LENGTH_LONG).show();
        }
        else
        {
            controlador.validarUsuario(nombre, apellido, dni, mail, clave, reingrese, actividad);
        }
    }
}
