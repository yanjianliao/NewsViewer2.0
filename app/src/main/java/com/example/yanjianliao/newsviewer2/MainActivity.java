package com.example.yanjianliao.newsviewer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.example.yanjianliao.newsviewer2.data.Article;
import com.example.yanjianliao.newsviewer2.local.LocalNewsActivity;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    TextView local;
    TextView online;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setClickListener();

//        List<Article> list = Article.listAll(Article.class);
//        Log.i("article", "\n");
//        for(Article a : list) {
//            Log.i("article", a.toString());
//            //a.delete();
//        }


    }

    private void setClickListener(){
        local = findViewById(R.id.local);
        online = findViewById(R.id.online);
        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewsCategoryActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LocalNewsActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }


}

