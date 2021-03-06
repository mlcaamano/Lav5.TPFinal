package com.example.matias.lav5tp.PKG_PedidoActivity.Pedido_Entidades;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matias.lav5tp.PKG_PedidoActivity.IServices;
import com.example.matias.lav5tp.R;

/**
 * Created by matias on 30/04/2017.
 */

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView imagen;
    private TextView txtDescripcion;
    private TextView txtValor;
    private ImageButton btnImgBorrar;
    private IServices listener;
    private int posicion;

    public ViewHolder (View v, IServices listener){

        super(v);
        imagen =(ImageView) v.findViewById(R.id.imagenPedido);
        txtDescripcion = (TextView) v.findViewById(R.id.txtDescripcionPedido);
        txtValor = (TextView) v.findViewById(R.id.txtPrecioPedido);
        btnImgBorrar = (ImageButton) v.findViewById(R.id.imgBorrar);
        this.listener=listener;

        btnImgBorrar.setOnClickListener(this);
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

    public  void setImagen(byte[] arrayDeBytes){
        if (arrayDeBytes==null)
        {

        }
        else{
            Bitmap bitmap = BitmapFactory.decodeByteArray(arrayDeBytes, 0, arrayDeBytes.length);
            imagen.setImageBitmap(bitmap);
        }

    }

    @Override
    public void onClick(View v) {
        listener.IBorrarItem(posicion);
    }
}
