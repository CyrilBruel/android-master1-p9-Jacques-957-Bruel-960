package com.example.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.android.R;
import com.example.android.adapters.CoursAdapter;
import com.example.android.adapters.ThemeAdapter;
import com.example.android.classes.Cours;
import com.example.android.classes.Theme;

import java.util.ArrayList;

public class CoursActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Cours> arrayList = new ArrayList<>();
    CoursAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cours);
        listView = findViewById(R.id.listView);
        Cours cours = new Cours();
        String videoStr = "<html><body>Promo video<br><iframe width=\"auto\" height=\"auto\" src=\"https://www.youtube.com/embed/tgbNymZ7vqY\">\n" +
                "</iframe><br>Image ici<br/><img width=\"auto\" height=\"auto\" src=\"https://images.unsplash.com/photo-1594312915251-48db9280c8f1?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870\" alt=\"Italian Trulli\"></body></html>";
        cours.setDesce(videoStr);
        arrayList.add(cours);
        cours = new Cours();
        videoStr = "<html><body>Promo video<br><iframe width=\"auto\" height=\"auto\" src=\"https://www.youtube.com/embed/tgbNymZ7vqY\">\n" +
                "</iframe></body></html>";
        cours.setDesce(videoStr);
        arrayList.add(cours);
        adapter = new CoursAdapter(this, arrayList);
        listView.setAdapter(adapter);
    }
}