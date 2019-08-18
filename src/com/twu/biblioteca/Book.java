package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private Integer year;

    public Book(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d", this.title, this.author, this.year);
    }

    public boolean match(String bookTitle) {
        if (bookTitle.toUpperCase().equals(this.title.toUpperCase())) {
            return true;
        } else {
            return false;
        }
    }
}
