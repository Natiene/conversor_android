package com.example.samsung.exe1aula6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Peso extends AppCompatActivity {

    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso);

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

        float mg,g,kg,lb,oz;
        mg=0.0f;kg=0.0f;lb=0.0f;oz=0.0f;g=0.0f;
        float valor=0;

        if(!((EditText)findViewById(R.id.valor)).getText().toString().equals(""))
            valor = Float.parseFloat(((EditText)findViewById(R.id.valor))
                    .getText().toString());

        switch (opc){

            case "mg":
                mg = valor;
                g = (mg/1000);
                kg = (g/1000);
                lb = (mg*0.0000022046f);
                oz = (mg*0.000035274f);
                break;

            case "g":
                g = valor;
                mg = (g*1000);
                kg = (mg/1000);
                lb = (g*0.0022046f);
                oz = (g*0.035274f);

                break;

            case "kg":
                kg = valor;
                g = (kg*1000);
                mg = (g*1000);
                lb = (kg*2.2046f);
                oz = (kg/3.5274f);

                break;

            case "lb":
                lb = valor;
                kg = (kg/2.2046f);
                g = (lb*220.46f);
                mg = (lb*220.46f);
                oz = (lb*220.46f);

                break;

            case "oz":
                oz = valor;
                kg = (oz*0.035274f);
                g = (oz*0.035274f);
                mg = (oz*0.035274f);
                lb= (oz*0.035274f);

                break;

        }
        ((TextView)findViewById(R.id.txt1)).setText(mg+"");
        ((TextView)findViewById(R.id.txt2)).setText(g+"");
        ((TextView)findViewById(R.id.txt3)).setText(kg+"");
        ((TextView)findViewById(R.id.txt4)).setText(lb+"");
        ((TextView)findViewById(R.id.txt5)).setText(oz+"");

    }
}
