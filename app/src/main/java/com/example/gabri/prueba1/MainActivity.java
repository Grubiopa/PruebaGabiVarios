package com.example.gabri.prueba1;

import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    Handler h2 = new Handler();
    boolean sentido = true;
    Runnable run = new Runnable() {

        @Override
        public void run() {
            Button boton2 = (Button) findViewById(R.id.button3);
            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            int width = metrics.widthPixels; // ancho absoluto en pixels
            int height = metrics.heightPixels; // alto absoluto en pixels

            if(sentido){
                boton2.setX(boton2.getX()+10);
            }else{
                boton2.setX(boton2.getX()-10);
            }
            if((boton2.getX()+boton2.getWidth() >= width - 10 )|| (boton2.getX() <=10))
                sentido=!sentido;

            h2.postDelayed(this, 50);
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = (Button) findViewById(R.id.button);
        boton.setText("HOla");
    }

    public void cambiarMensaje(View v){
        //TextView texto = (TextView) findViewById(R.id.textView);
        Button boton2 = (Button) findViewById(R.id.button2);
        //SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
        //Date fechaActual = Calendar.getInstance().getTime();

        //String s = formato.format(fechaActual);
        //texto.setText(String.format("Botón presionado: %s", s));

        if (boton2.getVisibility()==View.VISIBLE)
        boton2.setVisibility(View.INVISIBLE);
        else  boton2.setVisibility(View.VISIBLE);

        h2.postDelayed(run, 0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);

        switch (action) {
            case (MotionEvent.ACTION_DOWN):

                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                int width = metrics.widthPixels; // ancho absoluto en pixels
                int height = metrics.heightPixels; // alto absoluto en pixels

                Float x = event.getX();
                Button boton = (Button) findViewById(R.id.button);
                if (x > width/2){
                    boton.setX(boton.getX()+5);
                }else{
                    boton.setX(boton.getX()-5);
                }
                return true;

            default:
                return super.onTouchEvent(event);
        }
    }
}
