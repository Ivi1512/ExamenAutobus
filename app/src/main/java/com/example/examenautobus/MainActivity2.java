package com.example.examenautobus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private int numPasajeros = 0;
    private double precioBillete = 0.0;
    private double ingresos = 0.0;
    private double gastos = 0.0;
    private double total = 0.0;
    //------------------------------------------------
    private TextView txtValorNumPasajeros2;
    private TextView txtValorPrecioViaje2;
    private TextView txtValorIngresos2;
    private TextView txtValorGastos2;
    private TextView txtValorTotal2;
    private EditText edtPrecioAutobus2;
    //------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //--------------------------------------------------------------------------------------
        txtValorNumPasajeros2 = (TextView) findViewById(R.id.txtValorNumPasajeros2);
        txtValorPrecioViaje2 = (TextView) findViewById(R.id.txtValorPrecioViaje2);
        txtValorIngresos2 = (TextView) findViewById(R.id.txtValorIngresos2);
        txtValorGastos2 = (TextView) findViewById(R.id.txtValorGastos2);
        txtValorTotal2 = (TextView) findViewById(R.id.txtValorTotal2);
        edtPrecioAutobus2 = (EditText) findViewById(R.id.edtPrecioAutobus2);
        //--------------------------------------------------------------------------------------
        Intent intent = getIntent();
        if(intent != null)
        {
            numPasajeros = intent.getIntExtra(MainActivity.EXTRA_NUM_VIAJEROS, 0);
            txtValorNumPasajeros2.setText(String.valueOf(numPasajeros));
            //--------------------------------------------------------------------------------------
            precioBillete = intent.getDoubleExtra(MainActivity.EXTRA_PRECIO_BILLETE, 0);
            txtValorPrecioViaje2.setText(String.valueOf(precioBillete + "€"));
            //--------------------------------------------------------------------------------------
            ingresos = intent.getDoubleExtra(MainActivity.EXTRA_INGRESOS, 0);
            txtValorIngresos2.setText(String.valueOf(ingresos + "€"));
            //--------------------------------------------------------------------------------------
            total = ingresos - gastos;
            txtValorGastos2.setText(String.valueOf(gastos + "€"));
            txtValorTotal2.setText(String.valueOf(total + "€"));
            //--------------------------------------------------------------------------------------
            Toast.makeText(this, "Número de pasajeros: "+ String.valueOf(numPasajeros), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Precio del billete: "+ String.valueOf(precioBillete) + "€", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Ingresos obtenidos: "+ String.valueOf(ingresos) + "€", Toast.LENGTH_SHORT).show();
        }
    }

    public void Aplicar(View view) {
        String textoPrecioAutobus = String.valueOf(edtPrecioAutobus2.getText());
        if(!textoPrecioAutobus.isEmpty()) {
            gastos = Double.valueOf(textoPrecioAutobus);
            total = ingresos - gastos;
            txtValorGastos2.setText(String.valueOf(gastos + "€"));
            txtValorTotal2.setText(String.valueOf(total + "€"));
        }
        else
        {
            edtPrecioAutobus2.setError("Debes introducir un valor");
        }
    }
}