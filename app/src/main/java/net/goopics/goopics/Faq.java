package net.goopics.goopics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Faq extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        ImageButton menu = findViewById(R.id.more);
        ImageButton upload = findViewById(R.id.add_image);
        ImageButton gallery = findViewById(R.id.gallery);
        menu.setOnClickListener(v -> {
            Intent intent = new Intent(Faq.this, Menu.class);
            Faq.this.startActivity(intent);
        });
        upload.setOnClickListener(v -> {
            Intent intent = new Intent(Faq.this, Upload.class);
            Faq.this.startActivity(intent);
        });
        gallery.setOnClickListener(v -> {
            Intent intent = new Intent(Faq.this, Gallery.class);
            Faq.this.startActivity(intent);
        });
        findViewById(R.id.textView2).setVisibility(View.GONE);
        findViewById(R.id.textView4).setVisibility(View.GONE);
        findViewById(R.id.textView6).setVisibility(View.GONE);
        findViewById(R.id.textView8).setVisibility(View.GONE);
        findViewById(R.id.textView10).setVisibility(View.GONE);
        findViewById(R.id.textView12).setVisibility(View.GONE);
        findViewById(R.id.textView14).setVisibility(View.GONE);
        clickable(findViewById(R.id.textView),findViewById(R.id.textView2));
        clickable(findViewById(R.id.textView3),findViewById(R.id.textView4));
        clickable(findViewById(R.id.textView5),findViewById(R.id.textView6));
        clickable(findViewById(R.id.textView7),findViewById(R.id.textView8));
        clickable(findViewById(R.id.textView9),findViewById(R.id.textView10));
        clickable(findViewById(R.id.textView11),findViewById(R.id.textView12));
        clickable(findViewById(R.id.textView13),findViewById(R.id.textView14));
        //clickable(findViewById(R.id.textView15),findViewById(R.id.textView2));
    }
    public void clickable(TextView t1,TextView t2){
        t1.setOnClickListener(view -> {
            if (t2.getVisibility()== View.GONE){
                t2.setVisibility(View.VISIBLE);
            }else t2.setVisibility(View.GONE);
        });
    }
}
