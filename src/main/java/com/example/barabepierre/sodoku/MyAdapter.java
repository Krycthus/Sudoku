package com.example.barabepierre.sodoku;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TwoLineListItem;
import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<vGrille> items;

    public MyAdapter(Context context, ArrayList<vGrille> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        TwoLineListItem twoLineListItem;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            twoLineListItem = (TwoLineListItem) inflater.inflate(
                    android.R.layout.simple_list_item_2, null);
        } else {
            twoLineListItem = (TwoLineListItem) convertView;
        }

        TextView text1 = twoLineListItem.getText1();
        TextView text2 = twoLineListItem.getText2();

        text1.setText(items.get(position).getNum() + "   niveau: " + (double) items.get(position).getLevel());
        text2.setText(items.get(position).getDone() + " %");
        text2.setTextSize(22);
        if (items.get(position).getDone() < 40)
            text2.setTextColor(Color.RED);
        else
            text2.setTextColor(Color.GREEN);

        twoLineListItem.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Game.class);
                Bundle bun = new Bundle();
                bun.putString("stringGrid", items.get(position).getGrid());
                intent.putExtra("dataPasser", bun);
                context.startActivity(intent);
            }
        });

        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Munro.ttf");
        text2.setTypeface(typeface);

        return twoLineListItem;
    }
}
