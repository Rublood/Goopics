package net.goopics.goopics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ImageButton menu = findViewById(R.id.more);
        ImageButton upload = findViewById(R.id.add_image);
        ImageButton gallery = findViewById(R.id.gallery);
        menu.setOnClickListener(v -> {
            Intent intent = new Intent(Setting.this, Menu.class);
            Setting.this.startActivity(intent);
        });
        upload.setOnClickListener(v -> {
            Intent intent = new Intent(Setting.this, Upload.class);
            Setting.this.startActivity(intent);
        });
        gallery.setOnClickListener(v -> {
            Intent intent = new Intent(Setting.this, Gallery.class);
            Setting.this.startActivity(intent);
        });
    }
}
