package com.example.matias.lav5tp.PKG_MenuActivity.Entidades;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.matias.lav5tp.R;

/**
 * Created by matias on 30/04/2017.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView txtDescripcion;
    TextView txtValor;

    public ViewHolder (View v){

        super(v);
        txtDescripcion = (TextView) v.findViewById(R.id.txtDescripcion);
        txtValor = (TextView) v.findViewById(R.id.txtPrecio);
    }

    public void setTxtDescripcion(String descripcion){
        this.txtDescripcion.setText(descripcion);
    }

    public  void  setTxtValor(String valor){
        this.txtValor.setText(valor);
    }
}
