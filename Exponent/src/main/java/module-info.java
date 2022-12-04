module com.example.exponent {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exponent to javafx.fxml;
    exports com.example.exponent;
}