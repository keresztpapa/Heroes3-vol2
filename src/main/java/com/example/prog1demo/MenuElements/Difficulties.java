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

public class Difficulties {
    public void init(Stage stg) throws IOException {
        AnchorPane root = new AnchorPane();
        InputStream is = Files.newInputStream(Paths.get("pngs/menu.png"));
        Image bckgr = new Image(is);
        is.close();
        ImageView img = new ImageView(bckgr);
        img.setFitWidth(1000);
        img.setFitHeight(800);

        Button easy = new Button("Easy");
        easy.setPrefWidth(100);
        easy.setPrefHeight(100);
        easy.setLayoutX(750);
        easy.setLayoutY(100);

        easy.setOnMouseClicked((event)->{
            Champions chimps = new Champions(100);
            System.out.println(chimps.getGold());
        });

        Button medium = new Button("Medium");
        medium.setPrefWidth(100);
        medium.setPrefHeight(100);
        medium.setLayoutX(750);
        medium.setLayoutY(250);

        medium.setOnMouseClicked((event)->{
            Champions chimps = new Champions(200);
            System.out.println(chimps.getGold());
        });

        Button hard = new Button("Hard");
        hard.setPrefWidth(100);
        hard.setPrefHeight(100);
        hard.setLayoutX(750);
        hard.setLayoutY(400);

        hard.setOnMouseClicked((event)->{
            Champions chimps = new Champions(300);
            System.out.println(chimps.getGold());
        });

        Button prepare_for_battle = new Button("Prepare");
        prepare_for_battle.setPrefWidth(100);
        prepare_for_battle.setPrefHeight(100);
        prepare_for_battle.setLayoutX(750);
        prepare_for_battle.setLayoutY(600);

        prepare_for_battle.setOnMouseClicked((event) -> {
            Preparation prep = new Preparation();
            try {
                prep.init(stg);
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
