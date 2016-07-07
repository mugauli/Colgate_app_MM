package net.grapesoft.www.colgate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;


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
