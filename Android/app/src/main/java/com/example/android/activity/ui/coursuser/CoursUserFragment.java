package com.example.android.activity.ui.coursuser;

import androidx.lifecycle.ViewModelProvider;

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
import com.example.android.activity.ui.listcours.ListCoursViewModel;
import com.example.android.adapters.ListCoursAdapter;
import com.example.android.classes.BodyCoursUser;
import com.example.android.classes.BodyListCours;
import com.example.android.classes.Cours;
import com.example.android.classes.ResListCours;
import com.example.android.config.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CoursUserFragment extends Fragment {

    private CoursUserViewModel mViewModel;
    ListView listView;
    ArrayList<Cours> arrayList = new ArrayList<>();
    ListCoursAdapter adapter;
    public static CoursUserFragment newInstance() {
        return new CoursUserFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cours_user_fragment, container, false);
        listView = view.findViewById(R.id.listView);
        getListCours();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CoursUserViewModel.class);
        // TODO: Use the ViewModel
    }
    public void getListCours(){
        BodyCoursUser bodyListCours = new BodyCoursUser();
        SharedPreferences preferences = getContext().getSharedPreferences("user", 0);
        bodyListCours.setAge(preferences.getInt("age",-1));
        bodyListCours.setIdUser( preferences.getString("id",""));
        Call<ResListCours> call = RetrofitClient.getInstance().getMyApi().listCoursUser(bodyListCours);
        call.enqueue(new Callback<ResListCours>() {
            @Override
            public void onResponse(Call<ResListCours> call, Response<ResListCours> response) {
                ResListCours resListCours = response.body();
                if(resListCours.getStatus()==200){
                    arrayList = resListCours.getListCours();
                    adapter = new ListCoursAdapter(getContext(), arrayList);
                    listView.setAdapter(adapter);
                }else{
                    Toast.makeText(getContext(), resListCours.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<ResListCours> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}