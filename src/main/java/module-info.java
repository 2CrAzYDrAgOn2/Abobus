module com.example.abobus {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.abobus to javafx.fxml;
    exports com.example.abobus;
}