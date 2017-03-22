package services;


import dataMappers.PhotoMapper;
import models.Album;
import models.Photo;

import java.util.Collection;

public class PhotoService {
    private PhotoMapper photoMapper;

    public PhotoService() {
        this.photoMapper = new PhotoMapper();
    }

    public long createPhoto(Photo photo){
        photoMapper.save(photo);
        return photo.getId();
    }

    public Photo getPhoto(long id){
        return photoMapper.get(id);
    }

    public long updatePhoto(Photo photo){
        photoMapper.save(photo);
        return photo.getId();
    }

    public Collection<Photo> getAllPhotos(){
        return photoMapper.getAll();
    }

    public Photo deletePhoto(long id) {
        return photoMapper.delete(id);
    }
}
