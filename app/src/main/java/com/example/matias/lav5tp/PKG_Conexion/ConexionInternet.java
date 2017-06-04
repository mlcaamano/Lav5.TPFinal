package com.example.matias.lav5tp.PKG_Conexion;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by matias on 20/05/2017.
 */

public class ConexionInternet {

    private static ConexionInternet c;

    private ConexionInternet(){

    }

    public static ConexionInternet getConexionInternet(){

        if(c==null){
            c=new ConexionInternet();
        }

        return c;
    }

    public byte[] getBytesDataByGet(String strUrl) throws IOException {

        URL url = new URL(strUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        int response = urlConnection.getResponseCode();
        Log.d("http", "Response code:" + response);

        if (response==200)
        {
            InputStream is = urlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length = 0;

            while((length = is.read(buffer))!= -1)
            {
                baos.write(buffer, 0 , length);
            }

            is.close();
            return baos.toByteArray();
        }
        else
            throw new IOException();
    }

}
