package net.goopics.goopics;

import android.content.ClipData;
import android.content.ClipboardManager;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        TextView textView;
        ImageView image;
        image=findViewById(R.id.image);
        textView=findViewById(R.id.textView15);
        ImageButton button;
        button = findViewById(R.id.button);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
            link=(String)bundle.get("link");
        else
            link="null";
        textView.setText(link);
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
