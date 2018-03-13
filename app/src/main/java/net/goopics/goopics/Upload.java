package net.goopics.goopics;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.rximagepicker.RxImagePicker;
import com.loopj.android.http.*;
import cz.msebera.android.httpclient.Header;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action1;

public class Upload extends AppCompatActivity{
    private boolean state;
    private static String TAG = MainActivity.class.getSimpleName();
    private static final int RC_CAMERA = 3000;
    private TextView textView;
    ProgressBar barre;
    android.widget.ImageView imagepick;
    private ArrayList<com.esafirm.imagepicker.model.Image> images = new ArrayList<>();
    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "onStop()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        state=false;
        setContentView(R.layout.activity_upload);
        barre = findViewById(R.id.barre);
        imagepick = findViewById(R.id.imagepick);
        barre.setVisibility(View.GONE);
        imagepick.setVisibility(View.GONE);
        textView = findViewById(R.id.image_path);
        ImageButton menu = findViewById(R.id.more);
        ImageButton gallery = findViewById(R.id.gallery);
        menu.setOnClickListener(v -> {
            Intent intent = new Intent(Upload.this, Menu.class);
            Upload.this.startActivity(intent);
        });
        gallery.setOnClickListener(v -> {
            Intent intent = new Intent(Upload.this, Gallery.class);
            Upload.this.startActivity(intent);
        });
        findViewById(R.id.button_pick_image_rx).setOnClickListener(view ->{if(!state)getImagePickerObservable().forEach(action);});
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == RC_CAMERA) {
            if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED ) {
                captureImage();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void captureImage() {
        ImagePicker.cameraOnly().start(this);
    }

    Action1<List<com.esafirm.imagepicker.model.Image>> action = this::printImages;

    private rx.Observable<List<com.esafirm.imagepicker.model.Image>> getImagePickerObservable() {
        state=true;
        return RxImagePicker.getInstance()
                .start(this, ImagePicker.create(this).limit(1));
    }
    @Override
    protected void onActivityResult(int requestCode, final int resultCode, Intent data) {
        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
            images = (ArrayList<com.esafirm.imagepicker.model.Image>) ImagePicker.getImages(data);
            printImages(images);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void printImages(List<com.esafirm.imagepicker.model.Image> images) {
        if (images == null) return;

        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0, l = images.size(); i < l; i++) {
            stringBuffer.append(images.get(i).getPath());
        }
        try {
            Bitmap bm = BitmapFactory.decodeFile(stringBuffer.toString());
            imagepick.setImageBitmap(bm);
            imagepick.setVisibility(View.VISIBLE);
            //barre.setVisibility(View.VISIBLE);
            AsyncHttpClient client = new AsyncHttpClient();
            client.setTimeout(60);
            RequestParams params = new RequestParams();
            params.put("image", "image");
            params.put("image", new File(stringBuffer.toString()));
            client.post("https://goopics.net/api/", params, new TextHttpResponseHandler() {
                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    // error handling
                    state=false;
                    Log.v("Tag", "onFailure");
                    barre.setVisibility(View.GONE);
                    toastdisp("erreur");

                }

                @Override
                public void onProgress(long bytesWritten, long totalSize) {
                    super.onProgress(bytesWritten, totalSize);
                    /*barre.setProgress(50);
                    Log.v("Tag","progbar : "+((int)(bytesWritten * 1.0 / totalSize) * 10)*10);*/
                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, String responseString) {
                    // success
                    state=false;
                    Log.v("Tag", "onSuccess, responseString: " + responseString);
                    barre.setVisibility(View.GONE);
                    imagepick.setVisibility(View.GONE);
                    toastdisp("image envoyer");
                }
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void toastdisp(String mess) {
        Toast.makeText(this,mess,
                Toast.LENGTH_SHORT).show();
    }
}
