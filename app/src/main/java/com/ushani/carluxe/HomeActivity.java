package com.ushani.carluxe;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        // Set window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                return true;
            } else if (itemId == R.id.navigation_cart) {
                startActivity(new Intent(HomeActivity.this, MyCartActivity.class));
                return true;
            } else if (itemId == R.id.navigation_chart) {
                startActivity(new Intent(HomeActivity.this, ChartActivity.class));
                return true;
            } else if (itemId == R.id.navigation_profile) {
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
                return true;
            }
            return false;
        });

        // Add click listener for filter icon
        ImageView filterIcon = findViewById(R.id.filter_icon);
        filterIcon.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, SelectCarActivity.class);
            startActivity(intent);
        });

        // Add click listener for Toyota image
        ImageView toyotaImg = findViewById(R.id.toyota_img);
        toyotaImg.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ToyotaCarsActivity.class);
            startActivity(intent);
        });
    }
}
