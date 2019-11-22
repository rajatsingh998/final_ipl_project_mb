package com.company;

import java.util.ArrayList;
import java.util.HashMap;

class getSolution {

    static  HashMap<String, Integer> allSolution(int response, String file, String file1){
             fileParsing fileParsingObject= new fileParsing();
             ArrayList<HashMap<String, String>> data=fileParsingObject.dataParsing(file);
             ArrayList<HashMap<String, String>> data1= fileParsingObject.dataParsing(file1);
             HashMap<String, Integer> defaultMessage= new HashMap<>();
            switch(response){
                case 1:
                    noOfMatchesClass noOfMatchesObject= new noOfMatchesClass();
                    return noOfMatchesObject.noOfMatchesPlayedFun(data);
                case 2:
                    noOfMatchesClass noOfMatchesObject1= new noOfMatchesClass();
                    return noOfMatchesObject1.noOfMatchesWonFun(data);
                case 3:
                    extraRunsClass extraRunsObject= new extraRunsClass();
                    return extraRunsObject.extraRunsFun(data,data1);
                case 4:
                    topEconomicalBowlerClass topEconomicalBowlerObject= new topEconomicalBowlerClass();
                    return topEconomicalBowlerObject.topEconomicalBowlerFun(data,data1);
                case 5:
                    noOfPlayerOfTheMatchClass noOfPlayerOfTheMatchObject= new noOfPlayerOfTheMatchClass();
                    return noOfPlayerOfTheMatchObject.noOfPlayerOfTheMatchFun(data);
                default:
                    return defaultMessage;
            }

        }
    }

