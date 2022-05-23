package com.example.android.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.R;
import com.example.android.adapters.ThemeAdapter;
import com.example.android.classes.Theme;

import java.util.ArrayList;

public class ThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

    }

}