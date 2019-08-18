package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookTest {
    private Book book;

    @Before
    public void setUp() {
        book = new Book("Catcher in the Rye", "J.D. Salinger", 1966);
    }

    @Test
    public void shouldReturnTrueWhenInputTitleMatchesBookTitle() {
        String inputTitle = "Catcher in the Rye";

        assertTrue(book.match(inputTitle));

    }

    @Test
    public void shouldReturnFalseWhenInputTitileDoesntMatchBookTitle() {
        String inputTitle = "Bookkeeper";

        assertFalse(book.match(inputTitle));
    }
}
