package com.example.dbdtry;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Testdb implements Initializable {

    @FXML
    private TableColumn<fetch, Integer> colAge;

    @FXML
    private TableColumn<fetch,Integer> colID;

    @FXML
    private TableColumn<fetch,String > colName;

    @FXML
    private TableView<fetch> tableV;

    @FXML
    private TextField txtage;

    @FXML
    private TextField txtid;
    @FXML
    private Button clickme;
    @FXML
    private TextField txtname;
    ObservableList<fetch> list= FXCollections.observableArrayList();
    @Override



    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.colName.setCellValueFactory (new PropertyValueFactory<fetch,String>("Name"));
        this.colID.setCellValueFactory(new PropertyValueFactory<fetch,Integer>("Id"));
        this.colAge.setCellValueFactory(new PropertyValueFactory<fetch,Integer>("Age"));
        try {
            display();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void clickOnActio(ActionEvent event) throws IOException {
      Pane root=  FXMLLoader.load(Dbd.class.getResource("dbd.fxml"));
        Scene scene=new Scene(root);
        Stage st =new Stage();
        st.setScene(scene);
        st.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();



    }
    void display() throws SQLException {
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ca197", "root", "");
        Statement st= conn.createStatement();

        ResultSet rs=st.executeQuery("select * from ca197");

        while(rs.next()){
            this.list.add(new fetch( rs.getString("Name"),rs.getInt("Id"), rs.getInt("Age")));

        }
        this.tableV.setItems(this.list);
    }
}

