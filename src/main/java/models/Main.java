package models;


import models.model.ClassSignup;
import models.model.UserSignup;
import models.model.UserAttendance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection connection = DBConfig.connect();
        DBConfig db = new DBConfig();
        UserSignup us = new UserSignup();
        UserAttendance ua = new UserAttendance();
        ClassSignup cs = new ClassSignup();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter you username: ");
        String email = sc.next();

        System.out.println("Enter you Password: ");
        String password = sc.next();


        if (email.equalsIgnoreCase("admin") && (password.equalsIgnoreCase("superadmin"))) {
            while (true) {


                System.out.println("Choose an option : ");
                System.out.println("1. Add Classes");
                System.out.println("2. Add Users");
                System.out.println("3. Attendance");
                System.out.println("4. View Attendance");



                String opt = sc.next();
                if (opt.equals("2")) {
                    us.Signup_User();
                    db.insert_user(connection, us.getName(), us.getPassword());
                }else if (opt.equals("1")) {
                    cs.signup_class();;
                   db.insert_class(connection,cs.getName());
                } else if (opt.equals("3")) {
                    ua.do_attendance();
                    db.insert_attendance(connection,ua.getClassId(), ua.getUserId(), ua.getStatus(), ua.getDate() );
                }
                else if(opt.equals("4")){
                    Scanner day =new Scanner(System.in);
                    System.out.println("Enter date dd/mm");
                    String date = day.next();
                    db.displayList(connection,date);



                }



            }

        }
        else{
            System.out.println("Wrong credentials!");
        }
    }
}
