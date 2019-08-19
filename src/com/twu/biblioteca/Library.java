package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> availableBooks;
    private ArrayList<Book> checkedOutBooks;

    public Library(ArrayList<Book> availableBooks, ArrayList<Book> checkedOutBooks) {
        this.availableBooks = availableBooks;
        this.checkedOutBooks = checkedOutBooks;
    }

    public Library() {
        ArrayList<Book> testAvailableBookList = new ArrayList<>();
        Book testBook1 = new Book("Who Fears Death", "Nnedi Okorafor", 2010);
        Book testBook2 = new Book("1984", "George Orwell", 1966);
        testAvailableBookList.add(testBook1);
        testAvailableBookList.add(testBook2);

        this.availableBooks = testAvailableBookList;

    }

    public ArrayList<String> listBooks() {
        return listAvailableBooks();
    }

    private ArrayList<String> listAvailableBooks() {
        ArrayList<String> booksString = new ArrayList<>();
        for (Book book : this.availableBooks) {
                booksString.add(book.toString());
        }

        return booksString;
    }

    public boolean checkOutBook(String bookTitle) {
        for (Book book : this.availableBooks) {
           if (book.match(bookTitle)) {
               this.checkedOutBooks.add(book);
               this.availableBooks.remove(book);
               return true;
           }
        }
        return false;
    }

    public boolean returnBook(String bookTitle) {
        return true;
    }
}
