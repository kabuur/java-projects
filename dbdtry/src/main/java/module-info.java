module com.example.dbdtry {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.dbdtry to javafx.fxml;
    exports com.example.dbdtry;
}