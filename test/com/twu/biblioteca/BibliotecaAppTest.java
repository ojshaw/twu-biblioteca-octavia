package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.setOut;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
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
        ArrayList<String> titles = new ArrayList<>();
        String expectedBook1 = "Catcher in the Rye, J.D. Salinger, 1975";
        titles.add(expectedBook1);

        ArrayList<Book> bookList = new ArrayList<>();
        Book book1 = new Book("Catcher in the Rye", "J.D. Salinger", 1975);
        bookList.add(book1);

        app.listBooks(titles, bookList);

        List<String> outputBookList = asList(outputStream.toString().split("\n"));

        assertThat(outputBookList, is(titles));
    }

    @Test
    public void shouldPrintTwoDifferentBookTitlesWhenIStartTheApp() throws IOException {
        ArrayList<String> titles = new ArrayList<>();
        String expectedBook1 = "Who Fears Death, Nnedi Okorafor, 2010";
        String expectedBook2 = "1984, George Orwell, 1966";
        titles.add(expectedBook1);
        titles.add(expectedBook2);

        ArrayList<Book> bookList = new ArrayList<>();
        Book book1 = new Book("Who Fears Death", "Nnedi Okorafor", 2010);
        Book book2 = new Book("1984", "George Orwell", 1966);
        bookList.add(book1);
        bookList.add(book2);

        app.listBooks(titles, bookList);
        List<String> outputBookList = asList(outputStream.toString().split("\n"));

        assertThat(outputBookList, is(titles));
    }

   @Test
   public void shouldShowAuthorTitleAndYearOfBookWhenIStartTheApp() {
        ArrayList<String> expectedBookList = new ArrayList<>();
        String expectedBook1 = "Who Fears Death, Nnedi Okorafor, 2010";
        String expectedBook2 = "1984, George Orwell, 1966";
        expectedBookList.add(expectedBook1);
        expectedBookList.add(expectedBook2);

        // set up book list
        ArrayList<Book> bookList = new ArrayList<>();
        Book book1 = new Book("Who Fears Death", "Nnedi Okorafor", 2010);
        Book book2 = new Book("1984", "George Orwell", 1966);
        bookList.add(book1);
        bookList.add(book2);


        app.listBooks(expectedBookList,bookList);

        List<String> outputBookList = asList(outputStream.toString().split("\n"));

        assertThat(outputBookList, is(expectedBookList));
   }

}
