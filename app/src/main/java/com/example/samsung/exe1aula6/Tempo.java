package com.example.samsung.exe1aula6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Tempo extends AppCompatActivity {

    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempo);

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

        float ms,seg,min,hora,dia;
        ms=0.0f;seg=0.0f;min=0.0f;hora=0.0f;dia=0.0f;
        float valor=0;

        if(!((EditText)findViewById(R.id.valor)).getText().toString().equals(""))
            valor = Float.parseFloat(((EditText)findViewById(R.id.valor))
                    .getText().toString());

        switch (opc){

            case "ms":
                ms = valor;
                seg = (ms/1000);
                min = (seg/60);
                hora = (min/60);
                dia = (hora/24);
                break;

            case "seg":
                seg = valor;
                ms = seg*1000;
                min = (seg/60);
                hora = (min/60);
                dia = (hora/24);

                break;

            case "min":
                min = valor;
                seg = min*60;
                ms = seg*1000;
                hora = (min/60);
                dia = (hora/24);

                break;

            case "hora":
                hora = valor;
                min = hora*60;
                seg = min*60;
                ms = seg*1000;
                dia = (hora/24);

                break;

            case "dia":
                dia = valor;
                hora = dia*24;
                min = hora*60;
                seg = min*60;
                ms= seg*1000;

                break;

        }
        ((TextView)findViewById(R.id.txt1)).setText(ms+"");
        ((TextView)findViewById(R.id.txt2)).setText(seg+"");
        ((TextView)findViewById(R.id.txt3)).setText(min+"");
        ((TextView)findViewById(R.id.txt4)).setText(hora+"");
        ((TextView)findViewById(R.id.txt5)).setText(dia+"");

    }
}
