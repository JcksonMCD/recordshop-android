package com.example.recordshop_frontend.model;

import com.google.gson.annotations.SerializedName;

public class Artist {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
