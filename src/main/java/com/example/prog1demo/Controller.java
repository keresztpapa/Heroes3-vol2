package com.example.prog1demo;

import com.example.prog1demo.BattleField.Tiles;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Objects;
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
    }


}



/*
*
        ImageView img = new ImageView(new Image("file:pngs/tile_def.png"));

        img.setOnMouseClicked((MouseEvent e)->{
            img.setImage(new Image("file:pngs/water.png"));
        });

        ap.getChildren().add(img);
*
* */