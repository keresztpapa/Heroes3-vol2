package com.example.prog1demo;

import com.example.prog1demo.MenuElements.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(1000, 800);
        Menu menu = new Menu(stage, root);
    }

    public static void main(String[] args) {
        launch();
    }
}