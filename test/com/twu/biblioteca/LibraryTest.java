package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class LibraryTest {

    private ArrayList<Book> books;
    private String matchingBookTitle = "1984";
    private String unknownBookTitle = "Catcher in the Rye";
    private Book book = new Book("1984", "George Orwell", 1966);
    private Library lib;

    @Before
    public void setUp() {
        books = new ArrayList<>();
        books.add(book);
        lib = new Library(books);
    }

    @Test
    public void shouldRemoveBookFromListWhenCheckedOut() {
        lib.checkOutBook(matchingBookTitle);

        assertFalse(books.contains(book));
    }

    @Test
    public void shouldReturnTrueWhenCheckOutWasPossible() {
        boolean bookWasCheckedOut = lib.checkOutBook(matchingBookTitle);

        assertTrue(bookWasCheckedOut);
    }

    @Test
    public void shouldReturnFalseWhenCheckOutWasNotPossible() {
        boolean bookWasCheckedOut = lib.checkOutBook(unknownBookTitle);

        assertFalse(bookWasCheckedOut);
    }
}
