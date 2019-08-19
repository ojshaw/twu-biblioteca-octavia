package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class LibraryTest {

    private ArrayList<Book> availableBooks;
    private ArrayList<Book> checkedOutBooks;
    private String bookTitle = "1984";
    private String unavailableBookTitle = "Catcher in the Rye";
    private Book book;
    private Library lib;

    @Before
    public void setUp() {
        book = new Book(bookTitle, "George Orwell", 1966);
        checkedOutBooks = new ArrayList<>();
        availableBooks = new ArrayList<>();
        availableBooks.add(book);
        lib = new Library(availableBooks, checkedOutBooks);
    }

    @Test
    public void shouldReturnStringContainingBookTitlesInLibrary() {
        ArrayList<String> bookString = lib.listBooks();

        assertTrue(bookString.contains(book.toString()));
    }

    @Test
    public void shouldRemoveBookFromBookStringWhenCheckedOut() {
        lib.checkOutBook(bookTitle);
        ArrayList<String> bookStringList = lib.listBooks();
        assertFalse(bookStringList.contains(book.toString()));
    }

    @Test
    public void shouldReturnTrueWhenCheckOutWasPossible() {
        boolean bookWasCheckedOut = lib.checkOutBook(bookTitle);

        assertTrue(bookWasCheckedOut);
    }

    @Test
    public void shouldReturnFalseWhenCheckOutWasNotPossible() {
        boolean bookWasCheckedOut = lib.checkOutBook(unavailableBookTitle);

        assertFalse(bookWasCheckedOut);
    }

    @Test
    public void shouldAddReturnedBookToLibraryBookList() {
        lib.checkOutBook(bookTitle);
        lib.returnBook(bookTitle);
        ArrayList<String> bookStringList = lib.listBooks();
        assertTrue(bookStringList.contains(book.toString()));
    }
    @Test
    public void shouldReturnTrueWhenReturnWasPossible() {
        lib.checkOutBook(bookTitle);

        assertTrue(lib.returnBook(bookTitle));
    }

    @Test
    public void shouldReturnFalseWhenReturnWasNotPossible() {
        assertFalse(lib.returnBook(unavailableBookTitle));
    }
}
