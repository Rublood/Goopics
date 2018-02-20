package net.goopics.goopics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Upload extends AppCompatActivity {
    private static String TAG = MainActivity.class.getSimpleName();

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
        setContentView(R.layout.activity_upload);
        ImageButton menu = findViewById(R.id.more);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Upload.this, Menu.class);
                Upload.this.startActivity(intent);
            }
        });

    }
}
