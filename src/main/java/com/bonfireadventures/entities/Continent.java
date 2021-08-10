package com.bonfireadventures.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int continentId;
    private String continentName;
    @OneToMany(mappedBy = "continent")
    private List<Country> countryList;

    public int getContinentId() {
        return continentId;
    }

    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }
}
