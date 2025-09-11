package miniLibrary;

public class Main {
    public static void main(String[] args) {
        // СТВОРЮЮ БІБЛІОТЕКУ
        Library library = new Library();

        // СТВОРЮЮ КНИГИ
        Book chemistry = new Book("Chemistry, 11th grade", "Alexey Grigorievich", 2022);
        Book Snap = new Book("Snap", "Ernest Thompson Seton", 1903, "available");
        Book book1984 = new Book("1984", "George Orwell", 1949, "borrowed");

        // ДОДАЮ КНИГИ ДО БІБЛІОТЕКИ
        library.addBook(chemistry);
        library.addBook(Snap);
        library.addBook(book1984);
        System.out.println();

        // СТВОРЮЮ КОРИСТУВАЧІВ ТА БІБЛІОТЕКАРЯ
        User user1 = new User("Walter White");
        User user2 = new User("Jesse Pinkman");
        Librarian librarian = new Librarian("Gustavo Fring");

        // ДОДАЮ КОРИСТУВАЧІВ ТА БІБЛІОТЕКАРЯ ДО БІБЛІОТЕКИ
        library.addUser(user1);
        library.addUser(user2);
        library.addUser(librarian);
        System.out.println();

        /// ТЕСТИ
        // Користувач позичає книгу (true)
        librarian.registerAction(chemistry, user1, "borrow");

        // Спроба позичити ту ж книгу (false)
        librarian.registerAction(chemistry, user2, "borrow");
//        librarian.registerAction(book1984, user1, "borrow");

        // Перевантажений метод - позичити книгу за назвою (true)
        librarian.registerAction("Snap", user2, "borrow", library);

        // Спроба позичити невідому книгу за назвою (false)
        librarian.registerAction("Bookvarik", user2, "borrow", library);

        // Повернення книг (true)
        librarian.registerAction(chemistry, user1, "return");
        librarian.registerAction("Snap", user2, "return", library);

        // Тепер user2 може позичити цю книгу (true)
        librarian.registerAction("Chemistry, 11th grade", user2, "borrow", library);

        // Користувач переплутав бібліотеку з офісом Сола Гудмана (false)
        librarian.registerAction(book1984, user1, "call Saul Goodman");
        System.out.println();

        // Відображення інформації
        library.displayAllBooks();
        System.out.println();

        library.displayAllUsers();
        System.out.println();

        library.displayAllUserActions(librarian);
    }
}
