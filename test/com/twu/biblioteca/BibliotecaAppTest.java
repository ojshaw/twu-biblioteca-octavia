package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

import static java.lang.System.setOut;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    private final PrintStream mockOut = mock(PrintStream.class);
    private Library mockLib = mock(Library.class);
    private InputScannerWrapper mockIn = mock(InputScannerWrapper.class);
    private AppMenu mockMenu = mock(AppMenu.class);
    private BibliotecaApp app;

    @Before
    public void setUp() {
        app = new BibliotecaApp(mockOut, mockIn, mockLib, mockMenu);
    }

    @After
    public void cleanUp() {
    }

    @Test
    public void shouldPrintWelcomeWhenIStartTheApp() throws IOException {
        app.start();

        verify(mockOut).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    public void shouldRunUntilQuitIsEntered() {
        when(mockMenu.shouldRun()).thenReturn(true, true, false);

        app.start();

        verify(mockMenu, times(2)).doWhileRunning();
    }
}
