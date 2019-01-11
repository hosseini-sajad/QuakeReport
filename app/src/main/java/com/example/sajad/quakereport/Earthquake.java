package com.example.sajad.quakereport;

/**
 * Created by sajad on 6/25/2017.
 */

public class Earthquake {

    private String mMag;
    private String mLocation;
    private String mTime;
    private String murl;

    public String getmMag() {
        return mMag;
    }

    public void setmMag(String mMag) {
        this.mMag = mMag;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public void setMurl(String murl) {
        this.murl = murl;
    }

    public Earthquake(String mag, String location, String time, String url) {
        setmMag(mag);
        setmLocation(location);
        setmTime(time);
        setMurl(url);
    }
}
