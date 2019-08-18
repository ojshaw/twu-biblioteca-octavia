package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class LibraryTest {

    private ArrayList<Book> books = mock(ArrayList.class);
    private Book book = mock(Book.class);
    private Library lib;

    @Before
    public void setUp() {
        lib = new Library(books);
    }

    @Test
    public void shouldRemoveBookFromListWhenCheckedOut() {
        when(books.contains(book)).thenReturn(true);

        lib.checkOutBook(book);

        verify(books).remove(book);
    }
}
