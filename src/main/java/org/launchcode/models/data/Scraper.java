package org.launchcode.models.data;

/**
 * Created by johnmilito on 4/24/17.
 */
public class Scraper {
    try{
        UserAgent userAgent = new UserAgent();                       //create new userAgent (headless browser).
        userAgent.visit("http://oracle.com");                        //visit a url
        System.out.println(userAgent.doc.innerHTML());               //print the document as HTML
    }
catch(JauntException e){         //if an HTTP/connection error occurs, handle JauntException.
        System.err.println(e);
    }
}
