package com.example.recordshop_frontend.service;

import com.example.recordshop_frontend.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AlbumApiService {

    @GET("album")
    Call<List<Album>> getAllAlbums();

    @POST("album")
    Call<Album> addAlbum(@Body Album album);
}
