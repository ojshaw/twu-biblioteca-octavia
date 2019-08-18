package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {
    private AppMenu menu;

    public BibliotecaApp(AppMenu menu) {
        this.menu = menu;
    }

    public static void main(String[] args) {
        PrintStream output = new PrintStream(System.out);
        InputScannerWrapper input = new InputScannerWrapper(System.in);
        Library lib = new Library();
        AppMenu menu = new AppMenu(input, output, lib);
        BibliotecaApp app = new BibliotecaApp(menu);
        app.start();
    }

    public void start() {
        menu.welcome();
        while (shouldRun()) {
            menu.doWhileRunning();
        }
    }

    public boolean shouldRun() {
        return menu.shouldRun();
    }



}
