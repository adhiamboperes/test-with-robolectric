package com.adhiambo.dummybazelapp;


import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

/**
 * Main class for the Bazel Android "Hello, World" app.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("Bazel", "Hello, Android");

        setContentView(R.layout.activity_main);

        Button clickMeButton = findViewById(R.id.clickMeButton);
        TextView helloBazelTextView = findViewById(R.id.helloBazelTextView);

        Greeter greeter = new Greeter();

        // Bazel supports Java 8 language features like lambdas!
        clickMeButton.setOnClickListener(v -> helloBazelTextView.setText(greeter.sayHello()));

        TextView cardTitleTextView = findViewById(R.id.cardTitle);
        TextView cardSubTitleTextView = findViewById(R.id.cardSubTitle);

        MainViewModel model = new ViewModelProvider(this).get(MainViewModel.class);

        model.getCardItem();

        model.cardItemMutableLiveData.observe(this, item -> {
            cardTitleTextView.setText(item.getTitle());
            cardSubTitleTextView.setText(item.getSubTitle());
        });
    }
}
