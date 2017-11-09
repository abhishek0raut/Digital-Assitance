package com.afe.da;

import android.util.Log;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class optimize {
    public String Query = "AbC";
    String[][] appKey = ((String[][]) Array.newInstance(String.class, new int[]{20, 2}));
    ArrayList<ArrayList<String>> application = new ArrayList();
    String atp = "";
    ArrayList<String> command = new ArrayList();
    ArrayList<String> donts = new ArrayList();
    ArrayList<String> dos = new ArrayList();
    ArrayList<String> question = new ArrayList();
    ArrayList<String> sentense_breaker = new ArrayList();
    String[] str = null;
    String[] url = null;

    public void CheckMulti() {
        if (isMultiline(this.Query)) {
            for (String trim : this.str) {
                this.atp = optim(trim.trim());
            }
            return;
        }
        this.atp = optim(this.Query);
    }

    public String optim(String quer) {
        int i;
        boolean neg = false;
        String cat = "";
        String atpp = "";
        add_questions();
        add_Command();
        add_donts();
        addApplication();
        for (i = 0; i < this.application.size(); i++) {
            int j;
            for (j = 0; j < ((ArrayList) this.application.get(i)).size(); j++) {
                if (quer.equals(((ArrayList) this.application.get(i)).get(j))) {
                    return (String) ((ArrayList) this.application.get(i)).get(0);
                }
            }
        }
        for (i = 0; i < this.question.size(); i++) {
            if (quer.contains((CharSequence) this.question.get(i))) {
                new Browser().putUrl(quer);
                return "que";
            }
        }
        for (i = 0; i < this.donts.size(); i++) {
            if (quer.toLowerCase().contains((CharSequence) this.donts.get(i))) {
                neg = true;
            }
        }
        if (!neg) {
            for (i = 0; i < this.command.size(); i++) {
                if (quer.toLowerCase().contains((CharSequence) this.command.get(i))) {
                    cat = (String) this.command.get(i);
                }
            }
            if (!cat.equals("")) {
                for (i = 0; i < this.application.size(); i++) {
                    for (j = 0; j < ((ArrayList) this.application.get(i)).size(); j++) {
                        if (quer.toLowerCase().contains((CharSequence) ((ArrayList) this.application.get(i)).get(j))) {
                            atpp = (String) ((ArrayList) this.application.get(i)).get(0);
                            Log.d("Value", "Installed package :" + atpp);
                        }
                    }
                }
            }
        }
        return atpp;
    }

    void putstring(String S) {
        this.Query = S;
    }

    String getString() {
        CheckMulti();
        return this.atp;
    }

    public void add_sentense_breaker() {
        this.sentense_breaker.add("AND".toLowerCase());
        this.sentense_breaker.add("OR".toLowerCase());
        this.sentense_breaker.add("BUT".toLowerCase());
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
                this.str = sentense.split((String) this.sentense_breaker.get(i));
                return true;
            }
        }
        return false;
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

    public void add_Command() {
        this.command.add("START".toLowerCase());
        this.command.add("OPEN".toLowerCase());
        this.command.add("SHOW".toLowerCase());
        this.command.add("DISPLAY".toLowerCase());
        this.command.add("STARTUP".toLowerCase());
    }

    public void add_questions() {
        this.question.add("what");
        this.question.add("where");
        this.question.add("when");
        this.question.add("who");
        this.question.add("which");
        this.question.add("whos");
        this.question.add("how");
    }

    public void addApplication() {
        this.application.add(new ArrayList());
        ((ArrayList) this.application.get(0)).add("facebook");
        ((ArrayList) this.application.get(0)).add("fb");
        this.application.add(new ArrayList());
        ((ArrayList) this.application.get(1)).add("gmail");
        this.application.add(new ArrayList());
        ((ArrayList) this.application.get(2)).add("twitter");
        ((ArrayList) this.application.get(2)).add("twit");
        ((ArrayList) this.application.get(2)).add("follow on twitter");
        this.application.add(new ArrayList());
        ((ArrayList) this.application.get(3)).add("calendar");
        this.application.add(new ArrayList());
        ((ArrayList) this.application.get(4)).add("play store");
        ((ArrayList) this.application.get(4)).add("rate application");
        ((ArrayList) this.application.get(4)).add("game");
        ((ArrayList) this.application.get(4)).add("games");
        ((ArrayList) this.application.get(4)).add("download movie");
        ((ArrayList) this.application.get(4)).add("book");
        ((ArrayList) this.application.get(4)).add("books");
        this.application.add(new ArrayList());
        ((ArrayList) this.application.get(5)).add("gallery");
        ((ArrayList) this.application.get(5)).add("photo");
        ((ArrayList) this.application.get(5)).add("photos");
        ((ArrayList) this.application.get(5)).add("image");
        ((ArrayList) this.application.get(5)).add("images");
        ((ArrayList) this.application.get(5)).add("video");
        ((ArrayList) this.application.get(5)).add("videos");
        ((ArrayList) this.application.get(5)).add("wallpaper");
        ((ArrayList) this.application.get(5)).add("wallpapers");
        ((ArrayList) this.application.get(5)).add("movie");
        ((ArrayList) this.application.get(5)).add("movies");
        this.application.add(new ArrayList());
        ((ArrayList) this.application.get(6)).add("contact");
        this.application.add(new ArrayList());
        ((ArrayList) this.application.get(7)).add("take photo");
        ((ArrayList) this.application.get(7)).add("take photos");
        ((ArrayList) this.application.get(7)).add("take pic");
        ((ArrayList) this.application.get(7)).add("take pics");
        ((ArrayList) this.application.get(7)).add("capture photo");
        ((ArrayList) this.application.get(7)).add("capture pic");
        ((ArrayList) this.application.get(7)).add("capture image");
        ((ArrayList) this.application.get(7)).add("capture images");
        ((ArrayList) this.application.get(7)).add("capture photos");
        ((ArrayList) this.application.get(7)).add("take video");
        ((ArrayList) this.application.get(7)).add("take videos");
        this.application.add(new ArrayList());
        ((ArrayList) this.application.get(8)).add("chrome");
        this.application.add(new ArrayList());
        ((ArrayList) this.application.get(9)).add("maps");
        this.application.add(new ArrayList());
        ((ArrayList) this.application.get(10)).add("music");
        this.application.add(new ArrayList());
        ((ArrayList) this.application.get(11)).add("weather");
    }
}
