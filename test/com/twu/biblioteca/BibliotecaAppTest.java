package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.System.setOut;
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

        String[] output = outputStream.toString().split("\n");

        assertThat(output[0], is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!" ));
    }

    @Test
    public void shouldPrintABookTitleWhenIStartTheApp() throws IOException {
    }

}
