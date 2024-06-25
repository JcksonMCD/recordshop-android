package com.example.recordshop_frontend.ui.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recordshop_frontend.R;
import com.example.recordshop_frontend.databinding.ActivityMainBinding;
import com.example.recordshop_frontend.model.Album;
import com.example.recordshop_frontend.model.Artist;
import com.example.recordshop_frontend.ui.updatealbum.UpdateAlbumActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    private RecyclerView recyclerView;
    private ArrayList<Album> albumArrayList;
    private AlbumAdapter albumAdapter;
    private MainActivityViewModel mainActivityViewModel;
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandler clickHandlers;
    private static final String ALBUM_KEY = "album";
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main);

        clickHandlers = new MainActivityClickHandler(this);
        activityMainBinding.setMainActivityClickHandler(clickHandlers);

        mainActivityViewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        searchView.findViewById(R.id.searchView);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return false;
            }
        });
        getAllAlbums();
    }

    private void filterList(String newText) {
        ArrayList<Album> filteredAlbums = new ArrayList<>();

        for (Album album : albumArrayList){
            if(album.getAlbumName().contains(newText.toLowerCase())){
                filteredAlbums.add(album);
            }
        }

        if (filteredAlbums.isEmpty()){
            Toast.makeText(MainActivity.this,"No Albums found", Toast.LENGTH_SHORT).show();
        }
    }

    private void getAllAlbums() {
            mainActivityViewModel.getAllAlbums().observe(
                    this, new Observer<List<Album>>() {
                @Override
                public void onChanged(List<Album> albums) {
                    albumArrayList = (ArrayList<Album>) albums;

                    displayInRecyclerView();
                }
            });
        }

    private void displayInRecyclerView() {
//        Album album1 = new Album("1", "Album1", new Artist("1", "Artist1"), "ROCK", "1990", "1");
//        Album album2 = new Album("2", "Album2", new Artist("2", "Artist2"), "ROCK", "1980", "1");
//
//        List<Album> albumList = new ArrayList<>();
//        albumList.add(album1);
//        albumList.add(album2);
        recyclerView = activityMainBinding.recyclerView;
        albumAdapter = new AlbumAdapter(albumArrayList, this, this);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();
        albumAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, UpdateAlbumActivity.class);
        intent.putExtra(ALBUM_KEY, albumArrayList.get(position));
        this.startActivity(intent);
    }
}
