package com.service.models;

/**
 * Created by Olha_Pidhorna on 7/20/2016.
 */
public class Book {

    private String name;
    private String autor;
    private String genre;
    private int count;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", autor='" + autor + '\'' +
                ", genre='" + genre + '\'' +
                ", count=" + count +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public Book(String name, String autor, String genre, int count, int id) {
        this.name = name;
        this.autor = autor;
        this.genre = genre;
        this.count = count;
        this.id = id;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
