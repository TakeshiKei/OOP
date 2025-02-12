

import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        System.out.println("Book added to library: " + book.title);
        books.add(book);
    }

    public void borrowBook(Borrower borrower, Book book) {
        System.out.println(borrower.name + " borrowed: " + book.title);
        borrower.borrowedBooks.add(book);
        books.remove(book);
    }

    public void returnBook(Borrower borrower, Book book) {
        System.out.println(borrower.name + " returned " + book.title);
        books.add(book);
        borrower.borrowedBooks.remove(book);
    }

    public void displayLibraryBooks() {
        System.out.println("Books in Library:");
        for (Book book : books) {
        System.out.println("Title: " + book.title);
        System.out.println("ISBN: " + book.isbn);
        System.out.println("Author: " + book.author.name);
        System.out.println("Bio: " + book.author.bio);
        System.out.println("------------------------");
        }
    }
}
