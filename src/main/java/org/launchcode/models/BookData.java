package org.launchcode.models;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by johnmilito on 4/20/17.
 */
public class BookData {

    /**
     * Borrowed some of this from LaunchCode's techjobs-mvc and adapted it for this project.
     */

    private static final String DATA_FILE = "book_data.csv";
    private static boolean isDataLoaded = false;

    private static ArrayList<HashMap<String, Float>> allBooks;

    /**
     * Fetch list of all values from loaded data,
     * without duplicates, for a given column.
     *
     * @param field The column to retrieve values from
     * @return List of all of the values of the given field
     */
    public static ArrayList<Float> findAll(String field) {

        // load data, if not already loaded
        loadData();

        ArrayList<Float> values = new ArrayList<>();

        for (HashMap<String, Float> row : allBooks) {
            Float aValue = row.get(field);

            if (!values.contains(aValue)) {
                values.add(aValue);
            }
        }

        // TODO: here maybe sort by book price highest to lowest
        Collections.sort(values);

        return values;
    }

    public static ArrayList<HashMap<String, Float>> findAll() {

        // load data, if not already loaded
        loadData();

        // Bonus mission; normal version returns allBooks
        return new ArrayList<>(allBooks);
    }

    /**
     * Returns results of search the jobs data by key/value, using
     * inclusion of the search term.
     *
     * For example, searching for employer "Enterprise" will include results
     * with "Enterprise Holdings, Inc".
     *
     * @param column   Column that should be searched.
     * @param value Value of teh field to search for
     * @return List of all jobs matching the criteria
     */
    public static ArrayList<HashMap<String, Float>> findByColumnAndValue(String column, Float value) {

        // load data, if not already loaded
        loadData();

        ArrayList<HashMap<String, Float>> jobs = new ArrayList<>();

        for (HashMap<String, Float> row : allBooks) {

            Float aValue = row.get(column);


            //not a hundred percent sure that this will work correctly because floating points are not exact
            if (aValue != null && aValue.equals(value)) {
                jobs.add(row);
            }
        }

        return jobs;
    }

    /**
     * Search all columns for the given term
     *
     * @param value The search term to look for
     * @return      List of all jobs with at least one field containing the value
     */
    public static ArrayList<HashMap<String, String>> findByValue(String value) {

        // load data, if not already loaded
        loadData();

        ArrayList<HashMap<String, String>> jobs = new ArrayList<>();

        for (HashMap<String, String> row : allBooks) {

            for (String key : row.keySet()) {
                String aValue = row.get(key);

                if (aValue.toLowerCase().contains(value.toLowerCase())) {
                    jobs.add(row);

                    // Finding one field in a job that matches is sufficient
                    break;
                }
            }
        }

        return jobs;
    }

    /**
     * Read in data from a CSV file and store it in a list
     */
    private static void loadData() {

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

            allBooks = new ArrayList<>();

            // Put the records into a more friendly format
            for (CSVRecord record : records) {
                HashMap<String, String> newJob = new HashMap<>();

                for (String headerLabel : headers) {
                    newJob.put(headerLabel, record.get(headerLabel));
                }

                allBooks.add(newJob);
            }

            // flag the data as loaded, so we don't do it twice
            isDataLoaded = true;

        } catch (IOException e) {
            System.out.println("Failed to load job data");
            e.printStackTrace();
        }
    }
}
