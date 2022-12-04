package com.example.dbdtry;



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

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class NewDb implements Initializable {

    @FXML
    private Button Delete;

    @FXML
    private Button Display;

    @FXML
    private Button Insert;

    @FXML
    private Button Update;

    @FXML
    private TableColumn<newClass, Integer> colAge;

    @FXML
    private TableColumn<newClass, Integer> colID;

    @FXML
    private TableColumn<newClass, String> colName;

    @FXML
    private TableView<newClass> tableView;

    @FXML
    private TextField txtage;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;
Integer ID;
    @FXML
    ObservableList<newClass> list= FXCollections.observableArrayList();
    @FXML
    void DeleteAction(ActionEvent event) throws SQLException {
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ca197", "root", "");
        Statement st= conn.createStatement();


        st.executeUpdate("delete from ca197 where id ='"+txtid.getText()+" '");;
        conn.close();

        clear();


    }
    void clear(){
        txtage.setText("");
        txtid.setText("");
        txtname.setText("");
    }
    @FXML
    void DisplayActon(ActionEvent event) {
        this.list=tableView.getSelectionModel().getSelectedItems();
        this.ID=((newClass)list.get(0)).getId();
        txtname.setText(((newClass)list.get(0)).getName());
        txtid.setText(String.valueOf(((newClass)list.get(0)).getId()));
        txtage.setText(String.valueOf(((newClass)list.get(0)).getAge()));
    }

    @FXML
    void UpdateAction(ActionEvent event) {

    }

    @FXML
    void inserActio(ActionEvent event) throws SQLException {

        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ca197", "root", "");
        Statement st=conn.createStatement();
        st.executeUpdate("insert into ca197 values('"+txtname.getText()+"',"+txtid.getText()+","+txtage.getText()+") ");

        conn.close();st.close();
        Display();
        clear();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       this.colName.setCellValueFactory(new PropertyValueFactory <newClass,String>("Name"));
       this.colID.setCellValueFactory(new PropertyValueFactory<newClass,Integer>("Id"));
       this.colAge.setCellValueFactory(new PropertyValueFactory<newClass,Integer>("age"));
        try {
            Display();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    void Display() throws SQLException {
        this.list.clear();
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ca197", "root", "");
        Statement st=conn.createStatement();
        ResultSet sr=st.executeQuery("select * from ca197");

        while(sr.next()){
            this.list.add(new  newClass(sr.getString("Name"),sr.getInt("Id"),sr.getInt("Age")));
        }
        conn.close();
        st.close();
        this.tableView.setItems(this.list);

    }
}
