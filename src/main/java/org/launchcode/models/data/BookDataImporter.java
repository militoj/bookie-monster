package org.launchcode.models.data;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.launchcode.models.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

/**
 * Created by LaunchCode
 */
public class BookDataImporter {

    private static final String DATA_FILE = "book_data.csv";
    private static boolean isDataLoaded = false;

    /**
     * Read in data from a CSV file and store it in a list
     */
    static void loadData(BookData bookData) {

        // Only load data once
        if (isDataLoaded) {
            return;
        }

        try {

            // Open the CSV file and set up pull out column header info and records
            Resource resource = new ClassPathResource(DATA_FILE);
            InputStream is = resource.getInputStream();
            Reader reader = new InputStreamReader(is);
            CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            List<CSVRecord> records = parser.getRecords();
            Integer numberOfColumns = records.get(0).size();
            String[] headers = parser.getHeaderMap().keySet().toArray(new String[numberOfColumns]);

            // Put the records into a more friendly format
            for (CSVRecord record : records) {

                String empStr = record.get("isbn");
                int isbnInt = Integer.parseInt(empStr);

                String locStr = record.get("quantity");
                int quantityInt = Integer.parseInt(locStr);

                String coreCompStr = record.get("price");
                int priceInt = Integer.parseInt(coreCompStr);

                String posTypeStr = record.get("date-created");
                int priceInt = Integer.parseInt(coreCompStr);


                ISBN emp = bookData.getISBNs().findByValue(isbnInt);
                if (emp == null) {
                    emp = new ISBN(isbnInt);
                    bookData.getISBNs().add(emp);
                }

                Quantity loc = bookData.getLocations().findByValue(quantityInt);
                if (loc == null) {
                    loc = new Quantity(quantityInt);
                    bookData.getLocations().add(loc);
                }

                //TODO going to stop messing with the rest of these until I get the first one working
//                Price posType = bookData.getPositionTypes().findByValue(posTypeStr);
//                if (posType == null) {
//                    posType = new Price(posTypeStr);
//                    bookData.getPositionTypes().add(posType);
//                }
//
//                DateCreated coreComp = bookData.getCoreCompetencies().findByValue(coreCompStr);
//                if (coreComp == null) {
//                    coreComp = new DateCreated(coreCompStr);
//                    bookData.getCoreCompetencies().add(coreComp);
//                }

                //TODO this is what is should be. Leaving out some of the arguments to simplify and get it working.
//                Book newBook = new Book(record.get("name"), emp, loc, posType, coreComp);

                Book newBook = new Book(record.get("name"), emp, loc);

                bookData.add(newBook);
            }

            // flag the data as loaded, so we don't do it twice
            isDataLoaded = true;

        } catch (IOException e) {
            System.out.println("Failed to load book data");
            e.printStackTrace();
        }
    }

}
