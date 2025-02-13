import java.util.ArrayList;

public class Borrower {
    public String name;
    public ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Borrower(String name) {
        this.name = name;
    }

    public void displayBorrowedBooks() {
        System.out.println(name + "'s borrowed books: ");
        for (Book book : borrowedBooks) {
        System.out.println("Title: " + book.title);
        System.out.println("ISBN: " + book.isbn); 
        System.out.println("Author: " + book.author.name);
        System.out.println("Bio: " + book.author.bio);
        System.out.println("------------------------");
        }
    }
}
