package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class ExtraRuns {
    HashMap<String,Integer> extraRunsFun(ArrayList<HashMap<String, String>> data,
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
        return map;
    }
}
