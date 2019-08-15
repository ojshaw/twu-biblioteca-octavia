package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {
    public PrintStream out;

    public BibliotecaApp(PrintStream out) {
        this.out = out;
    }

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }


    public void start() {
        out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
