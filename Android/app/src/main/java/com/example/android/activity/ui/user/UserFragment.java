package com.example.android.activity.ui.user;

import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.R;
import com.example.android.adapters.ThemeAdapter;
import com.example.android.classes.ResGetCategorie;
import com.example.android.classes.User;
import com.example.android.config.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Path;


public class UserFragment extends Fragment {
    public User user;
    private UserViewModel mViewModel;
    public EditText userAge,userNom,userPrenom,userMotDePasse,userPseudo;
    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        getUser();
        View view = inflater.inflate(R.layout.user_fragment, container, false);
        userAge = view.findViewById(R.id.userAge);
        userNom = view.findViewById(R.id.userNom);
        userPrenom = view.findViewById(R.id.userPrenom);
        userMotDePasse = view.findViewById(R.id.userMotDePasse);
        userPseudo  = view.findViewById(R.id.userPseudo);
        Button confirm = view.findViewById(R.id.userUpdate);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUpdate();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        // TODO: Use the ViewModel
    }
    public void getUser(){
        SharedPreferences preferences = getContext().getSharedPreferences("user", 0);
        Call<User> call = RetrofitClient.getInstance().getMyApi().getUser(preferences.getString("id",""));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user = response.body();
                if(user!=null){
                    userAge.setText(String.valueOf(user.getAge()));
                    userNom.setText(String.valueOf(user.getNom()));
                    userPrenom.setText(String.valueOf(user.getPrenom()));
                    userMotDePasse.setText(String.valueOf(user.getMotdepasse()));
                    userPseudo.setText(String.valueOf(user.getPseudo()));
                }else{
                    Toast.makeText(getContext(), "Erreur du serveur", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    public void onUpdate(){
        user.setAge(Integer.parseInt(userAge.getText().toString()));
        user.setMotdepasse(userMotDePasse.getText().toString());
        user.setPseudo(userPseudo.getText().toString());
        user.setMotdepasse(userNom.getText().toString());
        user.setMotdepasse(userPrenom.getText().toString());
        Call<User> call = RetrofitClient.getInstance().getMyApi().putUser(String.valueOf(user.getId()),user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user = response.body();
                if(user!=null){
                     Toast.makeText(getContext(), "Mise à jour effectutée", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getContext(), "Erreur du serveur", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}