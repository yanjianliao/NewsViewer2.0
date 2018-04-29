package com.example.yanjianliao.newsviewer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yanjianliao.newsviewer2.news_list.NewsListActivity;

public class NewsCategoryActivity extends AppCompatActivity {

    Button general;
    Button business;
    Button entertainment;
    Button sports;
    Button science;
    String url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=035f26937eb1473991f5b45dce9220a8";

    public void setUpButtons(){
        general = findViewById(R.id.general);
        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=035f26937eb1473991f5b45dce9220a8";
                startListActivity();
            }
        });

        business = findViewById(R.id.business);
        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=035f26937eb1473991f5b45dce9220a8";
                startListActivity();
            }
        });

        entertainment = findViewById(R.id.entertainment);
        entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "https://newsapi.org/v2/top-headlines?country=us&category=entertainment&apiKey=035f26937eb1473991f5b45dce9220a8";
                startListActivity();
            }
        });

        sports = findViewById(R.id.sports);
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "https://newsapi.org/v2/top-headlines?country=us&category=sports&apiKey=035f26937eb1473991f5b45dce9220a8";
                startListActivity();
            }
        });

        science = findViewById(R.id.science);
        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "https://newsapi.org/v2/top-headlines?country=us&category=science&apiKey=035f26937eb1473991f5b45dce9220a8";
                startListActivity();
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_category);
        setUpButtons();
    }

    public void startListActivity(){
        Intent intent = new Intent(NewsCategoryActivity.this, NewsListActivity.class);
        intent.putExtra("url", url);
        NewsCategoryActivity.this.startActivity(intent);
    }

}
