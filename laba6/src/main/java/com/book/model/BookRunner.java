package com.book.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class BookRunner {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();

        BookRunner bookRunner = new BookRunner();

        System.out.println("Adding book's records to the DB");
        /**
         *  Adding book's records to the database (DB)
         */
        bookRunner.addBook("Tom Edison", "Electronic", "Engl", 1999, 2005);
        bookRunner.addBook("R.Lafore", "C++", "Rus", 2020, 924);
        bookRunner.addBook("Bulgakow", "MasterMargarita", "Rus", 1968, 4335);
        System.out.println("List of book");

        /**
         * List book
         */
        List books = bookRunner.listBook();
        for (Object book : books) {
            System.out.println(book);
        }


        /**
         * Update and Remove book
         */
        bookRunner.updateBook(2, "Мастер и Маргарита");


        bookRunner.removeBook(5);

        System.out.println("Final list of books");
        /**
         * List books
         */
        books = bookRunner.listBook();
        for (Object developer : books) {
            System.out.println(developer);
        }
        System.out.println("===================================");
    }


    public void addBook(String author, String name, String language, int year,int page) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Book book = new Book(1,author,name,language,year,page);

        session.save(book);
        transaction.commit();
        session.close();
    }

    public List listBook() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List books = session.createQuery("FROM Book").list();

        transaction.commit();
        session.close();
        return books;
    }

    public void updateBook(int bookId, String  name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Book book = (Book) session.get(Book.class, bookId);
        book.setNameBook(name);
        session.update(book);
        transaction.commit();
        session.close();
    }

    public void removeBook(int bookId) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Book book = (Book) session.get(Book.class, bookId);
        session.delete(book);
        transaction.commit();
        session.close();
    }





}
