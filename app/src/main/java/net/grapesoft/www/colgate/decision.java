package net.grapesoft.www.colgate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
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
                    ImageView img= (ImageView) findViewById(R.id.imageView);
                    img.setImageResource(R.drawable.vinetase);
                    Intent i = new Intent(decision.this,caminoWHFR.class);
                    startActivity(i);
                }
            });
        }
        LinearLayout llOpcion2 = (LinearLayout) findViewById(R.id.llOpcion2);
        if (llOpcion2 != null) {
            llOpcion2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView img= (ImageView) findViewById(R.id.imageView2);
                    img.setImageResource(R.drawable.vinetase);
                    Intent i = new Intent(decision.this,caminoMPSS.class);
                    startActivity(i);
                }
            });
        }



        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);


        int height = metrics.heightPixels; // alto absoluto en pixels
        //Log.e("DBG >---- Tamaño ---->"," "+height);

        TextView tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        TextView tvOpcion1 = (TextView) findViewById(R.id.tvOpcion1);
        TextView tvOpcion2 = (TextView) findViewById(R.id.tvOpcion2);


       LinearLayout lyPrincipal = (LinearLayout) findViewById(R.id.lyPrincipal);
       //LinearLayout lytSexo = (LinearLayout) findViewById(R.id.lytSexo);

       // if(height>730)
       // {
       //     if (lyPrincipal != null) lyPrincipal.setPadding(50,50,50,50);
       // }

        if(height<500) {

          //  Log.e("DBG: ",height + " < 500");

            if (lyPrincipal != null) lyPrincipal.setPadding(40,40,40,40);

            if (tvTitulo  != null) tvTitulo.setTextSize(TypedValue.COMPLEX_UNIT_SP,28);
            if (tvOpcion1 != null) {
                tvOpcion1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
                tvOpcion1.setPadding(3,7,0,0);
            }
            if (tvOpcion2 != null)
            {
                tvOpcion2.setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
                tvOpcion2.setPadding(3,7,0,0);
            }
        } else if(height<580 && height>499) {

          //  Log.e("DBG "+height,"580 > " + height + " > 499");

            if (lyPrincipal != null) lyPrincipal.setPadding(65,65,65,65);

            if (tvOpcion1 != null) {

                tvOpcion1.setPadding(6,16,0,0);
            }
            if (tvOpcion2 != null)
            {

                tvOpcion2.setPadding(6,16,0,0);
            }
        }
      else if(height>700 && height< 1200 ) {

          //  Log.e("DBG: "," 700 < " + height + " < 1200");

          if (lyPrincipal != null) lyPrincipal.setPadding(80,80,80,80);
          if (tvTitulo  != null) tvTitulo.setTextSize(TypedValue.COMPLEX_UNIT_SP,65);
          if (tvOpcion1 != null) {
              tvOpcion1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 37);
              tvOpcion1.setPadding(6,40,0,0);
          }
          if (tvOpcion2 != null)
          {
              tvOpcion2.setTextSize(TypedValue.COMPLEX_UNIT_SP,37);
              tvOpcion2.setPadding(6,20,0,0);
          }
      }
        else if(height>1200) {

         //   Log.e("DBG: ", height +" > 1200");

            if (lyPrincipal != null) lyPrincipal.setPadding(120,120,120,120);

            if (tvTitulo  != null) tvTitulo.setTextSize(TypedValue.COMPLEX_UNIT_SP,34);
            if (tvOpcion1 != null) {
                tvOpcion1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                tvOpcion1.setPadding(6,18,0,0);
            }
            if (tvOpcion2 != null)
            {
                tvOpcion2.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                tvOpcion2.setPadding(6,18,0,0);
            }
        }


    }
    protected void onRestart() {
        super.onRestart();  // Always call the superclass method first

        // Activity being restarted from stopped state
        ImageView img= (ImageView) findViewById(R.id.imageView);
        img.setImageResource(R.drawable.vineta);
        ImageView img2= (ImageView) findViewById(R.id.imageView2);
        img2.setImageResource(R.drawable.vineta);
    }
}
