package mockDataBase;

import java.util.*;


public class AlbumStore{
    private static HashMap<Long, String> _albums;

    private static HashMap<Long, String> get_albums() {
        return _albums;
    }

    private static void set_albums(HashMap<Long, String> albums) {
        _albums = albums;
    }

    public static void initializeNew(){
        set_albums(new HashMap<Long, String>());
    }

    public static void save(Long id, String title)
    {
        _albums.put(id, title);
    }

    public static String get(Long id)
    {
        return get_albums().get(id);
    }
}