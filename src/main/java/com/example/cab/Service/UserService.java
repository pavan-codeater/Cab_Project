package com.example.cab.Service;

import com.example.cab.Entity.Person;
import com.example.cab.Enum.PersonType;
import com.example.cab.Interfaces.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements User {

    @Autowired
    private Person personEntity;

    @Autowired
   private OnboardService onboardService;

    List<Map<String,String>> users=new ArrayList<>();

   public List<Map<String,String>> getUsers(){
       return users;
   }

    public void addUser(Map<String,String> user){
        users.add(user);
        System.out.println("User Registration Successful");
    }

    public void setUserEntity(String userDataInput) throws Exception {

        String userDetails[]=userDataInput.replaceAll("[\"()“”]", "").split(",");

        personEntity.User_Initializer(userDetails[0].trim(),userDetails[1].trim(),Integer.parseInt(userDetails[2].trim()));
        onboardService.addUserParseUserData(PersonType.USER);
    }




}








