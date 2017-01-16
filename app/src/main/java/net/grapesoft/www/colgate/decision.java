package net.grapesoft.www.colgate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class decision extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);

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
