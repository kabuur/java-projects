package com.example.shopapplication;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Slider slider;

    @FXML
    private Button btnchange;

    @FXML
    private Label lbloutput;

    @FXML
    private ColorPicker colorpicker;

    @FXML
    private ComboBox<String> cbxFontName;

    @FXML
    private ChoiceBox<String> choiceboxStyle;
    @FXML
    private Button btnalert;
    @FXML
    private DatePicker datepicker;
    @FXML
    private ListView<String> lvNames;

    @FXML
    private Button btnget;
    @FXML
    void GetHandler(ActionEvent event) {
        ObservableList<String> list = lvNames.getSelectionModel().getSelectedItems();
        String names="";
        for (String item : list){
            names += item + "\n";
        }
lbloutput.setText(names);

        lvNames.getItems().removeAll(list);
    }
    @FXML
    void alertHandler(ActionEvent event) {
Alert al = new Alert(Alert.AlertType.CONFIRMATION);
al.setTitle("Error message!");
al.setHeaderText("Array Exception");
al.setContentText("index was outside of the array side");

        Optional<ButtonType> result = al.showAndWait();
        if (result.get() == ButtonType.OK){
            lbloutput.setText("you clicked button ok");
        }
        else{
            lbloutput.setText("you clicked button Cancel");
        }
    }




    @FXML
    void changeHandler(ActionEvent event) {
String FontName = cbxFontName.getSelectionModel().getSelectedItem();
String Style = choiceboxStyle.getSelectionModel().getSelectedItem();
        Color color = colorpicker.getValue();
        int size =(int) slider.getValue();
        String Date = String.valueOf(datepicker.getValue());

        lbloutput.setText(Date);

        lbloutput.setTextFill(color);
if (Style.equals("Bold")){
    lbloutput.setFont(Font.font(FontName, FontWeight.BOLD,size));





}
else if (Style.equals("Italic")){
    lbloutput.setFont(Font.font(FontName, FontWeight.NORMAL, FontPosture.ITALIC,size));

}   }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] fontNames= {"Arial" , "Algerian"};
        cbxFontName.getItems().addAll(fontNames);

        String[] style = {"Bold", "Italic"};
        choiceboxStyle.getItems().addAll(style);

        String[] names= {"Ali","Farhia","geedi","kaafi"};
        lvNames.getItems().addAll(names);
        lvNames.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvNames.setOrientation(Orientation.VERTICAL);
        lvNames.setPrefSize(200,250);
    }
}
