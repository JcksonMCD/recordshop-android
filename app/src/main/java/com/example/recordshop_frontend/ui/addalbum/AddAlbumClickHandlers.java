package com.example.recordshop_frontend.ui.addalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.recordshop_frontend.model.Album;
import com.example.recordshop_frontend.ui.mainactivity.MainActivity;
import com.example.recordshop_frontend.ui.mainactivity.MainActivityViewModel;

public class AddAlbumClickHandlers {
    private Album album;
    private Context context;
    private MainActivityViewModel viewModel;

    public AddAlbumClickHandlers(Album album, Context context, MainActivityViewModel viewModel) {
        this.album = album;
        this.context = context;
        this.viewModel = viewModel;
    }

    public void submitAddAlbum(View view){
        if (album.getArtist().getArtistName() == null ||
                album.getAlbumName() == null ||
                album.getGenre() == null ||
                album.getReleaseYear() == 0 ||
                album.getStockQuantity() == 0) {
            Toast.makeText(context, "Fields must not be empty", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(context, MainActivity.class);
            Album submitAlbum = new Album(
                    album.getId(),
                    album.getAlbumName(),
                    album.getArtist(),
                    album.getGenre(),
                    album.getReleaseYear(),
                    album.getStockQuantity());

            viewModel.addAlbum(submitAlbum);
            context.startActivity(intent);
        }
    }

    public void returnToHomePage(View view){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
