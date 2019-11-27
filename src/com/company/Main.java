package com.company;
import java.sql.*;

import java.util.LinkedHashMap;

import static com.company.ConstantValues.*;


public class Main {
    private static PreparedStatement establishCon(String query) throws  SQLException{
        getCon = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement= getCon.prepareStatement(query);
        return preparedStatement;
    }
    private static PreparedStatement establishCon(String query, String year) throws SQLException{
        getCon= DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement=getCon.prepareStatement(query);
        preparedStatement.setString(1,year);
        return  preparedStatement;
    }

    private static LinkedHashMap<String, String> querySolver(String query) throws SQLException {
        resultSet= establishCon(query).executeQuery();
        return  getValue();
    }

    private static LinkedHashMap<String, String> querySolver(String query, String year) throws SQLException {
        resultSet= establishCon(query,year).executeQuery();
        return  getValue();
    }

  private static  LinkedHashMap<String, String> getValue() throws SQLException {
      LinkedHashMap<String, String> map = new LinkedHashMap<>();
        try {
            while (resultSet.next()) {
                String col1 = resultSet.getString(COLUMN1[j]);
                String col2 = resultSet.getString(COLUMN2[j]);
                map.put(col1, col2);
            }

        }

        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        getCon.close();
        resultSet.close();

        j++;
      return map;
    }

    public static void main(String[] args) throws SQLException {

        querySolver(query[0]).forEach((k,v)->System.out.printf("\n %-30s : %s ", k, v));
        System.out.println("\n\n");
        querySolver(query[1]).forEach((k,v)->System.out.printf("\n %-30s : %s ", k, v));
        System.out.println("\n\n");
        querySolver(query[2],YEAR_2016).forEach((k,v)->System.out.printf("\n %-30s : %s", k, v));
        System.out.println("\n\n");
        querySolver(query[3],YEAR_2015).forEach((k,v)->System.out.printf("\n %-30s : %s", k, v));
        System.out.println("\n\n");
        querySolver(query[4]).forEach((k,v)->System.out.printf("\n %-30s : %s", k, v));

    }
}
