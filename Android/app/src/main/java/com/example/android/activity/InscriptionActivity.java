package com.example.android.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
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
        getSupportActionBar().hide();
        Button signUp = findViewById(R.id.inscriptionSignUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onInscription();
            }
        });
        Button login = findViewById(R.id.inscriptionLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InscriptionActivity.this, LoginActivity.class);
                startActivity(intent);
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
        user.setAge(Integer.parseInt(age.getText().toString()));
        user.setMotdepasse(motdepasse.getText().toString());
        user.setNom(nom.getText().toString());
        user.setPrenom(prenom.getText().toString());
        user.setProfil(1);
        user.setPseudo(pseudo.getText().toString());

        Call<ResInscription> call = RetrofitClient.getInstance().getMyApi().inscription(user);
        call.enqueue(new Callback<ResInscription>() {
            @Override
            public void onResponse(Call<ResInscription> call, Response<ResInscription> response) {
                 ResInscription inscription = response.body();
                SharedPreferences preferences = getSharedPreferences("user", MODE_PRIVATE);
                if(inscription.getStatus()==200){
                    notifier();
                    preferences.edit().putString("id", inscription.getUser().getId()).commit();
                    preferences.edit().putInt("age", inscription.getUser().getAge()).commit();
                    Intent intent = new Intent(InscriptionActivity.this, CategorieActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), inscription.getMessage(), Toast.LENGTH_LONG).show();
                }
              }
            @Override
            public void onFailure(Call<ResInscription> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }
        });



    }
    public void notifier(){
        //notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(android.R.drawable.ic_dialog_alert);
        Intent intent = new Intent(this, CoursUserActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_education));
        builder.setContentTitle("Edukids");
        builder.setContentText("Nous avons des cours spécialement pour vous.");
        builder.setSubText("Les cours sont organisés par catégorie...");

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Will display the notification in the notification bar
        notificationManager.notify(1, builder.build());
        //Fin notification
    }
}