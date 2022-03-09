package com.example.assignment1vb;

import java.util.List;

public class GeographicArea {

    private String name;
    private String code;
    private String altCode;
    private String level;
    private String population;
    private List<String> nestedAreas;


    public GeographicArea(String name, String code, String altCode, String level, String population){
        this.name = name;
        this.code = code;
        this.altCode = altCode;
        this.level = level;
        this.population = population;
    }

    public GeographicArea(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAltCode() {
        return altCode;
    }

    public void setAltCode(String altCode) {
        this.altCode = altCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public List<String> getNestedAreas(){
        return nestedAreas;
    }

    public void setNestedAreas(List<String> nestedAreas) {
        this.nestedAreas = nestedAreas;
    }
}