package com.example.android.sunshineapp;

import android.os.AsyncTask;

/**
 * Created by Esraa on 04-Apr-16.
 */

public class FetchWeatherTask extends AsyncTask<String, Void, String[] > {

    private final String LOG_TAG = FetchWeatherTask.class.getSimpleName();




    @Override


    protected String[] doInBackground(String... params) {
        ////////////////////////////////////////////////////////////////////////////////////////////////////

        WeatherAPICalling weatherAPICalling = new WeatherAPICalling();

        return weatherAPICalling.callWeatherAPI(params[0]);
    }

    @Override
    protected void onPostExecute(String[] result) {
        if(result != null)
        {
            ForecastFragment.mForecastAdapter.clear();
            for (String dayForecastStr: result)
            {
                ForecastFragment.mForecastAdapter.add(dayForecastStr);
            }
        }
    }


}

