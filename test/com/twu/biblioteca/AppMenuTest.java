package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class AppMenuTest {

    private final PrintStream mockOut = mock(PrintStream.class);
    private Library mockLib = mock(Library.class);
    private InputScannerWrapper mockIn = mock(InputScannerWrapper.class);
    private AppMenu menu;

    @Before
    public void setUp() {
        menu = new AppMenu(mockIn, mockOut, mockLib);
    }

    @Test
    public void shouldPrintWelcome() {
        String expectedWelcome = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        menu.welcome();

        verify(mockOut).println(expectedWelcome);
    }

    @Test
    public void shouldPrintABookTitleWhenIStartTheApp() throws IOException {
        ArrayList<String> expectedBooks = new ArrayList<>();
        expectedBooks.add("Catcher in the Rye, J.D. Salinger, 1975");
        String expectedBookString = "Catcher in the Rye, J.D. Salinger, 1975";

        when(mockLib.listBooks()).thenReturn(expectedBooks);

        menu.listBooks();

        verify(mockOut, times(1)).println(expectedBookString);
    }

    @Test
    public void shouldPrintTwoDifferentBookTitlesWhenIStartTheApp() throws IOException {
        ArrayList<String> expectedBooks = new ArrayList<>();
        String expectedBookString1 = "Who Fears Death, Nnedi Okorafor, 2010";
        String expectedBookString2 = "1984, George Orwell, 1966";
        expectedBooks.add(expectedBookString1);
        expectedBooks.add(expectedBookString2);

        when(mockLib.listBooks()).thenReturn(expectedBooks);

        menu.listBooks();

        verify(mockOut, times(1)).println(expectedBookString1);
        verify(mockOut, times(1)).println(expectedBookString2);
    }

    @Test
    public void shouldShowAuthorTitleAndYearOfBookWhenIStartTheApp() {
        ArrayList<String> expectedBooks = new ArrayList<>();
        String expectedBookString1 = "Who Fears Death, Nnedi Okorafor, 2010";
        String expectedBookString2 = "1984, George Orwell, 1966";
        expectedBooks.add(expectedBookString1);
        expectedBooks.add(expectedBookString2);

        when(mockLib.listBooks()).thenReturn(expectedBooks);

        menu.listBooks();

        verify(mockOut).println(expectedBookString1);
        verify(mockOut).println(expectedBookString2);
    }

    @Test
    public void shouldDisplayMenuWhenIStartTheApp() {
        String expectedMenu = "1 - List of Books";

        menu.displayMenu();

        verify(mockOut).println(expectedMenu);

    }

    @Test
    public void shouldCallListBooksWhenISelectListOfBooks() {
        when(mockIn.readUserInput()).thenReturn("1");

        menu.doWhileRunning();

        verify(mockLib, times(1)).listBooks();
    }

    @Test
    public void shouldNotifyWhenAnInvalidOptionIsEntered() {
        when(mockIn.readUserInput()).thenReturn("o");

        menu.doWhileRunning();

        String expectedMsg = "Please select a valid option!";
        verify(mockOut).println(expectedMsg);
    }

    @Test
    public void shouldTellMenuToStopRunningWhenQIsEntered() {
        when(mockIn.readUserInput()).thenReturn("q");

        menu.doWhileRunning();

        verify(mockOut).println("Goodbye!");
    }
}
