package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class AlbumController extends Controller{
    public static Result createAlbum(){
       return ok("added");
    }

}