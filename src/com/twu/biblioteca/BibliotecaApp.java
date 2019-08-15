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
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        BibliotecaApp app = new BibliotecaApp(out);
        app.start();
    }

    public void start() {
        out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }


    public void listBooks(ArrayList<String> books) {
        for (String book : books) {
            out.println(book);
        }
        //out.println("Catcher in the Rye");
    }
}
