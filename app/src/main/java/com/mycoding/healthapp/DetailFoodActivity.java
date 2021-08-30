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

public class DetailFoodActivity extends AppCompatActivity {

    public static final String TAG = "DataBase";
    public String title;
    private TextView t1, t2, t3, t4, t5;
    private ImageView Image;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);

        Bundle bundle = getIntent().getExtras();
        title = bundle.getString("key");
        Toast.makeText(this ,title ,Toast.LENGTH_SHORT).show();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference Ref = database.getReference("List of Foods");
        myRef = Ref.child(title);

        Image = findViewById(R.id.list_img);
        t1 = findViewById(R.id.name);
        t2 = findViewById(R.id.calorie_count);
        t3 = findViewById(R.id.right_time);
        t4 = findViewById(R.id.worst_time);
        t5 = findViewById(R.id.consume);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DetailFood temp = snapshot.getValue(DetailFood.class);

                t1.setText(temp.title);
                t2.setText(temp.calorie);
                t3.setText(temp.right);
                t4.setText(temp.worst);
                t5.setText(temp.consume);
                Picasso.get().load(temp.image).into(Image);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "failed to read value", error.toException());
                Toast.makeText(DetailFoodActivity.this, "Failed to load", Toast.LENGTH_SHORT).show();
            }
        });
    }
}