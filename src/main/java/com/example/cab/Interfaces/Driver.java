package com.example.cab.Interfaces;

import java.util.List;
import java.util.Map;

public interface Driver {
     void getParseInput(String input, boolean isAvailable) throws Exception;
     List<Map<String,String>> getDrivers();
     void addDriver(Map<String,String> driver);
}
