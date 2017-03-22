package controllers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Album;
import models.Photo;
import play.libs.F;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Result;
import services.AlbumService;

import java.util.List;

import static play.libs.Json.fromJson;
import static play.libs.Json.setObjectMapper;

public class InitController extends Controller {
    public static F.Promise<Result> init() {
        String photoUrl = "http://jsonplaceholder.typicode.com/photos";
        String albumsUrl = "http://jsonplaceholder.typicode.com/albums";

        final F.Promise<JsonNode> albumResponsePromise = WS.url(albumsUrl).get().map(new F.Function<WSResponse, JsonNode>() {
            @Override
            public JsonNode apply(WSResponse wsResponse) throws Throwable {
                return wsResponse.asJson();
            }
        });

        final F.Promise<JsonNode> photosResponsePromise = WS.url(photoUrl).get().map(new F.Function<WSResponse, JsonNode>() {
            @Override
            public JsonNode apply(WSResponse wsResponse) throws Throwable {
                return wsResponse.asJson();
            }
        });

        F.Promise<List<JsonNode>> listPromise = F.Promise.sequence(albumResponsePromise, photosResponsePromise);

        F.Promise<Result> promiseResult = listPromise.map(new F.Function<List<JsonNode>, Result>() {
            @Override
            public Result apply(List<JsonNode> jsonNodes) throws Throwable {
                JsonNode albums = albumResponsePromise.get(30000L);
                JsonNode photos = photosResponsePromise.get(30000L);
                AlbumService albumService = new AlbumService();

                //Response has userId property which is not needed, so has to ignore unknown properties
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                setObjectMapper(objectMapper);

                SaveAlbums(albums, albumService);
                SavePhotos(photos, albumService);

                return ok();
            }
        });

        return promiseResult;
    }

    private static void SaveAlbums(JsonNode albums, AlbumService albumService) {


        for (int i = 0; i < albums.size(); i++) {
            Album album = fromJson(albums.get(i), Album.class);
            albumService.createAlbum(album);
        }


    }

    private static void SavePhotos(JsonNode photos, AlbumService albumService) {

        for (int i = 0; i < photos.size(); i++) {

            Photo photo = fromJson(photos.get(i), Photo.class);

            albumService.addPhotoToAlbum(photo, photo.getAlbumId());
        }


    }

}
