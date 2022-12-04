module com.example.dbddemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.dbddemo to javafx.fxml;
    exports com.example.dbddemo;
}