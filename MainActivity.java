package com.example.menuspiner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et1, et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.txt_valor1);
        et2 = (EditText) findViewById(R.id.txt_valor2);
        tv1 = (TextView) findViewById(R.id.tv_resultado);
        spinner1 = (Spinner) findViewById(R.id.spinner);

        String [] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};
        ArrayAdapter <String> adaptador  = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, opciones);
        spinner1.setAdapter(adaptador);
    }

    public void Calcular(View view){

        String valor1_String = et1.getText().toString();
        String valor2_String = et2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_String);

        String seleccion = spinner1.getSelectedItem().toString();
        if(seleccion.equals("Sumar")){
            int suma = valor1_int + valor2_int;
            String resultado = String.valueOf(suma);
            tv1.setText(resultado);
        }else if(seleccion.equals("Restar")){
            int resta = valor1_int-valor2_int;
            String resultado = String.valueOf(resta);
            tv1.setText(resultado);
        }else if(seleccion.equals("Multiplicar")){
            int mult = valor1_int*valor2_int;
            String resultado = String.valueOf(mult);
            tv1.setText(resultado);
        } else if(seleccion.equals("Dividir")){
            if(valor2_int!=0){
                int divi = valor1_int/valor2_int;
                String resultado = String.valueOf(divi);
                tv1.setText(resultado);
            } else {
                Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
            }
        }

    }

}