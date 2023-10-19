module com.example.heatcreator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.heatcreator to javafx.fxml;
    exports iet_gibb_labelcreator;
    opens iet_gibb_labelcreator to javafx.fxml;
}