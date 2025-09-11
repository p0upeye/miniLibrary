package miniLibrary;

import java.util.ArrayList;
import java.util.List;

public class User {
    protected String name;
    protected List<Book> borrowedBooks;

    public User(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {  // Метод для запозичення книги
        borrowedBooks.add(book);
    }
    public void returnBook(Book book) {  // Метод для повернення книги
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return String.format("Користувач %s [позичено %d книг]", getName(), getBorrowedBooks().size());
    }
}
