package com.example.miniproject1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class login {
    public login()
    {

    }
    @FXML
    private Button login;
    @FXML
    private Label wronguser1;
    @FXML
    private Label wronguser2;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Hyperlink SignUp;

    public void userLogin(ActionEvent event)throws IOException{
        checklogin();
    }
    public void SignUpPage(ActionEvent event)throws IOException{
        Main m=new Main();
        m.changeScene("SignUp.fxml","SignUp");
    }
    private void checklogin()throws IOException{

        Main m=new Main();
        if(username.getText().isEmpty() && password.getText().isEmpty())
        {
            wronguser1.setText("Username is required");
            wronguser2.setText("Password is required");
        }
        else if(username.getText().isEmpty())
        {
            wronguser1.setText("Username is required");
        }
        else if (password.getText().isEmpty()) {
            wronguser2.setText("Password is required");
        }
    }
}
