package com.example.miniproject1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.awt.event.KeyEvent;
import java.lang.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUp implements Initializable {
    @FXML
    private Button SignUp;
    @FXML
    private Hyperlink login;
    @FXML
    private PasswordField pw1,pw2;
    @FXML
    private TextField mail,mobile,name;
    @FXML
    private ImageView back;
    @FXML
    private Label label;
    public void signuppage1(ActionEvent event) throws IOException{
        Main m=new Main();
        m.changeScene("SignInLight.fxml","Sign In");
    }
    public void check()throws IOException{
        if(name.getText().isEmpty()||mobile.getText().isEmpty()||mail.getText().isEmpty()||pw1.getText().isEmpty()||pw2.getText().isEmpty())
        {
            label.setText("*All credentials are required");
        } else if (mobile.getText().length()!=10) {
            label.setText("*Invalid Mobile Number");
        } else if (!(mail.getText().endsWith("@gmail.com")||mail.getText().endsWith("@kongu.edu")||mail.getText().endsWith("@outlook.com"))) {
            label.setText("*Invalid Email");
        } else if (!(pw1.getText().equals(pw2.getText()))) {
            label.setText("*Password doesn't match");
        } else if (mobile.getText().length()==10) {
            try{
                long a=Long.parseLong(mobile.getText());
                dbutils.signuppage(name.getText(),pw2.getText(),mail.getText(),mobile.getText());
            }
            catch(Exception e)
            {
                label.setText("*Invalid Mobile Number");
            }
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
