package com.example.samsung.exe1aula6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Temperatura extends AppCompatActivity {

    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);

        sp = (Spinner)findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                calcular(sp.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public  void calcular(String opc){
        //mostra na tela a opção que foi selecionada
        //Toast.makeText(getApplicationContext(),opc,Toast.LENGTH_LONG).show();

        float c,f,k;
        c=0.0f;f=0.0f;k=0.0f;
        float valor=0;

        if(!((EditText)findViewById(R.id.valor)).getText().toString().equals(""))
            valor = Float.parseFloat(((EditText)findViewById(R.id.valor))
                    .getText().toString());

        switch (opc){

            case "C":
                c = valor;
                f = (c*1.8f)+32.00f;
                k = (c+273.15f);

                break;

            case "F":
                f = valor;
                c = (f-32)/1.8f;
                k = (f-32)/1.8f+273.15f;


                break;

            case "K":
                k = valor;
                c = (k-273.15f);
                f = (k-273.15f)*1.8f+32.00f;


                break;


        }
        ((TextView)findViewById(R.id.txt1)).setText(c+"");
        ((TextView)findViewById(R.id.txt2)).setText(f+"");
        ((TextView)findViewById(R.id.txt3)).setText(k+"");


    }
}
