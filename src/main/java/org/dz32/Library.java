package org.dz32;

import org.dz32.utils.HibernateUtil;
import org.hibernate.Session;
import org.postgresql.core.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private final Connection connection;

    public Library(Connection connection) {
        this.connection = connection;
    }


    public Book addBook(Book book) {
        if (book == null || !book.isValid()) {
            throw new IllegalArgumentException("Add - Invalid book data");
        }

        String query = "INSERT INTO books (author, title) VALUES (?, ?) RETURNING id;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, book.getAuthor());
            preparedStatement.setString(2, book.getTitle());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                book.setId(resultSet.getLong("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    public boolean removeBook(Book book) {
        if (book == null || book.getId() == null) {
            throw new IllegalArgumentException("Remove - Invalid book data");
        }

        String query = "DELETE FROM books WHERE id = ?;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, book.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> getBooks() {
        String query = "SELECT * FROM books";
        List books = new ArrayList();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                books.add(new Book(resultSet.getLong("id"),
                        resultSet.getString("author"),
                        resultSet.getString("title")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    public int getBookCount() {
        String query = "SELECT COUNT(*) FROM books";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
