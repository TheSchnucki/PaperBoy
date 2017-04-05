package com.theshnucki.paperboy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PaperboyActivity extends AppCompatActivity {

    public static final String LOG_TAG = PaperboyActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paperboy);

        //Create a fake news list
        ArrayList<NewsItem> newsItems = QueryUtils.extractNews();

        // Find reference to {@link ListView} in the layout
        ListView newsListView = (ListView) findViewById(R.id.list);

        //Create a new {@link ArrayAdapter} of news
        final NewsAdapter adapter = new NewsAdapter(this, newsItems);

        //set the adapter on the {@link ListView} so the list can be populated in the user interface
        newsListView.setAdapter(adapter);

        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //find the current news that was clicked on
                NewsItem currentNewsItem = adapter.getItem(position);

                //Convert the String URL into an URI object (to pass it into the Intent constructor)
                Uri NewsItemUri = Uri.parse(currentNewsItem.getUrl());

                //Create a new Intent to vie the news URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, NewsItemUri);

                //Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });
    }
}
