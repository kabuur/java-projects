module com.example.assignmentmultiforms {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignmentmultiforms to javafx.fxml;
    exports com.example.assignmentmultiforms;
}