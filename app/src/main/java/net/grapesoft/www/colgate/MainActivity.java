package net.grapesoft.www.colgate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView btnEntrar = (ImageView) findViewById(R.id.btnEntrar);


      if (btnEntrar != null) {
          btnEntrar.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Log.e("Boton","1");
                  Intent i = new Intent(MainActivity.this,foto.class);
                  startActivity(i);
              }
          });
      }
    }
}
