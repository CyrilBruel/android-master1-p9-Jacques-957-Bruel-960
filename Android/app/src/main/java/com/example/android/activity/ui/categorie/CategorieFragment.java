package com.example.android.activity.ui.categorie;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.R;
import com.example.android.activity.CategorieActivity;
import com.example.android.activity.LoginActivity;
import com.example.android.adapters.ThemeAdapter;
import com.example.android.classes.ResGetCategorie;
import com.example.android.classes.ResInscription;
import com.example.android.classes.Theme;
import com.example.android.config.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CategorieFragment extends Fragment {
    ListView listView;
    ArrayList<Theme> arrayList = new ArrayList<>();
    ThemeAdapter adapter;
    private CategorieViewModel mViewModel;

    public static CategorieFragment newInstance() {
        return new CategorieFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.categorie_fragment, container, false);
        listView = view.findViewById(R.id.listView);
        getCategorie();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CategorieViewModel.class);

        // TODO: Use the ViewModel
    }
    public void getCategorie(){
        Call<ResGetCategorie> call = RetrofitClient.getInstance().getMyApi().getCategories();
        call.enqueue(new Callback<ResGetCategorie>() {
            @Override
            public void onResponse(Call<ResGetCategorie> call, Response<ResGetCategorie> response) {
                ResGetCategorie resCategorie = response.body();
                System.out.println("hello "+resCategorie.getStatus());
                 if(resCategorie.getStatus()==200){
                     arrayList = resCategorie.getListTheme();
                     adapter = new ThemeAdapter(getContext(), arrayList);
                     listView.setAdapter(adapter);
                  }else{
                    Toast.makeText(getContext(), resCategorie.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<ResGetCategorie> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }

}