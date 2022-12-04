package com.example.assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class App implements Initializable {

    @FXML
    private Label output;

    @FXML
    private TextField txtlastName;

    @FXML
    private Button exit;

    @FXML
    private RadioButton view;

    @FXML
    private TextField txtMiddName;

    @FXML
    private TextField txtFname;

    @FXML
    private Button save;

    @FXML
    private CheckBox active;

    @FXML
    private RadioButton addminstrator;

    @FXML
    private RadioButton creative;

    @FXML
    private TextField txtusername;

    @FXML
    void btnSAve(ActionEvent event) {
        String add="";
        if(addminstrator.isSelected()){

            add="addminstrator";
        }
        if(creative.isSelected()){

            add="creative";
        }
        else if(view.isSelected()){

            add="view";
        }

            String acc="";
        if(active.isSelected()){

           acc ="Active";

        }
       else {
           acc="not Active";
        }
        String names=txtFname.getText()+"\n"+txtMiddName.getText()+'\n'+txtlastName.getText()+'\n'+txtusername.getText()+'\n'+add+'\n'+acc;

        output.setText(names);



    }

    @FXML
    void btnexit(ActionEvent event) {
        System.exit(0);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
