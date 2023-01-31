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


public class technology2 implements Initializable {
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
    public void prevpage(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("technology1.fxml","technology Courses 1");
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
            h.setalert("INTRODUCTION TO MIXED REALITY");
        });
        reg2.setOnMouseClicked(mouseEvent -> {
            h.setalert("INTRODUCTION TO AUGMENTED REALITY");
        });
        reg3.setOnMouseClicked(mouseEvent -> {
            h.setalert("SET UP A MIXED REALITY PROJECT IN UNITY WITH THE MIXED REALITY TOOL KIT");
        });
        reg4.setOnMouseClicked(mouseEvent -> {
            h.setalert("IOS AUGUMENTED REALITY IN ARKIT_CODE");
        });
        reg5.setOnMouseClicked(mouseEvent -> {
            h.setalert("ETHEREUM BLOCK CHAIN");
        });
        reg6.setOnMouseClicked(mouseEvent -> {
            h.setalert("WHAT IS BLOCK CHAIN?");
        });
        reg7.setOnMouseClicked(mouseEvent -> {
            h.setalert("BLOCK CHAIN 201 - BLOCK CHAIN IN DEPTH");
        });
        reg8.setOnMouseClicked(mouseEvent -> {
            h.setalert("INVESTING IN CRYPTO CURRENCIES");
        });
        reg9.setOnMouseClicked(mouseEvent -> {
            h.setalert("AZURE DEVOPS");
        });
        reg10.setOnMouseClicked(mouseEvent -> {
            h.setalert("DEVOPS FUNDAMENTALS");
        });
        reg11.setOnMouseClicked(mouseEvent -> {
            h.setalert("MASTERING DEVOPS");
        });
        reg12.setOnMouseClicked(mouseEvent -> {
            h.setalert("MASTERING PUPPET THE DEVOPS WAY BY SCHOOL OF DEVOPS");
        });
        reg13.setOnMouseClicked(mouseEvent -> {
            h.setalert("INTRODUCTION TO UI/UX");
        });
        reg14.setOnMouseClicked(mouseEvent -> {
            h.setalert("UI/UX FOR CHAT BOTS ANF ALL VOICE INTERFACE AI’S");
        });
        reg15.setOnMouseClicked(mouseEvent -> {
            h.setalert("UI/UX FUNDAMENTALS TO ADVANCED");
        });
        reg16.setOnMouseClicked(mouseEvent -> {
            h.setalert("CREATE YOUR UI/UX PORTFOLIOS WITH GITHUB");
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
