package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class noOfMatchesPlayedClass {

        public HashMap<String,Integer> noOfMatchesPlayedFun(ArrayList<HashMap<String, String>> data) {
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
