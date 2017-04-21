package org.launchcode.models;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * Created by LaunchCode
 */
public class BookField {

    private Float value;
    private int id;
    private static int nextId = 1;

    public BookField() {
        id = nextId;
        nextId++;
    }

    public BookField(Float aValue) {
        this();
        value = aValue;
    }

    public boolean contains(String value) {
        return this.value.equals(value);
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float aValue) {
        value = aValue;
    }

//    TODO figure out where this is used and what to do about it
//    public String toString() {
//        return value;
//    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookField bookField = (BookField) o;

        return id == bookField.getId();
    }

    @Override
    public int hashCode() {
        return id;
    }

}
