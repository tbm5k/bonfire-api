package com.bonfireadventures.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;
    private String uuid;
    private String cityName;

    @OnDelete( action = OnDeleteAction.CASCADE)
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn
    @JsonIgnore
    private Country country;

    @OneToMany(mappedBy = "city", cascade = CascadeType.REMOVE)
    private List<Hotel> hotelList;

    public City(String cityName, Country country) {
        this.uuid = String.valueOf(UUID.randomUUID());
        this.cityName = cityName;
        this.country = country;
    }

    public City(){
        this.uuid = String.valueOf(UUID.randomUUID());
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }
}
