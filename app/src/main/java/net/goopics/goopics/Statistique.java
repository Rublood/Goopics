package net.goopics.goopics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class Statistique extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistique);
        ImageButton menu = findViewById(R.id.more);
        ImageButton upload = findViewById(R.id.add_image);
        ImageButton gallery = findViewById(R.id.gallery);
        menu.setOnClickListener(v -> {
            Intent intent = new Intent(Statistique.this, Menu.class);
            Statistique.this.startActivity(intent);
        });
        upload.setOnClickListener(v -> {
            Intent intent = new Intent(Statistique.this, Upload.class);
            Statistique.this.startActivity(intent);
        });
        gallery.setOnClickListener(v -> {
            Intent intent = new Intent(Statistique.this, Gallery.class);
            Statistique.this.startActivity(intent);
        });
    }
}
