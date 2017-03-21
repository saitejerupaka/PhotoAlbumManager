package dataMappers;


import models.Photo;

import java.util.Collection;
import java.util.HashMap;

public class PhotoMap {
    private static HashMap<Long, Photo> _photos;

    public static HashMap<Long, Photo> get_photos() {
        return _photos;
    }

    public static void set_photos(HashMap<Long, Photo> _photos) {
        PhotoMap._photos = _photos;
    }

    public static  void initializePhotos(){
        set_photos(new HashMap<Long, Photo>());
    }

    public static void save(Photo photo)
    {
        _photos.put(photo.getId(), photo);
    }

    public static Photo get(Long id)
    {
        return get_photos().get(id);
    }

    public static Photo delete(Long id){
        return get_photos().remove(id);
    }

    public static Collection<Photo> getAll(){
        return get_photos().values();
    }

}
