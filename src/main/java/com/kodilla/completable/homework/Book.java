package com.kodilla.completable.homework;

import java.util.Objects;

public class Book {
    String author;
    String title;
    int releaseDate;
    String signature;

    public Book(String author, String title, int releaseDate, String signature) {
        this.author = author;
        this.title = title;
        this.releaseDate = releaseDate;
        this.signature = signature;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", signature='" + signature + '\'' +
                '}';
    }
}
