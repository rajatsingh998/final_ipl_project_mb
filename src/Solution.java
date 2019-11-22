package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    static HashMap<String, Integer> allSolution(int response, String file, String file1){
        FileParsingClass fileParsingObject= new FileParsingClass();
        ArrayList<HashMap<String, String>> data=fileParsingObject.dataParsing(file);
        ArrayList<HashMap<String, String>> data1= fileParsingObject.dataParsing(file1);
        HashMap<String, Integer> defaultMessage= new HashMap<>();
        switch(response){
            case 1:
                NoOfMatchesClass noOfMatchesPlayedObject= new NoOfMatchesClass();
                return noOfMatchesPlayedObject.noOfMatchesPlayedFun(data);
            case 2:
                NoOfMatchesClass noOfMatchesWonObject= new NoOfMatchesClass();
                return noOfMatchesWonObject.noOfMatchesWonFun(data);
            case 3:
                ExtraRuns extraRunsObject= new ExtraRuns();
                return extraRunsObject.extraRunsFun(data,data1);
            case 4:
                TopEconomicalBowler topEconomicalBowlerObject= new TopEconomicalBowler();
                return topEconomicalBowlerObject.topEconomicalBowlerFun(data,data1);
            case 5:
                NoOfPlayerOfTheMatch noOfPlayerOfTheMatchObject= new  NoOfPlayerOfTheMatch();
                return noOfPlayerOfTheMatchObject.noOfPlayerOfTheMatchFun(data);
            default:
                return defaultMessage;
        }

    }
}
