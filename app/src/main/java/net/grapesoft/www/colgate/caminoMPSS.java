package net.grapesoft.www.colgate;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class caminoMPSS extends AppCompatActivity {

    boolean aa = false,bb = false,cc= false, dd = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camino_mpss);

        //Quitamos barra de notificaciones
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        final RadioButton radioA1 = (RadioButton) findViewById(R.id.radioA1);
        final RadioButton radioA2 = (RadioButton) findViewById(R.id.radioA2);

        final RadioButton radioB1 = (RadioButton) findViewById(R.id.radioB1);
        final RadioButton radioB2 = (RadioButton) findViewById(R.id.radioB2);
        final RadioButton radioC1 = (RadioButton) findViewById(R.id.radioC1);
        final RadioButton radioC2 = (RadioButton) findViewById(R.id.radioC2);
        final RadioButton radioD1 = (RadioButton) findViewById(R.id.radioD1);
        final RadioButton radioD2 = (RadioButton) findViewById(R.id.radioD2);

        radioA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton a = (RadioButton) v;
                a.setTextColor(Color.WHITE);
                radioA2.setTextColor(Color.BLACK);
                aa = true;
                siguiente();
            }
        });
        radioA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton a = (RadioButton) v;

                a.setTextColor(Color.WHITE);
                radioA1.setTextColor(Color.BLACK);
                aa = true;
                siguiente();

            }
        });
        radioB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton a = (RadioButton) v;
                a.setTextColor(Color.WHITE);
                radioB2.setTextColor(Color.BLACK);
                bb = true;
                siguiente();
            }
        });
        radioB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton a = (RadioButton) v;

                a.setTextColor(Color.WHITE);
                radioB1.setTextColor(Color.BLACK);
                bb = true;
                siguiente();
            }
        });
        radioC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton a = (RadioButton) v;
                a.setTextColor(Color.WHITE);
                radioC2.setTextColor(Color.BLACK);
                cc = true;
                siguiente();
            }
        });
        radioC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton a = (RadioButton) v;

                a.setTextColor(Color.WHITE);
                radioC1.setTextColor(Color.BLACK);
                cc = true;
                siguiente();
            }
        });
        radioD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton a = (RadioButton) v;
                a.setTextColor(Color.WHITE);
                radioD2.setTextColor(Color.BLACK);
                dd = true;
                siguiente();
            }
        });
        radioD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton a = (RadioButton) v;
                a.setTextColor(Color.WHITE);
                radioD1.setTextColor(Color.BLACK);
                dd = true;
                siguiente();
            }
        });


        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);


        int height = metrics.heightPixels; // alto absoluto en pixels
        Log.e("tamaño", "-" + height);
        TextView tvTituloVideo = (TextView) findViewById(R.id.tvTituloVideo);

        TextView tvOpcion1 = (TextView) findViewById(R.id.tvOpcion1);
        TextView tvOpcion2 = (TextView) findViewById(R.id.tvOpcion2);
        LinearLayout lytTitulo = (LinearLayout) findViewById(R.id.lytTitulo);

        if (height > 800) {
            if (tvTituloVideo != null) tvTituloVideo.setTextSize(17);
            if (tvOpcion1 != null) {
                tvOpcion1.setTextSize(13);
                tvOpcion1.setPadding(0, 0, 0, 0);
                //llOpcion1.setPadding(0, 0, 0, 0);
            }
            if (tvOpcion2 != null) {
                tvOpcion2.setTextSize(13);
                tvOpcion2.setPadding(0, 0, 0, 0);
               // llOpcion2.setPadding(0, 0, 0, 0);
            }
            if (lytTitulo != null) lytTitulo.setPadding(0, 0, 0, 0);

        } else {

        }
    }
    public void siguiente()
    {
        if(aa&&bb&&cc&&dd)
        {
            Intent i = new Intent(caminoMPSS.this,sana.class);
            startActivity(i);
        }
    }


}
