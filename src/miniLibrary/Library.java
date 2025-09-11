package miniLibrary;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private static int totalBooksAdded = 0;
    private static int totalUsersAdded = 0;
    private final List<Book> books;
    private final List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public static int getTotalBooksAdded() {
        return totalBooksAdded;
    }
    public static int getTotalUsersAdded() {
        return totalUsersAdded;
    }

    public void addBook(Book book) {
        books.add(book);
        totalBooksAdded++;
        System.out.printf("Книгу %s було додано до бібліотеки!\n", book);
    }

    public void addUser(User user) {
        users.add(user);
        totalUsersAdded++;
        System.out.printf("%s доданий/на до бібліотеки!\n", user);
    }

    public Book findBookByTitle(String title) {
        for(Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void displayAllBooks() {
        System.out.println("📚 СПИСОК КНИГ У БІБЛІОТЕЦІ");

        if(books.isEmpty()) {
            System.out.println("○ У бібліотеці немає книг!");
        }
        else {

            for(int i = 0; i < books.size(); i++) {
                System.out.printf("%d. %s\n", (i + 1), books.get(i).toString());
            }
        }
        System.out.println("Загальна кількість доданих книг: " + getTotalBooksAdded());
    }

    public void displayAllUsers() {
        System.out.println("👥 СПИСОК КОРИСТУВАЧІВ БІБЛІОТЕКИ");

        if(users.isEmpty()) {
            System.out.println("○ Бібліотека не користується популярністю серед користувачів!");
        }
        else {

            for(int i = 0; i < users.size(); i++) {
                System.out.printf("%d. %s\n", (i + 1), users.get(i).toString());
            }
        }
        System.out.println("Загальна кількість доданих користувачів: " + getTotalUsersAdded());
    }

    public void displayAllUserActions(Librarian librarian) {
        List<String> actions = librarian.getActions();
        System.out.printf("🫳 СПИСОК ДІЙ КОРИСТУВАЧІВ (Бібліотекар: %s)\n", librarian.getName());

        if(users.isEmpty()) {
            System.out.println("○ Жодних дій не зафіксовано!");
        }
        else {
            for(int i = 0; i < actions.size(); i++) {
                System.out.printf("%d. %s\n", (i + 1), actions.get(i));
            }
        }
    }
}
