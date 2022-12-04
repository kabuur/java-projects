module com.example.try{
        requires javafx.controls;
        requires javafx.fxml;


        opens com.example.try to javafx.fxml;
        exports com.example.try;
        }