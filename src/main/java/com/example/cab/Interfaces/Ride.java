package com.example.cab.Interfaces;

import java.util.List;
import java.util.Map;

public interface Ride {
     void checkRideAvailability() throws Exception;
     void askRideSelection(List<Map<String,String>> driversAvailable) throws Exception;
     void setDriverStatus(List<Map<String, String>> driversAvailable, String driverName, String newStatus) throws Exception;

}
