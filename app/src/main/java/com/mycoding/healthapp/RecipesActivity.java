package com.mycoding.healthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class
RecipesActivity extends AppCompatActivity {
    ListView list;
    String[] title = {
            "Chicken Ball & Spinach Soup",
            "Patrani Machchi",
            "Jowar Medley",
            "Amaranth Tikkis",
            "Lentil and Charred Broccoli Chaat",
            "Ragi Cookies",
            "Oats Idli",
            "Carrot Salad with Black Grape Dressing",
            "Panchratna Dal",
            "Buttermilk Chicken with Char Grilled Broccoli",
            "Melon and Kiwi Fruit Smoothie"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        RecipeListItem adapter = new RecipeListItem(RecipesActivity.this, title);

        list = findViewById(R.id.recipes_list);
        list.setAdapter(adapter);
    }
}