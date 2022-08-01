package com.applitools.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private static List<ArrayList<String>> listOfContentPages;

    //    Renamed method to "get" instead of "set", and now accepts file path as input
    public static List<ArrayList<String>> getContentPages(String filePath) {
//        Declare primitive variable
        String line = "";

//        Create new ArrayList object
        listOfContentPages = new ArrayList<>();

//        try/catch block
        try {
//            Assign BufferedReader object (which accepts new FileReader object) to declared BufferedReader reference variable
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while ((line = br.readLine()) != null) {
//                Create new ArrayList object, reference variable will change with each iteration
                ArrayList<String> contentLine = new ArrayList<>();

                String[] values = line.split(",");

//                if conditional to account for empty lines within CSV file (e.g, ",,")
                if (values.length != 0) {
//                    System.out.println("values[0]" + values[0]);
//                    add base URL and page Title to contentLine ArrayList object
                    contentLine.add(values[0]);
                    contentLine.add(values[2]);
//                    add contentLine value to reference variable listOfContents
                    listOfContentPages.add(contentLine);
                }
            }
//            System.out.println("listOfContents: " + listOfContents); --> to check that there aren't anomalies in list that could case problems with seleniumCSV
            return (listOfContentPages);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
