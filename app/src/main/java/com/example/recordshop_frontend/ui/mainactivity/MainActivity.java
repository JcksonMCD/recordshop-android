package com.example.recordshop_frontend.ui.mainactivity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Album> albumArrayList;
    private AlbumAdapter albumAdapter;
    private MainActivityViewModel mainActivityViewModel;
    private ActivityMainBinding activityMainBinding;

    //super.onCreate(savedInstanceState);
    //        EdgeToEdge.enable(this);
    //        setContentView(R.layout.activity_main);
    //        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
    //            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
    //            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
    //            return insets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
            mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
            getAllAlbums();
    }

private void getAllAlbums() {
    mainActivityViewModel.getAllAlbums().observe(this, new Observer<List<Album>>() {
        @Override
        public void onChanged(List<Album> albumsFromLiveData) {
            albumArrayList = (ArrayList<Album>) albumsFromLiveData;

            displayInRecyclerView();
            }
    });
}
    private void displayInRecyclerView(){
        recyclerView = activityMainBinding.recyclerView;
        albumAdapter = new AlbumAdapter(albumArrayList, recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        albumAdapter.notifyDataSetChanged();
    }
}
