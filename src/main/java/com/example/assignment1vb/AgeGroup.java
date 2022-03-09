package com.example.assignment1vb;

public class AgeGroup {

    private String description;
    private String male;
    private String female;
    private String censusYear;



    public AgeGroup(String description, String male, String female, String censusYear){
        this.description = description;
        this.male = male;
        this.female = female;
        this.censusYear = censusYear;
    }

    public AgeGroup(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }

    public String getCensusYear() {
        return censusYear;
    }

    public void setCensusYear(String censusYear) {
        this.censusYear = censusYear;
    }
}
