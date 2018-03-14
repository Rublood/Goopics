package net.goopics.goopics;

import android.content.Context;
import android.graphics.Picture;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class gridadapteur extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private ArrayList<String> images;

    public gridadapteur(Context context, ArrayList<String> inputImages) {
        super();
        inflater=LayoutInflater.from(context);
        this.mContext = context;
        this.images = inputImages;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public String getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LinearLayout layoutItem;
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("https://i.goopics.net");
        stringBuffer.append(images.get(position).replaceAll("https://goopics.net/i",""));
        stringBuffer.append(".jpg");
        if (view == null){
            layoutItem=(LinearLayout) inflater.inflate(R.layout.rowlayout,parent,false);
        }else {
            layoutItem = (LinearLayout) view;
        }
        android.widget.ImageView icon = layoutItem.findViewById(R.id.cell_image);
        RequestOptions myOptions = new RequestOptions()
                .override(1000,1000);
        Glide.with(mContext)
                .load(stringBuffer.toString())
                .apply(myOptions)
                .into(icon);
        return layoutItem;
    }
}