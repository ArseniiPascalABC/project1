package ru.alishev.springcourse.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Book {
    private int id;
    @NotEmpty(message = "Название не должно быть пустым")
    @Size(min = 2, max = 100)
    private String title;
    @NotEmpty(message = "Автор не должен быть пустым")
    @Size(min = 2, max = 100)
    private String author;
    @Min(value = 1000, message = "Год не менее, чем 1000")
    private int release_year;

    public Book() {
    }

    public Book(int id, String title, String author, int release_year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.release_year = release_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
}
