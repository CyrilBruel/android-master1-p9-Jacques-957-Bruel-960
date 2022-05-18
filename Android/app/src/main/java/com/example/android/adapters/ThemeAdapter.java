package com.example.android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android.R;
import com.example.android.classes.Theme;

import java.util.ArrayList;

public class ThemeAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Theme> arrayList;
    private TextView serialNum, name, contactNum;
    public ThemeAdapter(Context context, ArrayList<Theme> arrayList) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.row_theme, parent, false);
        serialNum = convertView.findViewById(R.id.serailNumber);
        name = convertView.findViewById(R.id.studentName);
        contactNum = convertView.findViewById(R.id.mobileNum);
        serialNum.setText(" " + arrayList.get(position).getNum());
        name.setText(arrayList.get(position).getVal());
        contactNum.setText(arrayList.get(position).getDesce());
        return convertView;
    }
}