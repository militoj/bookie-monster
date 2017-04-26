package org.launchcode.models.data;

import com.jaunt.*;
import com.jaunt.component.*;
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
//            Table table = userAgent.doc.findFirst("<table>");

            Table table = userAgent.doc.getTable(0);


            //TODO figure out how tables and elements interact
            //System.out.println(table.getRow(5).outerHTML());

            List<Element> columns = table.getRow(5).toList();


            for (Element column : columns) {
                System.out.println(column.innerHTML());

            }


//            System.out.println(table.getRow(1).toList().toString() + "\n----\n");
//            System.out.println(table.getRow(2).toList().toString() + "\n----\n");
//            System.out.println(table.getRow(3).toList().toString() + "\n----\n");
//            System.out.println(table.getRow(4).toList().toString() + "\n----\n");
//





        } catch (JauntException e) {                                     //if an HTTP/connection error occurs, handle JauntException.
            System.err.println(e);
        }
    }
}
