package net.grapesoft.www.colgate;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;

public class caminoWHFR extends AppCompatActivity {

    boolean aa = false,bb = false,cc= false, dd = false;
    private int [] aux = new int[2];
    private int [] aux2  = new int[2];
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
