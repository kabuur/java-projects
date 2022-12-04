package com.example.exponent;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class hello {

    @FXML
    private Label lbloutput;

    @FXML
    private TextField txtname;

    @FXML
    private Button hello;
    @FXML
    void OnActionHello(ActionEvent event) {



        String name=txtname.getText();
        lbloutput.setText("hello"+name);

    }

}
