package com.example.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.menuAccueil:
                intent = new Intent(this, ThemeActivity.class);
                startActivity(intent);
                return true;
            case R.id.menuPreference:
                intent = new Intent(this, UserActivity.class);
                startActivity(intent);
                return true;
            case R.id.menuCours:
                intent = new Intent(this, CoursUserActivity.class);
                startActivity(intent);
                return true;
            case R.id.menuLogOut:
                intent = new Intent(this, LoginActivity.class);
                this.finish();
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}