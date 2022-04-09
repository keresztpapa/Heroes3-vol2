package com.example.prog1demo.MenuElements;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ChampionsPower {

    public void skills(Stage stg) throws IOException{
        AnchorPane root = new AnchorPane();
        root.setPrefSize(1000, 800);
        InputStream is = Files.newInputStream(Paths.get("pngs/Shop.png"));
        Image bckgr = new Image(is);
        is.close();
        ImageView img = new ImageView(bckgr);
        img.setFitWidth(1000);
        img.setFitHeight(800);

        ImageView fireBall = new ImageView(new Image("file:pngs/powers/fireball.png"));
        ImageView thunderStrike = new ImageView(new Image("file:pngs/powers/lightning-strike.png"));
        ImageView ressurection = new ImageView(new Image("file:pngs/powers/cross.png"));

        

        Button toShop = new Button(" SHOP ");
        toShop.setPrefHeight(60);
        toShop.setPrefWidth(75);
        toShop.setLayoutX(700);
        toShop.setLayoutY(700);

        toShop.setOnMouseClicked((event)->{
            Preparation prep = new Preparation();
            try {
                prep.init(stg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
