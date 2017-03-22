import dataMappers.AlbumMapper;
import dataMappers.PhotoMapper;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.F;
import play.mvc.Http;
import play.mvc.Result;


public class Global extends GlobalSettings {

    @Override
    public void onStart(Application application) {
        AlbumMapper.initializeAlbums();
        PhotoMapper.initializePhotos();
    }

    @Override
    public F.Promise<Result> onError(Http.RequestHeader request, Throwable t) {
        String message = String.format("Server Error while processing request - %s ", request.uri());

        Logger.error(message, t);
        return super.onError(request, t);
    }

    @Override
    public F.Promise<Result> onBadRequest(Http.RequestHeader request, String error) {
        String message = String.format("Cannot process request- %s,  error- %s} ", request.uri(), error);
        Logger.info(message);
        return super.onBadRequest(request, error);
    }


}