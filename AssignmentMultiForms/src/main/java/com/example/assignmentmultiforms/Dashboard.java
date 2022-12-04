package com.example.assignmentmultiforms;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboard {

    @FXML
    private MenuItem menueRed;

    @FXML
    private Button BtnView;

    @FXML
    private MenuItem menueGreen;

    @FXML
    private MenuItem MenueAbout;

    @FXML
    private Button BtnReport;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnRgstr;

    @FXML
    void redAction(ActionEvent event) {
        btnExit.setTextFill(Color.RED);
        btnRgstr.setTextFill(Color.RED);
        BtnReport.setTextFill(Color.RED);
        BtnView.setTextFill(Color.RED);

    }

    @FXML
    void GreenAction(ActionEvent event) {
        btnExit.setTextFill(Color.GREEN);
        btnRgstr.setTextFill(Color.GREEN);
        BtnReport.setTextFill(Color.GREEN);
        BtnView.setTextFill(Color.GREEN);

    }

    @FXML
    void AboutAction(ActionEvent event) {
        Alert Al =new Alert(Alert.AlertType.ERROR);
        Al.setTitle("about US");
        Al.setContentText("we are management system");
        Al.setHeaderText("wellcome");
        Al.showAndWait();
    }

    @FXML
    void Rgst(ActionEvent event)throws IOException {
        Pane root = FXMLLoader.load(Redister.class.getResource("redister.fxml"));
        Scene Scene=new Scene(root);
        Stage Stage=new Stage();

        Stage.setScene(Scene);
        Stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void RportAction(ActionEvent event) throws IOException{

        Pane root = FXMLLoader.load(ReportForm.class.getResource("ReportForm.fxml"));
        Scene Scene=new Scene(root);
        Stage Stage=new Stage();

        Stage.setScene(Scene);
        Stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void ViewAction(ActionEvent event) throws IOException {
        Pane root = FXMLLoader.load(ViewForm.class.getResource("viewForm.fxml"));
        Scene Scene=new Scene(root);
        Stage Stage=new Stage();

        Stage.setScene(Scene);
        Stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void ExitAction(ActionEvent event) {
        System.exit(0);
    }

}
