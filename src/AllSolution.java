package com.company;

import java.util.HashMap;

class AllSolution {
    HashMap<String, String> answer;
    AllSolution(HashMap<String, String> solution){
        this.answer=solution;
    }

    HashMap<String, String> getSolution(){
        return answer;
    }

    String  queryName(int n){
        switch(n){
            case 1:
                return  "Number of matches played per year of all the years in IPL are:";
            case 2:
                return " Number of matches won of all teams over all the years of IPL.";
            case 3:
                return "For the year 2016 get the extra runs conceded per team.";
            case 4:
                return "For the year 2015 get the top economical bowlers.";
            case 5:
                return "Number of the player of the match of award to players:";

            default:
                return "wrong message";

        }

    }


}
