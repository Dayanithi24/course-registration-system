package com.example.miniproject1;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;


public class newfx implements Initializable {
    @FXML
    private AnchorPane slider,slider1;
    @FXML
    private ImageView menu,menu1,next1,next2;
    @FXML
    private Button logout,help,home,set,dash;
    @FXML
    private Label l1;
    @FXML
    private TextField sbox;
    @FXML
    private ListView<String> list;

    ArrayList<String> words=new ArrayList<>(Arrays.asList("hey","hi"));

//    public void setuser(String name)
//    {
//        l1.setText("Welcome "+name);
//    }
//    public void logoutpage(ActionEvent event) throws IOException {
//        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setHeaderText("Are you sure?");
//        alert.setContentText("LOG OUT");
//        ButtonType yes=new ButtonType("Yes");
//        ButtonType no=new ButtonType("No");
//        alert.getButtonTypes().setAll(yes,no);
//        Optional<ButtonType> clcked=alert.showAndWait();
//        if(clcked.isPresent()&&clcked.get()==yes) {
//            Main m = new Main();
//            m.changeScene("IntroPage.fxml", "IntroPage");
//        }
//    }
//
//    public void helppage(ActionEvent event) throws IOException {
//        Main m=new Main();
//        m.changeScene("helpPage.fxml","Help");
//    }
//
//    public void homepage(ActionEvent event) throws IOException {
//        Main m=new Main();
//        m.changeScene("HomePage.fxml","HomePage");
//    }
//
//    public static void nextpage() throws IOException
//    {
//        Main m=new Main();
//        m.changeScene("CommonCourses.fxml","Common Courses");
//    }

    //https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqa0Z5UUFVZzZWbDZtR3p1ekxBUlJ1TWIwOHZnQXxBQ3Jtc0ttZEg1R1dKOHpwbHJpX0lfVnBiVUtuNWo4bmFUcllXS1VZQUw2SlJpeFpwQ1A4a21WVUp6bkU2RmhZRFdEaUZ5S3R0QzdPejZ5bEljY29ocDNCbEszb0ZXUXh3U3ZmZVVmWk9MSEg4eENNOHVvTDZ4RQ&q=https%3A%2F%2Fgithub.com%2FDJ-Raven%2Fjava-swing-search-suggestion.git&v=PjCzzJxSsLM
//    public void listadd() {
//        Connection conn=null;
//        PreparedStatement selectcourse=null;
//        ResultSet resultSet=null;
//        try{
//            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx-project","root","Daya@1224");
//            selectcourse=conn.prepareStatement("SELECT course_name FROM courses WHERE course_name LIKE '%?%'");
//            selectcourse.setString(1,sbox.getText());
//            resultSet=selectcourse.executeQuery();
//
//            while(resultSet.next()){
//                System.out.println(resultSet.getString("course_name"));
//            }
//            list.setItems(dataList);
//
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
    public void search(ActionEvent event){
        String s=sbox.getText().trim();
        if(!s.equals("")) {
            System.out.println(s);
        }
    }
    public void selectionchanged(ObservableValue<? extends String>observable,String oldval,String newval){
        ObservableList<String> selectedItems=list.getSelectionModel().getSelectedItems();
        String selected=selectedItems.toString();
        sbox.setText(selected);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list.setVisible(false);
        sbox.setOnMouseClicked(mouseEvent ->{
            list.setVisible(true);
            String[] words={"hey","hi","hello"};
            list.getItems().addAll(words);
            //list.getSelectionModel().selectedItemProperty().addListener(this::selectionchanged);
            //listadd();
                });
        LocalDate localDate=LocalDate.now();
        DateTimeFormatter sd=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(localDate.format(sd));
        LocalTime localtime=LocalTime.now();
        DateTimeFormatter sd1=DateTimeFormatter.ofPattern("hh:mm:ss a");
        System.out.println(localtime.format(sd1));
        slider.setTranslateX(-262);
        slider1.setTranslateX(-262);
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

            slide.setToX(-262);
            TranslateTransition slide1 = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider1);

            slide1.setToX(-262);
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
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.1),slider);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

        home.setOnMouseMoved(event ->{
            slider.setVisible(true);
            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.1),home);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(1);
            fadeTransition1.play();
        });
        dash.setOnMouseMoved(event ->{
            slider.setVisible(true);
            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.1),dash);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(1);
            fadeTransition1.play();
        });
        help.setOnMouseMoved(event ->{
            slider.setVisible(true);
            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.1),help);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(1);
            fadeTransition1.play();
        });
        set.setOnMouseMoved(event ->{
            slider.setVisible(true);
            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.1),set);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(1);
            fadeTransition1.play();

        });
//        next1.setOnMouseClicked(event -> {
//            try {
//                HomePage.nextpage();
//            }
//            catch (Exception e)
//            {
//                System.out.println(e);
//            }
//        });
    }
}