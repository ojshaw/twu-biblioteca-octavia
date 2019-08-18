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

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
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

//    @Test
//    public void shouldPrintABookTitleWhenIStartTheApp() throws IOException {
//        ArrayList<String> expectedBooks = new ArrayList<>();
//        expectedBooks.add("Catcher in the Rye, J.D. Salinger, 1975");
//        String expectedBookString = "Catcher in the Rye, J.D. Salinger, 1975";
//
//        when(mockLib.listBooks()).thenReturn(expectedBooks);
//
////        app.listBooks();
//
//        verify(mockOut, times(1)).println(expectedBookString);
//    }
//
//    @Test
//    public void shouldPrintTwoDifferentBookTitlesWhenIStartTheApp() throws IOException {
//        ArrayList<String> expectedBooks = new ArrayList<>();
//        String expectedBookString1 = "Who Fears Death, Nnedi Okorafor, 2010";
//        String expectedBookString2 = "1984, George Orwell, 1966";
//        expectedBooks.add(expectedBookString1);
//        expectedBooks.add(expectedBookString2);
//
//        when(mockLib.listBooks()).thenReturn(expectedBooks);
//
//
////        app.listBooks();
//
//        verify(mockOut, times(1)).println(expectedBookString1);
//        verify(mockOut, times(1)).println(expectedBookString2);
//    }
//
//   @Test
//   public void shouldShowAuthorTitleAndYearOfBookWhenIStartTheApp() {
//       ArrayList<String> expectedBooks = new ArrayList<>();
//       String expectedBookString1 = "Who Fears Death, Nnedi Okorafor, 2010";
//       String expectedBookString2 = "1984, George Orwell, 1966";
//       expectedBooks.add(expectedBookString1);
//       expectedBooks.add(expectedBookString2);
//
//       when(mockLib.listBooks()).thenReturn(expectedBooks);
//
//
////       app.listBooks();
//
//       verify(mockOut).println(expectedBookString1);
//       verify(mockOut).println(expectedBookString2);
//   }

//    @Test
//    public void shouldDisplayMenuWhenIStartTheApp() {
//        String expectedMenu = "1 - List of Books";
//
//        app.start();
//
//        verify(mockOut).println(expectedMenu);
//
//    }

//    @Test
//    public void shouldCallListBooksWhenISelectListOfBooks() {
//        when(mockIn.readUserInput()).thenReturn("1");
//
//        app.start();
//
//        verify(mockLib, times(1)).listBooks();
//    }
//
//    @Test
//    public void shouldNotifyWhenAnInvalidOptionIsEntered() {
//        //encapsulate the select option function to test outside the while loop
//        when(mockIn.readUserInput()).thenReturn("o");
//
//        app.start();
//
//        String expectedMsg = "Please select a valid option!";
//        verify(mockOut).println(expectedMsg);
//    }

}
