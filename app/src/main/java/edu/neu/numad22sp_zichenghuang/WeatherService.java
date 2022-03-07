package edu.neu.numad22sp_zichenghuang;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.concurrent.ExecutionException;

public class WeatherService extends AppCompatActivity {

    private ProgressBar pgsBar;

    Button search;
    TextView cityName;
    TextView showResults;
    String url;
    DecimalFormat df = new DecimalFormat("#.##");

    class getWeather extends AsyncTask<String, Void, String> {

        //use httpurlconnection to communicate with API
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
            String output = "";
            try {
                // converting JSON strings to be displayed
                JSONObject jsonResponse = new JSONObject(results);
                JSONArray jsonArray = jsonResponse.getJSONArray("weather");
                JSONObject jsonObjectWeather = jsonArray.getJSONObject(0);
                String description = jsonObjectWeather.getString("description");
                JSONObject jsonObjectMain = jsonResponse.getJSONObject("main");
                double temp = jsonObjectMain.getDouble("temp") - 273.15;
                double feelsLike = jsonObjectMain.getDouble("feels_like") - 273.15;
                int humidity = jsonObjectMain.getInt("humidity");
                JSONObject jsonObjectSys = jsonResponse.getJSONObject("sys");
                String countryName = jsonObjectSys.getString("country");
                String cityName = jsonResponse.getString("name");
                showResults.setTextColor(Color.rgb(68,134,199));
                output += "Current weather of " + cityName + " (" + countryName + ")"
                        + "\n Temp: " + df.format(temp) + " °C"
                        + "\n Feels Like: " + df.format(feelsLike) + " °C"
                        + "\n Humidity: " + humidity + "%";
                showResults.setText(output);

            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_service);

        cityName = findViewById(R.id.cityInput);
        showResults = findViewById(R.id.weatherResults);
        search = findViewById(R.id.citySearchBtn);
        pgsBar = (ProgressBar) findViewById(R.id.pBar);

        final String[] temp = {""};

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // add a progress bar while loading
                pgsBar.setVisibility(view.VISIBLE);

                String cityInput = cityName.getText().toString();


                getWeather task = new getWeather();
                try {

                    if(cityInput != null) {
                        url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityInput + "&appid=c2f54189cc31edc811638b9b45f817b0";
                    }
                    else {
                        Toast.makeText(WeatherService.this, "Please enter city name", Toast.LENGTH_SHORT).show();
                    }

                    temp[0] = task.execute(url).get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(temp[0] == null) {
                    showResults.setText("City Not Found");
                }
                // hide progress bar when finished
                pgsBar.setVisibility(view.GONE);
            }


        });
    }
}