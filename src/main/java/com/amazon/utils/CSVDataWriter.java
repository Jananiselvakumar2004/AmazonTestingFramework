package com.amazon.utils;

import com.opencsv.CSVWriter;

import java.io.FileWriter;

public class CSVDataWriter {

    public static void writeProduct(String name, String price, String rating) {

        try {

            CSVWriter writer = new CSVWriter(new FileWriter("testdata/output.csv", true));

            String[] data = {name, price, rating};

            writer.writeNext(data);

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}