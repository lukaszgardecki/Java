package com.example.lektury;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class BookDto {
    private String kind;
    @JsonProperty("full_sort_key")
    private String fullSortKey;
    private String title;
    private String url;
    @JsonProperty("cover_color")
    private String coverColor;
    private String author;
    private String cover;
    private String epoch;
    private String href;
    @JsonProperty("has_audio")
    private Boolean hasAudio;
    private String genre;
    @JsonProperty("simple_thumb")
    private String simpleThumb;
    private String slug;
    @JsonProperty("cover_thumb")
    private String coverThumb;
    private Boolean liked;

    public BookDto() {
    }

    public BookDto(String kind, String fullSortKey, String title, String url, String coverColor, String author, String cover, String epoch, String href, Boolean hasAudio, String genre, String simpleThumb, String slug, String coverThumb, Boolean liked) {
        this.kind = kind;
        this.fullSortKey = fullSortKey;
        this.title = title;
        this.url = url;
        this.coverColor = coverColor;
        this.author = author;
        this.cover = cover;
        this.epoch = epoch;
        this.href = href;
        this.hasAudio = hasAudio;
        this.genre = genre;
        this.simpleThumb = simpleThumb;
        this.slug = slug;
        this.coverThumb = coverThumb;
        this.liked = liked;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getFullSortKey() {
        return fullSortKey;
    }

    public void setFullSortKey(String fullSortKey) {
        this.fullSortKey = fullSortKey;
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

    public String getCoverColor() {
        return coverColor;
    }

    public void setCoverColor(String coverColor) {
        this.coverColor = coverColor;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getHasAudio() {
        return hasAudio;
    }

    public void setHasAudio(Boolean hasAudio) {
        this.hasAudio = hasAudio;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSimpleThumb() {
        return simpleThumb;
    }

    public void setSimpleThumb(String simpleThumb) {
        this.simpleThumb = simpleThumb;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCoverThumb() {
        return coverThumb;
    }

    public void setCoverThumb(String coverThumb) {
        this.coverThumb = coverThumb;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %s", title, author, genre);
    }
}
