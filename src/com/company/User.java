package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    enum UserType{
        Player,
        PlaygroundOwner,
        Administrator
    }
    private String name ;
    private static int ID = 0;
    private String email;
    private String password ;
    private int phone ;
    private String Default_location;
    private UserType user;
    ArrayList<Object> profile = new ArrayList<Object>();


    public void Register(){
      System.out.println("Choose user type:\n1.player \n2.playground owner \n3.Adminstrator\n");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if (choice==1){
            user =UserType.Player;
        }
        else if (choice==2){
            user =UserType.PlaygroundOwner;
        }
        else if(choice==3){
            user=UserType.Administrator;
        }
        else {
            System.out.println("invalid input");
        }


    }
    public void createProfile(){
        Scanner data=new Scanner(System.in);
        System.out.println("Enter name");
        name=data.next();
        profile.add(name);

        System.out.println("Enter email:");
        email=data.next();
        profile.add(email);

        System.out.println("Create a password");
        password=data.next();
        profile.add(password);

        System.out.println("Enter your phone number");
        phone=data.nextInt();
        profile.add(phone);

        System.out.println("Enter default location");
        Default_location=data.next();
        profile.add(Default_location);

       profile.add(user);
       profile.add(ID);

    }



}
