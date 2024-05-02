package com.example.project;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    SharedPreferences myPreferenceRef;
    SharedPreferences.Editor myPreferenceEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button secondActivityButton = findViewById(R.id.secondActivityButton);
        secondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
                Log.d("Tag", "SecondActivity");
            }
        });
    }
    public void onResume() {
        super.onResume();
        myPreferenceRef = getSharedPreferences("myPreferences", MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        TextView textView = new TextView(this);
        textView=(TextView)findViewById(R.id.myTextView);
        textView.setText(myPreferenceRef.getString("myPreferenceString", "No preference found."));
        Log.d("Tag", "update on resume");

    }

}
