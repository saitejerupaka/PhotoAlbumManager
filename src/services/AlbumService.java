package services;


import dataMappers.AlbumMapper;
import models.Album;
import models.Photo;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class AlbumService {

    private AlbumMapper albumMapper;

    public AlbumService() {
        this.albumMapper = new AlbumMapper();
    }

    public long createAlbum(Album album){
        albumMapper.save(album);
        return album.getId();
    }

    public Album getAlbum(long id){
        return albumMapper.get(id);
    }

    public long updateAlbum(Album album){
        Album currentAlbum = albumMapper.get(album.getId());
        album.setPhotos(currentAlbum.getPhotos());
        albumMapper.save(album);
        return album.getId();
    }

    public Collection<Album> getAllAlbums(){
        return albumMapper.getAll();
    }

    public Album deleteAlbum(long albumId) throws Exception {
        Album album = albumMapper.get(albumId);
        if(album.getPhotos().size() > 0)
        {
            throw new Exception("Album is not empty");
        }

        return albumMapper.delete(albumId);
    }

    public void addPhotoToAlbum(Photo photo, long albumId) {
        PhotoService photoService = new PhotoService();
        photo.setAlbumId(albumId);
        photoService.createPhoto(photo);

        Album album = getAlbum(albumId);
        HashSet<Photo> updatedPhotos = album.getPhotos();
        updatedPhotos.add(photo);
        album.setPhotos(updatedPhotos);
        albumMapper.save(album);
    }

    public void removePhotoFromAlbum(long albumId, long photoId) {
        PhotoService photoService = new PhotoService();
        Photo photo = photoService.deletePhoto(photoId);

        Album album = getAlbum(albumId);
        HashSet<Photo> updatedPhotos = album.getPhotos();
        updatedPhotos.remove(photo);
        album.setPhotos(updatedPhotos);
    }

    public Collection<Photo> getAllPhotosInAlbum(long albumId) {
        Album album = albumMapper.get(albumId);
        return album.getPhotos();
    }
}
