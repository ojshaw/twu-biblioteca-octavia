package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {
    private PrintStream out;
    private InputScannerWrapper in;
    private AppMenu menu;
    private Library lib;

    public BibliotecaApp(PrintStream out, InputScannerWrapper in, Library lib, AppMenu menu) {
        this.out = out;
        this.in = in;
        this.lib = lib;
        this.menu = menu;
    }

    public static void main(String[] args) {
        PrintStream output = new PrintStream(System.out);
        InputScannerWrapper input = new InputScannerWrapper(System.in);
        Library lib = new Library();
        AppMenu menu = new AppMenu(input, output, lib);
        BibliotecaApp app = new BibliotecaApp(output, input, lib, menu);
        app.start();
    }

    public void start() {
        welcome();
        while (shouldRun()) {
            menu.doWhileRunning();
        }
    }

    public boolean shouldRun() {
        return menu.shouldRun();
    }

    public void welcome() {
        out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

}
