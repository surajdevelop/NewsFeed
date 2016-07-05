package com.example.android.newsfeed;

/**
 * Created by Neeraj on 6/29/2016.
 */
public class NewsArticle {
    private String title;
    private String sectionName;
    private String thumbnailUrl;
    private String webUrl;

    public NewsArticle(String title, String sectionName, String thumbnailUrl, String webUrl) {
        this.title = title;
        this.sectionName = sectionName;
        this.thumbnailUrl = thumbnailUrl;
        this.webUrl = webUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
}
