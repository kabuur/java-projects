package com.example.multipleform;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboad {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnExit;
    @FXML
    private MenuItem AboutUS;

    @FXML
    void Alart(ActionEvent event) {
        Alert Al =new Alert(Alert.AlertType.ERROR);
        Al.setTitle("about US");
        Al.setContentText("We are software Engnering");
        Al.setHeaderText("wellcome");
        Al.showAndWait();

    }

    @FXML
    void exit(ActionEvent event)throws IOException {

        HelloApplication Main=new HelloApplication();
        Stage Stage=new Stage();
        Main.start(Stage);
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void login(ActionEvent event) {

    }

}
