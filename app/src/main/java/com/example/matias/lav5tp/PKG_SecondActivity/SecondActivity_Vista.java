package com.example.matias.lav5tp.PKG_SecondActivity;

import android.content.Intent;
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
    private Button btnIngresar;
    private SecondActivity_Controlador controlador;
    private Intent i;
    private EditText editNombre;
    private EditText editApellido;
    private EditText editDNI;
    private EditText editMail;
    private EditText editClave;
    private EditText editReingrese;

    public void setControlador(SecondActivity_Controlador cont){
        this.controlador= cont;
        btnIngresar.setOnClickListener(controlador.getMiListener());
        btnIngresar.setOnClickListener(controlador.getMiListener());
    }

    public SecondActivity_Vista(SecondActivity a)
    {
        this.actividad=a;

        btnIngresar= (Button) actividad.findViewById(R.id.btnGuardar);
        editNombre=(EditText) actividad.findViewById(R.id.editNombre);
        editApellido=(EditText) actividad.findViewById(R.id.editApellido);
        editDNI=(EditText) actividad.findViewById(R.id.editDNI);
        editMail=(EditText) actividad.findViewById(R.id.editMail);
        editClave=(EditText) actividad.findViewById(R.id.editClave);
        editReingrese=(EditText) actividad.findViewById(R.id.editReingrese);
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
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            CharSequence inputStr = mail;

            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(inputStr);
            if (matcher.matches()) {
                if(clave.matches(reingrese))
                {
                    //Posteriormente aqui desarrollara codigo para verificar que el dni no se repita
                    Toast.makeText(actividad.getApplicationContext(), "Se ha guardado exitosamente", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(actividad.getApplicationContext(), "Las claves no coinciden", Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Toast.makeText(actividad.getApplicationContext(), "El tipo de mail no es valido", Toast.LENGTH_LONG).show();
            }
        }


    }
}
