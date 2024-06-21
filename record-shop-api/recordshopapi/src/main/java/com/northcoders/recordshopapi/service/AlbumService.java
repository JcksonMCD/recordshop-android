package com.northcoders.recordshopapi.service;

import com.northcoders.recordshopapi.models.Album;
import com.northcoders.recordshopapi.models.Genre;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AlbumService {
    List<Album> getAllAlbums();

    Album getAlbumById(long id);

    Album addAlbum(Album album);

    Album updateAlbumById(long albumId, Album updatedAlbum);

    ResponseEntity<String> deleteById(long id);

    List<Album> findAllByReleaseYear(int releaseYear);

    List<Album> findAllByGenre(Genre genre);

    Album findByAlbumName(String albumName);
}

