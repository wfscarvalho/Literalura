package com.literalura.literalura.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Table(name = "books")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

    @Id
    Long id;
    String title;
    List<Author> authors = new ArrayList<Author>();
    boolean copyright;
    int downloadCount;
    int death_year;

    public Book(){

    }
    public Book(Long id, String title, List<Author> authors, boolean copyright, int downloadCount, int death_year) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.copyright = copyright;
        this.downloadCount = downloadCount;
        this.death_year = death_year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public boolean isCopyright() {
        return copyright;
    }

    public void setCopyright(boolean copyright) {
        this.copyright = copyright;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public int getDeath_year() {
        return death_year;
    }

    public void setDeath_year(int death_year) {
        this.death_year = death_year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", copyright=" + copyright +
                ", downloadCount=" + downloadCount +
                ", death_year=" + death_year +
                '}';
    }
}
