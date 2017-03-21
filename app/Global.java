import dataMappers.AlbumMapper;
import dataMappers.PhotoMapper;
import play.Application;
import play.GlobalSettings;


public class Global extends GlobalSettings {

    @Override
    public void onStart(Application application) {
        AlbumMapper.initializeAlbums();
        PhotoMapper.initializePhotos();
    }
}