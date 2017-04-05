package com.theshnucki.paperboy;

/**
 * Created by theSchnucki on 05.04.2017.
 */

public class NewsItem {
    private String mSection;
    private String mPubDate;
    private String mTitle;
    private String mUrl;

    public NewsItem(String section, String pubDate, String title, String url){
        mSection = section;
        mPubDate = pubDate;
        mTitle = title;
        mUrl = url;
    }

    public String getSection (){
        return mSection;
    }

    public String getPubDate (){
        return mPubDate;
    }

    public String getTitle () {
        return mTitle;
    }

    public String getUrl () {
        return mUrl;
    }
}
