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
import java.util.Optional;
import java.util.ResourceBundle;


public class helpPage implements Initializable {
    @FXML
    private AnchorPane slider,slider1;
    @FXML
    private ImageView menu,menu1;
    @FXML
    private Button logout,help,home;
    @FXML
    private TextArea t1;
    @FXML
    private Label l1;

    public void setuser()
    {
        dbutils db=new dbutils();
        String sname=db.getname();
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
    public void display(ActionEvent event) throws IOException{
        if(!t1.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Submitted Successfully");
            alert.show();
            t1.setText(null);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setuser();
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
