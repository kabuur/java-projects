package com.example.school;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {



    @FXML
    private Button btnDashboard;
    @FXML
    private ImageView Img;
    @FXML
    private Button btnLock;

    @FXML
    private Label lblStudents;

    @FXML
    private Label lblTeachers;

    @FXML
    private Label lblusers;
    @FXML
    private Button btnTeachers;

    @FXML
    private Button btnUsers;


    @FXML
    private BorderPane borderpane;
    @FXML
    private Button btnstudent;
    @FXML
    private Button btnExit;
    @FXML
    void ExitAction(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    void DashboardAction(ActionEvent event) throws IOException {

        Pane root = FXMLLoader.load(Dashboard.class.getResource("Dashboard.fxml"));
        Scene Scene=new Scene(root);
        Stage Stage=new Stage();
        Stage.setTitle("Dashboad");
        Stage.setScene(Scene);
        Stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void LockAction(ActionEvent event) throws IOException {

        HelloApplication Main=new HelloApplication();
        Stage Stage=new Stage();
        Main.start(Stage);
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void TeachersAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("Teachers.fxml"));
        borderpane.setCenter(root);

    }

    @FXML
    void UsersAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("Users.fxml"));
        borderpane.setCenter(root);

    }



    @FXML
    void studentAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("Students.fxml"));
        borderpane.setCenter(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            CountingStudents();
            CountingUSERS();
            CountingTeachers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void  CountingStudents() throws SQLException {
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select count(*)  from student");
        rs.next();
        int u =rs.getInt(1);
        lblStudents.setText(String.valueOf(u));



    }

    void  CountingTeachers() throws SQLException {
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select count(*)  from teacher");
        rs.next();
        int u =rs.getInt(1);
        lblTeachers.setText(String.valueOf(u));



    }

    void  CountingUSERS() throws SQLException {
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select count(*)  from user");
        rs.next();
        int u =rs.getInt(1);
        lblusers.setText(String.valueOf(u));



    }
}
