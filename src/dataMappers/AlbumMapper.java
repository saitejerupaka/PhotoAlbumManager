package dataMappers;

import models.Album;

import java.util.Collection;
import java.util.HashMap;


public class AlbumMapper {
    private static HashMap<Long, Album> _albums;

    private static HashMap<Long, Album> get_albums() {
        return _albums;
    }

    private static void set_albums(HashMap<Long, Album> albums) {
        _albums = albums;
    }

    public static void initializeAlbums() {
        set_albums(new HashMap<Long, Album>());
    }

    public void save(Album album) {
        _albums.put(album.getId(), album);
    }

    public Album get(Long id) {
        return get_albums().get(id);
    }

    public Album delete(Long id) {
        return get_albums().remove(id);
    }

    public Collection<Album> getAll() {
        return get_albums().values();
    }
}