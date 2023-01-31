package com.example.miniproject1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class IntroPage {
    @FXML
    private Button login,signup;

    public void loginpage(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("SignInLight.fxml","SignIn");
    }
    public void signuppage(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("SignUp.fxml","SignUp");
    }
}
