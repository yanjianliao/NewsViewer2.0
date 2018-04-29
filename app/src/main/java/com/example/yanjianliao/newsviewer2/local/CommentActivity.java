package com.example.yanjianliao.newsviewer2.local;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yanjianliao.newsviewer2.R;
import com.example.yanjianliao.newsviewer2.data.Article;

public class CommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        String str = getIntent().getStringExtra("position");
        int position = Integer.parseInt(str);
        final Article article = LocalListAdapter.articles.get(position);
        final EditText editText = findViewById(R.id.editText);
        editText.setText(article.comment);
        Button save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                article.comment = editText.getText().toString();
                Log.i("edit", article.comment);
                article.delete();
                article.save();
                finish();
            }
        });
    }
}
