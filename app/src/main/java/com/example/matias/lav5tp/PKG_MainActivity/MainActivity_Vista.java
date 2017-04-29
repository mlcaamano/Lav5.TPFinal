package com.example.matias.lav5tp.PKG_MainActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.matias.lav5tp.MenuActivity;
import com.example.matias.lav5tp.R;
import com.example.matias.lav5tp.SecondActivity;

/**
 * Created by matias on 22/04/2017.
 */

public class MainActivity_Vista implements ILanzar {

    private MainActivity actividad;
    private Button btnIngresar;
    private Button btnRegistrarme;
    private MainActivity_Controlador controlador;
    private CheckBox chkRecordarme;
    private Intent i;

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
        chkRecordarme= (CheckBox) actividad.findViewById(R.id.chkRecordar);
        chequearDatosGuardados();
    }

    public void chequearDatosGuardados(){
        SharedPreferences pref= actividad.getSharedPreferences("ArchivoDatos", actividad.MODE_PRIVATE);
        String mail = pref.getString("mail", "");
        String clave = pref.getString("clave", "");

        if(mail.equals("algo@gmail.com") && clave.equals("123")) {
            i= new Intent(actividad, MenuActivity.class);
            actividad.startActivity(i);
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

            if (edMail.equals("") || edClave.equals("")) {
                Toast mensaje = Toast.makeText(actividad.getApplicationContext(), "Los campos deben estar completos", Toast.LENGTH_LONG);
                mensaje.show();
            }
            else if(mailEditText.getText().toString().equals("algo@gmail.com") && claveEditText.getText().toString().equals("123")){

                if(chkRecordarme.isChecked())
                {
                    SharedPreferences pref = actividad.getSharedPreferences("ArchivoDatos", actividad.MODE_PRIVATE);
                    SharedPreferences.Editor editor=pref.edit();
                    editor.putString("mail",mailEditText.getText().toString());
                    editor.putString("clave", claveEditText.getText().toString());
                    editor.commit();
                }

                i= new Intent(actividad, MenuActivity.class);
                actividad.startActivity(i);
            }
            else
            {
                Toast mensaje = Toast.makeText(actividad.getApplicationContext(), "Usuario o contraseña incorrecta", Toast.LENGTH_LONG);
                mensaje.show();
            }


        }
    }

}
