package com.example.matias.lav5tp.PKG_SecondActivity;

import com.example.matias.lav5tp.PKG_MainActivity.MainActivity_Listener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by matias on 29/04/2017.
 */

public class SecondActivity_Controlador {

    SecondActivity_Listener guardar_Listener;

    public SecondActivity_Controlador(SecondActivity_Listener l){

        this.guardar_Listener= l;
    }

    public SecondActivity_Listener getMiListener(){
        return guardar_Listener;
    }

    public boolean validarMail(String mail)
    {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = mail;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean clavesIguales(String s1, String s2)
    {
        if(s1.matches(s2)){
            return true;
        }
        else{
            return false;
        }
    }
}
