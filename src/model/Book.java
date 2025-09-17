package model;

public class Book {
    private final String title;
    private final String author;
    private final int year;
    private String status;  // "available" or "borrowed"

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.status = "available";
    }

    public Book(String title, String author, int year, String status) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getYear() {
        return year;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("'%s' by %s (%d) [%s]", getTitle(), getAuthor(), getYear(), getStatus());
    }
}
