package com.example.recordshop_frontend.ui.updatealbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.recordshop_frontend.model.Album;
import com.example.recordshop_frontend.ui.mainactivity.MainActivity;
import com.example.recordshop_frontend.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumViewClickHandler {

    Album album;
    MainActivityViewModel viewModel;
    long albumId;
    Context context;

    public UpdateAlbumViewClickHandler(Album album, MainActivityViewModel viewModel, Context context) {
        this.album = album;
        this.viewModel = viewModel;
        this.context = context;
    }

    public void onBackButtonClick(View view){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public void onSbmitBtnClick(View view){
        Album updatedAlbum = new Album(
                album.getId(),
                album.getAlbumName(),
                album.getArtist(),
                album.getGenre(),
                album.getReleaseYear(),
                album.getStockQuantity()
        );

        if (album.getAlbumName().equals("")
                | album.getArtist().getArtistName().equals("")
                | album.getGenre().equals("")
                | album.getReleaseYear() == 0
                | album.getStockQuantity() == 0){
            Toast.makeText(context, "Fields can not be empty", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(context, MainActivity.class);

            albumId = Long.getLong(album.getId());

            viewModel.updateAlbum(albumId, album);

            context.startActivity(intent);
        }
    }

    public void onDelBtnClick(View view){
        Intent intent = new Intent(context, MainActivity.class);

        albumId = Long.getLong(album.getId());

        viewModel.deleteAlbum(albumId);

        context.startActivity(intent);
    }

}
