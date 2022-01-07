package com.bonfireadventures.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId;
    private String uuid;
    private String hotelName;
    private boolean offer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private PricePackage pricePackage;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private City city;

    @OneToMany(mappedBy = "hotel")
    private List<Image> imageList;

    public Hotel(String hotelName, City city) {
        this.uuid = String.valueOf(UUID.randomUUID());
        this.hotelName = hotelName;
        this.city = city;
    }

    public Hotel(){
        this.uuid = String.valueOf(UUID.randomUUID());
        this.offer = false;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public boolean isOffer() {
        return offer;
    }

    public void setOffer(boolean offer) {
        this.offer = offer;
    }

    public PricePackage getPricePackage() {
        return pricePackage;
    }

    public void setPricePackage(PricePackage pricePackage) {
        this.pricePackage = pricePackage;
    }
}
