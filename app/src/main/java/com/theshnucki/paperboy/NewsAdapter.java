package com.theshnucki.paperboy;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by theSchnucki on 05.04.2017.
 */

public class NewsAdapter  extends ArrayAdapter<NewsItem> {

    private static final String LOG_TAG = NewsAdapter.class.getName();

    public NewsAdapter(Activity context, ArrayList<NewsItem> newsItems) {
        super(context, 0, newsItems);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        final NewsItem currentNewsItem = getItem(position);

        TextView sectionTextView = (TextView)listItemView.findViewById(R.id.section);
        sectionTextView.setText(currentNewsItem.getSection());

        TextView pubDateView = (TextView)listItemView.findViewById(R.id.pub_date);
        pubDateView.setText(currentNewsItem.getPubDate());

        TextView titleView = (TextView)listItemView.findViewById(R.id.title);
        titleView.setText(currentNewsItem.getTitle());

        return listItemView;
    }
}
