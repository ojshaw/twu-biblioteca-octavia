package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public Library() {
        ArrayList<Book> testBookList = new ArrayList<>();
        Book testBook1 = new Book("Who Fears Death", "Nnedi Okorafor", 2010);
        Book testBook2 = new Book("1984", "George Orwell", 1966);
        testBookList.add(testBook1);
        testBookList.add(testBook2);

        this.books = testBookList;

    }

    public ArrayList<String> listBooks() {
        ArrayList<String> booksString = new ArrayList<>();
        for (Book book : this.books) {
            booksString.add(book.toString());
        }

        return booksString;
    }

    public boolean checkOutBook(String bookTitle) {
        for (Book book : this.books) {
           if (book.match(bookTitle)) {
               books.remove(book);
               return true;
           }
        }

        return false;
    }
}
