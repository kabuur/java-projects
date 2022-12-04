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

public class Students implements Initializable {
    Integer ID;
    @FXML
    private TableColumn<StudentClass,String> ColGen;

    @FXML
    private TableView<StudentClass> TableViewer;

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
    private TableColumn<StudentClass, Integer> colAge;

    @FXML
    private TableColumn<StudentClass,Integer> colId;

    @FXML
    private TableColumn<StudentClass, String> colName;

    @FXML
    private TableColumn<StudentClass,String> colPhone;

    @FXML
    private TextField txtage;

    @FXML
    private TextField txtgender;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtphone;

    @FXML
    private TextField txtsearch;
    ObservableList<StudentClass> list= FXCollections.observableArrayList();
    @FXML
    void TableViewAction(MouseEvent event) {
        StudentClass s=TableViewer.getSelectionModel().getSelectedItem();
        txtname.setText(s.getName());
        txtid.setText(String.valueOf(s.getID()));
        txtgender.setText(s.getGender());
        txtphone.setText(s.getPhone());
        txtage.setText(String.valueOf(s.getAge()));





    }

    @FXML
    void deleteaction(ActionEvent event) throws SQLException {
        if(txtid.getText().equals("")) {


            Alert Al = new Alert(Alert.AlertType.ERROR);
            Al.setTitle("ERROR");
            Al.setContentText("Plz enter the correctally");
            Al.setHeaderText("sorry..........");
            Al.showAndWait();
        }else {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
            Statement st = conn.createStatement();
            st.executeUpdate("delete from Student where StdID=" + txtid.getText() + " ");
            conn.close();
            masax();
            display();

        }

    }

    @FXML
    void insertaction(ActionEvent event) throws SQLException {
        if(txtid.getText().equals("")&&txtname.getText().equals("")&&txtage.getText().equals("")&&txtgender.getText().equals("")&&txtphone.getText().equals("")){
            Alert Al =new Alert(Alert.AlertType.ERROR);
            Al.setTitle("ERROR");
            Al.setContentText("Plz enter the correctally");
            Al.setHeaderText("sorry..........");
            Al.showAndWait();
        }else {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
            Statement st = conn.createStatement();
            st.executeUpdate("insert into Student values(" + txtid.getText() + ",'" + txtname.getText() + "','" + txtgender.getText() + "'," + txtage.getText() + ",'" + txtphone.getText() + "')");
            conn.close();
            display();
            masax();
        }
    }

    @FXML
    void refreshaction(ActionEvent event) throws SQLException {
        display();
    }

    @FXML
    void searchaction(ActionEvent event) throws SQLException {

        try {
            search();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void updateaction(ActionEvent event) throws SQLException {
        if(txtid.getText().equals("")){
            Alert Al =new Alert(Alert.AlertType.ERROR);
            Al.setTitle("ERROR");
            Al.setContentText("Plz enter the ID you want to Update");
            Al.setHeaderText("sorry...........");
            Al.showAndWait();
        }
        else { Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
            PreparedStatement pr= conn.prepareStatement("update Student set StdName=?, StdGender=? ,StdAge=?, StdPhone=? where StdID=?  ");

            pr.setString(1,txtname.getText());
            pr.setString(2,txtgender.getText());
            pr.setInt(3, Integer.parseInt(txtage.getText()));
            pr.setString(4,txtphone.getText());
            pr.setInt(5, Integer.parseInt(txtid.getText()));
            pr.executeUpdate();
            conn.close();
            masax();
            display();}


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.colName.setCellValueFactory(new PropertyValueFactory<StudentClass,String>("Name"));
        this.colId.setCellValueFactory(new PropertyValueFactory<StudentClass,Integer>("ID"));
       this.colAge.setCellValueFactory(new PropertyValueFactory<StudentClass,Integer>("Age"));
        this.colPhone.setCellValueFactory(new PropertyValueFactory<StudentClass,String>("Phone"));
        this.ColGen.setCellValueFactory(new PropertyValueFactory<StudentClass,String>("Gender"));
        try {
            display();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.TableViewer.setItems(this.list);
    }

   void masax(){
        txtid.setText("");
        txtgender.setText("");
        txtphone.setText("");
        txtname.setText("");
        txtage.setText("");
   }
    void display() throws SQLException {
        this.list.clear();
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
        Statement st=conn.createStatement();

        ResultSet rs=st.executeQuery("select * from Student");
        while(rs.next()){
           this.list.add(new StudentClass(rs.getString("StdName"), rs.getString("StdGender"),rs.getString("StdPhone"),rs.getInt("StdID"),rs.getInt("StdAge") ));
        }
        conn.close();
        st.close();
    }

   void search() throws SQLException {
        if(txtsearch.getText().equals("")){
            Alert Al =new Alert(Alert.AlertType.ERROR);
            Al.setTitle("ERROR");
            Al.setContentText("Plz enter the ID you want to Search");
            Al.setHeaderText("wellcome");
            Al.showAndWait();

        }else {
            this.list.clear();
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
            Statement st=conn.createStatement();

            ResultSet rs=st.executeQuery("select * from Student where StdID='"+txtsearch.getText()+"' ");
            while(rs.next()){
                this.list.add(new StudentClass(rs.getString("StdName"), rs.getString("StdGender"),rs.getString("StdPhone"),rs.getInt("StdID"),rs.getInt("StdAge") ));
            }
            conn.close();
            st.close();
            this.TableViewer.setItems(this.list);}

   }

}

