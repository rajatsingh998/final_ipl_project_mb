package com.company;


import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.opencsv.*;


import java.io.IOException;

import static java.util.Collections.*;
public class my_project {
    public static void main(String[] args) {

        System.out.println("====== IPL DATASET PROJECT =====");
        System.out.println("\n Choose one of the option");
        System.out.println("\n 1. Number of matches played per year of all the years in IPL.");
        System.out.println("\n 2. Number of matches won of all teams over all the years of IPL.");
        System.out.println("\n 3. For the year 2016 get the extra runs conceded per team.");
        System.out.println("\n 4. For the year 2015 get the top economical bowlers.");
        System.out.println("\n 5. Total number of the player of the match award by players");

        Scanner sc = new Scanner(System.in);
        int response = sc.nextInt();
        getSolution object = new getSolution();
        HashMap<String, Integer> solution = getSolution.allSolution(response);
        solution.forEach((k, v) -> System.out.printf("\n %-30s : %d", k, v));

    }
}

class getSolution {

    private static storingMatchData storingMatchDataObject= new storingMatchData();
    private static ArrayList<HashMap<String, String>> data=storingMatchDataObject.dataParsing("matches.csv");;
    private  static ArrayList<HashMap<String, String>> data1= storingMatchDataObject.dataParsing("deliveries.csv");

    public  static  HashMap<String, Integer> allSolution(int response){
        HashMap<String, Integer> ok= new HashMap<>();
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
                return ok;
        }

    }
}

class noOfMatchesPlayedClass{
    public  HashMap<String,Integer> noOfMatchesPlayedFun(ArrayList<HashMap<String, String>>data) {
         HashMap<String, Integer> map= new HashMap<>();
         String date;
         for(HashMap<String, String> i :data){
             date=i.get("season");
             if(map.containsKey(date)){
                 int val=map.get(date);
                 val=val+1;
                 map.replace(date,val);
             }
             else{
                 map.put(date,1);
             }
         }
         return  map;
     }
 }

 class noOfMatchesWonClass{
     public  HashMap<String, Integer> noOfMatchesWonFun(ArrayList<HashMap<String, String>>data){
         String team;
         HashMap<String, Integer> map= new HashMap<>();
         for(HashMap<String, String> i :data){
             team=i.get("winner");
             if(team.length()>0) {
                 if (map.containsKey(team)) {
                     int val = map.get(team);
                     val = val + 1;
                     map.put(team, val);
                 } else {
                     map.put(team, 1);
                 }
             }
         }
         return map;
     }
 }

 class extraRunsClass{
     public  HashMap<String,Integer> extraRunsFun(ArrayList<HashMap<String, String>>data,
                                                           ArrayList<HashMap<String, String>>data1){
         ArrayList<String> Id= new ArrayList<>();
         String year;
         for(HashMap<String, String> i :data){
             year=i.get("season");
             if(year.equals("2016")){
                 Id.add(i.get("id"));
             }
         }

         HashMap<String, Integer> map= new HashMap<>();
         String team;
         for (HashMap<String, String> i :data1){
             String val=i.get("match_id");
             if(Id.contains(val)){
                 team=i.get("bowling_team");
                 String extraRuns=i.get("extra_runs");

                 if (map.containsKey(team)){
                     int run=map.get(team);
                     run=run+Integer.parseInt(extraRuns);
                     map.put(team,run);
                 }
                 else{
                     int run=Integer.parseInt(extraRuns);
                     map.put(team, run);
                 }
             }
         }
         return map;
     }
 }

 class topEconomicalBowlerClass{
     public HashMap<String,Integer> topEconomicalBowlerFun(ArrayList<HashMap<String, String>>data,
                                                                     ArrayList<HashMap<String, String>>data1) {
         ArrayList<String> id= new ArrayList<>();
         for(HashMap<String, String> i :data){
             String year=i.get("season");
             if(year.equals("2015")){
                 id.add(i.get("id"));
             }
         }

         HashMap<String, Integer> player= new HashMap<>();
         HashMap<String, Integer> temp= new HashMap<>();
         HashMap<String, Integer> bowl= new HashMap<>();
         for(HashMap<String, String> i :data1){
             String val=i.get("match_id");
             if(id.contains(val)){
                 String playerName=i.get("bowler");
                 String totalRuns= i.get("total_runs");

                 if(player.containsKey(playerName)){
                     int run=player.get(playerName);
                     run=run+Integer.parseInt(totalRuns);

                     int noOfBall=bowl.get(playerName);
                     noOfBall=noOfBall+1;

                     player.put(playerName,run);
                     bowl.put(playerName, noOfBall);
                 }
                 else{
                     int run=Integer.parseInt(totalRuns);
                     player.put(playerName,run);

                     bowl.put(playerName,1);

                 }
             }
         }

         for(String key: player.keySet()){
             String playerName=key;
             int totalBall=bowl.get(playerName);
             int over=(totalBall/6);
             int totalRuns= player.get(playerName);

             int eco=(totalRuns/over);
             temp.put(playerName, eco);

         }
         sortByValueClass sortByValueObject= new sortByValueClass();
         HashMap<String, Integer> finals=sortByValueObject.sortByValueFun(temp);
         HashMap<String, Integer> ans= new HashMap<>();
         int i=1;
         for (Map.Entry<String, Integer> entry : finals.entrySet())
         {
             ans.put(entry.getKey(),entry.getValue());
             i++;
             if(i>3){
                 break;
             }
         }

         return ans;
     }
 }

 class noOfPlayerOfTheMatchClass{
     public HashMap<String, Integer> noOfPlayerOfTheMatchFun(ArrayList<HashMap<String, String>>data){
         HashMap<String, Integer> map= new HashMap<>();
         String playerOfTheMatch;
         for(HashMap<String, String> i :data){
             playerOfTheMatch=i.get("player_of_match");
             if(playerOfTheMatch.length()>0) {
                 if (map.containsKey(playerOfTheMatch)) {
                     int val = map.get(playerOfTheMatch);
                     val = val + 1;
                     map.replace(playerOfTheMatch, val);
                 } else {

                     map.put(playerOfTheMatch, 1);
                 }
             }
         }
         return map;
     }
 }

 class storingMatchData{

    ArrayList<HashMap<String, String>> data;
    public ArrayList<HashMap<String, String>> dataParsing(String my_file) {
        try {
            FileReader filereader = new FileReader(my_file);
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(0).build();
            List<String[]> allData = csvReader.readAll();
            ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();


            String[] keys = allData.get(0);
            for (String[] row : allData) {
                int counter = 0;
                HashMap<String, String> map = new HashMap<String, String>();
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
        ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        return data;}

}

class sortByValueClass {
    public HashMap<String, Integer> sortByValueFun(HashMap<String, Integer> temp) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(temp.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));

        HashMap<String, Integer> map = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> tempp : list) {
            map.put(tempp.getKey(), tempp.getValue());
        }
        return map;
    }
}











