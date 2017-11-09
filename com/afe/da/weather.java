package com.afe.da;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class weather extends Activity {
    static final String URL = "http://api.openweathermap.org/data/2.5/weather?q=pune";
    private handeljson obj;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0058R.layout.card);
        weathere();
    }

    private void weathere() {
        TextView country = (TextView) findViewById(C0058R.id.title_location);
        TextView temperature = (TextView) findViewById(C0058R.id.temp);
        TextView humidity = (TextView) findViewById(C0058R.id.humid);
        TextView pressure = (TextView) findViewById(C0058R.id.presure);
        TextView desc = (TextView) findViewById(C0058R.id.desc);
        country.setText(URL);
        this.obj = new handeljson(URL);
        this.obj.fetchJSON();
        do {
        } while (this.obj.parsingComplete);
        country.setText(this.obj.getCountry());
        temperature.setText(this.obj.getTemperature());
        humidity.setText(this.obj.getHumidity());
        pressure.setText(this.obj.getPressure());
        desc.setText(this.obj.getDesc());
    }
}
