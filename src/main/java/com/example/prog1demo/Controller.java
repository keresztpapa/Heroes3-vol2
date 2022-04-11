package com.example.prog1demo;

import com.example.prog1demo.BattleField.Tiles;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    AnchorPane ap;


    @FXML
    Button fireball = new Button();

    @FXML
    Button lightning = new Button();

    @FXML
    Button ressurr = new Button();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameEngine();
    }

    public void gameEngine(){
        Tiles tile = new Tiles(12,10,ap);
        tile.generate();
        System.out.println("GameEngine");
    }



    public void fireball(){
        System.out.println("fire");
    }

    public void lightning(){
        System.out.println("electro");
    }

    public void ressurr(){
        System.out.println("alive");
    }


}