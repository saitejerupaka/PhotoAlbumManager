package dataMappers;


import models.Photo;

import java.util.Collection;
import java.util.HashMap;

public class PhotoMapper {
    private static HashMap<Long, Photo> _photos;

    public static HashMap<Long, Photo> get_photos() {
        return _photos;
    }

    public static void set_photos(HashMap<Long, Photo> _photos) {
        PhotoMapper._photos = _photos;
    }

    public static  void initializePhotos(){
        set_photos(new HashMap<Long, Photo>());
    }

    public  void save(Photo photo)
    {
        _photos.put(photo.getId(), photo);
    }

    public Photo get(Long id)
    {
        return get_photos().get(id);
    }

    public Photo delete(Long id){
        return get_photos().remove(id);
    }

    public Collection<Photo> getAll(){
        return get_photos().values();
    }

}
