package com.example.android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android.R;
import com.example.android.classes.Cours;
import com.example.android.classes.DetailCours;
import com.example.android.classes.Theme;

import java.util.ArrayList;

public class DetailCoursAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DetailCours> arrayList;
    private WebView webView;
    public DetailCoursAdapter(Context context, ArrayList<DetailCours> arrayList) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.row_cours, parent, false);
        webView = convertView.findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        System.out.println("gogo"+arrayList.get(position).getDesce());
        webView.loadData(arrayList.get(position).getContent(), "text/html", "utf-8");

        return convertView;
    }
}