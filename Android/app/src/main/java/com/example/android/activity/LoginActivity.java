package com.example.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.R;
import com.example.android.classes.ResInscription;
import com.example.android.classes.User;
import com.example.android.config.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button inscription = findViewById(R.id.loginInscription);
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, InscriptionActivity.class);
                startActivity(intent);
            }
        });
        Button seConnecter = findViewById(R.id.loginSeConnecter);
        seConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLogin();
            }
        });
    }
    public void onLogin(){
        User user = new User();
        EditText motdepasse = findViewById(R.id.loginMotDePasse);
        EditText pseudo = findViewById(R.id.loginPseudo);
        user.setMotdepasse(motdepasse.getText().toString());
        user.setPseudo(pseudo.getText().toString());

        Call<ResInscription> call = RetrofitClient.getInstance().getMyApi().inscription(user);
        call.enqueue(new Callback<ResInscription>() {
            @Override
            public void onResponse(Call<ResInscription> call, Response<ResInscription> response) {
                ResInscription myheroList = response.body();
                Toast.makeText(getApplicationContext(), "Success"+myheroList.getStatus(), Toast.LENGTH_LONG).show();
            }
            @Override
            public void onFailure(Call<ResInscription> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }
        });
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
        switch (item.getItemId()) {
            case R.id.one:
                // do something
                return true;

            case R.id.two:
                //do something
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}