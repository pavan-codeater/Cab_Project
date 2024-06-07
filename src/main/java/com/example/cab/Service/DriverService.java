package com.example.cab.Service;


import com.example.cab.Entity.Location;
import com.example.cab.Entity.Person;
import com.example.cab.Entity.VehicleDetails;
import com.example.cab.Enum.PersonType;
import com.example.cab.Interfaces.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DriverService implements Driver {

    @Autowired
    private OnboardService onboardService;

    @Autowired
    private Person personEntity;

    @Autowired
    private VehicleDetails vehicleDetails;

    @Autowired
    private Location location;


    List<Map<String,String>> drivers=new ArrayList<>();

    public List<Map<String,String>> getDrivers(){
        return drivers;
    }

    public void addDriver(Map<String,String> driver){
        drivers.add(driver);
        System.out.println("Driver Onboard Successful");
    }

    public void getParseInput(String input, boolean isAvailable) throws Exception{
        try {
            String cleanedInput = input.replaceAll("[\"()“”]", "");
            String driverDetails[] = cleanedInput.split(",");

            personEntity.User_Initializer(driverDetails[0].trim(), driverDetails[1].trim(), Integer.parseInt(driverDetails[2].trim()));
            vehicleDetails.VehicleDetails_initializer(driverDetails[3].trim(), driverDetails[4].trim(), isAvailable);
            location.location_initializer(Double.parseDouble(driverDetails[5].trim()), Double.parseDouble(driverDetails[6].trim()));
            onboardService.addUserParseUserData(PersonType.DRIVER);
        }catch (Exception e){
            System.out.println("Please Provide valid input");
        }

    }









}
