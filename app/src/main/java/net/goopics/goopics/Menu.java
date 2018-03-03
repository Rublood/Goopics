package net.goopics.goopics;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Menu extends Activity {
    private static String TAG = MainActivity.class.getSimpleName();
    MenuAdapter menuAdapter;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        menuAdapter=new MenuAdapter(getApplicationContext());
        ListView listView =this.findViewById(R.id.menulist);
        listView.setAdapter(menuAdapter);

    }
}
