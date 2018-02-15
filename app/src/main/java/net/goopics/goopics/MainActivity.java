package net.goopics.goopics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //intent intent = new intent (mainactibity.this,secondActivity.class);
        //MainActivity.this.startActivity(intent);
    }
}
