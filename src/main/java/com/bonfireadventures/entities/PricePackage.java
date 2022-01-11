package com.bonfireadventures.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class PricePackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pricePackageId;
    private String uuid;
    private String mealPlan;
    private int threeDaySgr;
    private int fiveDaySgr;
    private int threeDayFlying;
    private int fiveDayFlying;

    @ManyToOne
    @JoinColumn
    private Hotel hotelPackage;

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

    public int getThreeDaySgr() {
        return threeDaySgr;
    }

    public void setThreeDaySgr(int threeDaySgr) {
        this.threeDaySgr = threeDaySgr;
    }

    public int getFiveDaySgr() {
        return fiveDaySgr;
    }

    public void setFiveDaySgr(int fiveDaySgr) {
        this.fiveDaySgr = fiveDaySgr;
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

    public Hotel getHotelPackage() {
        return hotelPackage;
    }

    public void setHotelPackage(Hotel hotelPackage) {
        this.hotelPackage = hotelPackage;
    }
}
