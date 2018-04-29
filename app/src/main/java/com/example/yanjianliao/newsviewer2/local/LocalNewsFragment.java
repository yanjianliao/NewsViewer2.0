package com.example.yanjianliao.newsviewer2.local;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yanjianliao.newsviewer2.R;
import com.example.yanjianliao.newsviewer2.data.Article;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LocalNewsFragment extends android.support.v4.app.Fragment {

    List<Article> articles;
    ArrayList<Article> data;
    HashSet<String> set;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getData();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new LocalListAdapter(data));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    private void getData(){
        articles = Article.listAll(Article.class);
        data = new ArrayList<>();
        set = new HashSet<>();
        for(Article a : articles){
            if(!set.contains(a.title)){
                Log.i("article", a.comment);
                data.add(a);
                set.add(a.title);
            }else{
                a.delete();
            }
        }


    }
}
