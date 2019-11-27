package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConstantValues {
    static  int j=0;
    static String URL = "jdbc:postgresql://localhost:5432/my_database";
    static String USER = "postgres";
    static String PASSWORD = "raje@19sh";
    static Connection getCon = null;
    static ResultSet resultSet= null;
    static Statement statement= null;

    static  String YEAR_2015="2015",YEAR_2016="2016";
    private static  int BALLS=6, NO_OF_ECONOMICAL_BOWLERS=5;



    static  String[] COLUMN1={"season","winner","bowling_team","bowler","player_of_match"};
    static  String[] COLUMN2={"match_played","match_played","total_extra_runs", "economical_bowler", "no_of_match" };
    static String [] query={"select season, count(id) as match_played from matches group by season order by  season;",
            "select winner, count(id) as match_played from matches where winner is not null group by winner  order by winner;",
            "select bowling_team, sum(cast(extra_runs as int) ) as total_extra_runs from deliveries where match_id in (select id from matches where season=?) group by  bowling_team;",
            "select  bowler , (sum(cast(total_runs as float)) /(count(match_id)/"+BALLS+"))as economical_bowler from deliveries where match_id in (select id from matches where season=?) group by bowler order by  economical_bowler limit " +NO_OF_ECONOMICAL_BOWLERS+";",
            "select  player_of_match, count(id) as no_of_match from matches group by  player_of_match order by count(id);"};
}
