package services;


import dataMappers.AlbumMapper;
import models.Album;

import java.util.Collection;

public class AlbumService {

    private AlbumMapper albumMapper;

    public AlbumService() {
        this.albumMapper = new AlbumMapper();
    }

    public long createAlbum(Album album){
        albumMapper.save(album);
        return album.getId();
    }

    public Album getAlbum(long id){
        return albumMapper.get(id);
    }

    public long updateAlbum(Album album){
        albumMapper.save(album);
        return album.getId();
    }

    public Collection<Album> getAllAlbums(){
        return albumMapper.getAll();
    }

    public Album deleteAlbum(long id) {
        return albumMapper.delete(id);
    }
}
