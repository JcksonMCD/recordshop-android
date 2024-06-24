package com.example.recordshop_frontend.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.recordshop_frontend.BR;
import com.google.gson.annotations.SerializedName;

public class Artist extends BaseObservable implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int flags) {
        parcel.writeString(id);
        parcel.writeString(artistName);
    }

    protected Artist(Parcel in) {
        id = in.readString();
        artistName = in.readString();
    }

    public static final Creator<Artist> CREATOR = new Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };
}
