package com.example.servertst;

import com.google.firebase.database.Exclude;

public class upload_data {

    private String sample_name;
    private String location;
    private String Acoustic_value;
    private String Mineral;
    private String imageurl;
    private String key;

    public String getSample_name() {
        return sample_name;
    }

    public void setSample_name(String sample_name) {
        this.sample_name = sample_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAcoustic_value() {
        return Acoustic_value;
    }

    public void setAcoustic_value(String acoustic_value) {
        Acoustic_value = acoustic_value;
    }

    public String getMineral() {
        return Mineral;
    }

    public void setMineral(String mineral) {
        Mineral = mineral;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }


    @Exclude
    public void setKey(String key)
    {
        this.key = key;
    }
    @Exclude
    public String getKey()
    {
        return key;
    }


    public upload_data() {

    }

    public upload_data(String sample_name, String location, String acoustic_value, String mineral, String imageurl) {
        this.sample_name = sample_name;
        this.location = location;
        this.Acoustic_value = acoustic_value;
        this.Mineral = mineral;
        this.imageurl = imageurl;
    }


}
