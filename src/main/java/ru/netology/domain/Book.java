package ru.netology.domain;

public class Book extends Product {

    private String author;

    public Book(int id, String name, int cost, String author) {
        super(id, name, cost);
        this.author = author;
    }

    public Book(String author) {
        this.author = author;
    }

    public Book() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean matches(Product product, String search) {
        return author.contains(search);
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (author.contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}


