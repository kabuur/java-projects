package com.example.school;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Users implements Initializable {

    @FXML
    private TableView<userClass> TableViewer;

    @FXML
    private Button btndelete;

    @FXML
    private Button btninsert;

    @FXML
    private Button btnrefresh;

    @FXML
    private Button btnsearch;

    @FXML
    private Button btnupdate;

    @FXML
    private TableColumn<userClass, Integer> colId;

    @FXML
    private TableColumn<userClass, String> colName;

    @FXML
    private TableColumn<userClass, String> colPassword;

    @FXML
    private TableColumn<userClass, String> colRole;

    @FXML
    private TextField txtRole;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtpassword;
        ObservableList<userClass>  list= FXCollections.observableArrayList();
    @FXML
    private TextField txtsearch;

    @FXML
    void TableViewAction(MouseEvent event) {
        userClass use=TableViewer.getSelectionModel().getSelectedItem();
        txtname.setText(use.getUserName());
        txtid.setText(String.valueOf(use.getUserID()));
        txtpassword.setText(use.getUserPassword());
        txtRole.setText(use.getUserRole());
    }

    @FXML
    void deleteaction(ActionEvent event) throws SQLException {
        if(txtid.getText().equals("")){
            Alert Al = new Alert(Alert.AlertType.ERROR);
            Al.setTitle("ERROR");
            Al.setContentText("Plz enter the id you want to delete");
            Al.setHeaderText("sorry..........");
            Al.showAndWait();
        }
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
        Statement st=conn.createStatement();
        st.executeUpdate("delete from user where UId="+txtid.getText()+" ");
        conn.close();

        display();
        clean();


        clean();

    }

    @FXML
    void insertaction(ActionEvent event) throws SQLException {
        if(txtid.getText().equals("")&&txtpassword.getText().equals("")&&txtname.getText().equals("")&&txtRole.getText().equals("")){
            Alert Al = new Alert(Alert.AlertType.ERROR);
            Al.setTitle("ERROR");
            Al.setContentText("Plz enter the correctally");
            Al.setHeaderText("sorry..........");
            Al.showAndWait();
        }
        else {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
            Statement st = conn.createStatement();
            st.executeUpdate("insert into user values(" + txtid.getText() + ",'" + txtname.getText() + "','" + txtpassword.getText() + "','" + txtRole.getText() + "')");
            conn.close();
            display();
            clean();
        }

    }

    @FXML
    void refreshaction(ActionEvent event) throws SQLException {
        display();

    }

    @FXML
    void searchaction(ActionEvent event) throws SQLException {
        if(txtsearch.getText().equals("")){
            Alert Al = new Alert(Alert.AlertType.ERROR);
            Al.setTitle("ERROR");
            Al.setContentText("Plz enter the you want to update");
            Al.setHeaderText("sorry..........");
            Al.showAndWait();
        }else {
        this.list.clear();
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
        Statement st=conn.createStatement();

        ResultSet rs=st.executeQuery("select * from user where UId="+txtsearch.getText()+" ");
        while(rs.next()){
            this.list.add(new userClass(rs.getString("UName"), rs.getString("UPassword"),rs.getString("URoll"),rs.getInt("UId") ));
        }
        conn.close();
        st.close();
        TableViewer.setItems(this.list);
        txtsearch.setText("");}

    }

    @FXML
    void updateaction(ActionEvent event) throws SQLException {

        if(txtid.getText().equals("")){
            Alert Al = new Alert(Alert.AlertType.ERROR);
            Al.setTitle("ERROR");
            Al.setContentText("Plz enter the The ID you wnat to update");
            Al.setHeaderText("sorry..........");
            Al.showAndWait();
        }
        else {
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
        PreparedStatement pr= conn.prepareStatement("update user set UName=?, UPassword=? ,URoll=? where UId=?");

        pr.setString(1,txtname.getText());
        pr.setString(2,txtpassword.getText());

        pr.setString(3,txtRole.getText());
        pr.setInt(4, Integer.parseInt(txtid.getText()));
        pr.executeUpdate();
        conn.close();
        display();

        clean();
        }

    }
    void display() throws SQLException {
        this.list.clear();
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
        Statement st=conn.createStatement();

        ResultSet rs=st.executeQuery("select * from user");
        while(rs.next()){
            this.list.add(new userClass(rs.getString("UName"), rs.getString("UPassword"),rs.getString("URoll"),rs.getInt("UId") ));
        }
        conn.close();
        st.close();
        TableViewer.setItems(this.list);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<userClass,Integer>("UserID"));
        colName.setCellValueFactory(new PropertyValueFactory<userClass,String>("UserName"));
        colPassword.setCellValueFactory(new PropertyValueFactory<userClass,String>("UserPassword"));
        colRole.setCellValueFactory(new PropertyValueFactory<userClass,String>("UserRole"));
        try {
            display();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
    void clean() {

        txtid.setText("");
        txtname.setText("");
        txtpassword.setText("");
        txtRole.setText("");
    }
}
