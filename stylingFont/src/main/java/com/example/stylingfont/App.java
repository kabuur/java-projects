package com.example.stylingfont;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class App implements Initializable {

    @FXML
    private DatePicker date;
    @FXML
    private ListView<String> lv;
    @FXML
    private Button btnchange;

    @FXML
    private ColorPicker color;

    @FXML
    private ComboBox<String> conboBox;

    @FXML
    private Slider range;

    @FXML
    private ChoiceBox<String> chiceBox;

    @FXML
    void onClick(ActionEvent event) {

        Alert al = new Alert(Alert.AlertType.CONFIRMATION);
        al.setTitle("Error message!");
        al.setHeaderText("Array Exception");
        al.setContentText("index was outside of the array side");

        Optional<ButtonType> result = al.showAndWait();
        if (result.get() == ButtonType.OK){
            output.setText("you clicked button ok");
        }
        else{
            output.setText("you clicked button Cancel");
        }


        ObservableList<String>ls=lv.getSelectionModel().getSelectedItems();
        String names="";
        for(String item:ls){
            names+=item+"\n";
        }
        output.setText (names);
        String fontName=conboBox.getSelectionModel().getSelectedItem();
        String style=chiceBox.getSelectionModel().getSelectedItem();

        output.setFont(Font.font(fontName,FontWeight.BOLD,range.getValue()));
        output.setTextFill(color.getValue());
    }

    @FXML
    private Label output;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {







        String[] fontWeight={"Bold", "Italic"};
        String[] fontStyle={"Arial","Algerian"};
       conboBox .getItems().addAll(fontWeight);
       chiceBox.getItems().addAll(fontStyle);

       String[] names={"Ahmed","Mohamed","Faarax","Xaaawo","Mulki","deeqo"};
       lv.getItems().addAll(names);
       lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
       lv.setOrientation(Orientation.VERTICAL);
       lv.setPrefSize(200,200);


    }
}
