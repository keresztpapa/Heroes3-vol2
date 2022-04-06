package com.example.prog1demo.MenuElements;

import javafx.scene.Scene;
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
        InputStream is = Files.newInputStream(Paths.get("pngs/menu.png"));
        Image bckgr = new Image(is);
        is.close();
        ImageView img = new ImageView(bckgr);
        img.setFitWidth(1000);
        img.setFitHeight(800);


        ImageView soldier = new ImageView(new Image("file:pngs/player_units/pike/pike_stand.png"));
        soldier.setX(200);
        soldier.setY(200);

        ImageView griff = new ImageView(new Image("file:pngs/player_units/griff/griff_stand.png"));
        griff.setX(400);
        griff.setY(200);

        ImageView archer = new ImageView(new Image("file:pngs/player_units/archer/archer_stand"));
        archer.setX(650);
        archer.setY(200);



        root.getChildren().addAll(img);
        root.getChildren().addAll(soldier);
        root.getChildren().addAll(griff);
        root.getChildren().addAll(archer);

        Scene sc = new Scene(root);
        stg.setTitle("Heroes -- Might and Magic 3: Low budget edition :: Menu");
        stg.setScene(sc);
        stg.show();
    }
}
