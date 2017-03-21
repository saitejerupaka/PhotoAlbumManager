package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import dataMappers.PhotoMapper;
import models.Photo;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.PhotoService;

public class PhotoController extends Controller{

    @BodyParser.Of(BodyParser.Json.class)
    public static Result createPhoto(){
        Photo photo = Json.fromJson(request().body().asJson(), Photo.class);
        PhotoService photoService = new PhotoService();
        photoService.createPhoto(photo);
        return ok(String.valueOf(photo.getId()));
    }

    public static Result getPhoto(Long id){
        PhotoService photoService = new PhotoService();
        JsonNode result = Json.toJson(photoService.getPhoto(id));
        return ok(result);
    }

    public static Result deletePhoto(Long id){
        PhotoService photoService = new PhotoService();
        JsonNode result = Json.toJson(photoService.deletePhoto(id));
        return ok(result);
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result updatePhoto(){
        Photo photo = Json.fromJson(request().body().asJson(), Photo.class);
        PhotoService photoService = new PhotoService();
        photoService.updatePhoto(photo);
        return ok(String.valueOf(photo.getId()));
    }

    public static Result getAllPhotos(){
        PhotoService photoService = new PhotoService();
        return ok(Json.toJson(photoService.getAllPhotos()));
    }

}
