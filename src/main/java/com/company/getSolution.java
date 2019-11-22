package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class getSolution {


        private static fileParsing fileParsingObject= new fileParsing();
        private static ArrayList<HashMap<String, String>> data=fileParsingObject.dataParsing("D:\\MY\\Mount blue\\matches.csv");;
        private  static ArrayList<HashMap<String, String>> data1= fileParsingObject.dataParsing("D:\\MY\\Mount blue\\deliveries.csv");

        public  static  HashMap<String, Integer> allSolution(int response){
            HashMap<String, Integer> defaultMessage= new HashMap<>();
            switch(response){
                case 1:
                    noOfMatchesPlayedClass noOfMatchesPlayedObject= new noOfMatchesPlayedClass();
                    return noOfMatchesPlayedObject.noOfMatchesPlayedFun(data);
                case 2:
                    noOfMatchesWonClass noOfMatchesWonObject= new noOfMatchesWonClass();
                    return noOfMatchesWonObject.noOfMatchesWonFun(data);
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

