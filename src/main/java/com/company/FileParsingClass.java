package com.company;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.util.*;

class FileParsingClass {

    ArrayList<Matches> dataParsing(String file) {

        List<String[]> allData= csvFileReader(file);
        ArrayList<Matches> object= new ArrayList<>();

        for (String[] row : allData) {

            ArrayList<String> data = new ArrayList<>(Arrays.asList(row));
            Matches temp= new Matches(data);
            object.add(temp);
        }

        object.remove(0);
        return object;

    }


    ArrayList<Deliveries> dataParsing1(String file) {

        List<String[]> allData= csvFileReader(file);
        ArrayList<Deliveries> object= new ArrayList<>();

        for (String[] row : allData) {
            ArrayList<String> data = new ArrayList<>(Arrays.asList(row));
            Deliveries temp= new Deliveries(data);
            object.add(temp);
        }

        object.remove(0);
        return object;


    }

    private List<String[]> csvFileReader(String file) {
        try {
            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(0).build();
            return csvReader.readAll();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
