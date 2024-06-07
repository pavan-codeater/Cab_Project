package com.example.cab.Service;

import com.example.cab.Entity.Location;
import com.example.cab.Entity.Person;
import com.example.cab.Entity.VehicleDetails;
import com.example.cab.Enum.PersonType;
import com.example.cab.Interfaces.Onboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class OnboardService implements Onboard {

    @Autowired
    private Person personEntity;

    @Autowired
    private UserService userService;

    @Autowired
    private DriverService driverService;


    @Autowired
    private VehicleDetails vehicleDetails;

    @Autowired
    private Location location;



    public void addUserParseUserData(PersonType personType) throws Exception{
        Map<String,String> personData=new HashMap<>();
        personData.put("name", personEntity.getName());
        personData.put("gender", personEntity.getGender());
        personData.put("age",String.valueOf(personEntity.getAge()));

        switch (personType){
            case USER :
                userService.addUser(personData);
//                System.out.println("Users list "+userService.getUsers());
                break;

            case DRIVER:
                personData.put("vehicleName",vehicleDetails.getVehicleName());
                personData.put("vehicleNumber",vehicleDetails.getVehicleNumber());
                personData.put("Available",String.valueOf(vehicleDetails.isAvailable()));
                personData.put("latitude",String.valueOf(location.getLattitude()));
                personData.put("longitude",String.valueOf(location.getLongitude()));
                driverService.addDriver(personData);
//                System.out.println("Users list "+driverService.getDrivers());
                break;

            default:
                System.out.println("Invalid Person Type");
        }





    }




}
