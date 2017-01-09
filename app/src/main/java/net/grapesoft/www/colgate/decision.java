package net.grapesoft.www.colgate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class decision extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);

        //Quitamos barra de notificaciones
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        LinearLayout llOpcion1 = (LinearLayout) findViewById(R.id.llOpcion1);

        if (llOpcion1 != null) {
            llOpcion1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(decision.this,caminoMPSS.class);
                    startActivity(i);
                }
            });
        }
        LinearLayout llOpcion2 = (LinearLayout) findViewById(R.id.llOpcion2);
        if (llOpcion2 != null) {
            llOpcion2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(decision.this,caminoWHFR.class);
                    startActivity(i);
                }
            });
        }

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);


        int height = metrics.heightPixels; // alto absoluto en pixels
        Log.e("tamaño","-"+height);
        TextView tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        TextView tvOpcion1 = (TextView) findViewById(R.id.tvOpcion1);
        TextView tvOpcion2 = (TextView) findViewById(R.id.tvOpcion2);
        LinearLayout lytTitulo = (LinearLayout) findViewById(R.id.lytTitulo);

        if(height>800) {
            if (tvTitulo  != null) tvTitulo.setTextSize(17);
            if (tvOpcion1 != null) {
                tvOpcion1.setTextSize(13);
                tvOpcion1.setPadding(0, 0, 0, 0);
                llOpcion1.setPadding(0, 0, 0, 0);
            }
            if (tvOpcion2 != null) {
                tvOpcion2.setTextSize(13);
                tvOpcion2.setPadding(0,0,0,0);
                llOpcion2.setPadding(0,0,0,0);
            }
            if (lytTitulo != null) lytTitulo.setPadding(0,0,0,0);

        }else
        {

        }

    }
}
