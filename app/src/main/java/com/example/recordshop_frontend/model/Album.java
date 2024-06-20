package com.example.recordshop_frontend.model;

import com.google.gson.annotations.SerializedName;


public class Album {

    @SerializedName(value = "id")
    String id;

    @SerializedName(value = "albumName")
    String albumName;

    @SerializedName(value = "artist")
    Artist artist;

    @SerializedName(value = "genre")
    String genre;

    @SerializedName(value = "releaseYear")
    String releaseYear;

    @SerializedName(value = "stockQuantity")
    String stockQuantity;

//            "id": 1,
//        "albumName": "Anne",
//        "artist": {
//            "id": 1,
//            "name": "Art Name"
//        },
//        "genre": "ROCK",
//        "releaseYear": 1990,
//        "stockQuantity": 10

    public Album() {
    }

    public Album(String id, String albumName, Artist artist, String genre, String releaseYear, String stockQuantity) {
        this.id = id;
        this.albumName = albumName;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.stockQuantity = stockQuantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(String stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
