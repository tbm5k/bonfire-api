package com.bonfireadventures.entities;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int continentId;
    private String uuid;
    private String continentName;
    @OneToMany(mappedBy = "continent")
    private List<Country> countryList;

    public Continent(){
        this.uuid = String.valueOf(UUID.randomUUID());
    }

    public int getContinentId() {
        return continentId;
    }

    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
