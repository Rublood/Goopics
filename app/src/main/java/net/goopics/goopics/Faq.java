package net.goopics.goopics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Faq extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        TextView textView,textView2;
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        textView.setOnClickListener(view -> {
            if (textView2.getVisibility()== View.INVISIBLE){
                textView2.setVisibility(View.VISIBLE);
            }else textView2.setVisibility(View.INVISIBLE);
        });
    }
}
