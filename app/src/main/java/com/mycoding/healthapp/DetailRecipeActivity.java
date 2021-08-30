package com.mycoding.healthapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DetailRecipeActivity extends AppCompatActivity {

    public static final String TAG = "DataBase";
    public String title;
    private TextView t1, t2, t3, t4;
    private ImageView Image;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_recipe);

        Bundle bundle = getIntent().getExtras();
        title = bundle.getString("key");
        Toast.makeText(this ,title ,Toast.LENGTH_SHORT).show();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference Ref = database.getReference("Recipes");
        myRef = Ref.child(title);

        Image = findViewById(R.id.recipe_img);
        t1 = findViewById(R.id.recipe_name);
        t2 = findViewById(R.id.time);
        t3 = findViewById(R.id.ingredient);
        t4 = findViewById(R.id.method);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DetailRecipe temp = snapshot.getValue(DetailRecipe.class);

                t1.setText(temp.title);
                t2.setText(temp.time);
                t3.setText(temp.ingredient);
                t4.setText(temp.method);
                Picasso.get().load(temp.image).into(Image);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "failed to read value", error.toException());
                Toast.makeText(DetailRecipeActivity.this, "Failed to load", Toast.LENGTH_SHORT).show();
            }
        });
    }
}