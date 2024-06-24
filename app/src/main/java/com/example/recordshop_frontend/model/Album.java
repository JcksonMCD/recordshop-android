package com.example.recordshop_frontend.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;

import com.example.recordshop_frontend.BR;
import com.google.gson.annotations.SerializedName;


public class Album extends BaseObservable implements Parcelable {

    @SerializedName(value = "id")
    private String id;

    @SerializedName(value = "albumName")
    private String albumName;

    @SerializedName(value = "artist")
    private Artist artist;

    @SerializedName(value = "genre")
    private String genre;

    @SerializedName(value = "releaseYear")
    private int releaseYear;

    @SerializedName(value = "stockQuantity")
    private int stockQuantity;

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
        notifyPropertyChanged(BR.releaseYear);  // Corrected ID
    }

    @Bindable
    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
        notifyPropertyChanged(BR.stockQuantity);  // Corrected ID
    }

    @BindingAdapter("android:text")
    public static void setText(TextView view, int value) {
        if (view.getText() != null
                && (!view.getText().toString().isEmpty())
                && Integer.parseInt(view.getText().toString()) != value) {
            view.setText(Integer.toString(value));
        }
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static int getText(TextView view) {
        return Integer.parseInt(view.getText().toString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int flags) {
        parcel.writeString(id);
        parcel.writeString(albumName);
        parcel.writeParcelable(artist, flags);
        parcel.writeString(genre);
        parcel.writeInt(releaseYear);
        parcel.writeInt(stockQuantity);
    }

    protected Album(Parcel in) {
        id = in.readString();
        albumName = in.readString();
        artist = in.readParcelable(Artist.class.getClassLoader());
        genre = in.readString();
        releaseYear = in.readInt();
        stockQuantity = in.readInt();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };
}