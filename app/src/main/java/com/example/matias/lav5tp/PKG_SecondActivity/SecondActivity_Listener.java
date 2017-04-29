package com.example.matias.lav5tp.PKG_SecondActivity;

import android.view.View;

import com.example.matias.lav5tp.PKG_MainActivity.ILanzar;
import com.example.matias.lav5tp.R;

/**
 * Created by matias on 29/04/2017.
 */

public class SecondActivity_Listener implements View.OnClickListener {

    IGuardar l;

    public SecondActivity_Listener(IGuardar l)
    {
        this.l=l;
    }


    public void onClick(View v){
        if(v.getId()== R.id.btnGuardar)
        {
            l.guadarUsuario();
        }
    }

}
