package net.grapesoft.www.colgate;

import android.media.session.MediaController;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import android.widget.VideoView;

public class video extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView videoView = (VideoView) findViewById(R.id.VideoView);


      // TextView tvTituloVideo = (TextView) findViewById(R.id.tvTituloVideo);
      // tvTituloVideo.setText("El Régimen que va más con tu sonrisa es:");

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videocolgate));

        videoView.setMediaController(new android.widget.MediaController(this));
        videoView.start();

    }
}
