package net.goopics.goopics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;

/**
 * Created by Rublood on 20/02/2018.
 */

public class MenuAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<MenuComponents> menu = null;

    public MenuAdapter(Context context) {
        this.context = context;
        inflater=LayoutInflater.from(context);

        menu = new ArrayList<>();
        menu.add(new MenuComponents("F.A.Q",R.drawable.faq));
        menu.add(new MenuComponents("Statistiques",R.drawable.stats));
        menu.add(new MenuComponents("Contact",R.drawable.contact));
        menu.add(new MenuComponents("Paramettre",R.drawable.settings));
    }

    @Override
    public int getCount() {
        return menu.size();
    }

    @Override
    public Object getItem(int i) {
        return menu.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        LinearLayout layoutItem;
        if (view == null){
            layoutItem=(LinearLayout) inflater.inflate(R.layout.rowlayout,parent,false);
        }else {
            layoutItem = (LinearLayout) view;
        }
        TextView label = layoutItem.findViewById(R.id.cell_label);
        label.setText(this.menu.get(i).getName());
        android.widget.ImageView icon = layoutItem.findViewById(R.id.cell_image);
        icon.setImageResource(this.menu.get(i).getImage());
        layoutItem.setLongClickable(true);
        return layoutItem;
    }

}
