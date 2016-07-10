package net.grapesoft.www.colgate;

import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;


public class foto extends AppCompatActivity {

    static final int PICK_CONTACT_REQUEST = 0;
    private ImageView capturedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        ImageButton btnCamera = (ImageButton) findViewById(R.id.btnCamera);

        if (btnCamera != null) {
            btnCamera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openCamera();

                }
            });
        }
    }
    private void openCamera() {


        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,PICK_CONTACT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            if(data.hasExtra("data")) {
                Bitmap bp = data.getParcelableExtra("data");

                Log.e("Imagen Map",bp.toString());

                ImageButton btnCamera = (ImageButton) findViewById(R.id.btnCamera);

                btnCamera.setVisibility(View.GONE);

                ImageView  capturedImage1 = (ImageView) findViewById(R.id.capturedImage);

                if(bp != null)
                capturedImage1.setImageBitmap(toGrayscale(bp));

            }
        }
        final ImageView  e1 = (ImageView) findViewById(R.id.e1);
        final ImageView  e2 = (ImageView) findViewById(R.id.e2);
        final ImageView  e3 = (ImageView) findViewById(R.id.e3);
        final ImageView  e4 = (ImageView) findViewById(R.id.e4);
        final ImageView  e5 = (ImageView) findViewById(R.id.e5);

        new CountDownTimer(500, 100) { // 5000 = 5 sec

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                e5.setImageResource(R.drawable.raya2);
            }
        }.start();

        new CountDownTimer(1000, 100) { // 5000 = 5 sec

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                e5.setVisibility(View.GONE);
                e4.setImageResource(R.drawable.raya2);
            }
        }.start();

        new CountDownTimer(1500, 100) { // 5000 = 5 sec

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                e4.setVisibility(View.GONE);
                e3.setImageResource(R.drawable.raya2);
            }
        }.start();

        new CountDownTimer(2000, 100) { // 5000 = 5 sec

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                e3.setVisibility(View.GONE);
                e2.setImageResource(R.drawable.raya2);
            }
        }.start();

        new CountDownTimer(2500, 100) { // 5000 = 5 sec

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                e2.setVisibility(View.GONE);
                e1.setImageResource(R.drawable.raya2);

            }
        }.start();

        new CountDownTimer(3000, 100) { // 5000 = 5 sec

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                e1.setVisibility(View.GONE);
                Intent i = new Intent(foto.this,video.class);
                startActivity(i);

            }
        }.start();

    }
    public Bitmap toGrayscale(Bitmap bmpOriginal)
    {
        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bmpOriginal, 0, 0, paint);
        return bmpGrayscale;
    }


}
