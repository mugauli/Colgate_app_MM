package net.grapesoft.www.colgate;

import android.media.session.MediaController;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.WindowManager;
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

    }
}
