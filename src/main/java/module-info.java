module com.example.kg_5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;


    opens com.example.kg_5 to javafx.fxml;
    exports com.example.kg_5;
}