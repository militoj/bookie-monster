package org.launchcode.models;
package com.journaldev.java8.time;


/**
 * Created by LaunchCode
 */
public class Book {

    private int id;
    private static int nextId = 1;

    private int isbn;
    private int quantity;
    private double price;
    private double amazon_price;


    public Book() {
        id = nextId;
        nextId++;
    }

    public Book(int aIsbn, int aQuantity, double aPrice) {

        this();

        isbn = aIsbn;
        quantity = aQuantity;
        price = aPrice;

    }

    public Book(int aIsbn, int aQuantity, double aPrice, double aAmazon_price) {

        this();

        isbn = aIsbn;
        quantity = aQuantity;
        price = aPrice;
        amazon_price = aAmazon_price;

    }


    public int getISBN() {
        return isbn;
    }

    public void setISBN(int isbn) {
        this.isbn = isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDateCreated() {
        return amazon_price;
    }

    public void setDateCreated(double dateCreated) {
        this.amazon_price = dateCreated;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id == book.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
