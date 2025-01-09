package org.dz32;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DbConnect.migrate();
        Library library = new Library(DbConnect.connect());
        Book book = new Book("Jack", "Title");
        library.addBook(book);
        System.out.println(library.getBookCount());
        System.out.println(library.removeBook(book));
        System.out.println(library.getBookCount());
    }
}
