package com.afe.da;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends ListActivity {
    static final int check = 1111;
    int f1a;
    List<ResolveInfo> list;
    String pkg;
    ArrayList<String> pnkName = new ArrayList();
    String query;
    public ArrayList<String> result;
    private ArrayList results;
    String str = "";

    class C00551 implements OnClickListener {
        C00551() {
        }

        public void onClick(View w) {
            TextView tp = (TextView) MainActivity.this.findViewById(C0058R.id.textView);
            EditText abc = (EditText) MainActivity.this.findViewById(C0058R.id.editText1);
            abc.setVisibility(0);
            optimize ab = new optimize();
            MainActivity.this.query = abc.getText().toString();
            if (!MainActivity.this.query.equals("")) {
                ab.putstring(MainActivity.this.query);
                String S1 = ab.getString();
                MainActivity.this.pkg = "";
                MainActivity.this.packagList(S1);
                if (S1.equals("")) {
                    tp.setText("nullStrings");
                } else {
                    tp.setText(MainActivity.this.pkg);
                }
                if (S1.equals("que")) {
                    Intent bro = new Intent(MainActivity.this, Browser.class);
                    Bundle ind = new Bundle();
                    ind.putString("key", MainActivity.this.query);
                    bro.putExtras(ind);
                    MainActivity.this.startActivity(bro);
                } else if (S1.equals("weather")) {
                    MainActivity.this.startActivity(new Intent(MainActivity.this, weather.class));
                }
            }
        }
    }

    class C00562 implements OnClickListener {
        C00562() {
        }

        public void onClick(View v) {
            Intent i = new Intent("android.speech.action.RECOGNIZE_SPEECH");
            i.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
            MainActivity.this.startActivityForResult(i, MainActivity.check);
        }
    }

    class AppInfo {
        String appname = "";
        Drawable icon;
        String pname = "";
        int versionCode = 0;
        String versionName = "";

        AppInfo() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0058R.layout.activity_main);
        setup();
        packagList("fucj");
    }

    private void setup() {
        ImageButton speak = (ImageButton) findViewById(C0058R.id.search);
        ((Button) findViewById(C0058R.id.button1)).setOnClickListener(new C00551());
        speak.setOnClickListener(new C00562());
    }

    protected void onListItemClick(ListView lv, View v, int position, long id) {
        super.onListItemClick(lv, v, position, id);
        TextView tp = (TextView) findViewById(C0058R.id.textView);
        String query = (String) this.result.get(position);
        optimize ab = new optimize();
        ab.putstring(query);
        this.pkg = "";
        String s = ab.getString();
        if (!s.equals(null)) {
            packagList(s);
        }
        tp.setText(this.pkg);
        if (!s.equals("que") || !s.equals("") || s.equals("cnd")) {
            openApp(this.pkg);
        } else if (s.equals("calendar")) {
            addCalendarEvent();
        } else if (s.equals("que")) {
            Intent bro = new Intent(this, Browser.class);
            Bundle ind = new Bundle();
            ind.putString("key", query);
            bro.putExtras(ind);
            startActivity(bro);
        } else if (s.equals("cnd") || s.equals("")) {
            tp.setText("Cant Do it right now");
        }
    }

    public void packagList(String s) {
        List<PackageInfo> apps = getPackageManager().getInstalledPackages(0);
        ArrayList<AppInfo> res = new ArrayList();
        for (int i = 0; i < apps.size(); i++) {
            PackageInfo p = (PackageInfo) apps.get(i);
            if (s.equals(p.applicationInfo.loadLabel(getPackageManager()).toString().toLowerCase())) {
                this.pkg = p.packageName;
                AppInfo newInfo = new AppInfo();
                newInfo.appname = p.applicationInfo.loadLabel(getPackageManager()).toString();
                newInfo.pname = p.packageName;
                newInfo.versionName = p.versionName;
                newInfo.versionCode = p.versionCode;
                newInfo.icon = p.applicationInfo.loadIcon(getPackageManager());
                res.add(newInfo);
            }
        }
    }

    private void openApp(String pkn) {
        try {
            startActivity(getPackageManager().getLaunchIntentForPackage(pkn));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ListView lv = (ListView) findViewById(16908298);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == check && resultCode == -1) {
            this.result = data.getStringArrayListExtra("android.speech.extra.RESULTS");
            lv.setAdapter(new ArrayAdapter(this, 17367043, this.result));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0058R.menu.main, menu);
        return true;
    }

    public void addCalendarEvent() {
        Calendar cal = Calendar.getInstance();
        Intent intent = new Intent("android.intent.action.EDIT");
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("beginTime", cal.getTimeInMillis());
        intent.putExtra("allDay", true);
        intent.putExtra("rrule", "FREQ=YEARLY");
        intent.putExtra("endTime", cal.getTimeInMillis() + 3600000);
        intent.putExtra("title", "A Test Event from android app");
        intent.putExtra("description", "A Test Description from android app");
        intent.putExtra("eventLocation", "Geolocation");
        startActivity(intent);
    }

    public void addAlarm() {
        Intent i = new Intent("android.intent.action.SET_ALARM");
        i.putExtra("android.intent.extra.alarm.HOUR", 9);
        i.putExtra("android.intent.extra.alarm.MINUTES", 37);
        startActivity(i);
    }
}
