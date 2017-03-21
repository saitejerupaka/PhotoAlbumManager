package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import models.Album;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import dataMappers.AlbumMap;

public class AlbumController extends Controller{

    @BodyParser.Of(BodyParser.Json.class)
    public static Result createAlbum(){
        Album album = Json.fromJson(request().body().asJson(), Album.class);
        AlbumMap.save(album);
        return ok(String.valueOf(album.getId()));
    }

    public static Result getAlbum(Long id){
        JsonNode result = Json.toJson(AlbumMap.get(id));
        return ok(result);
    }

    public static Result deleteAlbum(Long id){
        JsonNode result = Json.toJson(AlbumMap.delete(id));
        return ok(result);
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result updateAlbum(){
        Album album = Json.fromJson(request().body().asJson(), Album.class);
        AlbumMap.save(album);
        return ok(String.valueOf(album.getId()));
    }

    public static Result getAllAlbums(){
        return ok(Json.toJson(AlbumMap.getAll()));
    }

}