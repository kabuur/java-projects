module com.example.multipleform {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.multipleform to javafx.fxml;
    exports com.example.multipleform;
}