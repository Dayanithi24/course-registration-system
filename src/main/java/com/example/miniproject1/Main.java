package com.example.miniproject1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Intropage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1540, 800);
        stage.setTitle("IntroPage");
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxml,String s)throws IOException{
        Parent pane=FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stg.getScene().setRoot(pane);
        stg.setTitle(s);
    }
    public static void main(String[] args) {
        launch();
    }
}