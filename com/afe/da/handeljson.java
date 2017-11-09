package com.afe.da;

import android.annotation.SuppressLint;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class handeljson {
    private String country = "county";
    private String desc = "description";
    private String humidity = "humidity";
    public volatile boolean parsingComplete = true;
    private String pressure = "pressure";
    private String temperature = "temperature";
    private String urlString = null;

    class C00591 implements Runnable {
        C00591() {
        }

        public void run() {
            try {
                HttpURLConnection conn = (HttpURLConnection) new URL(handeljson.this.urlString).openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();
                InputStream stream = conn.getInputStream();
                handeljson.this.readAndParseJSON(handeljson.convertStreamToString(stream));
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public handeljson(String url) {
        this.urlString = url;
    }

    public String getCountry() {
        return this.country;
    }

    public String getTemperature() {
        return this.temperature;
    }

    public String getHumidity() {
        return this.humidity;
    }

    public String getPressure() {
        return this.pressure;
    }

    public String getDesc() {
        return this.desc;
    }

    @SuppressLint({"NewApi"})
    public void readAndParseJSON(String in) {
        try {
            JSONObject reader = new JSONObject(in);
            this.country = reader.getJSONObject("sys").getString("country");
            this.desc = reader.getJSONArray("weather").getJSONObject(0).getString("description");
            JSONObject main = reader.getJSONObject("main");
            this.temperature = main.getString("temp");
            this.pressure = main.getString("pressure");
            this.humidity = main.getString("humidity");
            this.parsingComplete = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fetchJSON() {
        new Thread(new C00591()).start();
    }

    static String convertStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
