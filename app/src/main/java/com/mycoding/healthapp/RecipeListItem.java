package com.mycoding.healthapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class RecipeListItem extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] title;

    public RecipeListItem(Activity context, String[] title) {
        super(context, R.layout.list_item, title);
        this.context = context;
        this.title = title;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater =context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);
        TextView txtTitle = rowView.findViewById(R.id.textViewTitle);

        txtTitle.setText(title[position]);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailRecipeActivity.class);
                intent.putExtra("key", title[position]);
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
