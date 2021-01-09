package com.mycompany.firsttask.library;


import java.util.Arrays;
import java.util.Objects;

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("The price should be >= 0");
        } else {
            this.price = price;
        }
        this.name = name;
        this.authors = authors;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this(name, authors, price);
        if (qty < 0) {
            throw new IllegalArgumentException("The qty should be >= 0");
        } else {
            this.qty = qty;
        }
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("The price should be >= 0");
        } else {
            this.price = price;
        }
    }

    public void setQty(int qty) {
        if (qty < 0) {
            throw new IllegalArgumentException("The qty should be >= 0");
        } else {
            this.qty = qty;
        }
    }

    public String getAuthorNames() {
        String authorNames = "";
        for (Author author : authors) {
            authorNames += author.getName() + ',';
        }
        authorNames = authorNames.substring(0, authorNames.length() - 1);
        return authorNames;
    }

    @Override
    public String toString() {
        String authorsInfromation = "";
        for (Author author : authors) {
            authorsInfromation += "Author[name=" + author.getName() +
                    ", email=" + author.getEmail() +
                    ", gender=" + author.getGender() + "], ";
        }
        authorsInfromation = authorsInfromation.substring(0, authorsInfromation.length() - 2);
        return "Book[" +
                "name=" + name +
                ", authors={" + authorsInfromation + '}' +
                ", price=" + price +
                ", qty=" + qty +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        boolean priceEquals = (Math.abs(price - book.price) < 0.000001);
        boolean qtyEquals = (qty == book.qty);
        boolean nameEquals = (name == null && book.name == null)
                || (name != null && name.equals(book.name));
        boolean authorsEquals = Arrays.equals(authors, book.authors);
        return priceEquals && qtyEquals && nameEquals && authorsEquals;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(price);
        result = 31 * result + qty;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + Arrays.hashCode(authors);
        return result;
    }
}
