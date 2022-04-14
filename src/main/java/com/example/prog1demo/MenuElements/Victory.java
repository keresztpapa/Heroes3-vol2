package com.example.prog1demo.MenuElements;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Victory {
    AnchorPane ap = new AnchorPane();
    Stage stg = new Stage();
    Button btn = new Button(" Új játék indítása");
    TextField txtEnd = new TextField();

    public Victory(){
        ap.setPrefSize(1500,1000);
        btn.setPrefWidth(150);
        btn.setPrefHeight(70);
        btn.setLayoutX(700);
        btn.setLayoutY(500);
        txtEnd.setLayoutX(700);
        txtEnd.setLayoutY(800);
        txtEnd.setPrefHeight(70);
        txtEnd.setPrefWidth(150);

        btn.setOnMouseClicked((event) -> {
            try {
                Menu mn = new Menu(stg, ap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    public void endGame(String str){
        if(str.equals("bukta")) {
            txtEnd.setText("Az emberek vesztettek!");
        }else{
            txtEnd.setText("Az emberek nyertek!");
        }
    }

}
