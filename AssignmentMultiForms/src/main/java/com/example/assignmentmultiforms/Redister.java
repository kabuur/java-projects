package com.example.assignmentmultiforms;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Redister {

    @FXML
    private Button btnLogOut;

    @FXML
    void LogOutAction(ActionEvent event) throws IOException {


        HelloApplication Main=new HelloApplication();
        Stage Stage=new Stage();
        Main.start(Stage);
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

};
