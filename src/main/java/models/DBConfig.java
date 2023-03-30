package models;


import models.model.AttendanceList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBConfig {
    public static final String name ="username";
    public static final String className="classname";
    public static final String status="status";

    public static Connection connect() {
        Connection connection = null;
        String databaseUrl = "jdbc:sqlite:src/main/resources/database/ams.db";
        try {
            connection = DriverManager.getConnection(databaseUrl);
            System.out.println("Connection Established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    public static void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insert_user(Connection connection, String name, String password) {
        String sql = "INSERT INTO user (name,password) VALUES(?,?)";
        PreparedStatement pstmt = null;
        try  {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);

            pstmt.setString(2, password);

            pstmt.executeUpdate();
            System.out.println("successful");



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            close(pstmt);
        }

    }

    public void insert_class(Connection connection, String name) {
        String sql = "INSERT INTO class (className) VALUES(?)";
        PreparedStatement pstmt = null;
        try  {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);



            pstmt.executeUpdate();
            System.out.println("successful");



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            close(pstmt);
        }

    }

    public  void displayList(Connection connection, String date){

        String sql="SELECT attendance.id, user.name, class.className FROM attendance JOIN user ON attendance.userid = user.id  JOIN class ON attendance.classid = class.id  WHERE attendance.date =?" ;

        List<AttendanceList> aList=new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            pstmt = connection.prepareStatement(sql);

            Statement statement= connection.createStatement();
            pstmt.setString(1, "5/12");
            rs=statement.executeQuery(sql);


            while(rs.next()){




                String userName = rs.getString("name");
                String className = rs.getString("className");


                System.out.println("User Name: " + userName);
                System.out.println("Class Name: " + className);
                System.out.println();

            }

        }catch (SQLException e){
            System.out.println("error");
            System.out.println(e.getMessage());
        } finally {
            close(pstmt);
        }


    }





    public void insert_attendance(Connection connection, int classId, int userId, String status, String date) {
        String sql = "INSERT INTO attendance (classId,userId,status,date) VALUES(?,?,?,?)";
        PreparedStatement pstmt = null;
        try  {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, classId);

            pstmt.setInt(2, userId);

            pstmt.setString(3, status);

            pstmt.setString(4, date);

            pstmt.executeUpdate();
            System.out.println("successful");



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            close(pstmt);
        }



    }

}
