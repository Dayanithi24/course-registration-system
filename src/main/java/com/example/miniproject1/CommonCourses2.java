package com.example.miniproject1;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;


public class CommonCourses2 implements Initializable {
    @FXML
    private AnchorPane slider,slider1;
    @FXML
    private ImageView menu,menu1;
    @FXML
    private Button logout,help,home,prev,reg1,reg2,reg3,reg4,reg5,reg6,reg7,reg8,reg9,reg10,reg11,reg12,reg13,reg14,reg15,reg16;
    @FXML
    private Label l1;

    private String sname;
    public void setuser()
    {
        dbutils db=new dbutils();
        sname=db.getname();
        l1.setText("Hi "+sname+"!");
    }

    public void logoutpage(ActionEvent event) throws IOException {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log Out");
        alert.setHeaderText("Are you sure?");
        ButtonType yes=new ButtonType("Yes");
        ButtonType no=new ButtonType("No");
        alert.getButtonTypes().setAll(yes,no);
        Optional<ButtonType> clcked=alert.showAndWait();
        if(clcked.isPresent()&&clcked.get()==yes) {
            Main m = new Main();
            m.changeScene("IntroPage.fxml", "IntroPage");
        }
    }
    public void prevpage(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("CommonCourses.fxml","Common Courses");
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setuser();
        HomePage h=new HomePage();
        reg1.setOnMouseClicked(mouseEvent -> {
            h.setalert("JAVASCRIPT: INTRODUCTION");
        });
        reg2.setOnMouseClicked(mouseEvent -> {
            h.setalert("JAVASCRIPT HIGH PERFORMANCE");
        });
        reg3.setOnMouseClicked(mouseEvent -> {
            h.setalert("BUILD AN INTERACTIVE BIRD FLYING GAME USING JAVASCRIPT DOM");
        });
        reg4.setOnMouseClicked(mouseEvent -> {
            h.setalert("JAVASCRIPT FETCH AND PROMISE");
        });
        reg5.setOnMouseClicked(mouseEvent -> {
            h.setalert("MYSQL: QUERYING DATA");
        });
        reg6.setOnMouseClicked(mouseEvent -> {
            h.setalert("ORACLE SQL");
        });
        reg7.setOnMouseClicked(mouseEvent -> {
            h.setalert("WORKING WITH SQL POWERSHELL");
        });
        reg8.setOnMouseClicked(mouseEvent -> {
            h.setalert("AZURE SQL DATABASE");
        });
        reg9.setOnMouseClicked(mouseEvent -> {
            h.setalert("WORKING WITH GITHUB");
        });
        reg10.setOnMouseClicked(mouseEvent -> {
            h.setalert("VERSION CONTROL WITH GIT AND GITHUB");
        });
        reg11.setOnMouseClicked(mouseEvent -> {
            h.setalert("MASTERING GIT AND GITHUB - A PRACTICAL BOOTCAMP FOR BEGINNERS");
        });
        reg12.setOnMouseClicked(mouseEvent -> {
            h.setalert("COMPLETE GIT AND GITHUB MASTERCLASS : BEGINNER TO GIT EXPERT");
        });
        reg13.setOnMouseClicked(mouseEvent -> {
            h.setalert("BUSINESS ENGLISH: MANAGEMENT AND LEADERSHIP");
        });
        reg14.setOnMouseClicked(mouseEvent -> {
            h.setalert("ENGLISH FOR EFFECTIVE BUSINESS SPEAKING");
        });
        reg15.setOnMouseClicked(mouseEvent -> {
            h.setalert("BUSINESS COMMUNICATION EXCELLENCE PROGRAM –LEARNSHIP");
        });
        reg16.setOnMouseClicked(mouseEvent -> {
            h.setalert("PROJECT: WRITING A RESEARCH PAPER");
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
    }
}
