package net.grapesoft.www.colgate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
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

        Button btnCamera = (Button) findViewById(R.id.btnCamera);

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

                ImageView  capturedImage1 = (ImageView) findViewById(R.id.capturedImage);

                if(bp != null)
                capturedImage1.setImageBitmap(bp);
            }
        }

    }



}
