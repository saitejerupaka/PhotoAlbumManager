package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import dataMappers.PhotoMapper;
import models.Photo;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

public class PhotoController extends Controller{

    @BodyParser.Of(BodyParser.Json.class)
    public static Result createPhoto(){
        Photo photo = Json.fromJson(request().body().asJson(), Photo.class);
        PhotoMapper.save(photo);
        return ok(String.valueOf(photo.getId()));
    }

    public static Result getPhoto(Long id){
        JsonNode result = Json.toJson(PhotoMapper.get(id));
        return ok(result);
    }

    public static Result deletePhoto(Long id){
        JsonNode result = Json.toJson(PhotoMapper.delete(id));
        return ok(result);
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result updatePhoto(){
        Photo photo = Json.fromJson(request().body().asJson(), Photo.class);
        PhotoMapper.save(photo);
        return ok(String.valueOf(photo.getId()));
    }

    public static Result getAllPhotos(){
        return ok(Json.toJson(PhotoMapper.getAll()));
    }

}
