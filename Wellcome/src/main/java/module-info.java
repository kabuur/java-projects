module com.example.wellcome {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.wellcome to javafx.fxml;
    exports com.example.wellcome;
}