package com.amazon.utils;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVDataReader {

    public static List<String> readProducts() {

        List<String> products = new ArrayList<>();

        try {

            CSVReader reader = new CSVReader(new FileReader("testdata/input.csv"));

            String[] line;

            reader.readNext(); // Skip header

            while ((line = reader.readNext()) != null) {

                products.add(line[0]);

            }

            reader.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return products;

    }
}