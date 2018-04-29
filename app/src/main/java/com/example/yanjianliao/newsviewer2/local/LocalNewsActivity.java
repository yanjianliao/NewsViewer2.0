package com.example.yanjianliao.newsviewer2.local;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yanjianliao.newsviewer2.R;

public class LocalNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_news);
        setUpFragment();
    }



    public void setUpFragment() {
        LocalNewsFragment localFragment = new LocalNewsFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.localFragment, localFragment)
                .commit();

    }
}
