package com.example.cab;

import com.example.cab.Service.DriverService;
import com.example.cab.Service.FindRide;
import com.example.cab.Service.OnboardService;
import com.example.cab.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Starter {

    @Autowired
    private UserService userService;

    @Autowired
    private OnboardService onboardService;


    @Autowired
    private DriverService driverService;

    @Autowired
    private FindRide findRide;


     public void begin() {



             while (true) {

                 try {
                 System.out.println("Please Make a Choice");
                 Scanner sc = new Scanner(System.in);

                 System.out.println("Press 1: Register New  User ");
                 System.out.println("Press 2: Onboard  Driver ");
                 System.out.println("Press 3: Book a ride!! ");
                 int choice = sc.nextInt();
                 sc.nextLine();

                 switch (choice) {

                     case 1:
                         System.out.println("please enter user details in following format \"name,gender,age\" ");
                         String userDataInput = sc.nextLine();
                         try {
                             userService.setUserEntity(userDataInput);
                         } catch (Exception e) {
                             System.out.println("Please Provide valid input");
                         }
                         break;

                     case 2:
                         System.out.println("please enter Driver details in following format \"name,gender,age\",\"carName,carNumber\",\"Location\" ");
                         String driverDataInput = sc.nextLine();
                         try {
                             driverService.getParseInput(driverDataInput, true);
                         } catch (Exception e) {
                             System.out.println("Please Provide valid input");
                         }
                         break;

                     case 3:
                         System.out.println("Book a Ride provide details in following format “name” ,(0,0),(20,1)");
                         String userData = sc.nextLine();
                         try {
                             findRide.findRide(userData);
                         } catch (Exception e) {
                             System.out.println("Please Provide valid input");
                         }
                         break;


                     default:
                         System.out.println("Invalid input,Please make a Valid Choice");


                 }
                 }catch (Exception e){
                     System.out.println("Invalid Input");


             }


         }
     }


}
