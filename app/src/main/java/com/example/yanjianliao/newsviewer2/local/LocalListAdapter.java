package com.example.yanjianliao.newsviewer2.local;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yanjianliao.newsviewer2.R;
import com.example.yanjianliao.newsviewer2.data.Article;
import com.example.yanjianliao.newsviewer2.news_detail.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LocalListAdapter extends RecyclerView.Adapter  {

    static ArrayList<Article> articles;

    public LocalListAdapter(ArrayList<Article> articles){
        this.articles = articles;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.local_news_list, parent, false);
        return new LocalListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        LocalListHolder listHolder = (LocalListHolder) holder;
        final Article article = articles.get(position);
        listHolder.articleTitle.setText(article.title);
        listHolder.publishDate.setText(article.publishedAt);
        if(article.urlToImage != null){
            Picasso.get().load(article.urlToImage).into(listHolder.imageView);
        }else{
            listHolder.imageView.setImageResource(R.drawable.images);
        }
        listHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("article", article);
                context.startActivity(intent);


            }
        });

        listHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Deleted", Toast.LENGTH_LONG).show();
                articles.remove(position);
                notifyDataSetChanged();
                article.delete();
            }
        });

        listHolder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, CommentActivity.class);
                intent.putExtra("position", String.valueOf(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
