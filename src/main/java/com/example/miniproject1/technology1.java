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


public class technology1 implements Initializable {
    @FXML
    private AnchorPane slider,slider1;
    @FXML
    private ImageView menu,menu1;
    @FXML
    private Button logout,help,home,next1,reg1,reg2,reg3,reg4,reg5,reg6,reg7,reg8,reg9,reg10,reg11,reg12,reg13,reg14,reg15,reg16;
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

    public void helppage(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("helpPage.fxml","Help");
    }
    public void nextpage1(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("technology2.fxml","technology Courses 2");
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
            h.setalert("CYBER SECURITY FOUNDATION");
        });
        reg2.setOnMouseClicked(mouseEvent -> {
            h.setalert("INTRODUCTION TO CYBER SECURITY");
        });
        reg3.setOnMouseClicked(mouseEvent -> {
            h.setalert("DIGITAL FORENSICS FOR CYBER PROFESSIONALS");
        });
        reg4.setOnMouseClicked(mouseEvent -> {
            h.setalert("CYBER SECURITY TERMINOLOGIES");
        });
        reg5.setOnMouseClicked(mouseEvent -> {
            h.setalert("WHAT IS IOT?");
        });
        reg6.setOnMouseClicked(mouseEvent -> {
            h.setalert("MASTERING IOT WITH ARDINO");
        });
        reg7.setOnMouseClicked(mouseEvent -> {
            h.setalert("SERVERLESS IOT SOLUTIONS");
        });
        reg8.setOnMouseClicked(mouseEvent -> {
            h.setalert("INGEST IOT DATA BY USING AZURE IOT HUB");
        });
        reg9.setOnMouseClicked(mouseEvent -> {
            h.setalert("UX WITH ARTIFICIAL INTELLIGENCE");
        });
        reg10.setOnMouseClicked(mouseEvent -> {
            h.setalert("ARTIFICIAL INTELLIGENCE IN A  NUTSHELL");
        });
        reg11.setOnMouseClicked(mouseEvent -> {
            h.setalert("MACHINE LEARNING");
        });
        reg12.setOnMouseClicked(mouseEvent -> {
            h.setalert("AWS MACHINE LEARNING SERVICE");
        });
        reg13.setOnMouseClicked(mouseEvent -> {
            h.setalert("INTRODUCTION TO DATA SCIENCE");
        });
        reg14.setOnMouseClicked(mouseEvent -> {
            h.setalert("PYTHON FOR DATA SCIENCE");
        });
        reg15.setOnMouseClicked(mouseEvent -> {
            h.setalert("DATA SCIENCE TOOLS");
        });
        reg16.setOnMouseClicked(mouseEvent -> {
            h.setalert("JUPYTER FOR DATA SCIENCE");
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
