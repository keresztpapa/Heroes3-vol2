package com.example.prog1demo.MenuElements;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Victory {
    AnchorPane ap = new AnchorPane();
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
    }

    public void endGame(String str){
        if(str.equals("lost")) {
            txtEnd.setText("Vesztettél");
        }else{
            txtEnd.setText("Győztél");
        }
    }

}
