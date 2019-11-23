package com.company;

import java.util.*;
import static com.company.ConstantValues.*;

class Services {

    static AllSolution noOfMatchesPlayedFun(ArrayList<Matches> data) {
        HashMap<String, Integer> map= new HashMap<>();
        String date;
        for(Matches i :data){
            date=i.getSeason();
            if(map.containsKey(date)){
                int val = map.get(date) + 1;
                map.replace(date,val);
            }
            else{
                map.put(date,1);
            }
        }
        HashMap<String,String> answer;
        answer= funToString(map);
        return  (new AllSolution(answer));
    }

    static AllSolution noOfMatchesWonFun(ArrayList<Matches> data){
        String team;
        HashMap<String, Integer> map= new HashMap<>();
        for(Matches i :data){
            team=i.getWinner();
            if(team.length()>0) {
                if (map.containsKey(team)) {
                    int val = map.get(team) +1;
                    map.put(team, val);
                } else {
                    map.put(team, 1);
                }
            }
        }
        HashMap<String,String> answer= funToString(map);
        return  (new AllSolution(answer));
    }

    static AllSolution noOfPlayerOfTheMatchFun(ArrayList<Matches> data){

        HashMap<String, Integer> map= new HashMap<>();
        String playerOfTheMatch;

        for(Matches i :data){
            playerOfTheMatch=i.getPlayerOfTheMatch();
            if(playerOfTheMatch.length()>0) {
                if (map.containsKey(playerOfTheMatch)) {
                    int val= map.get(playerOfTheMatch) +1;
                    map.replace(playerOfTheMatch, val);
                }
                else {
                    map.put(playerOfTheMatch, 1);
                }
            }
        }

        HashMap<String,String> answer= funToString(map);
        return  (new AllSolution(answer));
    }

    static AllSolution extraRunsFun(ArrayList<Matches> data, ArrayList<Deliveries> data1){
        ArrayList<String> Id= new ArrayList<>();
        String year;

        for(Matches i :data){
            year=i.getSeason();
            if(year.equals(YEAR_2016)){
                Id.add(i.getMatchId());
            }
        }

        HashMap<String, Integer> map= new HashMap<>();
        String team;

        for (Deliveries i :data1){
            String val=i.getMatchId();
            if(Id.contains(val)){
                team=i.getBowlingTeam();
                String extraRuns=i.getExtraRuns();
                if (map.containsKey(team)){
                    int run = map.get(team) + Integer.parseInt(extraRuns);
                    map.put(team,run);
                }
                else{
                    int run=Integer.parseInt(extraRuns);
                    map.put(team, run);
                }
            }
        }

        HashMap<String,String> answer= funToString(map);
        return  (new AllSolution(answer));
    }


    static AllSolution topEconomicalBowlerFun(ArrayList<Matches> data, ArrayList<Deliveries> data1){

        ArrayList<String> id= new ArrayList<>();

        for(Matches i :data){
            String year=i.getSeason();
            if(year.equals(YEAR_2015)){
                id.add(i.getMatchId());
            }
        }

        HashMap<String, Integer> player= new HashMap<>();
        HashMap<String, Float> temp= new HashMap<>();
        HashMap<String, Integer> bowl= new HashMap<>();

        for(Deliveries i :data1){
            String val=i.getMatchId();
            if(id.contains(val)){
                String playerName=i.getBowler();
                String totalRuns= i.getTotalRuns();

                if(player.containsKey(playerName)){
                    int run = player.get(playerName) + Integer.parseInt(totalRuns);

                    int noOfBall = bowl.get(playerName) + 1;

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

            float totalBall=bowl.get(key);
            float over=(totalBall/OVER);
            int totalRuns= player.get(key);
            float eco=(totalRuns/over);
            temp.put(key, eco);
        }

        LinkedHashMap<String, Float> finals=sortByValueFun(temp);
        LinkedHashMap<String, Float> ans= new LinkedHashMap<>();
        int i=1;
        for (Map.Entry<String, Float> entry : finals.entrySet())
        {
            ans.put(entry.getKey(),entry.getValue());
            i++;
            if(i>NO_OF_TOP_ECONOMICAL_BOWLERS){
                break;
            }
        }

        HashMap<String,String> answer= floatToString(ans);
        return  (new AllSolution(answer));
    }

    private static HashMap<String, String> funToString(HashMap<String, Integer> map){
        HashMap<String, String> temp = new HashMap<>();
        for( Map.Entry<String, Integer> entry : map.entrySet()){
            int x= entry.getValue();
            temp.put(entry.getKey(), Integer.toString(x));
        }
        return temp;
    }

    private static HashMap<String, String> floatToString(HashMap<String, Float> map){
        LinkedHashMap<String, String> temp = new LinkedHashMap<>();
        for( Map.Entry<String, Float> entry : map.entrySet()){
            float x= entry.getValue();
            String strfloat = String.format("%.2f", x);
            temp.put(entry.getKey(),strfloat);
        }
        return temp;
    }

    private static LinkedHashMap<String, Float> sortByValueFun(HashMap<String, Float> temp) {
        List<Map.Entry<String, Float>> list = new LinkedList<>(temp.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue));

        LinkedHashMap<String, Float> map = new LinkedHashMap<>();
        for (Map.Entry<String, Float> tempp : list) {
            map.put(tempp.getKey(), tempp.getValue());
        }

        return map;
    }
}
