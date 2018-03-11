package com.example.samsung.exe1aula6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Volume extends AppCompatActivity {

    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

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

        float l,cm,dm,m,in;
        l=0.0f;cm=0.0f;dm=0.0f;m=0.0f;in=0.0f;
        float valor=0;

        if(!((EditText)findViewById(R.id.valor)).getText().toString().equals(""))
            valor = Float.parseFloat(((EditText)findViewById(R.id.valor))
                    .getText().toString());

        switch (opc){

            case "l":
                l = valor;
                cm = (l*1000);
                dm = (cm/1000);
                m = (dm/1000);
                in = (l*61.024f);
                break;

            case "cm³":
                cm = valor;
                l = (cm/1000);
                dm = (cm/1000);
                m = (dm/1000);
                in = (cm*61.024f);

                break;

            case "dm³":
                dm = valor;
                l = (dm*1);
                cm = (dm*1000);
                m = (dm/1000);
                in = (dm*61.024f);

                break;

            case "m³":
                m = valor;
                l = (m*1000);
                cm = (l*1000);
                dm = (m*1000);
                in = (m*61.024f);

                break;

            case "in³":
                in = valor;
                l = (in/61.024f);
                cm = (in*1000)/61.024f;
                dm = (in/61.024f);
                m= (in/1000)/61.024f;

                break;

        }
        ((TextView)findViewById(R.id.txt1)).setText(l+"");
        ((TextView)findViewById(R.id.txt2)).setText(cm+"");
        ((TextView)findViewById(R.id.txt3)).setText(dm+"");
        ((TextView)findViewById(R.id.txt4)).setText(m+"");
        ((TextView)findViewById(R.id.txt5)).setText(in+"");

    }
}