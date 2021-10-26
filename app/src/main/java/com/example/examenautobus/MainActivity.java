package com.example.examenautobus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NUM_VIAJEROS = "numviajeros";
    public static final String EXTRA_PRECIO_BILLETE = "preciobillete";
    public static final String EXTRA_INGRESOS = "ingresosobtenidos";
    EditText edt_numViajeros = null;
    EditText edt_precioViaje = null;
    TextView txt_ingresosObtenidos = null;

    int numero_viajeros = 0;
    double precio_viaje = 0.0;
    double ingresos_recaudados = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_numViajeros = (EditText) findViewById(R.id.edt_numViajeros);
        edt_precioViaje = (EditText) findViewById(R.id.edt_precioViaje);
        txt_ingresosObtenidos = (TextView) findViewById(R.id.txt_verIngresos);




    }

    public void mostrar_ingresos(View view) {

        boolean errores = false;

        String texto_pasajeros = String.valueOf(edt_numViajeros.getText());
        if(!texto_pasajeros.isEmpty())
        {
            numero_viajeros = Integer.valueOf(texto_pasajeros);
        }
        else
        {
            edt_numViajeros.setError("Debes introducir el número de pasajeros que asistirán al viaje");
            errores = true;
        }
        //------------------------------------------------------------------------------
        String texto_ingresos = String.valueOf(edt_precioViaje.getText());
        if(!texto_ingresos.isEmpty())
        {
            precio_viaje = Double.valueOf(texto_ingresos);
        }
        else
        {
            edt_precioViaje.setError("Debes introducir el precio del billete");
            errores = true;
        }
        //------------------------------------------------------------------------------
        //Si hubo errores, termino el método
        if(errores)
        {
            return;
        }
        //------------------------------------------------------------------------------
        ingresos_recaudados = numero_viajeros * precio_viaje;
        txt_ingresosObtenidos.setText(String.valueOf(ingresos_recaudados) + "€");
    }


    public void siguiente(View view) {
        boolean errores = false;

        String texto_pasajeros = String.valueOf(edt_numViajeros.getText());
        if(!texto_pasajeros.isEmpty())
        {
            numero_viajeros = Integer.valueOf(texto_pasajeros);
        }
        else
        {
            edt_numViajeros.setError("Debes introducir el número de pasajeros que asistirán al viaje");
            errores = true;
        }
        //------------------------------------------------------------------------------
        String texto_ingresos = String.valueOf(edt_precioViaje.getText());
        if(!texto_ingresos.isEmpty())
        {
            precio_viaje = Double.valueOf(texto_ingresos);
        }
        else
        {
            edt_precioViaje.setError("Debes introducir el precio del billete");
            errores = true;
        }
        //------------------------------------------------------------------------------
        //Si hubo errores, termino el método
        if(errores)
        {
            return;
        }
        //------------------------------------------------------------------------------
        ingresos_recaudados = numero_viajeros * precio_viaje;
        txt_ingresosObtenidos.setText(String.valueOf(ingresos_recaudados) + "€");
        //------------------------------------------------------------------------------

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(EXTRA_NUM_VIAJEROS, numero_viajeros);
        intent.putExtra(EXTRA_PRECIO_BILLETE, precio_viaje);
        intent.putExtra(EXTRA_INGRESOS, ingresos_recaudados);
        startActivity(intent);
    }
}