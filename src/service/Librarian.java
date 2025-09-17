package service;

import model.Book;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class Librarian extends User {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private final List<String> actions;

    public Librarian(String name) {
        super(name);
        this.actions = new ArrayList<>();
    }

    public List<String> getActions() {
        return actions;
    }

    // За об'єктом Book
    public void registerAction(Book book, User user, String action) {
        if(action.equals("borrow")) {

            if(book.getStatus().equals("available")) {
                book.setStatus("borrowed");
                user.borrowBook(book);
                String actionRecord = String.format("[-] %s позичив книгу '%s'", user.getName(), book.getTitle());
                getActions().add(actionRecord);
                System.out.println(actionRecord);
            }
            else {
                System.out.printf("%s[!] Нам шкода %s, але книга '%s' вже кимось позичена!%s\n",
                        ANSI_RED, user.getName(), book.getTitle(), ANSI_RESET);
            }
        }
        else if(action.equals("return")) {

            if(book.getStatus().equals("borrowed")) {
                book.setStatus("available");
                user.returnBook(book);
                String actionRecord = String.format("[+] %s повернув книгу '%s'", user.getName(), book.getTitle());
                getActions().add(actionRecord);
                System.out.println(actionRecord);
            }
            else {
                System.out.printf("%s[!] %s, ви помилилися, адже книга '%s' досі у нас!%s\n",
                        ANSI_RED, user.getName(), book.getTitle(), ANSI_RESET);
            }
        }
        else {
            System.out.printf("%s[!] %s, ми не змогли допомогти Вам. :(%s\n",
                    ANSI_RED, user.getName(), ANSI_RESET);
        }
    }

    // За назвою книги
    public void registerAction(String bookTitle, User user, String action, Library library) {
        Book book = library.findBookByTitle(bookTitle);

        if(book != null) {
            registerAction(book, user, action);
        }
        else {
            System.out.printf("%s[!] Пробачте %s, книги '%s' не має у наявності!%s\n",
                    ANSI_RED, user.getName(), bookTitle, ANSI_RESET);
        }
    }

    @Override
    public String toString() {
        return String.format("Бібліотекар %s [зареєстровано %d дій]", getName(), getActions().size());
    }
}
