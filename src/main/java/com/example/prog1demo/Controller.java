package com.example.prog1demo;

import com.example.prog1demo.BattleField.Tiles;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    AnchorPane ap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameEngine();
    }

    public void gameEngine(){
        Tiles tile = new Tiles(8,8,ap);
        tile.generate();
        System.out.println("GameEngine");
    }
}