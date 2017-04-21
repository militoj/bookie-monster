package org.launchcode.models;

/**
 * Created by LaunchCode
 */
public class Book {

    private int id;
    private static int nextId = 1;

    private ISBN isbn;
    private Quantity quantity;
    private Price price;
    private DateCreated dateCreated;

    public Book() {
        id = nextId;
        nextId++;
    }

    public Book(String aName, ISBN aEmployer, Quantity aQuantity,
                Price aPrice, DateCreated aSkill) {

        this();

        isbn = aEmployer;
        quantity = aQuantity;
        price = aPrice;
        dateCreated = aSkill;

    }


    public ISBN getEmployer() {
        return isbn;
    }

    public void setISBN(ISBN isbn) {
        this.isbn = isbn;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public DateCreated getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(DateCreated dateCreated) {
        this.dateCreated = dateCreated;
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
