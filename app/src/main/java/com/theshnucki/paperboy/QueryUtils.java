package com.theshnucki.paperboy;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by theSchnucki on 05.04.2017.
 */

public class QueryUtils {

    public static final String LOG_TAG = QueryUtils.class.getName();

    //Sample JSON response for a Guardian query
    private static final String SAMPLE_JSON_RESPONSE = "{\"response\":{\"status\":\"ok\",\"userTier\":\"developer\",\"total\":1941725,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":194173,\"orderBy\":\"newest\",\"results\":[{\"id\":\"business/live/2017/apr/05/service-sector-uk-growth-eurozone-car-sales-xi-business-live\",\"type\":\"liveblog\",\"sectionId\":\"business\",\"sectionName\":\"Business\",\"webPublicationDate\":\"2017-04-05T13:49:06Z\",\"webTitle\":\"Bank of England policymaker warns that consumer slowdown will 'intensify' - business live\",\"webUrl\":\"https://www.theguardian.com/business/live/2017/apr/05/service-sector-uk-growth-eurozone-car-sales-xi-business-live\",\"apiUrl\":\"https://content.guardianapis.com/business/live/2017/apr/05/service-sector-uk-growth-eurozone-car-sales-xi-business-live\",\"isHosted\":false},{\"id\":\"politics/blog/live/2017/apr/05/nigel-farage-tells-meps-eu-acting-like-the-mafia-and-making-impossible-brexit-demands-politics-live\",\"type\":\"liveblog\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2017-04-05T13:49:02Z\",\"webTitle\":\"Corbyn says Livingstone could face further disciplinary action for ongoing 'offensive' remarks - Politics live\",\"webUrl\":\"https://www.theguardian.com/politics/blog/live/2017/apr/05/nigel-farage-tells-meps-eu-acting-like-the-mafia-and-making-impossible-brexit-demands-politics-live\",\"apiUrl\":\"https://content.guardianapis.com/politics/blog/live/2017/apr/05/nigel-farage-tells-meps-eu-acting-like-the-mafia-and-making-impossible-brexit-demands-politics-live\",\"isHosted\":false},{\"id\":\"tv-and-radio/2017/apr/05/game-of-thrones-season-seven-everything-we-know\",\"type\":\"article\",\"sectionId\":\"tv-and-radio\",\"sectionName\":\"Television & radio\",\"webPublicationDate\":\"2017-04-05T13:47:44Z\",\"webTitle\":\"Summer is coming! Everything we know about new Game of Thrones so far\",\"webUrl\":\"https://www.theguardian.com/tv-and-radio/2017/apr/05/game-of-thrones-season-seven-everything-we-know\",\"apiUrl\":\"https://content.guardianapis.com/tv-and-radio/2017/apr/05/game-of-thrones-season-seven-everything-we-know\",\"isHosted\":false},{\"id\":\"business/2017/apr/05/bmw-strikes-mini-rolls-royce-unite-pension\",\"type\":\"article\",\"sectionId\":\"business\",\"sectionName\":\"Business\",\"webPublicationDate\":\"2017-04-05T13:47:11Z\",\"webTitle\":\"BMW strikes set to disrupt Mini and Rolls-Royce production\",\"webUrl\":\"https://www.theguardian.com/business/2017/apr/05/bmw-strikes-mini-rolls-royce-unite-pension\",\"apiUrl\":\"https://content.guardianapis.com/business/2017/apr/05/bmw-strikes-mini-rolls-royce-unite-pension\",\"isHosted\":false},{\"id\":\"fashion/shortcuts/2017/apr/05/my-crocs-rock-and-the-fashion-world-has-finally-come-round-to-them\",\"type\":\"article\",\"sectionId\":\"fashion\",\"sectionName\":\"Fashion\",\"webPublicationDate\":\"2017-04-05T13:42:11Z\",\"webTitle\":\"My Crocs rock … and the fashion world has finally come round to them\",\"webUrl\":\"https://www.theguardian.com/fashion/shortcuts/2017/apr/05/my-crocs-rock-and-the-fashion-world-has-finally-come-round-to-them\",\"apiUrl\":\"https://content.guardianapis.com/fashion/shortcuts/2017/apr/05/my-crocs-rock-and-the-fashion-world-has-finally-come-round-to-them\",\"isHosted\":false},{\"id\":\"law/2017/apr/05/briton-rosslee-charles-escapes-turkey-extradition-court-hears-prison-torture\",\"type\":\"article\",\"sectionId\":\"law\",\"sectionName\":\"Law\",\"webPublicationDate\":\"2017-04-05T13:39:13Z\",\"webTitle\":\"Briton escapes Turkey extradition after court hears of previous prison torture\",\"webUrl\":\"https://www.theguardian.com/law/2017/apr/05/briton-rosslee-charles-escapes-turkey-extradition-court-hears-prison-torture\",\"apiUrl\":\"https://content.guardianapis.com/law/2017/apr/05/briton-rosslee-charles-escapes-turkey-extradition-court-hears-prison-torture\",\"isHosted\":false},{\"id\":\"gnmeducationcentre/2017/apr/05/reading-for-pleasure-primary-teacher-conference-thursday-29-june-2017\",\"type\":\"article\",\"sectionId\":\"gnmeducationcentre\",\"sectionName\":\"GNM education centre\",\"webPublicationDate\":\"2017-04-05T13:32:07Z\",\"webTitle\":\"Reading for pleasure primary teacher conference, Thursday 29 June 2017\",\"webUrl\":\"https://www.theguardian.com/gnmeducationcentre/2017/apr/05/reading-for-pleasure-primary-teacher-conference-thursday-29-june-2017\",\"apiUrl\":\"https://content.guardianapis.com/gnmeducationcentre/2017/apr/05/reading-for-pleasure-primary-teacher-conference-thursday-29-june-2017\",\"isHosted\":false},{\"id\":\"football/2017/apr/05/premier-league-elite-player-performance-plan\",\"type\":\"article\",\"sectionId\":\"football\",\"sectionName\":\"Football\",\"webPublicationDate\":\"2017-04-05T13:30:00Z\",\"webTitle\":\"The Premier League elite player performance plan – ‘not perfect but lessons are being learned’\",\"webUrl\":\"https://www.theguardian.com/football/2017/apr/05/premier-league-elite-player-performance-plan\",\"apiUrl\":\"https://content.guardianapis.com/football/2017/apr/05/premier-league-elite-player-performance-plan\",\"isHosted\":false},{\"id\":\"sustainable-business/live/2017/mar/30/palm-oil-industry-boycott-deforestation-biodiversity-plantation-workers-india-china\",\"type\":\"liveblog\",\"sectionId\":\"sustainable-business\",\"sectionName\":\"Guardian Sustainable Business\",\"webPublicationDate\":\"2017-04-05T13:22:52Z\",\"webTitle\":\"What does boycotting palm oil achieve?  – live chat\",\"webUrl\":\"https://www.theguardian.com/sustainable-business/live/2017/mar/30/palm-oil-industry-boycott-deforestation-biodiversity-plantation-workers-india-china\",\"apiUrl\":\"https://content.guardianapis.com/sustainable-business/live/2017/mar/30/palm-oil-industry-boycott-deforestation-biodiversity-plantation-workers-india-china\",\"isHosted\":false},{\"id\":\"books/booksblog/2017/apr/05/do-two-unpublished-books-make-you-a-failed-author-no-youre-a-quitter\",\"type\":\"article\",\"sectionId\":\"books\",\"sectionName\":\"Books\",\"webPublicationDate\":\"2017-04-05T13:15:01Z\",\"webTitle\":\"Do two unpublished books make you a failed author? No, you're a quitter\",\"webUrl\":\"https://www.theguardian.com/books/booksblog/2017/apr/05/do-two-unpublished-books-make-you-a-failed-author-no-youre-a-quitter\",\"apiUrl\":\"https://content.guardianapis.com/books/booksblog/2017/apr/05/do-two-unpublished-books-make-you-a-failed-author-no-youre-a-quitter\",\"isHosted\":false}]}}";

            /**
             * Create a private constructor because no one should ever create a {@link QueryUtils} object.
             * This class is only meant to hold static variables and methods, which can be accessed
             * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
             */
            private QueryUtils () {}

            /**
             * Return a list of {@link NewsItem} objects that has been built up from
             * parsing a JSON response.
             */
            public static ArrayList<NewsItem> extractNews() {

                //Create an empty ArrayList we can start adding news to
                ArrayList<NewsItem> newsItems = new ArrayList<>();

                try {
                    JSONObject root = new JSONObject(SAMPLE_JSON_RESPONSE);
                    JSONObject response = root.getJSONObject("response");
                } catch (JSONException e) {
                    Log.e(LOG_TAG, "Problem parsing the earthquake JSON results", e);
                }

                return newsItems;
            }


}
