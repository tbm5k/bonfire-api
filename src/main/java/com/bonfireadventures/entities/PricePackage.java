package com.bonfireadventures.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class PricePackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pricePackageId;
    private String uuid;
    private String mealPlan;
    private int threeDaySGR;
    private int fiveDaySGR;
    private int threeDayFlying;
    private int fiveDayFlying;
    private Date validity;

    @OneToOne(mappedBy = "pricePackage")
    @JsonBackReference
    private Hotel hotel;

    public PricePackage() {
        this.uuid = String.valueOf(UUID.randomUUID());
    }

    public int getPricePackageId() {
        return pricePackageId;
    }

    public void setPricePackageId(int pricePackageId) {
        this.pricePackageId = pricePackageId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(String mealPlan) {
        this.mealPlan = mealPlan;
    }

    public int getThreeDaySGR() {
        return threeDaySGR;
    }

    public void setThreeDaySGR(int threeDaySGR) {
        this.threeDaySGR = threeDaySGR;
    }

    public int getFiveDaySGR() {
        return fiveDaySGR;
    }

    public void setFiveDaySGR(int fiveDaySGR) {
        this.fiveDaySGR = fiveDaySGR;
    }

    public int getThreeDayFlying() {
        return threeDayFlying;
    }

    public void setThreeDayFlying(int threeDayFlying) {
        this.threeDayFlying = threeDayFlying;
    }

    public int getFiveDayFlying() {
        return fiveDayFlying;
    }

    public void setFiveDayFlying(int fiveDayFlying) {
        this.fiveDayFlying = fiveDayFlying;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
