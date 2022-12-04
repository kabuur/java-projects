package com.example.school;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Login {

    @FXML
    private TextField TxtUserPassword;

    @FXML
    private Button btnLogin;
    @FXML
    private Button btnExit;
    @FXML
    private TextField txtUserName;
    @FXML
    void ExitActio(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    void LoginActio(ActionEvent event) throws SQLException, IOException {
        if(txtUserName.getText().equals("")&&TxtUserPassword.getText().equals("")){
            Alert Al =new Alert(Alert.AlertType.ERROR);
            Al.setTitle("ERROR");
            Al.setContentText("Plz Enter the password or Username");
            Al.setHeaderText("sorry......");
            Al.showAndWait();
        }
        else {

            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select  UName,UPassword from user where UName='"+txtUserName.getText()+"' and UPassword= '"+TxtUserPassword.getText()+"' ");
            if(!rs.next()) {
                Alert Al = new Alert(Alert.AlertType.ERROR);
                Al.setTitle("ERROR");
                Al.setContentText("Plz correct your user name or password");
                Al.setHeaderText("sorry.......");
                Al.showAndWait();



                }
            else {
                Pane root = FXMLLoader.load(Dashboard.class.getResource("Dashboard.fxml"));
                Scene Scene = new Scene(root);
                Stage Stage = new Stage();
                Stage.setTitle("Dashboad");
                Stage.setScene(Scene);
                Stage.show();
                ((Node) (event.getSource())).getScene().getWindow().hide();
                }
            }






    }

}
