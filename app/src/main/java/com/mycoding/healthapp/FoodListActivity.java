package com.mycoding.healthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class FoodListActivity extends AppCompatActivity {

    ListView list;
    String[] title = {
            "Homemade protein smoothies",
            "Milk",
            "Rice",
            "Nuts and nut butters",
            "Red meats",
            "Salmon and oily fish",
            "Protein Supplements",
            "Dried Fruit",
            "Whole grain bread",
            "Avocades",
            "Healthy cereals",
            "Cereal bars",
            "Dark Chocolate",
            "Cheese",
            "Whole eggs",
            "Full fat yogurt",
            "Healthy fats and oils",
            "Leafy Greens",
            "Cruciferous Vegetable",
            "Lean Beef and Chicken Breast",
            "Boiled Potatoes",
            "Tuna",
            "Beans and Legumes",
            "Soups",
            "Cottage Cheese",
            "Apple Cider Vinegar",
            "Whole Grains",
            "Fruit",
            "Chia Seeds"
    };

    String[] subTitle ={
            "Weight Gaining Food",
            "Weight Gaining Food",
            "Weight Gaining Food",
            "Weight Gaining and Weight loss Food",
            "Weight Gaining Food",
            "Weight Gaining Food",
            "Weight Gaining and Weight loss Food",
            "Weight Gaining Food",
            "Weight Gaining Food",
            "Weight Gaining Food",
            "Weight Gaining and Weight loss Food",
            "Weight Gaining Food",
            "Weight Gaining Food",
            "Weight Gaining Food",
            "Weight Gaining Food",
            "Weight Gaining and Weight loss Food",
            "Weight Gaining Food",
            "Weight Gaining and Weight loss Food",
            "Weight loss Food",
            "Weight loss Food",
            "Weight loss Food",
            "Weight loss Food",
            "Weight loss Food",
            "Weight loss Food",
            "Weight loss Food",
            "Weight loss Food",
            "Weight loss Food",
            "Weight loss Food",
            "Weight loss Food",
            "Weight loss Food"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        FoodListItem adapter = new FoodListItem(FoodListActivity.this, title, subTitle);

        list = findViewById(R.id.food_list);
        list.setAdapter(adapter);
    }
}