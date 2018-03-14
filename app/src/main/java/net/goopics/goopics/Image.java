package net.goopics.goopics;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Image extends AppCompatActivity {
    String link;
    double lat;
    double longi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ImageButton menu = findViewById(R.id.more);
        ImageButton upload = findViewById(R.id.add_image);
        ImageButton gallery = findViewById(R.id.gallery);
        ImageButton marker = findViewById(R.id.marker);
        menu.setOnClickListener(v -> {
            Intent intent = new Intent(Image.this, Menu.class);
            Image.this.startActivity(intent);
        });
        upload.setOnClickListener(v -> {
            Intent intent = new Intent(Image.this, Upload.class);
            Image.this.startActivity(intent);
        });
        gallery.setOnClickListener(v -> {
            Intent intent = new Intent(Image.this, Gallery.class);
            Image.this.startActivity(intent);
        });

        TextView textView;
        ImageView image;
        image=findViewById(R.id.image);
        textView=findViewById(R.id.textView15);
        ImageButton button;
        button = findViewById(R.id.button);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            link=(String)bundle.get("link");
            lat=(double)bundle.get("lat");
            longi=(double)bundle.get("longi");
        }
        else
            link="null";
        textView.setText(link);
        marker.setOnClickListener(view -> {
            Intent intent = new Intent(Image.this,MapsActivity.class);
            intent.putExtra("link",link);
            intent.putExtra("lat",lat);
            intent.putExtra("longi",longi);
            Image.this.startActivity(intent);
        });
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("https://i.goopics.net");
        stringBuffer.append(link.replaceAll("https://goopics.net/i",""));
        stringBuffer.append(".jpg");
        RequestOptions myOptions = new RequestOptions()
                .fitCenter();
        Glide.with(this)
                .load(stringBuffer.toString())
                .apply(myOptions)
                .into(image);
        ClipboardManager clipboard = (ClipboardManager)getSystemService(this.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("link",link);
        clipboard.setPrimaryClip(clip);
    }
}
