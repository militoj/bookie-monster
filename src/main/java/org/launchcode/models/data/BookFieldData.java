package org.launchcode.models.data;

import org.launchcode.models.BookField;

import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
public class BookFieldData<T extends BookField> {

    private ArrayList<T> allFields = new ArrayList<>();

    public ArrayList<T> findAll() {
        return allFields;
    }

    public T findById(int id) {
        for (T item : allFields) {
            if (item.getId() == id)
                return item;
        }

        return null;
    }

    public void add(T item) {
        allFields.add(item);
    }

    T findByValue(String value) {
        for (T item : allFields) {
            if (item.contains(value))
                return item;
        }

        return null;
    }

    T findByValue(int value) {
        for (T item : allFields) {
            if (item.contains(value))
                return item;
        }

        return null;
    }

    T findByValue(Float value) {
        for (T item : allFields) {
            if (item.contains(value))
                return item;
        }

        return null;
    }

    T findByValue(Float value) {
        for (T item : allFields) {
            if (item.contains(value))
                return item;
        }

        return null;
    }

}
