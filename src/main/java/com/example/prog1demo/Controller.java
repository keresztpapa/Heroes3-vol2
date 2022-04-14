package com.example.prog1demo;

import com.example.prog1demo.BattleField.Tiles;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    AnchorPane ap;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            gameEngine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gameEngine() throws IOException {
        Tiles tile = new Tiles(12,10, ap);
        tile.generate();
        System.out.println("GameEngine");
    }



}