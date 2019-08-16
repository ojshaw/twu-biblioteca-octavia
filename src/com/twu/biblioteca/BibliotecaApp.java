package com.twu.biblioteca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    public PrintStream out;

    public BibliotecaApp(PrintStream out) {
        this.out = out;
    }

    public static void main(String[] args) {
        PrintStream out = new PrintStream(System.out);
        BibliotecaApp app = new BibliotecaApp(out);
        app.start();
    }

    public void start() {
        ArrayList<String> books = new ArrayList<>();
        welcome();
        displayMenu();
//        books.add("I am a book");
//        listBooks(books);
    }

    public void welcome() {
        out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }


    public void listBooks(ArrayList<Book> books) {
        for (Book book : books) {
            out.println(book.toString());
        }
    }

    public void displayMenu() {
        out.println("List of Books");
    }
}
