package org.launchcode.models;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * Created by LaunchCode
 */
public class BookField {

    private int value;
    private String stringValue;
    private int id;
    private static int nextId = 1;

    public BookField() {
        id = nextId;
        nextId++;
    }

    public BookField(int aValue) {
        this();
        value = aValue;
    }

    public boolean contains(int value) {
        return this.value == value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int aValue) {
        value = aValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String aValue) {
        stringValue = aValue;
    }


    public String toString() {
        return Integer.toString(value);
    }

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
