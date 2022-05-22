package com.example.android.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android.R;
import com.example.android.activity.DetailCoursActivity;
import com.example.android.activity.ListCoursActivity;
import com.example.android.classes.Cours;
import com.example.android.classes.Theme;

import java.util.ArrayList;
import java.util.List;

public class ListCoursAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Cours> arrayList;
    private TextView listCoursDesce;
    public ListCoursAdapter(Context context, ArrayList<Cours> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.row_list_cours, parent, false);
        listCoursDesce = convertView.findViewById(R.id.listCoursDesce);
        listCoursDesce.setText(arrayList.get(position).getDesce());
        listCoursDesce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailCoursActivity.class);
                intent.putExtra("idcours",arrayList.get(position).getId());
                view.getContext().startActivity(intent);
            }
        });
        return convertView;
    }
}