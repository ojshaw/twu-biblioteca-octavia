package com.twu.biblioteca;


import java.io.InputStream;
import java.util.Scanner;

public class InputScannerWrapper {

    Scanner scanner;

    public InputScannerWrapper(InputStream source) {

        this.scanner = new Scanner(source);
    }

    public String readUserInput() {

        String userInput = this.scanner.nextLine();
        return userInput;

    }
}
