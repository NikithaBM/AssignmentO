package com.nikitha.oyelabstask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GroceryDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_details);

        TextView tvGrocDetailName =findViewById(R.id.tvGrocDetaiName);
        tvGrocDetailName.setText(  getIntent().getStringExtra("name"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}