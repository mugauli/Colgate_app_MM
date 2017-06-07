package net.grapesoft.www.colgate;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.LinkedList;


public class tusdatos extends AppCompatActivity {

    public int tamanoTextoSpinner = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tusdatos);

        //Quitamos barra de notificaciones
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //Spinner SEXO
        Spinner spiner_sexo = (Spinner) findViewById(R.id.spSexo);

        //Creamos el adaptador
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.sexo,android.R.layout.simple_spinner_item);
       //Añadimos el layout para el menú
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      //Le indicamos al spinner el adaptador a usar
        spiner_sexo.setAdapter(adapter);


        //Set the text color of the Spinner's selected view (not a drop down list view)
        spiner_sexo.setSelection(0, true);
        View v = spiner_sexo.getSelectedView();



        //Spinner EDADES
        Spinner spiner_edad = (Spinner) findViewById(R.id.spEdad);

        LinkedList edades = new LinkedList();
        int edad_minima = Integer.parseInt(getString(R.string.edad_minimo));
        int edad_maxima = Integer.parseInt(getString(R.string.edad_maximo));

        for(int i = edad_minima ; i<edad_maxima;i++)
        {
            edades.add(new edad(i, i + " años"));
        }

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);


        ArrayAdapter adapter_edad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, edades);
        adapter_edad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner_edad.setAdapter(adapter_edad);


        //Set the text color of the Spinner's selected view (not a drop down list view)
        spiner_edad.setSelection(0, true);
        View v2 = spiner_edad.getSelectedView();

//Tamaño del texto
        int height = metrics.heightPixels; // alto absoluto en pixels

        Log.e("DBG: ","Tamaño "+height);

        TextView tvEdad = (TextView) findViewById(R.id.tvEdad);
        TextView tvSexo = (TextView) findViewById(R.id.tvSexo);

        LinearLayout lytEdad = (LinearLayout) findViewById(R.id.lytEdad);
        LinearLayout lytSexo = (LinearLayout) findViewById(R.id.lytSexo);
        LinearLayout lyPrincipal = (LinearLayout) findViewById(R.id.lyPrincipal);


        if(height > 730)
        {
            if (lytSexo != null) lytSexo.setPadding(35,35,35,35);
            if (lytEdad != null) lytEdad.setPadding(35,35,35,35);
        }

        //Tamaño

        if(height < 500) {

            Log.e("DBG: ",height + " < 500");

            if (tvEdad != null){ tvEdad.setTextSize(18); tvEdad.setPadding(0,5,0,5);};
            if (tvSexo != null){ tvSexo.setTextSize(18); tvSexo.setPadding(0,5,0,5);};
            if (lyPrincipal != null) lyPrincipal.setPadding(40,20,40,20);

            tamanoTextoSpinner= 12;


        } else if(height < 580 && height >= 500) {

            Log.e("DBG: "+height,"580 > " + height + " > 499");

            if (tvEdad != null) tvEdad.setTextSize(50);
            if (tvSexo != null) tvSexo.setTextSize(50);
            if (lyPrincipal != null) lyPrincipal.setPadding(80,70,80,70);

            tamanoTextoSpinner= 39;

        }
        else if(height < 900 && height >= 700) {

            Log.e("DBG: "," 700 < " + height + " < 900");

            if (tvEdad != null){ tvEdad.setTextSize(40); tvEdad.setPadding(0,5,0,5);}
            if (tvSexo != null){ tvSexo.setTextSize(40); tvSexo.setPadding(0,5,0,5);}
            if (lyPrincipal != null) lyPrincipal.setPadding(80,70,80,70);

            tamanoTextoSpinner= 24;

        }
        else if(height < 1200 && height >= 900) {

            Log.e("DBG: "," 900 < " + height + " < 1200");

            if (tvEdad != null){ tvEdad.setTextSize(50); tvEdad.setPadding(0,5,0,5);}
            if (tvSexo != null){ tvSexo.setTextSize(50); tvSexo.setPadding(0,5,0,5);}
            if (lyPrincipal != null) lyPrincipal.setPadding(80,70,80,70);

            tamanoTextoSpinner= 39;

        }
        else if(height>1200) {

            Log.e("DBG: ", height +" > 1200");

            if (tvEdad != null) tvEdad.setTextSize(20);
            if (tvSexo != null) tvSexo.setTextSize(20);

            tamanoTextoSpinner= 17;


        }

        ((TextView)v).setTextSize(tamanoTextoSpinner);
        ((TextView)v).setTextColor(Color.DKGRAY);
        ((TextView)v2).setTextSize(tamanoTextoSpinner);
        ((TextView)v2).setTextColor(Color.DKGRAY);

        //Set the listener for when each option is clicked.
        spiner_edad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                //Change the selected item's text color
                ((TextView) view).setTextSize(tamanoTextoSpinner);
                ((TextView)view).setTextColor(Color.DKGRAY);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });



        //Set the listener for when each option is clicked.
        spiner_sexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                //Change the selected item's text color
                ((TextView) view).setTextSize(tamanoTextoSpinner);
                ((TextView)view).setTextColor(Color.DKGRAY);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });

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
