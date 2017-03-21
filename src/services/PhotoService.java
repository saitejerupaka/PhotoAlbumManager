package services;


import dataMappers.PhotoMapper;
import models.Photo;

import java.util.Collection;

public class PhotoService {
    private PhotoMapper albumMapper;

    public PhotoService() {
        this.albumMapper = new PhotoMapper();
    }

    public long createPhoto(Photo album){
        albumMapper.save(album);
        return album.getId();
    }

    public Photo getPhoto(long id){
        return albumMapper.get(id);
    }

    public long updatePhoto(Photo album){
        albumMapper.save(album);
        return album.getId();
    }

    public Collection<Photo> getAllPhotos(){
        return albumMapper.getAll();
    }

    public Photo deletePhoto(long id) {
        return albumMapper.delete(id);
    }
}
