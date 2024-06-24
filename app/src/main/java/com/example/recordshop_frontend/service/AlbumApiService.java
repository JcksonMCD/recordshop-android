package com.example.recordshop_frontend.service;

import com.example.recordshop_frontend.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlbumApiService {

    @GET("album")
    Call<List<Album>> getAllAlbums();

    @POST("album")
    Call<Album> addAlbum(@Body Album album);

    @PUT("album/{id}")
    Call<Album> updateAlbum(@Path("id") long id, @Body Album album);

    @DELETE("album/{id}")
    Call<String> deleteAlbum(@Path("id") long id);
}
