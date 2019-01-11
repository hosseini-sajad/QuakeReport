package com.example.sajad.quakereport;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity {

    private EarthquakeAdapter earthquakeAdapter;

    private static final String USGS_REQUEST_URL =
           "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);


        ListView listView = (ListView) findViewById(R.id.list);

        earthquakeAdapter = new EarthquakeAdapter(this, new ArrayList<Earthquake>());

        listView.setAdapter(earthquakeAdapter);

        EarthquakeAsynkTask task = new EarthquakeAsynkTask();
        task.execute(USGS_REQUEST_URL);
    }

    private class EarthquakeAsynkTask extends AsyncTask<String, Void, List<Earthquake>> {
        @Override
        protected List<Earthquake> doInBackground(String... urls) {

            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            List<Earthquake> result = QueryUtils.fetchEarthquakeData(urls[0]);
            return result;
        }

        @Override
        protected void onPostExecute(List<Earthquake> data) {
            // Clear the adapter of previous earthquake data
            earthquakeAdapter.clear();

            // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (data != null && !data.isEmpty()) {
                earthquakeAdapter.addAll(data);
            }
        }
    }
}