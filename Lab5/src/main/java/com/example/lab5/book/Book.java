package com.example.lab5.book;

import java.util.Objects;

/**
 * @author Ataev Ismayyl
 * */

import org.apache.logging.log4j.Level; // почему-то не видит, и в pom.xml добавил, и в модуль

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Book {
    private final Logger logger = LogManager.getLogger(Book.class.getName());

    private String authorBook;

    private String nameBook;

    private String language;

    private int yearBook = 0;

    private int countPage = 0;

    public Book(String authorBook, String nameBook, String language, int yearBook, int countPage) {
        this.authorBook = authorBook;
        this.nameBook = nameBook;
        this.language = language;
        this.yearBook = yearBook;
        this.countPage = countPage;
    }

    public Book() { }

    public Book(String authorBook) {
        this.authorBook = authorBook;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearBook == book.yearBook && countPage == book.countPage &&
                Objects.equals(authorBook, book.authorBook) &&
                Objects.equals(nameBook, book.nameBook) &&
                Objects.equals(language, book.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorBook, nameBook, language, yearBook, countPage);
    }

    @Override
    public String toString() {
        return "Book{" +
                "authorBook='" + authorBook + '\'' +
                ", nameBook='" + nameBook + '\'' +
                ", language='" + language + '\'' +
                ", yearBook=" + yearBook +
                ", countPage=" + countPage +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Book(authorBook, nameBook, language, yearBook, countPage);
    }
}