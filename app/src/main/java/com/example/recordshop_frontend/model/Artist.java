package com.example.recordshop_frontend.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.recordshop_frontend.BR;
import com.google.gson.annotations.SerializedName;

public class Artist extends BaseObservable {
    @SerializedName(value = "id")
    String id;

    @SerializedName(value = "artistName")
    String artistName;

    public Artist() {
    }

    public Artist(String id, String artistName) {
        this.id = id;
        this.artistName = artistName;
    }

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
        notifyPropertyChanged(BR.artistName);
    }
}
