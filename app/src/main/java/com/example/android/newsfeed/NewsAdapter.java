package com.example.android.newsfeed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Neeraj on 6/29/2016.
 */
public class NewsAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private List<NewsArticle> mNewsArticles;

    public NewsAdapter(Context context, List<NewsArticle> newsArticles) {
        this.mContext = context;
        this.mNewsArticles = newsArticles;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsArticle currentNews = mNewsArticles.get(position);
        String newsTitle = currentNews.getTitle();
        String newsThumbnail = currentNews.getThumbnailUrl();
        String articleSectionName = currentNews.getSectionName();
        holder.articleTitle.setText(newsTitle);
        holder.articleSectionName.setText(articleSectionName);
        if (newsThumbnail != null && !newsThumbnail.equals("")) {
            new GetThumbnail(holder.articleThumbnail).execute(newsThumbnail);
        } else {
            holder.articleThumbnail.setVisibility(View.GONE);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        ViewHolder hold = new ViewHolder(layout, mContext);
        return hold;
    }

    @Override
    public int getItemCount() {
        return this.mNewsArticles.size();
    }
}