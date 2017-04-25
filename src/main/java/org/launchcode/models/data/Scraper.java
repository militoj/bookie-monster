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
            Element table = userAgent.doc.findFirst("<table>");

            //TODO figure out how tables and elements interact
            System.out.println(table.getRow(5).outerHTML());

//            System.out.println(table.outerHTML() + "\n----\n");




        } catch (JauntException e) {                                     //if an HTTP/connection error occurs, handle JauntException.
            System.err.println(e);
        }
    }
}
