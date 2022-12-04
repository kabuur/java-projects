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
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class Dbd implements Initializable {

    @FXML
    private Button btnGetdata;

    @FXML
    private TextField txtID;

    @FXML
    private TableColumn<Emp, String> colName;

    @FXML
    private TextField txtName;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField txtAge;

    @FXML
    private TableColumn<Emp, Integer> ColAge;

    @FXML
    private TableView<Emp> TableView;

    @FXML
    private TableColumn<Emp, Integer> ColID;
    ObservableList<Emp> list= FXCollections.observableArrayList();



    @FXML
    void getdataAction(ActionEvent event) {

        list=TableView.getSelectionModel().getSelectedItems();
        txtName.setText(((Emp)list.get(0)).getName());
        txtID.setText(String.valueOf(((Emp)list.get(0)).getId()));
        txtAge.setText(String.valueOf(((Emp)list.get(0)).getAge()));

    }
    @FXML
    void insertAction(ActionEvent event) throws SQLException {

        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ca197", "root", "");
        Statement st=conn.createStatement();
        st.executeUpdate("insert into ca197 values('"+txtName.getText()+"',"+txtID.getText()+","+txtAge.getText()+")");
        st.close();
        conn.close();
        clear();
        display();

    }

    @FXML
    void updateAction(ActionEvent event) throws SQLException {
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ca197", "root", "");

       PreparedStatement ps=conn.prepareStatement("update ca197 set Name=?,Age=? where Id=? ");
       ps.setString(1,txtName.getText());
       ps.setInt(2,Integer.parseInt(txtAge.getText()));
       ps.setInt(3,Integer.parseInt(txtID.getText()));
        clear();
        display();




    }

    @FXML
    void DeleteAction(ActionEvent event) throws SQLException {

        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ca197", "root", "");
        PreparedStatement ps=conn.prepareStatement("delete ca197  where Id=? ");
        ps.setInt(1,Integer.parseInt(txtID.getText()));
        ps.executeUpdate();
        conn.close();
        clear();
        display();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {


        try {
            display();


            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }






    }

    public void display() throws SQLException {

        this.colName.setCellValueFactory (new PropertyValueFactory<Emp,String>("Name"));
        this.ColID.setCellValueFactory(new PropertyValueFactory<Emp,Integer>("Id"));
        this.ColAge.setCellValueFactory(new PropertyValueFactory<Emp,Integer>("Age"));
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ca197", "root", "" );
        Statement st=con.createStatement();
        ResultSet rs= st.executeQuery("select * from ca197");
        while(rs.next()){
            this.list.add(new Emp( rs.getString("Name"),rs.getInt("Id"), rs.getInt("Age")));

        }
        this.TableView.setItems(this.list);
        clear();

    }
    void clear(){
        txtName.setText("");
        txtAge.setText("");
        txtID.setText("");
    }
}
