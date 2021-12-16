package com.bonfireadventures.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int countryId;
    private String uuid;
    private String countryName;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Continent continent;

    @OneToMany(mappedBy = "country")
    private List<City> cityList;

    public Country(){
        this.uuid = String.valueOf(UUID.randomUUID());
    }

    public Country(String countryName, Continent continent) {
        this.uuid = String.valueOf(UUID.randomUUID());
        this.countryName = countryName;
        this.continent = continent;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                ", continent=" + continent +
                ", cityList=" + cityList +
                '}';
    }
}
