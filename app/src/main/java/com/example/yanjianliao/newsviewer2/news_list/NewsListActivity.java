package com.example.yanjianliao.newsviewer2.news_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yanjianliao.newsviewer2.R;

public class NewsListActivity extends AppCompatActivity {

    public String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        url = getIntent().getStringExtra("url");
        setUpFragment();
    }


    public void setUpFragment(){
        ListFragment listFragment = new ListFragment();
        listFragment.URL = url;
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment, listFragment)
                .commit();

    }
}
