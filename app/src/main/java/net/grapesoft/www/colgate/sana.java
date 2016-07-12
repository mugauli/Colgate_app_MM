package net.grapesoft.www.colgate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class sana extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sana);

        LinearLayout llOpcion1 = (LinearLayout) findViewById(R.id.llOpcion1);

        if (llOpcion1 != null) {
            llOpcion1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(sana.this,foto.class);
                    i.putExtra("video","1");
                    startActivity(i);
                }
            });
        }
        LinearLayout llOpcion2 = (LinearLayout) findViewById(R.id.llOpcion2);
        if (llOpcion2 != null) {
            llOpcion2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(sana.this,foto.class);
                    i.putExtra("video","2");
                    startActivity(i);
                }
            });
        }
    }
}
