package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Album{
    long id;
    String title;
    HashSet<Photo> photos = new HashSet<Photo>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;

        Album album = (Album) o;

        if (getId() != album.getId()) return false;
        return getTitle().equals(album.getTitle());

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getTitle().hashCode();
        return result;
    }

    public HashSet<Photo> getPhotos() {
        return photos;

    }

    public void setPhotos(HashSet<Photo> photos) {
        this.photos = photos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}