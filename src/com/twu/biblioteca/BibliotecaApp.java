package com.twu.biblioteca;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.io.PrintStream;
import java.util.ArrayList;

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
//        displayMenu();
        while (shouldRun()) {
            menu.doWhileRunning();
//            try {
//                String userInput = in.readUserInput();
//                switch (userInput) {
//                    case "1":
//                        listBooks();
//                        break;
//                    case "q":
//                        quit();
//                        break;
//                    default:
//                        out.println("Please select a valid option!");
//                }
//
////            if (userInput.equals("1")) {
////                listBooks();
////            } else {
////                out.println("Please select a valid option!");
////            }
//            } catch (Exception e) {
//
//            }
        }
    }

    public boolean shouldRun() {
        return menu.shouldRun();
    }

    public void welcome() {
        out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

}
