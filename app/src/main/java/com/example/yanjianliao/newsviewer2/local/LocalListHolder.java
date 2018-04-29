package com.example.yanjianliao.newsviewer2.local;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yanjianliao.newsviewer2.R;

public class LocalListHolder extends RecyclerView.ViewHolder {

    Button delete;
    Button comment;
    ImageView imageView;
    TextView articleTitle;
    TextView publishDate;


    public LocalListHolder(View itemView) {
        super(itemView);
        delete = itemView.findViewById(R.id.deleteInDatabase);
        imageView = itemView.findViewById(R.id.imageOfLocalList);
        articleTitle = itemView.findViewById(R.id.articleLocalTitle);
        publishDate = itemView.findViewById(R.id.publishLocalDate);
        comment = itemView.findViewById(R.id.comment);

    }
}
