/**
 * A játék nehezéségét szabályozza az osztály.
 * Könnyű, közepes, nehéz -től függően 1300/1000/700 arannyal indul a játékos amit be kell osztania később.
 */

package com.example.prog1demo.MenuElements;

import com.example.prog1demo.units.unit.Heroes.Champions;
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

public class Difficulties {
    public void init(Stage stg) throws IOException {
        AnchorPane root = new AnchorPane();
        InputStream is = Files.newInputStream(Paths.get("pngs/menu.png"));
        Image bckgr = new Image(is);
        is.close();
        ImageView img = new ImageView(bckgr);
        img.setFitWidth(1500);
        img.setFitHeight(1000);

        Button easy = new Button("Easy");
        easy.setPrefWidth(100);
        easy.setPrefHeight(100);
        easy.setLayoutX(1000);
        easy.setLayoutY(200);

        easy.setOnMouseClicked((event)->{
            Champions chimps = new Champions(1300);
            System.out.println(chimps.getGold());
            ChimpBooster chimpBooster = new ChimpBooster();
            try {
                chimpBooster.boost(stg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Button medium = new Button("Medium");
        medium.setPrefWidth(100);
        medium.setPrefHeight(100);
        medium.setLayoutX(1000);
        medium.setLayoutY(400);

        medium.setOnMouseClicked((event)->{
            Champions chimps = new Champions(1000);
            System.out.println(chimps.getGold());
            ChimpBooster chimpBooster = new ChimpBooster();
            try {
                chimpBooster.boost(stg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Button hard = new Button("Hard");
        hard.setPrefWidth(100);
        hard.setPrefHeight(100);
        hard.setLayoutX(1000);
        hard.setLayoutY(600);

        hard.setOnMouseClicked((event)->{
            Champions chimps = new Champions(700);
            System.out.println(chimps.getGold());
            ChimpBooster chimpBooster = new ChimpBooster();
            try {
                chimpBooster.boost(stg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Button prepare_for_battle = new Button("Prepare");
        prepare_for_battle.setPrefWidth(100);
        prepare_for_battle.setPrefHeight(100);
        prepare_for_battle.setLayoutX(1000);
        prepare_for_battle.setLayoutY(800);

        prepare_for_battle.setOnMouseClicked((event) -> {
            ChimpBooster chimpBooster = new ChimpBooster();
            try {
                chimpBooster.boost(stg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        root.getChildren().addAll(img);
        root.getChildren().addAll(easy);
        root.getChildren().addAll(medium);
        root.getChildren().addAll(hard);
        root.getChildren().addAll(prepare_for_battle);
        Scene sc = new Scene(root);
        stg.setTitle("Heroes -- Might and Magic 3: Low budget edition :: Difficulty");
        stg.setScene(sc);
        stg.show();
    }
}
