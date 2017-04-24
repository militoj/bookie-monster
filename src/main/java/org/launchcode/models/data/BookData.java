package org.launchcode.models.data;

import org.launchcode.models.*;

import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
public class BookData {

    private ArrayList<Book> books = new ArrayList<>();
    private static BookData instance;

    private BookFieldData<ISBN> isbns = new BookFieldData<>();
    private BookFieldData<Quantity> locations = new BookFieldData<>();
    private BookFieldData<DateCreated> coreCompetencies = new BookFieldData<>();
    private BookFieldData<Price> positionTypes = new BookFieldData<>();


    BookData() {
        BookDataImporter.loadData(this);
    }


    public static BookData getInstance() {
        if (instance == null) {
            instance = new BookData();
        }
        return instance;
    }

    public Book findById(int id) {
        for (Book book : books) {
            if (book.getId() == id)
                return book;
        }

        return null;
    }

    public ArrayList<Book> findAll() {
        return books;
    }


//    public ArrayList<Book> findByColumnAndValue(BookFieldType column, int value) {
//
//        ArrayList<Book> matchingBooks = new ArrayList<>();
//
//        for (Book book : books) {
//            if (getFieldByType(book, column).contains(value))
//                matchingBooks.add(book);
//        }
//
//        return matchingBooks;
//    }


//    public ArrayList<Book> findByValue(Float value) {
//
//        ArrayList<Book> matchingBooks = new ArrayList<>();
//
//        for (Book book : books) {
//
//            // TODO Figure out what this does where and fix it. why is name important?
//            if (book.getName().toLowerCase().contains(value)) {
//                matchingBooks.add(book);
//                continue;
//            }
//
//            for (BookFieldType column : BookFieldType.values()) {
//                if (column != BookFieldType.ALL && getFieldByType(book, column).contains(value)) {
//                    matchingBooks.add(book);
//                    break;
//                }
//            }
//        }
//
//        return matchingBooks;
//    }


    public void add(Book book) {
        books.add(book);
    }

//    TODO do I need this?
//    private static BookField getFieldByType(Book book, BookFieldType type) {
//        switch(type) {
//            case ISBN:
//                return book.getEmployer();
//            case QUANTITY:
//                return book.getQuantity();
//            case PRICE:
//                return book.getDateCreated();
//            case DATE_CREATED:
//                return book.getPrice();
//        }
//
//        throw new IllegalArgumentException("Cannot get field of type " + type);
//    }

    public BookFieldData<ISBN> getISBNs() {
        return isbns;
    }

    public BookFieldData<Quantity> getLocations() {
        return locations;
    }

    public BookFieldData<DateCreated> getCoreCompetencies() {
        return coreCompetencies;
    }

    public BookFieldData<Price> getPositionTypes() {
        return positionTypes;
    }
}
