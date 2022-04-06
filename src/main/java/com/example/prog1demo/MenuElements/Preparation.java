package com.example.prog1demo.MenuElements;

import com.example.prog1demo.units.Champions;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Preparation {
    public void init(Stage stg) throws IOException {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(1000, 800);
        InputStream is = Files.newInputStream(Paths.get("pngs/Shop.png"));
        Image bckgr = new Image(is);
        is.close();
        ImageView img = new ImageView(bckgr);
        img.setFitWidth(1000);
        img.setFitHeight(800);

        ImageView soldier = new ImageView(new Image("file:pngs/player_units/pike/pike_stand.png"));
        soldier.setX(200);
        soldier.setY(200);

        Button solMin = new Button(" - ");
        solMin.setPrefHeight(50);
        solMin.setPrefWidth(50);
        solMin.setLayoutX(100);
        solMin.setLayoutY(350);

        solMin.setOnMouseClicked((event)->{
            Champions chimp = new Champions();
            chimp.setGold(chimp.getGold()+50);
            chimp.setSoldierCount(chimp.getSoldierCount()-1);
            System.out.println("Chimp gold: "+chimp.getGold());
        });

        Button solMax = new Button(" + ");
        solMax.setPrefHeight(50);
        solMax.setPrefWidth(50);
        solMax.setLayoutX(250);
        solMax.setLayoutY(350);

        solMax.setOnMouseClicked((event)->{
            Champions chimp = new Champions();
            chimp.setGold(chimp.getGold()-50);
            chimp.setSoldierCount(chimp.getSoldierCount()+1);
            System.out.println("Chimp gold: "+chimp.getGold());
        });


        ImageView griff = new ImageView(new Image("file:pngs/player_units/griff/griff_stand.png"));
        griff.setX(400);
        griff.setY(200);

        Button griffMin = new Button(" - ");
        griffMin.setPrefHeight(50);
        griffMin.setPrefWidth(50);
        griffMin.setLayoutX(350);
        griffMin.setLayoutY(350);

        griffMin.setOnMouseClicked((event)->{
            Champions chimp = new Champions();
            chimp.setGold(chimp.getGold()+50);
            chimp.setGriffCount(chimp.getGriffCount()-1);
            System.out.println("Chimp gold: "+chimp.getGold());
        });

        Button griffMax = new Button(" + ");
        griffMax.setPrefHeight(50);
        griffMax.setPrefWidth(50);
        griffMax.setLayoutX(500);
        griffMax.setLayoutY(350);

        griffMax.setOnMouseClicked((event)->{
            Champions chimp = new Champions();
            chimp.setGold(chimp.getGold()-50);
            chimp.setGriffCount(chimp.getGriffCount()+1);
            System.out.println("Chimp gold: "+chimp.getGold());
        });

        ImageView archer = new ImageView(new Image("file:pngs/player_units/archer/archer_stand"));
        archer.setX(700);
        archer.setY(200);

        Button archerMin = new Button(" - ");
        archerMin.setPrefHeight(50);
        archerMin.setPrefWidth(50);
        archerMin.setLayoutX(600);
        archerMin.setLayoutY(350);

        archerMin.setOnMouseClicked((event)->{
            Champions chimp = new Champions();
            chimp.setGold(chimp.getGold()+50);
            chimp.setGriffCount(chimp.getGriffCount()-1);
            System.out.println("Chimp gold: "+chimp.getGold());
        });

        Button archerMax = new Button(" + ");
        archerMax.setPrefHeight(50);
        archerMax.setPrefWidth(50);
        archerMax.setLayoutX(775);
        archerMax.setLayoutY(350);

        archerMax.setOnMouseClicked((event)->{
            Champions chimp = new Champions();
            chimp.setGold(chimp.getGold()-50);
            chimp.setGriffCount(chimp.getGriffCount()+1);
            System.out.println("Chimp gold: "+chimp.getGold());
        });

        root.getChildren().add(img);
        root.getChildren().add(soldier);
        root.getChildren().add(griff);
        root.getChildren().add(archer);
        root.getChildren().add(solMin);
        root.getChildren().add(solMax);
        root.getChildren().add(griffMin);
        root.getChildren().add(griffMax);
        root.getChildren().add(archerMin);
        root.getChildren().add(archerMax);

        Scene sc = new Scene(root);
        stg.setTitle("Heroes -- Might and Magic 3: Low budget edition :: Shop");
        stg.setScene(sc);
        stg.show();
    }
}
