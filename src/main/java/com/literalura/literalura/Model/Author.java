package com.literalura.literalura.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String name;
    int birth_year;
    int death_year;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "authors_Books",
            joinColumns = @JoinColumn(name = "join_table_author"),
            inverseJoinColumns = @JoinColumn(name = "join_table_book"))
    private List<Book> books = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public int getDeath_year() {
        return death_year;
    }

    public void setDeath_year(int death_year) {
        this.death_year = death_year;
    }

    public Author() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        books.forEach(book -> book.setAuthors((List<Author>) this));
        this.books = books;
    }

    public Author(String name, int birth_year, int death_year) {
        this.name = name;
        this.birth_year = birth_year;
        this.death_year = death_year;
    }

    @Override
    public String toString() {
        return name;
    }
}
