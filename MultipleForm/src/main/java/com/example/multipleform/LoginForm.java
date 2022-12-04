package com.example.multipleform;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginForm {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtPassword;

    @FXML

    void Login(ActionEvent event) throws IOException {

       Pane root = FXMLLoader.load(Dashboad.class.getResource("Dashboad.fxml"));
        Scene Scene=new Scene(root);
        Stage Stage=new Stage();
        Stage.setTitle("Dashboad");
        Stage.setScene(Scene);
        Stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

}
