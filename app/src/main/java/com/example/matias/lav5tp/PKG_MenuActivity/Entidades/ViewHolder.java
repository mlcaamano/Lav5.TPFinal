package com.example.matias.lav5tp.PKG_MenuActivity.Entidades;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matias.lav5tp.PKG_MenuActivity.IServices;
import com.example.matias.lav5tp.PKG_MenuActivity.MenuActivity_Controlador;
import com.example.matias.lav5tp.R;

/**
 * Created by matias on 30/04/2017.
 */

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView imagen;
    private TextView txtDescripcion;
    private TextView txtValor;
    private ImageButton btnImgSumar;
    private IServices listener;
    private int posicion;
    private  String tipoDeLista;

    public ViewHolder (View v, IServices listener, String tipo){

        super(v);
        imagen =(ImageView) v.findViewById(R.id.imagenMenu);
        txtDescripcion = (TextView) v.findViewById(R.id.txtDescripcion);
        txtValor = (TextView) v.findViewById(R.id.txtPrecio);
        btnImgSumar = (ImageButton) v.findViewById(R.id.imgSumar);
        this.listener=listener;
        this.tipoDeLista=tipo;

        btnImgSumar.setOnClickListener(this);
    }

    public void setTxtDescripcion(String descripcion){
        this.txtDescripcion.setText(descripcion);
    }

    public  void  setTxtValor(String valor){
        this.txtValor.setText(valor);
    }

    public void setPosicion(int pos){
        this.posicion=pos;
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(posicion, tipoDeLista);
    }
}
