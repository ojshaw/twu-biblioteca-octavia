package com.twu.biblioteca;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {
    private PrintStream out;
    private InputScannerWrapper in;
    private Library lib;

    public BibliotecaApp(PrintStream out, InputScannerWrapper in, Library lib) {
        this.out = out;
        this.in = in;
        this.lib = lib;
    }

    public static void main(String[] args) {
        PrintStream output = new PrintStream(System.out);
        InputScannerWrapper input = new InputScannerWrapper(System.in);
        Library lib = new Library();
        BibliotecaApp app = new BibliotecaApp(output, input, lib);
        app.start();
    }

    public void start() {
        welcome();
        displayMenu();
        try {
            String userInput = in.readUserInput();
            if (userInput.equals("1")) {
                listBooks();
            }
        } catch (Exception e) {

        }
    }

    public void welcome() {
        out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }


    public void listBooks(Library lib) {
        for (String book : lib.listBooks()) {
            out.println(book);
        }
    }

    public void listBooks() {
        for (String book : this.lib.listBooks()) {
            out.println((book));
        }
    }

    public void displayMenu() {
        out.println("1 - List of Books");
    }

}
