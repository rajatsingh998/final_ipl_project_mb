package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TopEconomicalBowler {
    HashMap<String,Integer> topEconomicalBowlerFun(ArrayList<HashMap<String, String>> data,
                                                   ArrayList<HashMap<String, String>> data1) {
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
            int totalBall=bowl.get(key);
            int over=(totalBall/6);
            int totalRuns= player.get(key);

            int eco=(totalRuns/over);
            temp.put(key, eco);

        }
        SortByTheValues sortByValueObject= new SortByTheValues();
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
