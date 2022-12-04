package com.example.wellcome;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField txtname;

    @FXML
    private Label name;

    @FXML
    private Label lbloutbut;

    @FXML
    void click(ActionEvent event) {


        String name=txtname.getText();
        lbloutbut.setText("Hello: " +name);


    }

}
