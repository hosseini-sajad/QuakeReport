package com.example.sajad.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sajad on 6/25/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listitem = convertView;

        if(listitem == null) {
            listitem = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake ceurrentEarth = getItem(position);

        TextView mag = (TextView) listitem.findViewById(R.id.mag_text);
        mag.setText(ceurrentEarth.getmMag());

        TextView location = (TextView) listitem.findViewById(R.id.location_text);
        location.setText(ceurrentEarth.getmLocation());

        TextView time = (TextView) listitem.findViewById(R.id.time_text);
        time.setText(ceurrentEarth.getmTime());

        return listitem;
    }
}
