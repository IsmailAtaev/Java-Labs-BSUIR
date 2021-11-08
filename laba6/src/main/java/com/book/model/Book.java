package com.book.model;

import java.util.Objects;

public class Book {

    private int id;

    private String authorBook;

    private String nameBook;

    private String language;

    private int yearBook;

    private int countPage;

    public Book() {
    }

    public Book(int id, String authorBook, String nameBook, String language, int yearBook, int countPage) {
        this.id = id;
        this.authorBook = authorBook;
        this.nameBook = nameBook;
        this.language = language;
        this.yearBook = yearBook;
        this.countPage = countPage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getYearBook() {
        return yearBook;
    }

    public void setYearBook(int yearBook) {
        this.yearBook = yearBook;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", authorBook='" + authorBook + '\'' +
                ", nameBook='" + nameBook + '\'' +
                ", language='" + language + '\'' +
                ", yearBook=" + yearBook +
                ", countPage=" + countPage +
                '}';
    }
}