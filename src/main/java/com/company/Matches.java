package com.company;

import java.util.ArrayList;
import static com.company.ConstantValues.*;

class Matches {

    private String matchId;
    private String season;
    private String winner;
    private String playerOfTheMatch;

    Matches (ArrayList<String> data){
        this.matchId= data.get(ID_COL);
        this.season= data.get(SEASON_COL);
        this.winner= data.get(WINNER_COL);
        this.playerOfTheMatch= data.get(PLAYER_OF_THE_MATCH_COL);
    }

    String getMatchId() { return matchId; }

    String getSeason() {
            return season;
        }

    String getWinner() {
            return winner;
        }

    String getPlayerOfTheMatch() {
            return playerOfTheMatch;
        }

}
