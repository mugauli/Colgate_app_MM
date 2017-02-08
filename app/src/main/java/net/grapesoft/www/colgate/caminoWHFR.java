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
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class caminoWHFR extends AppCompatActivity {

    boolean aa = false,bb = false,cc= false, dd = false;
    private int [] aux = new int[2];
    private int [] aux2  = new int[2];
    public int tamanoPregunta = 0,tamanoRadio = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camino_whfr);


        //Quitamos barra de notificaciones
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        final RadioButton radioA1 = (RadioButton)findViewById(R.id.radioA1);
        final RadioButton radioA2 = (RadioButton)findViewById(R.id.radioA2);

        final RadioButton radioB1 = (RadioButton)findViewById(R.id.radioB1);
        final RadioButton radioB2 = (RadioButton)findViewById(R.id.radioB2);
        final RadioButton radioC1 = (RadioButton)findViewById(R.id.radioC1);
        final RadioButton radioC2 = (RadioButton)findViewById(R.id.radioC2);
        final RadioButton radioD1 = (RadioButton)findViewById(R.id.radioD1);
        final RadioButton radioD2 = (RadioButton)findViewById(R.id.radioD2);

        radioA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton a = (RadioButton)v;
                a.setTextColor(Color.WHITE);
                radioA2.setTextColor(Color.BLACK);
                aa = true;
                aux[0]=1;
                siguiente();
            }
        });
        radioA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton a = (RadioButton)v;

                a.setTextColor(Color.WHITE);
                radioA1.setTextColor(Color.BLACK);
                aa = true;
                aux[0]=2;
                siguiente();

            }
        });
        radioB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton a = (RadioButton)v;
                a.setTextColor(Color.WHITE);
                radioB2.setTextColor(Color.BLACK);
                bb = true;
                aux[1]=1;
                siguiente();
            }
        });
        radioB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton a = (RadioButton)v;

                a.setTextColor(Color.WHITE);
                radioB1.setTextColor(Color.BLACK);
                bb = true;
                aux[1]=2;
                siguiente();
            }
        });
        radioC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton a = (RadioButton)v;
                a.setTextColor(Color.WHITE);
                radioC2.setTextColor(Color.BLACK);
                cc = true;
                aux2[0]=1;
                siguiente();
            }
        });
        radioC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton a = (RadioButton)v;

                a.setTextColor(Color.WHITE);
                radioC1.setTextColor(Color.BLACK);
                cc = true;
                aux2[0]=2;
                siguiente();
            }
        });
        radioD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton a = (RadioButton)v;
                a.setTextColor(Color.WHITE);
                radioD2.setTextColor(Color.BLACK);
                dd = true;
                aux2[1]=1;
                siguiente();
            }
        });
        radioD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton a = (RadioButton)v;
                a.setTextColor(Color.WHITE);
                radioD1.setTextColor(Color.BLACK);
                dd = true;
                aux2[1]=2;
                siguiente();
            }
        });


        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);


        int height = metrics.heightPixels; // alto absoluto en pixels
        Log.e("DBG: ","Tamaño "+height);
        TextView tvTituloVideo = (TextView) findViewById(R.id.tvTituloVideo);

        TextView tvOpcion1 = (TextView) findViewById(R.id.tvOpcion1);
        TextView tvOpcion2 = (TextView) findViewById(R.id.tvOpcion2);
        LinearLayout lyPrincipal = (LinearLayout) findViewById(R.id.lyPrincipal);


        //Tamaño

        if(height<500) {

            Log.e("DBG: ",height + " < 500");
            if (tvTituloVideo != null) tvTituloVideo.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
            if (lyPrincipal != null) lyPrincipal.setPadding(21,10,40,10);

            tamanoPregunta = 10;
            tamanoRadio = 12;

        } else if(height<580 && height>499) {

            Log.e("DBG "+height,"580 > " + height + " > 499");

            if (tvTituloVideo != null) tvTituloVideo.setTextSize(TypedValue.COMPLEX_UNIT_SP,39);
            if (lyPrincipal != null) lyPrincipal.setPadding(60,10,60,10);

            tamanoPregunta = 22;
            tamanoRadio = 28;


        }
        else if(height>700 && height< 1200 ) {

            Log.e("DBG: "," 700 < " + height + " < 1200");

            if (tvTituloVideo != null) tvTituloVideo.setTextSize(TypedValue.COMPLEX_UNIT_SP,42);
            if (lyPrincipal != null) lyPrincipal.setPadding(70,10,70,10);

            tamanoPregunta = 28;
            tamanoRadio = 30;
        }
        else if(height>1200) {

            Log.e("DBG: ", height +" > 1200");

            if (tvTituloVideo != null) tvTituloVideo.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
            if (lyPrincipal != null) lyPrincipal.setPadding(70,10,70,10);

            tamanoPregunta = 10;
            tamanoRadio = 12;

        }

        TextView askB1 = (TextView) findViewById(R.id.askB1);
        TextView askB2 = (TextView) findViewById(R.id.askB2);
        TextView askB3 = (TextView) findViewById(R.id.askB3);
        TextView askB4 = (TextView) findViewById(R.id.askB4);

        if(askB1 != null) askB1.setTextSize(TypedValue.COMPLEX_UNIT_SP,tamanoPregunta);
        if(askB2 != null) askB2.setTextSize(TypedValue.COMPLEX_UNIT_SP,tamanoPregunta);
        if(askB3 != null) askB3.setTextSize(TypedValue.COMPLEX_UNIT_SP,tamanoPregunta);
        if(askB4 != null) askB4.setTextSize(TypedValue.COMPLEX_UNIT_SP,tamanoPregunta);

        if(radioA1 != null) radioA1.setTextSize(TypedValue.COMPLEX_UNIT_SP,tamanoRadio);
        if(radioA2 != null) radioA2.setTextSize(TypedValue.COMPLEX_UNIT_SP,tamanoRadio);
        if(radioB1 != null) radioB1.setTextSize(TypedValue.COMPLEX_UNIT_SP,tamanoRadio);
        if(radioB2 != null) radioB2.setTextSize(TypedValue.COMPLEX_UNIT_SP,tamanoRadio);
        if(radioC1 != null) radioC1.setTextSize(TypedValue.COMPLEX_UNIT_SP,tamanoRadio);
        if(radioC2 != null) radioC2.setTextSize(TypedValue.COMPLEX_UNIT_SP,tamanoRadio);
        if(radioD1 != null) radioD1.setTextSize(TypedValue.COMPLEX_UNIT_SP,tamanoRadio);
        if(radioD2 != null) radioD2.setTextSize(TypedValue.COMPLEX_UNIT_SP,tamanoRadio);



    }

    public void siguiente()
    {
        int cont1=0,cont2=0;
        if(aa&&bb&&cc&&dd) {
            for (int j = 0; j <2 ; j++) {
                if(aux[j] == 1) {

                    cont1++;
                }
                if(aux2[j]==1){
                    cont2++;
                }

            }
            if (cont1 == cont2) {

                Intent i = new Intent(caminoWHFR.this, sanados.class);
                startActivity(i);
            }
            if (cont1 < cont2) {

                Intent i = new Intent(caminoWHFR.this, foto.class);
                i.putExtra("video", "4");
                startActivity(i);
            }
            if(cont2 < cont1) {

                Intent i = new Intent(caminoWHFR.this, foto.class);
                i.putExtra("video", "3");
                startActivity(i);
            }


        }
    }


}
