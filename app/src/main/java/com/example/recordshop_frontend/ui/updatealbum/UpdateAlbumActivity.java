package com.example.recordshop_frontend.ui.updatealbum;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.recordshop_frontend.R;
import com.example.recordshop_frontend.databinding.ActivityUpdateAlbumBinding;
import com.example.recordshop_frontend.model.Album;

public class UpdateAlbumActivity extends AppCompatActivity {
    ActivityUpdateAlbumBinding albumBinding;
    UpdateAlbumViewClickHandler handler;
    Album album;
    private static final String ALBUM_KEY = "album";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_album);


        album = getIntent().getParcelableExtra(ALBUM_KEY, Album.class);

        albumBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_update_album
        );

        albumBinding.setAlbum(album);

    }
}