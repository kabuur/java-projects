module com.example.stylingfont {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.stylingfont to javafx.fxml;
    exports com.example.stylingfont;
}