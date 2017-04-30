package com.example.matias.lav5tp.PKG_MenuActivity;

import android.view.View;

import com.example.matias.lav5tp.R;

/**
 * Created by matias on 30/04/2017.
 */

public class MenuActivity_Listener implements View.OnClickListener {

    IServices l;

    public MenuActivity_Listener(IServices is)
    {
        this.l=is;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.btnBebidas){
            l.ILanzar(R.id.btnBebidas);
        }
        else if (v.getId()== R.id.btnMenus){
            l.ILanzar(R.id.btnMenus);
        }
        else if (v.getId()== R.id.btnSnacks){
            l.ILanzar(R.id.btnSnacks);
        }

    }
}
