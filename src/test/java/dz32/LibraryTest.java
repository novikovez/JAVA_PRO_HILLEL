package dz32;
import org.dz32.Book;
import org.dz32.DbConnect;
import org.dz32.Library;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LibraryTest {
    private static Connection connection;
    private static Library library;
    private static Book tempBook;

    @BeforeAll
    static void setUp() throws SQLException {
        System.out.println("BeforeAll");
        connection = DbConnect.connect();
        library = new Library(connection);
        DbConnect.migrate();
    }

    @AfterAll
    static void cleaUp() throws SQLException {
        System.out.println("AfterAll");
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE books;");
        }
        connection.close();
    }

    @BeforeEach
    void beforeEachTest() throws SQLException {
        System.out.println("BeforeEach");
        tempBook = library.addBook(new Book("Temp Author", "title"));
    }

    @AfterEach
    void afterEachTest() throws SQLException {
        System.out.println("AfterEach");
        library.removeBook(tempBook);
    }

    @Test
    @Order(1)
    public void testCreateBook() throws SQLException {
        System.out.println("testCreateBook");
        Book book = new Book("Author", "Title");
        Book savedBook = library.addBook(book);
        assertNotNull(savedBook.getId());
        library.removeBook(savedBook);
    }

    @Test
    @Order(2)
    public void testInvalidBookCreation() {
        System.out.println("testInvalidBookCreation");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(new Book(null, "title"));
        });
        assertEquals("Add - Invalid book data", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(new Book("Invalid User", null));
        });
        assertEquals("Add - Invalid book data", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(null);
        });
        assertEquals("Add - Invalid book data", exception.getMessage());
    }

    @Test
    @Order(3)
    void testGetBooks() throws SQLException {
        System.out.println("testGetBooks");
        List<Book> book = library.getBooks();
        assertFalse(book.isEmpty());
    }

    @Test
    @Order(4)
    void testGetBooksEmpty() throws SQLException {
        System.out.println("testGetBooksEmpty");
        library.removeBook(tempBook);
        List<Book> book = library.getBooks();
        assertTrue(book.isEmpty());
    }

    @Test
    @Order(5)
    public void testRemoveBookIdNull() throws SQLException {
        System.out.println("testRemoveBookIdNull");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            library.removeBook(new Book(null, "Author", "Title"));
        });
        assertEquals("Remove - Invalid book data", exception.getMessage());
    }

    @Test
    @Order(6)
    public void testRemoveBookSuccess() throws SQLException {
        System.out.println("testRemoveBookSuccess");
        boolean destroy = library.removeBook(tempBook);
        assertTrue(destroy);
    }

    @Test
    @Order(7)
    public void testCountBook() throws SQLException {
        System.out.println("testCountBook");
        assertEquals(1, library.getBookCount());
    }

    @Test
    @Order(8)
    public void testCountBookEmpty() throws SQLException {
        System.out.println("testCountBookEmpty");
        library.removeBook(tempBook);
        assertEquals(0, library.getBookCount());
    }




}
