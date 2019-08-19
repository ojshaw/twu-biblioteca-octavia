package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

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
