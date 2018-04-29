package com.example.yanjianliao.newsviewer2.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;

public class Article extends SugarRecord implements Parcelable {

    public int idInDatabase = 0;
    public String author = "";
    public String title = "";
    public String description = "";
    public String url = "";
    public String urlToImage = "";
    public String publishedAt = "";
    public String comment = "";

    public Article(){

    }
    @Override
    public String toString() {
        return "\n" + author + "\n" + title + "\n" + description + "\n" + url + "\n" + urlToImage + "\n" + publishedAt;
    }

    protected Article(Parcel in) {
        idInDatabase = in.readInt();
        author = in.readString();
        title = in.readString();
        description = in.readString();
        url = in.readString();
        urlToImage = in.readString();
        publishedAt = in.readString();
        comment = in.readString();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idInDatabase);
        dest.writeString(author);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(url);
        dest.writeString(urlToImage);
        dest.writeString(publishedAt);
        dest.writeString(comment);
    }
}
