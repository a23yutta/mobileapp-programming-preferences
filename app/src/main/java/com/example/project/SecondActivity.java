package com.example.project;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
public class SecondActivity extends AppCompatActivity {
    private  EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = new EditText(this);
        editText = (EditText) findViewById(R.id.storedEditedText);

        Button closeSecondActivityButton = findViewById(R.id.closeSecondActivity);
        closeSecondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Log.d("Tag", "Close SecondActivity");

            }
        });

        Button saveEditedTextButton = findViewById(R.id.saveButton);
        saveEditedTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences myPreferenceRef = getSharedPreferences("myPreferences", MODE_PRIVATE);
                SharedPreferences.Editor myPreferenceEditor = myPreferenceRef.edit();
                myPreferenceEditor.putString("myPreferenceString", editText.getText().toString());
                myPreferenceEditor.apply();
                Log.d("Tag", "Text saved" + editText.getText().toString());
            }
        });
    }

}