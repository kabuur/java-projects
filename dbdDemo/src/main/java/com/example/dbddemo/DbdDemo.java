package com.example.dbddemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

import java.net.URL;
import java.util.ResourceBundle;

public class DbdDemo implements Initializable {

    @FXML
    private TableView<Emp> TableEmp;

    @FXML
    private TextField txtid;

    @FXML
    private Button btnsave;

    @FXML
    private TableColumn<Emp, Integer> colAge;

    @FXML
    private TableColumn<Emp ,String> colName;

    @FXML
    private TextField txtname;

    @FXML
    private Button btnexit;

    @FXML
    private TextField txtage;

    @FXML
    private TableColumn<Emp, Integer> colId;

    ObservableList<Emp> list = FXCollections.observableArrayList();

    @FXML
    void saveAction(ActionEvent event) {

    }

    @FXML
    void exitAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.colId.setCellValueFactory(new PropertyValueFactory("ID"));
        this.colName.setCellValueFactory(new PropertyValueFactory("Name"));
        this.colAge.setCellValueFactory(new PropertyValueFactory("Age"));

        try {
            this.bindTableview();
        } catch (SQLException var4) {
            throw new RuntimeException(var4);
        }

        this.TableEmp.setItems(this.list);

    }

    void bindTableview() throws SQLException {
        this.list.clear();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ca197", "root", "");

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("select * from ca197");

        while(rs.next()) {
            this.list.add(new Emp( rs.getString("name"),rs.getInt("id"), rs.getInt("age")));
        }

        st.close();
        con.close();
    }
}
