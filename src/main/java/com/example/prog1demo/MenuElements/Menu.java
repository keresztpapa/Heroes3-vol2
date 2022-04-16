/**
 * A főmenü class-ja.
 * Betölti a menünek szánt hátteret.
 * Van 2 gomb, az egyik instant a harctért indítja, a másik a felkészülést a játékos által.
 */
package com.example.prog1demo.MenuElements;

import com.example.prog1demo.Interfaces.Multiplayer;
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

public class Menu {
    public Menu(Stage stg, AnchorPane root) throws IOException {
        //menü háttér
        InputStream is = Files.newInputStream(Paths.get("pngs/menu.png"));
        Image bckgr = new Image(is);
        is.close();
        ImageView img = new ImageView(bckgr);
        img.setFitWidth(1500);
        img.setFitHeight(1000);

        Button next_scene = new Button("Multiplayer");
        next_scene.setPrefWidth(100);
        next_scene.setPrefHeight(100);
        next_scene.setLayoutX(1000);
        next_scene.setLayoutY(400);

        next_scene.setOnAction(e -> {
            root.setMaxHeight(1000);
            root.setPrefHeight(1000);
            root.setMaxWidth(1500);
            root.setPrefWidth(1500);
            Multiplayer mp = new Multiplayer(12,10,root);
            mp.generate();
        });

        Button diff = new Button("Single");
        diff.setPrefWidth(100);
        diff.setPrefHeight(100);
        diff.setLayoutX(1000);
        diff.setLayoutY(600);

        diff.setOnAction(e -> {
            Difficulties dff = new Difficulties();
            try {
                dff.init(stg);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        root.getChildren().addAll(img);
        root.getChildren().addAll(next_scene);
        root.getChildren().addAll(diff);
        Scene sc = new Scene(root);

        stg.setTitle("Heroes -- Might and Magic 3: Low budget edition :: Menu");
        stg.setScene(sc);
        stg.show();
    }
}
