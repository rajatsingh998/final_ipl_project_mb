package com.company;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class fileParsing {
    ArrayList<HashMap<String, String>> dataParsing(String file) {
        try {
            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(0).build();
            List<String[]> allData = csvReader.readAll();
            ArrayList<HashMap<String, String>> data = new ArrayList<>();


            String[] keys = allData.get(0);
            for (String[] row : allData) {
                int counter = 0;
                HashMap<String, String> map = new HashMap<>();
                for (String cell : row) {
                    map.put(keys[counter], cell);
                    counter++;
                }
                data.add(map);

            }
            data.remove(0);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();}
}
