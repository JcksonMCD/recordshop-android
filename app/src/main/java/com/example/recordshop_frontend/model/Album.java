package com.example.recordshop_frontend.model;

import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;

import com.example.recordshop_frontend.BR;
import com.google.gson.annotations.SerializedName;


public class Album extends BaseObservable {

    @SerializedName(value = "id")
    String id;

    @SerializedName(value = "albumName")
    String albumName;

    @SerializedName(value = "artist")
    Artist artist;

    @SerializedName(value = "genre")
    String genre;

    @SerializedName(value = "releaseYear")
    int releaseYear;

    @SerializedName(value = "stockQuantity")
    int stockQuantity;

    public Album() {
    }

    public Album(String id, String albumName, Artist artist, String genre, int releaseYear, int stockQuantity) {
        this.id = id;
        this.albumName = albumName;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.stockQuantity = stockQuantity;
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
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
        notifyPropertyChanged(BR.albumName);
    }

    @Bindable
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
        notifyPropertyChanged(BR.artist);
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    @Bindable
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        notifyPropertyChanged(BR.album);
    }

    @Bindable
    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
        notifyPropertyChanged(BR.album);
    }

    @BindingAdapter("android:text")
    public static void setText(TextView view, int value) {
        if (view.getText() != null
                && ( !view.getText().toString().isEmpty() )
                && Integer.parseInt(view.getText().toString()) != value) {
            view.setText(Integer.toString(value));
        }
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static int getText(TextView view) {
        return Integer.parseInt(view.getText().toString());
    }
}
