package com.example.assignment1vb;

public class AgeGroup {

    private String description;
    private String malePopulation;
    private String femalePopulation;
    private String censusYear;



    public AgeGroup(String description, String malePopulation, String femalePopulation, String censusYear){
        this.description = description;
        this.malePopulation = malePopulation;
        this.femalePopulation = femalePopulation;
        this.censusYear = censusYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMalePopulation() {
        return malePopulation;
    }

    public void setMalePopulation(String malePopulation) {
        this.malePopulation = malePopulation;
    }

    public String getFemalePopulation() {
        return femalePopulation;
    }

    public void setFemalePopulation(String femalePopulation) {
        this.femalePopulation = femalePopulation;
    }

    public String getCensusYear() {
        return censusYear;
    }

    public void setCensusYear(String censusYear) {
        this.censusYear = censusYear;
    }
}
