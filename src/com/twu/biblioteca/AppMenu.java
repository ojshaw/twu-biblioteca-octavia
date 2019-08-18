package com.twu.biblioteca;

import java.io.PrintStream;

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
            case "2":
                checkOut();
            case "q":
                out.println("Goodbye!");
                isRunning = false;
                break;
            default:
                out.println("Please select a valid option!");
                break;
        }

    }

    private void checkOut() {
        String checkOutMsg = "What is the title of the book you would like to check out?";
        out.println(checkOutMsg);

        String title = in.readUserInput();


    }

    public void displayMenu() {
        out.println("1 - List of Books");
        out.println("2 - Check Out a Book");
        out.println("Press 'q' to quit");
    }

    public void listBooks() {
        for (String book : this.lib.listBooks()) {
            out.println((book));
        }
    }

    public boolean shouldRun() {
        return isRunning;
    }

    public void welcome() {
        out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
