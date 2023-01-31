package com.example.miniproject1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import org.jetbrains.annotations.NotNull;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignInLight implements Initializable {
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
    private Hyperlink Signup;
    @FXML
    private ImageView back;

    public String name;
    public void userLogin(ActionEvent event)throws IOException{
        checklogin();
    }
    public void SignUpPage(ActionEvent event)throws IOException{
        Main m=new Main();
        m.changeScene("SignUp.fxml","SignUp");
    }

    private void checklogin()throws IOException{

        Main m=new Main();
        if(!username.getText().isEmpty() && !password.getText().isEmpty())
        {
            name= username.getText();
            dbutils.LoginUser(username.getText(),password.getText());
        }
        else if(username.getText().isEmpty() && password.getText().isEmpty())
        {
            wronguser1.setText("*Username is required");
            wronguser2.setText("*Password is required");
        }
        else if(username.getText().isEmpty())
        {
            wronguser1.setText("*Username is required");
            wronguser2.setText(null);
        }
        else if (password.getText().isEmpty()) {
            wronguser2.setText("*Password is required");
            wronguser1.setText(null);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        back.setOnMouseClicked(event ->{
            try{
            Main m=new Main();
            m.changeScene("IntroPage.fxml","IntroPage");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        });
    }
}
