package com.twu.biblioteca;

import java.io.PrintStream;

import static java.lang.System.exit;

public class AppMenu {
    private InputScannerWrapper in;
    private PrintStream out;
    private Library lib;
    private boolean isRunning;

    public AppMenu(InputScannerWrapper in, PrintStream out, Library lib) {
        this.in = in;
        this.out = out;
        this.lib = lib;
        isRunning = true;
    }

    public void doWhileRunning() {
        displayMenu();
        String userInput = in.readUserInput().trim();
        switch (userInput) {
            case "1":
                listBooks();
                break;
            case "q":
                out.println("Goodbye!");
                isRunning = false;
                break;
            default:
                out.println("Please select a valid option!");
                break;
        }

    }

    public void displayMenu() {
        out.println("1 - List of Books");
    }

    public void listBooks() {
        for (String book : this.lib.listBooks()) {
            out.println((book));
        }
    }

    public boolean shouldRun() {
        return isRunning;
    }
}
