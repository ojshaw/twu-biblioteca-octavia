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
    private AppMenu mockMenu = mock(AppMenu.class);
    private BibliotecaApp app;

    @Before
    public void setUp() {
        app = new BibliotecaApp(mockMenu);
    }

    @After
    public void cleanUp() {
    }

    @Test
    public void shouldPrintWelcomeWhenIStartTheApp() throws IOException {
        app.start();

        verify(mockMenu, times(1)).welcome();
    }

    @Test
    public void shouldRunUntilQuitIsEntered() {
        when(mockMenu.shouldRun()).thenReturn(true, true, false);

        app.start();

        verify(mockMenu, times(2)).doWhileRunning();
    }
}
