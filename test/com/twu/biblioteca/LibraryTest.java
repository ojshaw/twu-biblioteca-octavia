package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class LibraryTest {

    private ArrayList<Book> books = new ArrayList<>();
    private String bookTitle = "A Book";
    private Book book = mock(Book.class);
    private Library lib;

    @Before
    public void setUp() {
        lib = new Library(books);
    }

    @Test
    public void shouldRemoveBookFromListWhenCheckedOut() {
        books.add(book);
        when(book.match(bookTitle)).thenReturn(true);

        assertTrue(lib.checkOutBook(bookTitle));
    }
}
