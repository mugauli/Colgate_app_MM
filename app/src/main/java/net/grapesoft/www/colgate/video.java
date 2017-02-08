package net.grapesoft.www.colgate;

import android.content.Intent;
import android.media.session.MediaController;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

public class video extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        //Quitamos barra de notificaciones
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        VideoView videoView = (VideoView) findViewById(R.id.VideoView);
        String  video = getIntent().getExtras().getString("video");

      // TextView tvTituloVideo = (TextView) findViewById(R.id.tvTituloVideo);
      // tvTituloVideo.setText("El Régimen que va más con tu sonrisa es:");

        switch (video)
        {
            case "1":
                videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videocolgate1));
                break;
            case "2":
                videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videocolgate2));
                break;
            case "3":
                videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videocolgate3));
                break;
            case "4":
                videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videocolgate4));
                break;
            default:
                videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videocolgate1));
                break;
        }



        videoView.setMediaController(new android.widget.MediaController(this));
        videoView.start();

        ImageView btnIr = (ImageView) findViewById(R.id.btnIr);


        if (btnIr != null) {
            btnIr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(video.this,MainActivity.class);
                    startActivity(i);
                }
            });
        }

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);


        int height = metrics.heightPixels; // alto absoluto en pixels
        Log.e("DBG: ","Tamaño "+height);


        TextView tvTituloVideo = (TextView) findViewById(R.id.tvTituloVideo);
        LinearLayout lyPrincipal = (LinearLayout) findViewById(R.id.lyPrincipal);


        //Tamaño

        if(height<500) {

            Log.e("DBG: ",height + " < 500");
            if (tvTituloVideo != null) tvTituloVideo.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
            if (lyPrincipal != null) lyPrincipal.setPadding(65,30,60,20);


        } else if(height<580 && height>499) {

            Log.e("DBG: "+height,"580 > " + height + " > 499");

            if (tvTituloVideo != null) tvTituloVideo.setTextSize(TypedValue.COMPLEX_UNIT_SP,38);
            if (lyPrincipal != null) lyPrincipal.setPadding(87,25,87,25);


        }
        else if(height>700 && height< 1200 ) {

            Log.e("DBG: "," 700 < " + height + " < 1200");

            if (tvTituloVideo != null) tvTituloVideo.setTextSize(TypedValue.COMPLEX_UNIT_SP,51);
            if (lyPrincipal != null) lyPrincipal.setPadding(115,40,115,40);



        }
        else if(height>1200) {

            Log.e("DBG: ", height +" > 1200");

            if (tvTituloVideo != null) tvTituloVideo.setTextSize(TypedValue.COMPLEX_UNIT_SP,33);
            if (lyPrincipal != null) lyPrincipal.setPadding(200,70,200,70);


        }



    }

        /*Intent i = new Intent(video.this, MainActivity.class);
        startActivity(i);*/
        //Nuestro código a ejecutar en este momento

}
