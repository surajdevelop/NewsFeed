package com.example.android.newsfeed;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView infoText;
    RecyclerView newsList;
    NewsAdapter newsAdapter;

    public static ArrayList<NewsArticle> newsArticleArrayList;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsArticleArrayList = new ArrayList<>();
        infoText = (TextView) findViewById(R.id.infoText);
        newsList = (RecyclerView) findViewById(R.id.newsList);
        newsList.setLayoutManager(new LinearLayoutManager(this));
        newsAdapter = new NewsAdapter(MainActivity.this, newsArticleArrayList);
        newsList.setAdapter(newsAdapter);
        if (isInternetConnected()) {
            new FetchNews(newsArticleArrayList, this).execute("sports");
            setInfoText("Fetching Your daily dose.....");
        } else {
            setInfoText("OOPS..No internet");
        }
    }

    public boolean isInternetConnected() {
        ConnectivityManager connMgr =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            setInfoText(getResources().getString(R.string.error_network));
            return false;
        }
    }

    private void setInfoText(String errorText) {
        infoText.setVisibility(View.VISIBLE);
        infoText.setText(errorText);
    }
}
