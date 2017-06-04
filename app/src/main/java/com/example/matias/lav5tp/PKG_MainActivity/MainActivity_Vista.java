package com.example.matias.lav5tp.PKG_MainActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.matias.lav5tp.PKG_MenuActivity.MenuActivity;
import com.example.matias.lav5tp.R;
import com.example.matias.lav5tp.PKG_SecondActivity.SecondActivity;

/**
 * Created by matias on 22/04/2017.
 */

public class MainActivity_Vista implements ILanzar{

    private MainActivity actividad;
    private Button btnIngresar;
    private Button btnRegistrarme;
    private MainActivity_Controlador controlador;
    private MainActivity_Modelo modelo;
    private CheckBox chkRecordarme;
    private Intent i;

    public void setControlador(MainActivity_Controlador cont){
        this.controlador= cont;
        btnRegistrarme.setOnClickListener(controlador.getMiListener());
        btnIngresar.setOnClickListener(controlador.getMiListener());
        chequearDatosGuardados();
    }

    public MainActivity_Vista(MainActivity a, MainActivity_Modelo mod)
    {
        this.actividad=a;
        this.modelo=mod;

        btnIngresar= (Button) actividad.findViewById(R.id.btnIngresar);
        btnRegistrarme= (Button) actividad.findViewById(R.id.btnResgistrarme);
        chkRecordarme= (CheckBox) actividad.findViewById(R.id.chkRecordar);

    }

    public void chequearDatosGuardados(){
        SharedPreferences pref= actividad.getSharedPreferences("ArchivoDatos", actividad.MODE_PRIVATE);
        String mail = pref.getString("mail", "");
        String clave = pref.getString("clave", "");

        if(mail.isEmpty() || clave.isEmpty())
        {

        }
        else
        {
            controlador.validarLogIn(mail,clave, false, actividad);
        }

    }

    @Override
    public void lanzarActivity(int ref){

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

            controlador.validarLogIn(mailEditText.getText().toString(),claveEditText.getText().toString(), chkRecordarme.isChecked(), actividad);
        }
    }
}
