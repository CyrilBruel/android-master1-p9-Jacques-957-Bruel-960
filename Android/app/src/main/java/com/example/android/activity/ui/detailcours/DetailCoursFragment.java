package com.example.android.activity.ui.detailcours;

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
import com.example.android.adapters.DetailCoursAdapter;
import com.example.android.adapters.ListCoursAdapter;
import com.example.android.classes.BodyListCours;
import com.example.android.classes.Cours;
import com.example.android.classes.DetailCours;
import com.example.android.classes.ResDetailCours;
import com.example.android.classes.ResListCours;
import com.example.android.config.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailCoursFragment extends Fragment {
    String idCours;
    private DetailCoursViewModel mViewModel;
    ListView listView;
    ArrayList<DetailCours> arrayList = new ArrayList<>();
    DetailCoursAdapter adapter;
    public static DetailCoursFragment newInstance() {
        return new DetailCoursFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        idCours = getActivity().getIntent().getExtras().getString("idcours");
        View view = inflater.inflate(R.layout.detail_cours_fragment, container, false);
        listView = view.findViewById(R.id.listView);
        getCours();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetailCoursViewModel.class);
        // TODO: Use the ViewModel
    }
    public void getCours(){
        SharedPreferences preferences = getContext().getSharedPreferences("user", 0);
        String idUser = preferences.getString("id","");
        Call<ResDetailCours> call = RetrofitClient.getInstance().getMyApi().getCours(idUser,idCours);
        call.enqueue(new Callback<ResDetailCours>() {
            @Override
            public void onResponse(Call<ResDetailCours> call, Response<ResDetailCours> response) {
                ResDetailCours resCours = response.body();
                 if(resCours.getStatus()==200){
                    arrayList = resCours.getListCours();
                    adapter = new DetailCoursAdapter(getContext(), arrayList);
                    listView.setAdapter(adapter);
                }else{
                    Toast.makeText(getContext(), resCours.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<ResDetailCours> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}