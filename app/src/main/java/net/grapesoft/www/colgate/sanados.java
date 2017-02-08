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
import android.widget.TextView;

public class sanados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanados);

        //Quitamos barra de notificaciones
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        LinearLayout llOpcion1 = (LinearLayout) findViewById(R.id.llOpcion1);

        if (llOpcion1 != null) {
            llOpcion1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView img= (ImageView) findViewById(R.id.imageView);
                    img.setImageResource(R.drawable.vinetase);
                    Intent i = new Intent(sanados.this,foto.class);

                  //      Intent i = new Intent(sanados.this,video.class);
                    i.putExtra("video","3");

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
                    Intent i = new Intent(sanados.this,foto.class);
                    i.putExtra("video","4");
                    startActivity(i);
                }
            });
        }

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);


        int height = metrics.heightPixels; // alto absoluto en pixels
        Log.e("DBG: ","Tamaño "+height);


        TextView tvTituloVideo = (TextView) findViewById(R.id.tvTitulo);
        LinearLayout lyPrincipal = (LinearLayout) findViewById(R.id.lyPrincipal);

        TextView tvOpcion1 = (TextView) findViewById(R.id.tvOpcion1);
        TextView tvOpcion2 = (TextView) findViewById(R.id.tvOpcion2);

        //Tamaño

        if(height<500) {

            Log.e("DBG: ",height + " < 500");
            if (tvTituloVideo != null) tvTituloVideo.setTextSize(TypedValue.COMPLEX_UNIT_SP,23);
            if (lyPrincipal != null) lyPrincipal.setPadding(65,30,60,20);

            if(tvOpcion1 != null) tvOpcion1.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
            if(tvOpcion2 != null) tvOpcion2.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);

            if(llOpcion1 != null) llOpcion1.setPadding(0,0,0,0);
            if(llOpcion2 != null) llOpcion2.setPadding(0,0,0,0);

        } else if(height<580 && height>499) {

            Log.e("DBG: "+height,"580 > " + height + " > 499");

            if (tvTituloVideo != null) tvTituloVideo.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
            if (lyPrincipal != null) lyPrincipal.setPadding(87,25,87,25);

            if(tvOpcion1 != null) tvOpcion1.setTextSize(TypedValue.COMPLEX_UNIT_SP,26);
            if(tvOpcion2 != null) tvOpcion2.setTextSize(TypedValue.COMPLEX_UNIT_SP,26);

            if(llOpcion1 != null) llOpcion1.setPadding(0,6,0,6);
            if(llOpcion2 != null) llOpcion2.setPadding(0,6,0,6);


        }
        else if(height>700 && height< 1200 ) {

            Log.e("DBG: "," 700 < " + height + " < 1200");

            if (tvTituloVideo != null) tvTituloVideo.setTextSize(TypedValue.COMPLEX_UNIT_SP,63);
            if (lyPrincipal != null) lyPrincipal.setPadding(115,40,115,40);

            if(tvOpcion1 != null) tvOpcion1.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
            if(tvOpcion2 != null) tvOpcion2.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);

            if(llOpcion1 != null) llOpcion1.setPadding(0,17,0,17);
            if(llOpcion2 != null) llOpcion2.setPadding(0,17,0,17);


        }
        else if(height>1200) {

            Log.e("DBG: ", height +" > 1200");

            if (tvTituloVideo != null) tvTituloVideo.setTextSize(TypedValue.COMPLEX_UNIT_SP,33);
            if (lyPrincipal != null) lyPrincipal.setPadding(200,70,200,70);

            if(tvOpcion1 != null) tvOpcion1.setTextSize(TypedValue.COMPLEX_UNIT_SP,19);
            if(tvOpcion2 != null) tvOpcion2.setTextSize(TypedValue.COMPLEX_UNIT_SP,19);

            if(llOpcion1 != null) llOpcion1.setPadding(0,6,0,6);
            if(llOpcion2 != null) llOpcion2.setPadding(0,6,0,6);

        }

    }
    @Override
    protected void onRestart() {
        super.onRestart();  // Always call the superclass method first

        // Activity being restarted from stopped state
        ImageView img= (ImageView) findViewById(R.id.imageView);
        img.setImageResource(R.drawable.vineta);
        ImageView img2= (ImageView) findViewById(R.id.imageView2);
        img2.setImageResource(R.drawable.vineta);
    }
}
