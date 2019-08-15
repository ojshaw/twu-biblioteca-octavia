package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.setOut;
import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private BibliotecaApp app;

    @Before
    public void setUp() {
        final PrintStream out = new PrintStream(outputStream);
        app = new BibliotecaApp(out);
    }

    @After
    public void cleanUp() {
    }

    @Test
    public void shouldPrintWelcomeWhenIStartTheApp() throws IOException {
        app.start();

        String[] welcome = outputStream.toString().split("\n");

        assertThat(welcome[0], is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!" ));
    }

    @Test
    public void shouldPrintABookTitleWhenIStartTheApp() throws IOException {
        app.listBooks();
        List<String> titles = new LinkedList<>();
        String expected = "Catcher in the Rye";
        titles.add(expected);
        List<String> books = asList(outputStream.toString().split("\n"));

        assertThat(books, is(titles));
    }

}
