package models;

public class Photo {
    private Long id;
    private Long albumId;
    private String title;
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo)) return false;

        Photo photo = (Photo) o;

        if (getId() != null ? !getId().equals(photo.getId()) : photo.getId() != null) return false;
        if (getAlbumId() != null ? !getAlbumId().equals(photo.getAlbumId()) : photo.getAlbumId() != null) return false;
        if (!getTitle().equals(photo.getTitle())) return false;
        return getUrl().equals(photo.getUrl());

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getAlbumId() != null ? getAlbumId().hashCode() : 0);
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getUrl().hashCode();
        return result;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
