package com.example.matias.lav5tp.PKG_MainActivity;

import android.view.View;

import com.example.matias.lav5tp.R;

/**
 * Created by matias on 22/04/2017.
 */

public class MainActivity_Listener implements View.OnClickListener{

    ILanzar l;

    public MainActivity_Listener(ILanzar l)
    {
        this.l=l;
    }


    public void onClick(View v){
        if(v.getId()== R.id.btnResgistrarme)
        {
            l.lanzarActivity(R.id.btnResgistrarme);
        }
        else if(v.getId()==R.id.btnIngresar){
            l.lanzarActivity((R.id.btnIngresar));
        }
    }


}
