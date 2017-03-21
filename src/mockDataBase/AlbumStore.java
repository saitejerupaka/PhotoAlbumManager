package mockDataBase;

import models.Album;

import java.util.*;


public class AlbumStore{
    private static HashMap<Long, Album> _albums;

    private static HashMap<Long, Album> get_albums() {
        return _albums;
    }

    private static void set_albums(HashMap<Long, Album> albums) {
        _albums = albums;
    }

    public static void initializeNew(){
        set_albums(new HashMap<Long, Album>());
    }

    public static void save(Album album)
    {
        _albums.put(album.getId(), album);
    }

    public static Album get(Long id)
    {
        return get_albums().get(id);
    }

    public static Album delete(Long id){
        return get_albums().remove(id);
    }

    public static Collection<Album> getAll(){
        return get_albums().values();
    }
}