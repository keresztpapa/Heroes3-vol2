package com.example.prog1demo.MenuElements;

import com.example.prog1demo.Application;
import com.example.prog1demo.BattleField.Tiles;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
        img.setFitWidth(1000);
        img.setFitHeight(800);

        Button next_scene = new Button("New Game");
        next_scene.setPrefWidth(100);
        next_scene.setPrefHeight(100);
        next_scene.setLayoutX(750);
        next_scene.setLayoutY(200);

        next_scene.setOnAction(e -> {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("app.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(),1000,800);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            stg.setTitle("Heroes!");
            stg.setScene(scene);
            stg.show();
        });

        Button diff = new Button("Difficulty");
        diff.setPrefWidth(100);
        diff.setPrefHeight(100);
        diff.setLayoutX(750);
        diff.setLayoutY(400);

        diff.setOnAction(e -> {
            Difficulties dff = new Difficulties();
            try {
                dff.init(stg);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        //next_scene.setOnAction(actionEvent -> { onClick(next_scene); });

        root.getChildren().addAll(img);
        root.getChildren().addAll(next_scene);
        root.getChildren().addAll(diff);
        Scene sc = new Scene(root);

        stg.setTitle("Heroes -- Might and Magic 3: Low budget edition :: Menu");
        stg.setScene(sc);
        stg.show();
    }
}
