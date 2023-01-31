package com.example.miniproject1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.sql.*;

public class dbutils {
    private static String name;
    public String getname(){
        return name;
    }
   public static void signuppage(String username,String password,String mail,String mobile){
       Connection conn=null;
       PreparedStatement psInsert=null;
       PreparedStatement psCheckUserExists=null;
       ResultSet resultSet=null;

       try{
           conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx-project","root","Daya@1224");
           psCheckUserExists=conn.prepareStatement("SELECT * FROM users WHERE username= ? ");
           psCheckUserExists.setString(1, username);
           resultSet=psCheckUserExists.executeQuery();

           if(resultSet.isBeforeFirst())
           {
               System.out.println("Username Already exists");
               Alert alert=new Alert(Alert.AlertType.ERROR);
               alert.setContentText("You cannot use this Username");
               alert.show();
           }
           else {
               psInsert=conn.prepareStatement("INSERT INTO users (username,password,email,mobile_no) VALUES (?, ?, ?, ?)");
               psInsert.setString(1,username);
               psInsert.setString(2,password);
               psInsert.setString(3,mail);
               psInsert.setString(4,mobile);
               psInsert.executeUpdate();

               Main m=new Main();
               m.changeScene("SignInLight.fxml","SignIn");
           }
       }
       catch(Exception e)
       {
            e.printStackTrace();
       }
       finally {
           if(resultSet!=null)
           {
               try{
               resultSet.close();
               }catch(Exception e)
               {
                   e.printStackTrace();
               }
           }
           if(psCheckUserExists!=null)
           {
               try{
                   psCheckUserExists.close();
               }catch(Exception e)
               {
                   e.printStackTrace();
               }
           }
           if(psInsert!=null)
           {
               try{
                   psInsert.close();
               }catch(Exception e)
               {
                   e.printStackTrace();
               }
           }
           if(conn!=null)
           {
               try{
                   conn.close();
               }catch(Exception e)
               {
                   e.printStackTrace();
               }
           }
       }
   }

   public static void LoginUser(String username,String password)
   {
       Connection conn=null;
       PreparedStatement psCheckUserExists=null;
       ResultSet resultSet=null;

       try {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx-project", "root", "Daya@1224");
           psCheckUserExists = conn.prepareStatement("SELECT password,email,mobile_no FROM users WHERE username= ? ");
           psCheckUserExists.setString(1, username);
           resultSet = psCheckUserExists.executeQuery();

           if (!resultSet.isBeforeFirst()) {
               System.out.println("Username Not Found");
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("Provided credentials are incorrect");
               alert.show();
           }else{
               while(resultSet.next()){
               String rpassword=resultSet.getString("password");
               String remail=resultSet.getString("email");
               String rmobile=resultSet.getString("mobile_no");

               if(rpassword.equals(password))
               {
                   name=username;
                   //System.out.println(name);
                   Main m=new Main();
                   m.changeScene("HomePage.fxml","HomePage");
               }
               else {
                   System.out.println("Password doesn't match");
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setContentText("Provided credentials are incorrect");
                   alert.show();
               }
               }
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       finally {
           if(resultSet!=null)
           {
               try{
                   resultSet.close();
               }catch(Exception e)
               {
                   e.printStackTrace();
               }
           }
           if(psCheckUserExists!=null) {
               try {
                   psCheckUserExists.close();
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
           if(conn!=null)
           {
               try{
                   conn.close();
               }catch(Exception e)
               {
                   e.printStackTrace();
               }
           }
       }
   }
}