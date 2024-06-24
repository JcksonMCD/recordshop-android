package com.example.recordshop_frontend.ui.addalbum;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.recordshop_frontend.R;
import com.example.recordshop_frontend.databinding.ActivityAddNewAlbumBinding;
import com.example.recordshop_frontend.model.Album;
import com.example.recordshop_frontend.ui.mainactivity.MainActivityViewModel;

public class AddNewAlbumActivity extends AppCompatActivity {
    ActivityAddNewAlbumBinding albumBinding;
    MainActivityViewModel viewModel;
    AddAlbumClickHandlers addAlbumClickHandlers;
    Album album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_album);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        albumBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_album);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        album = new Album();
        addAlbumClickHandlers = new AddAlbumClickHandlers(album, this, viewModel);
        albumBinding.setClickHandler(addAlbumClickHandlers);
        albumBinding.setAlbum(album);
    }
}