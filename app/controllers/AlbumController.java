package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import models.Album;
import models.Photo;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.AlbumService;

public class AlbumController extends Controller {


    @BodyParser.Of(BodyParser.Json.class)
    public static Result createAlbum() {
        Album album = Json.fromJson(request().body().asJson(), Album.class);
        AlbumService albumService = new AlbumService();
        long id = albumService.createAlbum(album);
        return ok(String.valueOf(id));
    }

    public static Result getAlbum(long id) {
        AlbumService albumService = new AlbumService();
        JsonNode result = Json.toJson(albumService.getAlbum(id));
        return ok(result);
    }

    public static Result deleteAlbum(long id) {
        AlbumService albumService = new AlbumService();
        try {
            JsonNode result = Json.toJson(albumService.deleteAlbum(id));
            return ok(result);
        } catch (Exception ex) {
            return badRequest(ex.getMessage());
        }
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result updateAlbum() {
        Album album = Json.fromJson(request().body().asJson(), Album.class);
        AlbumService albumService = new AlbumService();
        albumService.updateAlbum(album);
        return ok(String.valueOf(album.getId()));
    }

    public static Result getAllAlbums() {
        AlbumService albumService = new AlbumService();
        return ok(Json.toJson(albumService.getAllAlbums()));
    }

    public static Result getAllPhotos(long albumId) {
        AlbumService albumService = new AlbumService();
        return ok(Json.toJson(albumService.getAllPhotosInAlbum(albumId)));
    }


    @BodyParser.Of(BodyParser.Json.class)
    public static Result addPhotoToAlbum(long id) {
        Photo photo = Json.fromJson(request().body().asJson(), Photo.class);
        AlbumService albumService = new AlbumService();
        albumService.addPhotoToAlbum(photo, id);
        return ok(String.valueOf(photo.getAlbumId()));

    }

    public static Result removePhotoFromAlbum(long albumId, long photoId) {
        AlbumService albumService = new AlbumService();
        albumService.removePhotoFromAlbum(albumId, photoId);
        return ok(String.valueOf(photoId));
    }
}