package net.grapesoft.www.colgate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.LinkedList;


public class tusdatos extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tusdatos);

        Spinner spiner_sexo = (Spinner) findViewById(R.id.spSexo);

        //Creamos el adaptador
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.sexo,android.R.layout.simple_spinner_item);
       //Añadimos el layout para el menú
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      //Le indicamos al spinner el adaptador a usar
        spiner_sexo.setAdapter(adapter);

        Spinner spiner_edad = (Spinner) findViewById(R.id.spEdad);

        LinkedList edades = new LinkedList();
        int edad_minima = Integer.parseInt(getString(R.string.edad_minimo));
        int edad_maxima = Integer.parseInt(getString(R.string.edad_maximo));

        for(int i = edad_minima ; i<edad_maxima;i++)
        {
            edades.add(new edad(i, i + " años"));
        }

        ArrayAdapter adapter_edad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, edades);


        adapter_edad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner_edad.setAdapter(adapter_edad);



        ImageView btnIr = (ImageView) findViewById(R.id.btnIr);


        if (btnIr != null) {
            btnIr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(tusdatos.this,decision.class);
                    startActivity(i);
                }
            });
        }



    }



}
