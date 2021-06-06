package com.example.invokecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button run = findViewById(R.id.button);
        run.setOnClickListener(v -> start());

        Button run2 = findViewById(R.id.button2);
        run2.setOnClickListener(v -> start());
    }

    private void start (){
        Uri uri = Uri.parse("example://intent");
        Intent runIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(runIntent);

        ActivityInfo activityInfo = runIntent.resolveActivityInfo(getPackageManager(), runIntent.getFlags());
        if (activityInfo != null) {
            startActivity(runIntent);
        }
    }
}