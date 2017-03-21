import dataMappers.AlbumMap;
import dataMappers.PhotoMap;
import play.Application;
import play.GlobalSettings;


public class Global extends GlobalSettings {

    @Override
    public void onStart(Application application) {
        AlbumMap.initializeAlbums();
        PhotoMap.initializePhotos();
    }
}