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

public class Teachers implements Initializable {

    @FXML
    private TableColumn<TeacherClass, String> ColGen;

    @FXML
    private TableView<TeacherClass> TableViewer;

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
    private TableColumn<TeacherClass, Integer> colAge;

    @FXML
    private TableColumn<TeacherClass, Integer> colId;

    @FXML
    private TableColumn<TeacherClass, String> colName;

    @FXML
    private TableColumn<TeacherClass, String> colPhone;

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
    ObservableList<TeacherClass> list = FXCollections.observableArrayList();

    @FXML
    void TableViewAction(MouseEvent event) {
        TeacherClass s = TableViewer.getSelectionModel().getSelectedItem();
        txtname.setText(s.getName());
        txtid.setText(String.valueOf(s.getID()));
        txtgender.setText(s.getGender());
        txtphone.setText(s.getPhone());
        txtage.setText(String.valueOf(s.getAge()));
    }

    @FXML
    void deleteaction(ActionEvent event) throws SQLException {
        if (txtid.getText().equals("")) {

            Alert Al = new Alert(Alert.AlertType.ERROR);
            Al.setTitle("ERROR");
            Al.setContentText("Plz enter the correctally");
            Al.setHeaderText("sorry..........");
            Al.showAndWait();
        }
     else

    {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
        Statement st = conn.createStatement();
        st.executeUpdate("delete from teacher where TeID=" + txtid.getText() + " ");
        conn.close();
        masax();
        display();

    }

}
    @FXML
    void insertaction(ActionEvent event) throws SQLException {


        if(txtid.getText().equals("")&&txtname.getText().equals("")&&txtage.getText().equals("")&&txtgender.getText().equals("")&&txtphone.getText().equals("")) {
            Alert Al = new Alert(Alert.AlertType.ERROR);
            Al.setTitle("ERROR");
            Al.setContentText("Plz enter the correctally");
            Al.setHeaderText("sorry..........");
            Al.showAndWait();
        }
        else {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
            Statement st = conn.createStatement();
            st.executeUpdate("insert into teacher values(" + txtid.getText() + ",'" + txtname.getText() + "','" + txtgender.getText() + "'," + txtage.getText() + ",'" + txtphone.getText() + "')");
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
        search();
    }

    @FXML
    void updateaction(ActionEvent event) throws SQLException {
        if(txtid.getText().equals("")){
            Alert Al = new Alert(Alert.AlertType.ERROR);
            Al.setTitle("ERROR");
            Al.setContentText("Plz enter the correctally");
            Al.setHeaderText("sorry..........");
            Al.showAndWait();
        }else {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
            PreparedStatement pr = conn.prepareStatement("update teacher set TeName=?, Tegender=? ,Tephone=?, TeAge=? where TeID=?  ");

            pr.setString(1, txtname.getText());
            pr.setString(2, txtgender.getText());
            pr.setInt(3, Integer.parseInt(txtage.getText()));
            pr.setString(4, txtphone.getText());
            pr.setInt(5, Integer.parseInt(txtid.getText()));
            pr.executeUpdate();
            conn.close();
            masax();
            display();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.colName.setCellValueFactory(new PropertyValueFactory<TeacherClass,String>("Name"));
        this.colId.setCellValueFactory(new PropertyValueFactory<TeacherClass,Integer>("ID"));
        this.colAge.setCellValueFactory(new PropertyValueFactory<TeacherClass,Integer>("Age"));
        this.colPhone.setCellValueFactory(new PropertyValueFactory<TeacherClass,String>("Phone"));
        this.ColGen.setCellValueFactory(new PropertyValueFactory<TeacherClass,String>("Gender"));
        try {
            display();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.TableViewer.setItems(this.list);
    }

    void display() throws SQLException {
        this.list.clear();
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
        Statement st=conn.createStatement();

        ResultSet rs=st.executeQuery("select * from teacher");
        while(rs.next()){
            this.list.add(new TeacherClass(rs.getString("TeName"),rs.getString("Tegender"),rs.getString("Tephone"),rs.getInt("TeID"),rs.getInt("TeAge")));
        }
        conn.close();
        st.close();
    }
    void masax(){
        txtid.setText("");
        txtgender.setText("");
        txtphone.setText("");
        txtname.setText("");
        txtage.setText("");
    }

    void search() throws SQLException {
        if(txtsearch.getText().equals("")){
            Alert Al = new Alert(Alert.AlertType.ERROR);
            Al.setTitle("ERROR");
            Al.setContentText("Plz enter the correctally");
            Al.setHeaderText("sorry..........");
            Al.showAndWait();
        }else {
            this.list.clear();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("select * from teacher  where TeID='" + txtsearch.getText() + "'");
            while (rs.next()) {
                this.list.add(new TeacherClass(rs.getString("TeName"), rs.getString("Tegender"), rs.getString("Tephone"), rs.getInt("TeID"), rs.getInt("TeAge")));
            }
            conn.close();
            st.close();
        }
    }

}
