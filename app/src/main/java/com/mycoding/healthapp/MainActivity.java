package com.mycoding.healthapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public CardView list_food, BMI, health_recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_food = (CardView) findViewById(R.id.list_food);
        BMI = (CardView) findViewById(R.id.bmi);
        health_recipe = (CardView) findViewById(R.id.recipes);

        list_food.setOnClickListener(this);
        BMI.setOnClickListener(this);
        health_recipe.setOnClickListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()) {
            case R.id.list_food:
                i = new Intent(MainActivity.this, FoodListActivity.class);
                startActivity(i);
                break;
            case R.id.bmi:
                i = new Intent(MainActivity.this, BMICalActivity.class);
                startActivity(i);
                break;
            case R.id.recipes:
                i = new Intent(MainActivity.this, RecipesActivity.class);
                startActivity(i);
                break;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.sign_out){
            FirebaseAuth.getInstance().signOut();
            finish();
        }
        else if (item.getItemId() == R.id.settings){
            Toast.makeText(MainActivity.this, "You have selected the settings", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}