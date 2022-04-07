package com.example.prog1demo.MenuElements;

import com.example.prog1demo.BattleField.Tiles;
import com.example.prog1demo.units.Champions;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Preparation {
    static TextField solText;
    static TextField griffText;
    static TextField arcText;
    public void init(Stage stg) throws IOException {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(1000, 800);
        InputStream is = Files.newInputStream(Paths.get("pngs/Shop.png"));
        Image bckgr = new Image(is);
        is.close();
        ImageView img = new ImageView(bckgr);
        img.setFitWidth(1000);
        img.setFitHeight(800);

        Champions champ = new Champions();

        ImageView soldier = new ImageView(new Image("file:pngs/player_units/pike/pike_stand.png"));
        soldier.setX(200);
        soldier.setY(200);

        solText = new TextField(":: "+champ.getSoldierCount());
        solText.setBackground(new Background(new BackgroundFill(Color.rgb(243, 243, 243, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        solText.setMinHeight(50);
        solText.setMaxHeight(50);
        solText.setMinWidth(50);
        solText.setMaxWidth(50);
        solText.setLayoutX(170);
        solText.setLayoutY(350);

        Button solMin = new Button(" - ");
        solMin.setPrefHeight(50);
        solMin.setPrefWidth(50);
        solMin.setLayoutX(100);
        solMin.setLayoutY(350);

        solMin.setOnMouseClicked((event) -> {
            Champions chimp = new Champions();
            chimp.setGold(chimp.getGold() + 50);
            chimp.setSoldierCount(chimp.getSoldierCount() - 1);
            solText.setText(":: "+champ.getSoldierCount());
            System.out.println("Chimp gold: " + chimp.getGold());
        });

        Button solMax = new Button(" + ");
        solMax.setPrefHeight(50);
        solMax.setPrefWidth(50);
        solMax.setLayoutX(250);
        solMax.setLayoutY(350);

        solMax.setOnMouseClicked((event) -> {
            Champions chimp = new Champions();
            chimp.setGold(chimp.getGold() - 50);
            chimp.setSoldierCount(chimp.getSoldierCount() + 1);
            solText.setText(":: "+champ.getSoldierCount());
            System.out.println("Chimp gold: " + chimp.getGold());
        });

        ImageView griff = new ImageView(new Image("file:pngs/player_units/griff/griff_stand.png"));
        griff.setX(400);
        griff.setY(200);

        Button griffMin = new Button(" - ");
        griffMin.setPrefHeight(50);
        griffMin.setPrefWidth(50);
        griffMin.setLayoutX(350);
        griffMin.setLayoutY(350);

        griffText = new TextField(":: "+champ.getGriffCount());
        griffText.setBackground(new Background(new BackgroundFill(Color.rgb(243, 243, 243, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        griffText.setMinHeight(50);
        griffText.setMaxHeight(50);
        griffText.setMinWidth(50);
        griffText.setMaxWidth(50);
        griffText.setLayoutX(425);
        griffText.setLayoutY(350);

        griffMin.setOnMouseClicked((event) -> {
            Champions chimp = new Champions();
            chimp.setGold(chimp.getGold() + 50);
            chimp.setGriffCount(chimp.getGriffCount() - 1);
            griffText.setText(":: "+champ.getGriffCount());
            System.out.println("Chimp gold: " + chimp.getGold());
        });

        Button griffMax = new Button(" + ");
        griffMax.setPrefHeight(50);
        griffMax.setPrefWidth(50);
        griffMax.setLayoutX(500);
        griffMax.setLayoutY(350);

        griffMax.setOnMouseClicked((event) -> {
            Champions chimp = new Champions();
            chimp.setGold(chimp.getGold() - 50);
            chimp.setGriffCount(chimp.getGriffCount() + 1);
            griffText.setText(":: "+champ.getGriffCount());
            System.out.println("Chimp gold: " + chimp.getGold());
        });

        ImageView archer = new ImageView(new Image("file:pngs/player_units/archer/archer_stand"));
        archer.setX(700);
        archer.setY(200);

        Button archerMin = new Button(" - ");
        archerMin.setPrefHeight(50);
        archerMin.setPrefWidth(50);
        archerMin.setLayoutX(600);
        archerMin.setLayoutY(350);

        arcText = new TextField(":: "+champ.getGriffCount());
        arcText.setBackground(new Background(new BackgroundFill(Color.rgb(243, 243, 243, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        arcText.setMinHeight(50);
        arcText.setMaxHeight(50);
        arcText.setMinWidth(50);
        arcText.setMaxWidth(50);
        arcText.setLayoutX(700);
        arcText.setLayoutY(350);

        archerMin.setOnMouseClicked((event) -> {
            Champions chimp = new Champions();
            chimp.setGold(chimp.getGold() + 50);
            chimp.setArcherCount(chimp.getArcherCount() - 1);
            arcText.setText(":: "+champ.getArcherCount());
            System.out.println("Chimp gold: " + chimp.getGold());
        });

        Button archerMax = new Button(" + ");
        archerMax.setPrefHeight(50);
        archerMax.setPrefWidth(50);
        archerMax.setLayoutX(775);
        archerMax.setLayoutY(350);

        archerMax.setOnMouseClicked((event) -> {
            Champions chimp = new Champions();
            chimp.setGold(chimp.getGold() - 50);
            chimp.setArcherCount(chimp.getGriffCount() + 1);
            griffText.setText(":: "+champ.getGriffCount());
            System.out.println("Chimp gold: " + chimp.getGold());
        });

        ImageView toBattle = new ImageView(new Image("file:pngs/toBattleIcon.png"));
        toBattle.setFitHeight(75);
        toBattle.setFitWidth(75);
        toBattle.setX(800);
        toBattle.setY(600);

        toBattle.setOnMouseClicked((event)->{
            root.getChildren().clear();
            Tiles tile = new Tiles(8,8,root);
            tile.generate();
            System.out.println("GameEngine");
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
        root.getChildren().add(solText);
        root.getChildren().add(griffText);
        root.getChildren().add(arcText);
        root.getChildren().add(toBattle);

        Scene sc = new Scene(root);
        stg.setTitle("Heroes -- Might and Magic 3: Low budget edition :: Shop");
        stg.setScene(sc);
        stg.show();
    }
}
