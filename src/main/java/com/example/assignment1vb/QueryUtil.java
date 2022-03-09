package com.example.assignment1vb;

import com.example.assignment1vb.AgeGroup;
import com.example.assignment1vb.GeographicArea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryUtil {

    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    //return list of geographic areas
    public List<String> getGeographicList(int level){

        String SQL_geoAreaList = "SELECT name FROM GEOGRAPHICAREA WHERE level = ? ORDER BY level";
        List<String> areaList = new ArrayList<String>();
        try{
            connection = DBUtil.getInstances().getConnection();
            connection.setAutoCommit(false);

            ps = connection.prepareStatement(SQL_geoAreaList);
            ps.setString(1, Integer.toString(level));

            rs = ps.executeQuery();



            while(rs.next()){
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

    //returns geographic aras with details
    public List<GeographicArea> getGeographicDetailsList(){

        String SQL_geoDetails = "SELECT ga.ALTERNATIVECODE, ga.NAME, ga.CODE, ga.LEVEL, (SELECT SUM(MALE + FEMALE) FROM AGE a JOIN CENSUSYEAR c ON a.CENSUSYEAR = c.CENSUSYEARID JOIN AGEGROUP ag ON a.AGEGROUP = ag.AGEGROUPID WHERE a.GEOGRAPHICAREA = ga.GEOGRAPHICAREAID AND c.CENSUSYEARID = 2 AND AGEGROUPID = 1) AS population FROM GEOGRAPHICAREA ga INNER JOIN AGE a ON ga.GEOGRAPHICAREAID = a.GEOGRAPHICAREA JOIN CENSUSYEAR c ON a.CENSUSYEAR = c.CENSUSYEARID JOIN AGEGROUP ag ON a.AGEGROUP = ag.AGEGROUPID WHERE c.CENSUSYEARID = 2 AND AGEGROUPID = 1 ORDER BY ga.ALTERNATIVECODE";

        List<GeographicArea> getGeographicDetailsList = new ArrayList<GeographicArea>();

        try{
            connection = DBUtil.getInstances().getConnection();
            connection.setAutoCommit(false);

            ps = connection.prepareStatement(SQL_geoDetails);

            rs = ps.executeQuery();

            while(rs.next()){

                String name = rs.getString("NAME");
                String code = rs.getString("CODE");
                String altcode = rs.getString("ALTERNATIVECODE");
                String level = rs.getString("LEVEL");
                String population = rs.getString("POPULATION");

                GeographicArea currentDetails = new GeographicArea(name, code, altcode, level, population);

                getGeographicDetailsList.add(currentDetails);

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
        return getGeographicDetailsList;
    }

    //returns a list of age groups
    public List<AgeGroup> getAgeList(String year) {

        String SQL_ageGroup = "SELECT DISTINCT a.censusyear, ag.ageGroupID , ag.DESCRIPTION, SUM(a.MALE) AS MALE, SUM(a.FEMALE) AS FEMALE FROM AGE a JOIN AGEGROUP ag ON a.AGEGROUP = ag.AGEGROUPID JOIN GEOGRAPHICAREA ga ON a.GEOGRAPHICAREA = ga.GEOGRAPHICAREAID WHERE ga.GEOGRAPHICAREAID = 1 AND a.censusYear = ? AND ag.ageGroupID IN (3,9,22,28,34,40,46,52,58,70,76,83,89,95,101,108,114,120,126) GROUP BY a.censusyear, ag.DESCRIPTION,  ag.ageGroupID";

        List<AgeGroup> groups = new ArrayList<AgeGroup>();

        try{
            connection = DBUtil.getInstances().getConnection();
            connection.setAutoCommit(false);

            ps = connection.prepareStatement(SQL_ageGroup);
            ps.setString(1, year);

            rs = ps.executeQuery();

            while(rs.next()){

                String description = rs.getString("DESCRIPTION");
                String malePopulation = rs.getString("MALE");
                String femalePopulation = rs.getString("FEMALE");
                String censusYear = rs.getString("CENSUSYEAR");

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
