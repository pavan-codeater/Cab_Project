package com.example.cab.Interfaces;

import java.util.List;
import java.util.Map;

public interface User {
     List<Map<String,String>> getUsers();
     void addUser(Map<String,String> user);
    void setUserEntity(String userDataInput) throws Exception;

}
