package com.example.cab.Entity;

import org.springframework.stereotype.Component;

@Component
public class FindRideEntity {
    private String username;
    private double sourceLatitude;
    private double sourceLongitude;
    private double destLatitude;
    private double destLongitude;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getSourceLatitude() {
        return sourceLatitude;
    }

    public void setSourceLatitude(double sourceLatitude) {
        this.sourceLatitude = sourceLatitude;
    }

    public double getSourceLongitude() {
        return sourceLongitude;
    }

    public void setSourceLongitude(double sourceLongitude) {
        this.sourceLongitude = sourceLongitude;
    }

    public double getDestLatitude() {
        return destLatitude;
    }

    public void setDestLatitude(double destLatitude) {
        this.destLatitude = destLatitude;
    }

    public double getDestLongitude() {
        return destLongitude;
    }

    public void setDestLongitude(double destLongitude) {
        this.destLongitude = destLongitude;
    }
}
