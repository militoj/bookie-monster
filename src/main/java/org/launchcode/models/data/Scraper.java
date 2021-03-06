package org.launchcode.models.data;

import com.jaunt;
import com.jaunt.component.*;
import org.launchcode.models.Book;

import java.io.*;
import java.util.*;


/**
 * Created by johnmilito on 4/24/17.
 */
// Learned how to use Jaunt at http://jaunt-api.com/jaunt-tutorial.htm
public class Scraper {

    public static void main(String[]args) {
        try {
            UserAgent userAgent = new UserAgent();                       //create new userAgent (headless browser).
            userAgent.visit("http://www.cash4books.net/recent500.php");                    //visit a url

            Table table = userAgent.doc.getTable(0);


            ArrayList<Book> scrapedBooks = new ArrayList<Book>();


            int count = 1;
            while (count < 501 ) {
                List<Element> columns = table.getRow(count).toList();

                String isbn = columns.get(0).innerHTML();
                Long isbnInt = Long.parseLong(isbn);

                String price = columns.get(3).innerHTML();
                String[] priceNoDollSign = price.split("\\$");
                double priceDouble = Double.parseDouble(priceNoDollSign[1]);

                String buyer_name = "Cash4Books";
                Book newBook = new Book(buyer_name, isbnInt, priceDouble);
                scrapedBooks.add(newBook);

                count++;
            }

            String fileName = "book_data.csv";

            CsvFileReader.readCsvFile(fileName);


        } catch (JauntException e) {                                     //if an HTTP/connection error occurs, handle JauntException.
            System.err.println(e);
        }
    }


}
