package com.example.miniproject1;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;


public class HomePage implements Initializable {
    @FXML
    private AnchorPane slider,slider1;
    @FXML
    private ImageView menu,menu1,next1,next2;
    @FXML
    private Button logout,help;
    @FXML
    private Label l1;
    @FXML
    private Hyperlink reg1,reg2,reg3,reg4,reg5,reg6;

    public String sname;

    public void setuser()
    {
        dbutils db=new dbutils();
        sname=db.getname();
        l1.setText("Hi "+sname+"!");
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
    public void dashboard(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("Dashboard.fxml","Dashboard");
    }
    public static void nextpage() throws IOException
    {
        Main m=new Main();
        m.changeScene("CommonCourses.fxml","Common Courses");
    }
    public static void nextpage2() throws IOException
    {
        Main m=new Main();
        m.changeScene("technology1.fxml","Technology Courses 1");
    }
    public void setalert(String message){
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Do you want to register this course?");
        alert.setContentText(message);
        ButtonType yes=new ButtonType("Yes");
        ButtonType no=new ButtonType("No");
        alert.getButtonTypes().setAll(yes,no);
        Optional<ButtonType> clcked=alert.showAndWait();
        LocalDate localDate=LocalDate.now();
        DateTimeFormatter sd=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalTime localtime=LocalTime.now();
        DateTimeFormatter sd1=DateTimeFormatter.ofPattern("hh:mm:ss a");
        if(clcked.isPresent()&&clcked.get()==yes) {
            Connection conn = null;
            PreparedStatement psInsert = null;
            ResultSet resultSet = null;
            PreparedStatement psCheckUserExists = null;
            try {
                boolean flag=true;
                dbutils db1=new dbutils();
                String name=db1.getname();
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx-project", "root", "Daya@1224");
                psCheckUserExists = conn.prepareStatement("SELECT course_name FROM registration WHERE username= ? ");
                psCheckUserExists.setString(1, name);
                resultSet = psCheckUserExists.executeQuery();
                while(resultSet.next()){
                if (resultSet.getString("course_name").equals(message)) {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setContentText("You have already registered this course");
                    alert1.show();
                    flag=false;
                    break;
                }
                }if(flag)
                {
                    psInsert = conn.prepareStatement("INSERT INTO registration (username,course_name,date,time) VALUES (?, ?, ?, ?)");
                    psInsert.setString(1, name);
                    psInsert.setString(2, message);
                    psInsert.setString(3, localDate.format(sd));
                    psInsert.setString(4, localtime.format(sd1));
                    psInsert.executeUpdate();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (psCheckUserExists != null) {
                    try {
                        psCheckUserExists.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (psInsert != null) {
                    try {
                        psInsert.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setuser();
        reg1.setOnMouseClicked(mouseEvent -> {
            setalert("FUNDAMENTAL OF THE C LANGUAGE: GETTING STARTED");
        });
        reg2.setOnMouseClicked(mouseEvent -> {
            setalert("JAVASCRIPT: INTRODUCTION");
        });
        reg3.setOnMouseClicked(mouseEvent -> {
            setalert("FRONTEND WEB DEVELOPMENT BOOTCAMP: BUILD A TWITTER CLONE");
        });
        reg4.setOnMouseClicked(mouseEvent -> {
            setalert("UX WITH ARTIFICIAL INTELLIGENCE");
        });
        reg5.setOnMouseClicked(mouseEvent -> {
            setalert("CYBER SECURITY FOUNDATION");
        });
        reg6.setOnMouseClicked(mouseEvent -> {
            setalert("AZURE DEVOPS");
        });
        slider.setTranslateX(-262);
        slider1.setTranslateX(-131);
        menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            TranslateTransition slide1 = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider1);

            slide1.setToX(0);
            slide.play();
            slide1.play();
            slider.setTranslateX(0);
            slider1.setTranslateX(0);
            slide.setOnFinished((ActionEvent e)-> {
                menu.setVisible(false);
                menu1.setVisible(true);
            });
            slide1.setOnFinished((ActionEvent e)-> {
                menu.setVisible(true);
                menu1.setVisible(false);
            });
        });

        menu1.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-131);
            TranslateTransition slide1 = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider1);

            slide1.setToX(0);
            slide.play();
            slide1.play();

            slider.setTranslateX(-262);
            slider1.setTranslateX(0);
            slide.setOnFinished((ActionEvent e)-> {
                menu.setVisible(true);
                menu1.setVisible(false);
            });
            slide1.setOnFinished((ActionEvent e)-> {
                menu.setVisible(false);
                menu1.setVisible(true);
            });
        });
        next1.setOnMouseClicked(event -> {
            try {
                HomePage.nextpage();
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        });
        next2.setOnMouseClicked(event -> {
            try {
                HomePage.nextpage2();
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        });
    }
}
