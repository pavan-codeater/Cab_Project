package com.example.cab.Service;

import com.example.cab.Entity.FindRideEntity;
import com.example.cab.Interfaces.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class FindRide implements Ride {
    @Autowired
    private UserService userService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private FindRideEntity findRideEntity;

    public void findRide(String userInp) throws Exception{

            parseInput(userInp);
            checkRideAvailability();


    }

    public void parseInput(String userInp) throws Exception{
        String rideData[]=userInp.replaceAll("[\"()“”]","").split(",");
        findRideEntity.setUsername(rideData[0]);
        findRideEntity.setSourceLatitude(Double.parseDouble(rideData[1]));
        findRideEntity.setSourceLongitude(Double.parseDouble(rideData[2]));
        findRideEntity.setDestLatitude(Double.parseDouble(rideData[3]));
        findRideEntity.setDestLongitude(Double.parseDouble(rideData[4]));
    }

    public void checkRideAvailability() throws Exception{
        List<Map<String,String>> driversAvailable = new ArrayList<>();
        List<Map<String, String>> filteredUsers = findPerson(userService.getUsers(),findRideEntity.getUsername().trim());


        if(!filteredUsers.isEmpty()){
            for (Map<String, String> driver : driverService.getDrivers()) {
                double distance = calculateDistance(findRideEntity.getSourceLatitude(),findRideEntity.getSourceLongitude(),Double.parseDouble(driver.get("latitude")),Double.parseDouble(driver.get("longitude")));
                if(distance > 5.0){
                    //System.out.println("NOT AVAILABLE"+ driver.get("name")+"->"+distance);
                }else{
                    // System.out.println("AVAILABLE"+ driver.get("name")+"->"+distance);
                    if(driver.get("Available").equals("true")) {
                        driversAvailable.add(driver);
                    }
                }

            }
            askRideSelection(driversAvailable);
        }
        else{
            System.out.println("Please register to book a ride");
        }


    }

    public double calculateDistance(double srcLat, double srcLong, double destLat, double destLong) throws Exception{
        double deltaX = destLat - srcLat;
        double deltaY = destLong - srcLong;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }


    public void askRideSelection(List<Map<String,String>> driversAvailable) throws Exception{
        HashMap<Integer,Object> driverSelectionList = new HashMap<>();
        System.out.println("Please select ride from available rides shown below");
        int optionNumber = 1;
        for (Map<String, String> driver : driversAvailable){
                System.out.println(optionNumber + ". " + driver.get("name") + " " + driver.get("vehicleName") + " " + driver.get("vehicleNumber") + " " + driver.get("age"));
                driverSelectionList.put(optionNumber, driver);
                optionNumber++;
        }
        if(!driverSelectionList.isEmpty()) {
            System.out.println("Please select driver by entering your choice number (ex: 2)");
            Scanner inp = new Scanner(System.in);
            int choice = inp.nextInt();
            System.out.println("Ride selection successful, Below is vehicle details");
            Object selectedDriver = driverSelectionList.get(choice);
            if (selectedDriver != null && selectedDriver instanceof Map) {
                Map<String, String> selectedDriverDetails = (Map<String, String>) selectedDriver;
                System.out.println(choice + " " + selectedDriverDetails.get("name") + " " + selectedDriverDetails.get("vehicleName") + " " + selectedDriverDetails.get("vehicleNumber")+ " " + selectedDriverDetails.get("age"));
                setDriverStatus(driversAvailable, selectedDriverDetails.get("name"), "false");
                System.out.println(driversAvailable);
            } else {
                System.out.println("Sorry! No rides available");
            }
            System.out.println("********* Thank you **********");
        }else{
            System.out.println("Sorry! No rides available");
        }
    }

    public void setDriverStatus(List<Map<String, String>> driversAvailable, String driverName, String newStatus) throws Exception {
//        List<Map<String, String>> filteredUsers = findPerson(driversAvailable,driverName);

        for (Map<String, String> driver : driversAvailable) {
            if (driverName.equals(driver.get("name"))) {
                driver.put("Available", newStatus);
            }
        }

       // System.out.println(driversAvailable);
    }


    public List<Map<String, String>> findPerson(List<Map<String, String>> personsAvailable,String personName){

        return personsAvailable.stream()
                .filter(user -> personName.equals(user.get("name").trim()))
                .collect(Collectors.toList());


    }
}
