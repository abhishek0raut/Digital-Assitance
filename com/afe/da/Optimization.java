package com.afe.da;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

public class Optimization {
    static String query = "I have a mood to danse,open facebook";
    ArrayList<String> application = new ArrayList();
    ArrayList<String> catagory = new ArrayList();
    ArrayList<String> catagory_music = new ArrayList();
    ArrayList<String> donts = new ArrayList();
    ArrayList<String> dos = new ArrayList();
    int f2i = 0;
    boolean isFound = false;
    int f3j = 0;
    ArrayList<String> sentense_breaker = new ArrayList();

    class C00571 implements Runnable {
        C00571() {
        }

        public void run() {
            Optimization.this.isFound = true;
        }
    }

    public String[] break_Sentense(String sentense) {
        String[] str = null;
        for (int i = 0; i < this.sentense_breaker.size(); i++) {
            if (sentense.toLowerCase().contains(((String) this.sentense_breaker.get(i)).toLowerCase())) {
                return sentense.split((String) this.sentense_breaker.get(i));
            }
        }
        return str;
    }

    public boolean isMultiline(String sentense) {
        for (int i = 0; i < this.sentense_breaker.size(); i++) {
            if (sentense.toLowerCase().contains(((String) this.sentense_breaker.get(i)).toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void add_sentense_breaker() {
        this.sentense_breaker.add(",".toLowerCase());
        this.sentense_breaker.add("AND".toLowerCase());
        this.sentense_breaker.add("OR".toLowerCase());
        this.sentense_breaker.add("BUT".toLowerCase());
    }

    public void add_donts() {
        this.donts.add("NOT".toLowerCase());
        this.donts.add("DO NOT".toLowerCase());
        this.donts.add("DOES NOT".toLowerCase());
        this.donts.add("DID NOT".toLowerCase());
        this.donts.add("HAVE NOT".toLowerCase());
        this.donts.add("HAS NOT".toLowerCase());
        this.donts.add("HAD NOT".toLowerCase());
        this.donts.add("MAY NOT".toLowerCase());
        this.donts.add("MIGHT NOT".toLowerCase());
        this.donts.add("MUST NOT".toLowerCase());
        this.donts.add("DONT".toLowerCase());
        this.donts.add("DOES'NT".toLowerCase());
        this.donts.add("DID'NT".toLowerCase());
        this.donts.add("HAVE'NT".toLowerCase());
        this.donts.add("HAS'NT".toLowerCase());
        this.donts.add("HAD'NT".toLowerCase());
        this.donts.add("'NT".toLowerCase());
        this.donts.add("CLOSE".toLowerCase());
        this.donts.add("HIDE".toLowerCase());
    }

    public void add_do() {
        this.dos.add("DO".toLowerCase());
        this.dos.add("DOES".toLowerCase());
        this.dos.add("DID".toLowerCase());
        this.dos.add("HAVE".toLowerCase());
        this.dos.add("HAS".toLowerCase());
        this.dos.add("HAD".toLowerCase());
        this.dos.add("MAY".toLowerCase());
        this.dos.add("MIGHT".toLowerCase());
        this.dos.add("MUST".toLowerCase());
    }

    public void add_Catagory() {
        this.catagory.add("START".toLowerCase());
        this.catagory.add("OPEN".toLowerCase());
        this.catagory.add("SHOW".toLowerCase());
        this.catagory.add("DISPLAY".toLowerCase());
    }

    public void add_catagory_for_music() {
        this.catagory_music.add("play");
        this.catagory_music.add("sing");
    }

    public void addApplication() {
        this.application.add("facebook");
        this.application.add("gmail");
        this.application.add("twitter");
        this.application.add("linkdin");
    }

    public boolean optimize_Query(String query, Context context) {
        this.f2i = 0;
        this.f3j = 0;
        this.f2i = 0;
        while (this.f2i < this.catagory.size()) {
            if (query.toLowerCase().contains((CharSequence) this.catagory.get(this.f2i))) {
                this.f3j = 0;
                while (this.f3j < this.application.size()) {
                    if (query.contains((CharSequence) this.application.get(this.f3j))) {
                        new Handler(Looper.getMainLooper()).post(new C00571());
                        break;
                    }
                    this.f3j++;
                }
                System.out.println(query.toLowerCase() + "Query and catagory is" + ((String) this.catagory.get(this.f2i)));
                return true;
            }
            this.f2i++;
        }
        if (!this.isFound) {
            searchForOtherCatagory(context, query);
        }
        return false;
    }

    public void searchForOtherCatagory(Context context, String query) {
        System.out.println("searchForOtherCatagory--->" + query);
        this.f2i = 0;
        while (this.f2i < this.catagory_music.size()) {
            if (query.toLowerCase().contains((CharSequence) this.catagory_music.get(this.f2i))) {
                System.out.println(query.toLowerCase() + "Query and catagory is" + ((String) this.catagory.get(this.f2i)));
            }
            this.f2i++;
        }
    }
}
