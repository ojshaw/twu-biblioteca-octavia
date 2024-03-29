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
                break;
            case "3":
                returnBook();
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

    private void returnBook() {
        String returnMsg = "What is the title of the book you would like to return?";
        String successfulReturnMsg = "Thank you for returning the book.";
        String unsuccessfulReturnMsg = "That is not a valid book to return.";

        out.println(returnMsg);

        String title = in.readUserInput();

        if(lib.returnBook(title)) {
            out.println(successfulReturnMsg);
        } else {
            out.println(unsuccessfulReturnMsg);
        }

    }

    private void checkOut() {
        String checkOutMsg = "What is the title of the book you would like to check out?";
        String successfulCheckOutMsg = "Thank you! Enjoy the book!";
        String unSuccessfulCheckOutMsg = "Sorry, that book is not available.";
        out.println(checkOutMsg);

        String title = in.readUserInput();

        if (lib.checkOutBook(title)) {
            out.println(successfulCheckOutMsg);
        } else {
            out.println(unSuccessfulCheckOutMsg);
        }
    }

    public void displayMenu() {
        out.println("1 - List of books");
        out.println("2 - Check Out a book");
        out.println("3 - Return a book");
        out.println("Enter 'q' to quit");
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
