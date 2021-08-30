package com.mycoding.healthapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodListItem extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] title;
    private final String[] subTitle;

    public FoodListItem(Activity context, String[] title, String[] subTitle) {
        super(context, R.layout.list_item, title);
        this.context = context;
        this.title = title;
        this.subTitle = subTitle;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater =context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);
        TextView txtTitle = rowView.findViewById(R.id.textViewTitle);
        TextView txtSubTitle = rowView.findViewById(R.id.textViewSubTitle);

        txtTitle.setText(title[position]);
        txtSubTitle.setText(subTitle[position]);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailFoodActivity.class);
                intent.putExtra("key", title[position]);
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
