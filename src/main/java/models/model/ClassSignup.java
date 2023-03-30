package models.model;

import java.util.Scanner;

public class ClassSignup {

    String name;



    public ClassSignup( String name) {

        this.name = name;


    }

    public ClassSignup() {

    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void signup_class(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Class Name: ");
        this.name=sc.nextLine();


    }
}
