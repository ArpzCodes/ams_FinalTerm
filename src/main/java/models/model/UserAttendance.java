package models.model;

import java.sql.SQLOutput;
import java.util.Scanner;


public class UserAttendance {
    int id;
    int classId;
    int userId;

    String date;

    String status;

    public UserAttendance(int id, int classId, int userId, String status, String date) {
        this.id = id;
        this.classId = classId;
        this.userId = userId;
        this.date= date;
        this.status = status;
    }



    public UserAttendance(){

}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void do_attendance(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter user id: ");
        this.userId=sc.nextInt();
        System.out.println("Enter date");
        this.date= sc.next();
        System.out.println("Enter attendance status : present / absent");
        this.status= sc.next();

        System.out.println("Enter class id: ");
        this.classId=sc.nextInt();


    }

}
