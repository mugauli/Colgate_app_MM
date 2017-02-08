package net.grapesoft.www.colgate;

import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class foto extends AppCompatActivity {

    static final int PICK_CONTACT_REQUEST = 0;
    private ImageView capturedImage;

    String video = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        //Quitamos barra de notificaciones
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        video = getIntent().getExtras().getString("video");

        ImageButton btnCamera = (ImageButton) findViewById(R.id.btnCamera);

        if (btnCamera != null) {
            btnCamera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openCamera();

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
            if (tvTituloVideo != null) tvTituloVideo.setTextSize(TypedValue.COMPLEX_UNIT_SP,23);
            if (lyPrincipal != null) lyPrincipal.setPadding(65,30,60,20);


        } else if(height<580 && height>499) {

            Log.e("DBG: "+height,"580 > " + height + " > 499");

            if (tvTituloVideo != null) tvTituloVideo.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
            if (lyPrincipal != null) lyPrincipal.setPadding(87,25,87,25);


        }
        else if(height>700 && height< 1200 ) {

            Log.e("DBG: "," 700 < " + height + " < 1200");

            if (tvTituloVideo != null) tvTituloVideo.setTextSize(TypedValue.COMPLEX_UNIT_SP,63);
            if (lyPrincipal != null) lyPrincipal.setPadding(115,40,115,40);



        }
        else if(height>1200) {

            Log.e("DBG: ", height +" > 1200");

            if (tvTituloVideo != null) tvTituloVideo.setTextSize(TypedValue.COMPLEX_UNIT_SP,33);
            if (lyPrincipal != null) lyPrincipal.setPadding(200,70,200,70);


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
                final Bitmap bp = data.getParcelableExtra("data");

                Log.e("Imagen Map",bp.toString());

                ImageButton btnCamera = (ImageButton) findViewById(R.id.btnCamera);

                btnCamera.setVisibility(View.GONE);

                final ImageView  capturedImage1 = (ImageView) findViewById(R.id.capturedImage);

                if(bp != null)
                    capturedImage1.setImageBitmap(bp);

                final ImageView  e1 = (ImageView) findViewById(R.id.e1);
                final ImageView  e2 = (ImageView) findViewById(R.id.e2);
                final ImageView  e3 = (ImageView) findViewById(R.id.e3);
                final ImageView  e4 = (ImageView) findViewById(R.id.e4);
                final ImageView  e5 = (ImageView) findViewById(R.id.e5);

                new CountDownTimer(500, 100) { // 5000 = 5 sec

                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {


                        capturedImage1.setImageBitmap(toGrayscale(bp));
                        e5.setImageResource(R.drawable.raya2);
                    }
                }.start();

                new CountDownTimer(1000, 100) { // 5000 = 5 sec

                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        capturedImage1.setImageBitmap(bp);
                        e5.setVisibility(View.GONE);
                        e4.setImageResource(R.drawable.raya2);
                    }
                }.start();

                new CountDownTimer(1500, 100) { // 5000 = 5 sec

                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        capturedImage1.setImageBitmap(toGrayscale(bp));
                        e4.setVisibility(View.GONE);
                        e3.setImageResource(R.drawable.raya2);
                    }
                }.start();

                new CountDownTimer(2000, 100) { // 5000 = 5 sec

                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        capturedImage1.setImageBitmap(bp);
                        e3.setVisibility(View.GONE);
                        e2.setImageResource(R.drawable.raya2);
                    }
                }.start();

                new CountDownTimer(2500, 100) { // 5000 = 5 sec

                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        capturedImage1.setImageBitmap(toGrayscale(bp));
                        e2.setVisibility(View.GONE);
                        e1.setImageResource(R.drawable.raya2);

                    }
                }.start();

                new CountDownTimer(3000, 100) { // 5000 = 5 sec

                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        capturedImage1.setImageBitmap(bp);
                        e1.setVisibility(View.GONE);
                        Intent i = new Intent(foto.this,video.class);
                        i.putExtra("video",video);
                        startActivity(i);

                    }
                }.start();
            }
        }




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

    public Bitmap fastblur(Bitmap sentBitmap, float scale, int radius) {

        int width = Math.round(sentBitmap.getWidth() * scale);
        int height = Math.round(sentBitmap.getHeight() * scale);
        sentBitmap = Bitmap.createScaledBitmap(sentBitmap, width, height, false);

        Bitmap bitmap = sentBitmap.copy(sentBitmap.getConfig(), true);

        if (radius < 1) {
            return (null);
        }

        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        int[] pix = new int[w * h];
        Log.e("pix", w + " " + h + " " + pix.length);
        bitmap.getPixels(pix, 0, w, 0, 0, w, h);

        int wm = w - 1;
        int hm = h - 1;
        int wh = w * h;
        int div = radius + radius + 1;

        int r[] = new int[wh];
        int g[] = new int[wh];
        int b[] = new int[wh];
        int rsum, gsum, bsum, x, y, i, p, yp, yi, yw;
        int vmin[] = new int[Math.max(w, h)];

        int divsum = (div + 1) >> 1;
        divsum *= divsum;
        int dv[] = new int[256 * divsum];
        for (i = 0; i < 256 * divsum; i++) {
            dv[i] = (i / divsum);
        }

        yw = yi = 0;

        int[][] stack = new int[div][3];
        int stackpointer;
        int stackstart;
        int[] sir;
        int rbs;
        int r1 = radius + 1;
        int routsum, goutsum, boutsum;
        int rinsum, ginsum, binsum;

        for (y = 0; y < h; y++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            for (i = -radius; i <= radius; i++) {
                p = pix[yi + Math.min(wm, Math.max(i, 0))];
                sir = stack[i + radius];
                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);
                rbs = r1 - Math.abs(i);
                rsum += sir[0] * rbs;
                gsum += sir[1] * rbs;
                bsum += sir[2] * rbs;
                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }
            }
            stackpointer = radius;

            for (x = 0; x < w; x++) {

                r[yi] = dv[rsum];
                g[yi] = dv[gsum];
                b[yi] = dv[bsum];

                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;

                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];

                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];

                if (y == 0) {
                    vmin[x] = Math.min(x + radius + 1, wm);
                }
                p = pix[yw + vmin[x]];

                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);

                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];

                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;

                stackpointer = (stackpointer + 1) % div;
                sir = stack[(stackpointer) % div];

                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];

                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];

                yi++;
            }
            yw += w;
        }
        for (x = 0; x < w; x++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            yp = -radius * w;
            for (i = -radius; i <= radius; i++) {
                yi = Math.max(0, yp) + x;

                sir = stack[i + radius];

                sir[0] = r[yi];
                sir[1] = g[yi];
                sir[2] = b[yi];

                rbs = r1 - Math.abs(i);

                rsum += r[yi] * rbs;
                gsum += g[yi] * rbs;
                bsum += b[yi] * rbs;

                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }

                if (i < hm) {
                    yp += w;
                }
            }
            yi = x;
            stackpointer = radius;
            for (y = 0; y < h; y++) {
                // Preserve alpha channel: ( 0xff000000 & pix[yi] )
                pix[yi] = ( 0xff000000 & pix[yi] ) | ( dv[rsum] << 16 ) | ( dv[gsum] << 8 ) | dv[bsum];

                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;

                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];

                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];

                if (x == 0) {
                    vmin[y] = Math.min(y + r1, hm) * w;
                }
                p = x + vmin[y];

                sir[0] = r[p];
                sir[1] = g[p];
                sir[2] = b[p];

                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];

                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;

                stackpointer = (stackpointer + 1) % div;
                sir = stack[stackpointer];

                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];

                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];

                yi += w;
            }
        }

        Log.e("pix", w + " " + h + " " + pix.length);
        bitmap.setPixels(pix, 0, w, 0, 0, w, h);

        return (bitmap);
    }


}
