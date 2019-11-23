package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeliveriesMatches {
    static AllSolution extraRunsFun(ArrayList<HashMap<String, String>> data,
                                    ArrayList<HashMap<String, String>> data1){
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
        HashMap<String,String> answer= funToString(map);;
        AllSolution obj= new AllSolution(answer);
        return  (obj);
    }


    static AllSolution topEconomicalBowlerFun(ArrayList<HashMap<String, String>> data,
                                              ArrayList<HashMap<String, String>> data1) {
        ArrayList<String> id= new ArrayList<>();
        for(HashMap<String, String> i :data){
            String year=i.get("season");
            if(year.equals("2015")){
                id.add(i.get("id"));
            }
        }

        HashMap<String, Integer> player= new HashMap<>();
        HashMap<String, Float> temp= new HashMap<>();
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
            int totalBall=bowl.get(key);
            int over=(totalBall/6);
            int totalRuns= player.get(key);

           float eco=(totalRuns/over);
            temp.put(key, eco);

        }
        SortByTheValues sortByValueObject= new SortByTheValues();
        HashMap<String, Float> finals=sortByValueObject.sortByValueFun(temp);
        HashMap<String, Float> ans= new HashMap<>();
        int i=1;
        for (Map.Entry<String, Float> entry : finals.entrySet())
        {
            ans.put(entry.getKey(),entry.getValue());
            i++;
            if(i>3){
                break;
            }
        }

        HashMap<String,String> answer= floatToString(ans);;
        AllSolution obj= new AllSolution(answer);
        return  (obj);
    }

    static HashMap<String, String> funToString(HashMap<String, Integer> map){
        HashMap<String, String> temp = new HashMap<>();
        for( Map.Entry<String, Integer> entry : map.entrySet()){
            int x= entry.getValue();
            temp.put(entry.getKey(), Integer.toString(x));
        }
        return temp;
    }

    static HashMap<String, String> floatToString(HashMap<String, Float> map){
        HashMap<String, String> temp = new HashMap<>();
        for( Map.Entry<String, Float> entry : map.entrySet()){
           float x= entry.getValue();
            String strfloat = String.format("%.2f", x);
            temp.put(entry.getKey(),strfloat);
        }
        return temp;
    }
}
