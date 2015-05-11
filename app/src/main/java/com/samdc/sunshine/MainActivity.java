package com.samdc.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment
     */

    public static class PlaceholderFragment extends Fragment {

        private ArrayAdapter<String> mForecastAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            /** create fake data */
            String[] fakeData = {
                    "Today - sunny - 84/79",
                    "Tomorrow - cloudy - 82/78,",
                    "Friday - raining - 76/72",
                    "Saturday - cloudy - 88/89",
                    "Sunday - gawdamn - 98/99"
            };

            List<String> weekForecast = new ArrayList<>(Arrays.asList(fakeData));

            mForecastAdapter = new ArrayAdapter<>(
                    // the current activity
                    getActivity(),
                    // id of list layout
                    R.layout.list_item_forecast,
                    // id of list item to populate
                    R.id.list_item_forecast_textview,
                    // forecast data
                    weekForecast);

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ListView listview = (ListView) rootView.findViewById(R.id.listview_forecast);
            listview.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}