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
import com.example.android.classes.Theme;

import java.util.ArrayList;

public class CoursAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Cours> arrayList;
    private WebView webView;
    public CoursAdapter(Context context, ArrayList<Cours> arrayList) {
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

        //build your own src link with your video ID
        String videoStr = "<html><body>Promo video<br><iframe width=\"auto\" height=\"suto\" src=\"https://www.youtube.com/embed/47yJ2XCRLZs\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        webView.loadData(arrayList.get(position).getDesce(), "text/html", "utf-8");

        return convertView;
    }
}