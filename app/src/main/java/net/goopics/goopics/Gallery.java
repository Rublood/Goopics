package net.goopics.goopics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ImageButton;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {
    gridadapteur menuAdapter;
    ArrayList<String> links;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SQLiteDataBaseHelper db = new SQLiteDataBaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ImageButton menu = findViewById(R.id.more);
        ImageButton upload = findViewById(R.id.add_image);
        menu.setOnClickListener(v -> {
            Intent intent = new Intent(Gallery.this, Menu.class);
            Gallery.this.startActivity(intent);
        });
        upload.setOnClickListener(v -> {
            Intent intent = new Intent(Gallery.this, Upload.class);
            Gallery.this.startActivity(intent);
        });
        links=db.getallurl();
        menuAdapter=new gridadapteur(getApplicationContext(),links);
        GridView gridView = this.findViewById(R.id.grid);
        gridView.setAdapter(menuAdapter);
        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(Gallery.this,Image.class);
            intent.putExtra("link",links.get(i));
            intent.putExtra("lat",db.getalllat().get(i));
            intent.putExtra("longi",db.getalllongi().get(i));
            this.startActivity(intent);
        });
    }

}
