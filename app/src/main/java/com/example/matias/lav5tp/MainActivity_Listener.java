package com.example.matias.lav5tp;

import android.util.Log;
import android.view.View;

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
        Log.d("Click", "se hizo click");
        if(v.getId()==R.id.btnResgistrarme)
        {
            Log.d("Click", "se hizo click");
            l.lanzarActivity();
        }
    }


}
