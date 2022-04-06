module com.example.prog1demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.prog1demo to javafx.fxml;
    exports com.example.prog1demo;
    exports com.example.prog1demo.MenuElements;
    opens com.example.prog1demo.MenuElements to javafx.fxml;
}