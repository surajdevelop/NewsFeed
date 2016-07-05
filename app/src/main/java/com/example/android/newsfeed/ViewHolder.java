package com.example.android.newsfeed;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Neeraj on 6/29/2016.
 */
public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView articleTitle;
    TextView articleSectionName;
    ImageView articleThumbnail;
    Context mContext;

    public ViewHolder(View view, Context mContext) {
        super(view);
        view.setOnClickListener(this);
        this.mContext = mContext;
        articleTitle = (TextView) view.findViewById(R.id.article_title);
        articleSectionName = (TextView) view.findViewById(R.id.article_section_name);
        articleThumbnail = (ImageView) view.findViewById(R.id.article_thumbnail);
    }

    @Override public void onClick(View view) {
        NewsArticle newsArticle = MainActivity.newsArticleArrayList.get(getAdapterPosition());
        Intent browserIntent =
                new Intent("android.intent.action.VIEW", Uri.parse(newsArticle.getWebUrl()));
        mContext.startActivity(browserIntent);
    }
}

