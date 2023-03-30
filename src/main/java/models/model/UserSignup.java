package models.model;

import java.util.Scanner;

public class UserSignup {
    int id;
    String name;

    String password;

    public UserSignup(int id, String name, int contact, String email, String password) {
        this.id = id;
        this.name = name;

        this.password = password;
    }

    public UserSignup() {

    }

    public UserSignup(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void Signup_User(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Name: ");
        this.name=sc.nextLine();
        System.out.println("Enter Contact: ");
        System.out.println("Enter Password: ");
        this.password=sc.next();

    }
}
