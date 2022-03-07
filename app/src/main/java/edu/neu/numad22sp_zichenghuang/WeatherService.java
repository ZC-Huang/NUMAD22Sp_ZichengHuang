package edu.neu.numad22sp_zichenghuang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService extends AppCompatActivity {

    Button search;
    TextView cityName;
    TextView showResults;

    class getWeather extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            StringBuilder results = new StringBuilder();

            try {
                URL url = new URL(urls[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String line = "";

                while ((line = reader.readLine()) != null) {
                    results.append(line).append("\n");
                }
                return results.toString();
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);

            showResults.setText(results);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_service);

        cityName = findViewById(R.id.cityInput);
        showResults = findViewById(R.id.weatherResults);
        search = findViewById(R.id.citySearchBtn);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "https://api.openweathermap.org/data/2.5/weather?q=kolkata&appid=c2f54189cc31edc811638b9b45f817b0";

                getWeather task = new getWeather();
                task.execute(url);


            }
        });
    }
}