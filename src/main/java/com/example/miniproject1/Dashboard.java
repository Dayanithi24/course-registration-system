package com.example.miniproject1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {
    @FXML
    private Label l1,l2,no;
    @FXML
    private ListView<String> list;
    private String sname;

    public void setuser()
    {
        dbutils db=new dbutils();
        sname=db.getname();
        l1.setText(sname);
    }
    public void logoutpage(ActionEvent event) throws IOException {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Are you sure?");
        alert.setTitle("Log Out");
        ButtonType yes=new ButtonType("Yes");
        ButtonType no=new ButtonType("No");
        alert.getButtonTypes().setAll(yes,no);
        Optional<ButtonType> clcked=alert.showAndWait();
        if(clcked.isPresent()&&clcked.get()==yes) {
            Main m = new Main();
            m.changeScene("IntroPage.fxml", "IntroPage");
        }
    }

    public void helppage(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("helpPage.fxml","Help");
    }

    public void homepage(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("HomePage.fxml","HomePage");
    }
    public void getdetails(){
        Connection conn=null;
        PreparedStatement psget=null,psget1=null;
        ResultSet result=null,result1=null;
        try {
            int c=0;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx-project", "root", "Daya@1224");
            psget = conn.prepareStatement("SELECT course_name FROM registration WHERE username=?");
            psget.setString(1, sname);
            result = psget.executeQuery();
            ObservableList<String> list1 = FXCollections.observableArrayList();
            while (result.next()) {
                //System.out.println(result.getString("course_name"));
                list1.add(result.getString("course_name"));
                list.getItems().addAll(result.getString("course_name"));
                c++;
            }
           // System.out.println(list1);
            no.setText(String.valueOf(c));
            psget1=conn.prepareStatement("SELECT email FROM users WHERE username=?");
            psget1.setString(1,sname);
            result1=psget1.executeQuery();
            if(result1.next())
            l2.setText(result1.getString("email"));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setuser();
        getdetails();
    }
}
