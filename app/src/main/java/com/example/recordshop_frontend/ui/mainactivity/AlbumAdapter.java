package com.example.recordshop_frontend.ui.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recordshop_frontend.R;
import com.example.recordshop_frontend.databinding.AlbumPresentationBinding;
import com.example.recordshop_frontend.model.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    List<Album> albumList;
    RecyclerView context;

    public AlbumAdapter(List<Album> albumList, RecyclerView context) {
        this.albumList = albumList;
        this.context = context;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AlbumPresentationBinding albumPresentationBinding = AlbumPresentationBinding.bind(LayoutInflater.from(parent.getContext()).inflate(R.layout.album_presentation, parent, false));

        return new AlbumViewHolder(albumPresentationBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albumList.get(position);

        holder.albumItemBinding.recordName.setText(album.getAlbumName());
        holder.albumItemBinding.recordArtist.setText(album.getArtist().getArtistName());
        holder.albumItemBinding.recordGenre.setText(album.getGenre());
        holder.albumItemBinding.recordStock.setText(album.getStockQuantity());
        holder.albumItemBinding.recordReleaseYear.setText(album.getReleaseYear());
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder{
        private AlbumPresentationBinding albumItemBinding;

        public AlbumViewHolder (AlbumPresentationBinding albumItemBinding) {
            super(albumItemBinding.getRoot());
            this.albumItemBinding = albumItemBinding;
        }
    }
}
