package com.example.cab.Entity;


import org.springframework.stereotype.Component;

@Component
public class VehicleDetails {

    private String vehicleName;
    private String vehicleNumber;
    private boolean isAvailable;

    public void VehicleDetails_initializer(String vehicleName, String vehicleNumber, boolean isAvailable) {
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.isAvailable = isAvailable;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
