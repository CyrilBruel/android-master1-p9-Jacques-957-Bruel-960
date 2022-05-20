package com.example.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class InscriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        Button seConnecter = findViewById(R.id.inscriptionSeConnecter);
        seConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onInscription();
            }
        });
    }
    public void onInscription(){
        User user = new User();
        CheckBox sexeF = findViewById(R.id.inscriptionFeminin);
        EditText age = findViewById(R.id.inscriptionAge);
        CheckBox sexeM = findViewById(R.id.inscriptionFeminin);
        EditText motdepasse = findViewById(R.id.inscriptionPassword);
        EditText nom = findViewById(R.id.inscriptionNom);
        EditText prenom = findViewById(R.id.inscriptionPrenom);
        EditText pseudo = findViewById(R.id.inscriptionPseudo);
        if(sexeF.isChecked()){
            user.setSexe("f");
        }else{
            user.setSexe("m");
        }
        user.setAge(age.getText().toString());
        user.setMotdepasse(motdepasse.getText().toString());
        user.setNom(nom.getText().toString());
        user.setPrenom(prenom.getText().toString());
        user.setProfil(1);
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
}