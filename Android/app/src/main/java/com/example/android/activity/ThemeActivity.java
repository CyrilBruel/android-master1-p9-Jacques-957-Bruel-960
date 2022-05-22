package com.example.android.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.R;
import com.example.android.adapters.ThemeAdapter;
import com.example.android.classes.Theme;

import java.util.ArrayList;

public class ThemeActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Theme> arrayList = new ArrayList<>();
    ThemeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        listView = findViewById(R.id.listView);
        arrayList.add(new Theme(1, "Anglais","987576443"));
        arrayList.add(new Theme(2, "Francais","8787576768"));
        arrayList.add(new Theme(3, "Malagasy","65757657657"));
        arrayList.add(new Theme(4, "Mathematiques","65757657657"));
        arrayList.add(new Theme(5, "Histoire","65757657657"));
        arrayList.add(new Theme(6, "Geographie","65757657657"));
        arrayList.add(new Theme(7, "Sciences","65757657657"));
        arrayList.add(new Theme(8, "Culture G","65757657657"));
        arrayList.add(new Theme(9, "Photoshop","65757657657"));
        arrayList.add(new Theme(10, "Dev C","65757657657"));
        arrayList.add(new Theme(11, "Dev Java","65757657657"));
        arrayList.add(new Theme(12, "Dev Angular","65757657657"));
        arrayList.add(new Theme(13, "Node js","65757657657"));
        arrayList.add(new Theme(14, "C#","65757657657"));
        arrayList.add(new Theme(15, "PHP","65757657657"));
        arrayList.add(new Theme(16, "HTML CSS","65757657657"));
        adapter = new ThemeAdapter(this, arrayList);
        listView.setAdapter(adapter);
    }

}