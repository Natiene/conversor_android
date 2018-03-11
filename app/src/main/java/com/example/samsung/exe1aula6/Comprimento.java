package com.example.samsung.exe1aula6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Comprimento extends AppCompatActivity {

    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprimento);

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

        float cm,mm,dm,m,km;
        cm=0.0f;mm=0.0f;dm=0.0f;m=0.0f;km=0.0f;
        float valor=0;

        if(!((EditText)findViewById(R.id.valor)).getText().toString().equals(""))
            valor = Float.parseFloat(((EditText)findViewById(R.id.valor))
                    .getText().toString());

        switch (opc){

            case "km":
                km = valor;
                mm = (km*1000)*1000;
                cm = (km*1000)*100;
                dm = (km*1000)*10;
                m = (km*1000);
                break;

            case "mm":
                mm = valor;
                cm = (mm/10);
                dm = (mm/100);
                m = (mm/1000);
                km = (mm/1000)/1000;

                break;

            case "cm":
                cm = valor;
                mm = (cm*10);
                dm = (cm/10);
                m = (cm/100);
                km = (cm/1000)/100;

                break;

            case "dm":
                dm = valor;
                mm = (dm*100);
                m = (dm/10);
                km = (dm/1000)/10;
                cm = (dm*10);

                break;

            case "m":
                m = valor;
                mm = (m*1000);
                cm = (m*100);
                dm = (m*10);
                km= (m/1000);

                break;

        }
        ((TextView)findViewById(R.id.txt1)).setText(mm+"");
        ((TextView)findViewById(R.id.txt2)).setText(cm+"");
        ((TextView)findViewById(R.id.txt3)).setText(dm+"");
        ((TextView)findViewById(R.id.txt4)).setText(m+"");
        ((TextView)findViewById(R.id.txt5)).setText(km+"");

    }
}
