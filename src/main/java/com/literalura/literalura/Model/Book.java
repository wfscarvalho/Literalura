package com.literalura.literalura.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

    @Id
    Long id;
    String title;
    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    List<Author> authors = new ArrayList<>();
    boolean copyright;
    List<String> languages= new ArrayList<>();
    int download_count;

    public Book(){

    }
    public Book(Long id, String title, List<Author> authors, boolean copyright, int download_count, int death_year) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.copyright = copyright;
        this.download_count = download_count;
        //this.death_year = death_year;
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
        for (Author author: authors)
            author.getBooks().add(this);
    }

    public boolean isCopyright() {
        return copyright;
    }

    public void setCopyright(boolean copyright) {
        this.copyright = copyright;
    }

    public int getDownload_count() {
        return download_count;
    }

    public void setDownload_count(int download_count) {
        this.download_count = download_count;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "id: " + id +
                "   title: " + title +
                "   author: " + authors;
    }

    public String detailedDescription() {
        return String.format("""
                
                ______LIVRO______
                
                Id: %d
                Título: %s
                Authors: %s
                Language: %s
                downloadCount: %d
                _________________
                
                """,getId(),getTitle(),getAuthors(),getLanguages(), getDownload_count());
    }
}
