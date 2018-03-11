package com.example.samsung.exe1aula6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Area extends AppCompatActivity {

    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

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

        float cm,dm,m,in,ft;
        cm=0.0f;dm=0.0f;in=0.0f;m=0.0f;ft=0.0f;
        float valor=0;

        if(!((EditText)findViewById(R.id.valor)).getText().toString().equals(""))
            valor = Float.parseFloat(((EditText)findViewById(R.id.valor))
                    .getText().toString());

        switch (opc){

            case "cm²":
                cm = valor;
                dm = (cm/100f);
                m = (dm/100f);
                in =  (m/0.155f);
                ft = (in/0.0010764f);
                break;

            case "dm²":
                dm = valor;
                cm = (dm*100);
                m = (dm/100);
                in =  (m/0.155f);
                ft = (in/0.0010764f);

                break;

            case "m²":
                m = valor;
                dm = (m*100);
                cm = (dm*100);
                in =  (m/0.155f);
                ft = (in/0.0010764f);
                break;

            case "in²":
                m = valor;
                dm = (m*100);
                cm = (dm*100);
                in =  (m/0.155f);
                ft = (in/0.0010764f);
                break;

            case "ft²":
                m = valor;
                dm = (m*100);
                cm = (dm*100);
                in =  (m/0.155f);
                ft = (in/0.0010764f);
                break;
        }
        ((TextView)findViewById(R.id.txt1)).setText(dm+"");
        ((TextView)findViewById(R.id.txt2)).setText(cm+"");
        ((TextView)findViewById(R.id.txt3)).setText(m+"");
        ((TextView)findViewById(R.id.txt4)).setText(in+"");
        ((TextView)findViewById(R.id.txt5)).setText(ft+"");

    }
}
