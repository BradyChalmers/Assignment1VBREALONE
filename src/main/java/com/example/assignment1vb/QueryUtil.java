package com.example.assignment1vb;

import com.example.assignment1vb.AgeGroup;
import com.example.assignment1vb.GeographicArea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryUtil {

    //variable declarations
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    //return list of geographic areas
    public List<String> getGeographicList(int level){

        //define sql statement
        String SQL_geoAreaList = "SELECT name FROM GEOGRAPHICAREA WHERE level = ? ORDER BY level";
        //define list of areas
        List<String> areaList = new ArrayList<String>();
        try{
            //attempt connection
            connection = DBUtil.getInstances().getConnection();
            connection.setAutoCommit(false);

            //prepare sql statement
            ps = connection.prepareStatement(SQL_geoAreaList);
            ps.setString(1, Integer.toString(level));

            //execute statement
            rs = ps.executeQuery();

            //check if statement found anything
            while(rs.next()){

                //add name to list
                String name = rs.getString("name");
                areaList.add(name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            }
            catch(Exception e) {}
            try {
                ps.close();
            }
            catch(Exception e) {}
            try {
                connection.close();
            }
            catch(Exception e) {}
        }

        return areaList;
    }

    //returns individual item for geographic report
    public GeographicArea getIndividualGeoArea(String name){

        //prepare sql statement
        String SQL_geoDetails = "SELECT ga.ALTERNATIVECODE, ga.NAME, ga.CODE, ga.LEVEL, (SELECT SUM(MALE + FEMALE) FROM AGE a JOIN CENSUSYEAR c ON a.CENSUSYEAR = c.CENSUSYEARID JOIN AGEGROUP ag ON a.AGEGROUP = ag.AGEGROUPID WHERE a.GEOGRAPHICAREA = ga.GEOGRAPHICAREAID AND c.CENSUSYEARID = 2 AND AGEGROUPID = 1) AS population FROM GEOGRAPHICAREA ga INNER JOIN AGE a ON ga.GEOGRAPHICAREAID = a.GEOGRAPHICAREA JOIN CENSUSYEAR c ON a.CENSUSYEAR = c.CENSUSYEARID JOIN AGEGROUP ag ON a.AGEGROUP = ag.AGEGROUPID WHERE c.CENSUSYEARID = 2 AND AGEGROUPID = 1 AND NAME = ? ORDER BY ga.ALTERNATIVECODE";

        //define geographic area object
        GeographicArea geoArea = new GeographicArea();

        try{
            //attempt connection
            connection = DBUtil.getInstances().getConnection();
            connection.setAutoCommit(false);

            //prepare sql statement
            ps = connection.prepareStatement(SQL_geoDetails);
            ps.setString(1, name);

            //execute statement
            rs = ps.executeQuery();

            //check if statement found anything
            while(rs.next()){

                //set return variables
                String name2 = rs.getString("NAME");
                String code = rs.getString("CODE");
                String altcode = rs.getString("ALTERNATIVECODE");
                String level = rs.getString("LEVEL");
                String population = rs.getString("POPULATION");

                //set return object
                geoArea = new GeographicArea(name2, code, altcode, level, population);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            }
            catch(Exception e) {}
            try {
                ps.close();
            }
            catch(Exception e) {}
            try {
                connection.close();
            }
            catch(Exception e) {}
        }
        return geoArea;
    }

    //returns a list of age groups
    public List<AgeGroup> getAgeList(String year) {

        //define sql statement
        String SQL_ageGroup = "SELECT DISTINCT a.censusyear, ag.ageGroupID , ag.DESCRIPTION, SUM(a.MALE) AS MALE, SUM(a.FEMALE) AS FEMALE FROM AGE a JOIN AGEGROUP ag ON a.AGEGROUP = ag.AGEGROUPID JOIN GEOGRAPHICAREA ga ON a.GEOGRAPHICAREA = ga.GEOGRAPHICAREAID WHERE ga.GEOGRAPHICAREAID = 1 AND a.censusYear = ? AND ag.ageGroupID IN (3,9,22,28,34,40,46,52,58,70,76,83,89,95,101,108,114,120,126) GROUP BY a.censusyear, ag.DESCRIPTION,  ag.ageGroupID";

        //define return list
        List<AgeGroup> groups = new ArrayList<AgeGroup>();

        try{
            //attempt database connection
            connection = DBUtil.getInstances().getConnection();
            connection.setAutoCommit(false);

            //prepare sql statement
            ps = connection.prepareStatement(SQL_ageGroup);
            ps.setString(1, year);

            //execute statement
            rs = ps.executeQuery();

            //check if statement found anything
            while(rs.next()){
                //prepare placeholder variables
                String description = rs.getString("DESCRIPTION");
                String malePopulation = rs.getString("MALE");
                String femalePopulation = rs.getString("FEMALE");
                String censusYear = rs.getString("CENSUSYEAR");

                //add item to list
                AgeGroup group = new AgeGroup(description, malePopulation, femalePopulation, censusYear);
                groups.add(group);
            }


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            }
            catch(Exception e) {}
            try {
                ps.close();
            }
            catch(Exception e) {}
            try {
                connection.close();
            }
            catch(Exception e) {}
        }
        return groups;
    }

}
