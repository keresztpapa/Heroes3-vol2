module com.example.prog1demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.prog1demo to javafx.fxml;
    exports com.example.prog1demo;
    exports com.example.prog1demo.BattleField;
    exports com.example.prog1demo.units.unit;
    exports com.example.prog1demo.MenuElements;
    opens com.example.prog1demo.MenuElements to javafx.fxml;
    exports com.example.prog1demo.Interfaces;
    opens com.example.prog1demo.Interfaces to javafx.fxml;
    exports com.example.prog1demo.units.unit.Humans;
    exports com.example.prog1demo.units.unit.EvilUnits;
    exports com.example.prog1demo.units.unit.Heroes;
}