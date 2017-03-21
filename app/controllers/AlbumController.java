package controllers;


import play.mvc.Controller;
import play.mvc.Result;
import mockDataBase.AlbumStore;

public class AlbumController extends Controller{

    public static Result createAlbum(){
        AlbumStore.save(3l, "google");
       return ok(AlbumStore.get(3l));
    }

}