package com.company;

import java.util.ArrayList;

import static com.company.ConstantValues.*;

class Deliveries {
    private String bowlingTeam;
    private String extraRuns;
    private String bowler;
    private String matchId;
    private String totalRuns;

    Deliveries (ArrayList<String> data){
        this.bowler= data.get(BOWLER_COL);
        this.bowlingTeam= data.get(BOWLING_TEAM_COL);
        this.extraRuns= data.get(EXTRA_RUNS_COL);
        this.matchId= data.get(ID_COL);
        this.totalRuns= data.get(TOTAL_RUNS);
    }

    String getTotalRuns() {
        return totalRuns;
    }

    String getBowlingTeam() {
        return bowlingTeam;
    }

    String getExtraRuns() {
        return extraRuns;
    }

    String getBowler() {
        return bowler;
    }

    String getMatchId() {
        return matchId;
    }

}
