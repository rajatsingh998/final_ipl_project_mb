package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.company.ConstantValues.*;

class DeliveriesMatches {
    static AllSolution extraRunsFun(ArrayList<HashMap<String, String>> data,
                                    ArrayList<HashMap<String, String>> data1){
        ArrayList<String> Id= new ArrayList<>();
        String year;
        for(HashMap<String, String> i :data){
            year=i.get(SEASON);
            if(year.equals(YEAR_2016)){
                Id.add(i.get(ID));
            }
        }

        HashMap<String, Integer> map= new HashMap<>();
        String team;
        for (HashMap<String, String> i :data1){
            String val=i.get(MATCH_ID);
            if(Id.contains(val)){
                team=i.get(BOWLING_TEAM);
                String extraRuns=i.get(EXTRA_RUNS);

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


    static AllSolution topEconomicalBowlerFun(ArrayList<HashMap<String, String>> data,
                                              ArrayList<HashMap<String, String>> data1) {
        ArrayList<String> id= new ArrayList<>();
        for(HashMap<String, String> i :data){
            String year=i.get(SEASON);
            if(year.equals(YEAR_2015)){
                id.add(i.get(ID));
            }
        }

        HashMap<String, Integer> player= new HashMap<>();
        HashMap<String, Float> temp= new HashMap<>();
        HashMap<String, Integer> bowl= new HashMap<>();
        for(HashMap<String, String> i :data1){
            String val=i.get(MATCH_ID);
            if(id.contains(val)){
                String playerName=i.get(BOWLER);
                String totalRuns= i.get(TOTAL_RUNS);

                if(player.containsKey(playerName)){
                    int run = player.get(playerName) + Integer.parseInt(totalRuns);

                    int noOfBall=bowl.get(playerName);
                    noOfBall++;

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
        SortByTheValues sortByValueObject= new SortByTheValues();
        LinkedHashMap<String, Float> finals=sortByValueObject.sortByValueFun(temp);
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
}
