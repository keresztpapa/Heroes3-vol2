package com.example.prog1demo.BattleField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Tile {
    int x_count;
    int y_count;
    AnchorPane ap;

    ImageView img;

    public Tile(int x, int y, AnchorPane anchor){
        this.x_count = x;
        this.y_count = y;
        this.ap=anchor;
    }

    public void giveImageFeed(String str, int x, int y){
        switch (str) {
            case "def" -> img = new ImageView(new Image("file:pngs/tile_def.png"));
            case "hover" -> img = new ImageView(new Image("file:pngs/tile_hover.png"));
            case "water" -> img = new ImageView(new Image("file:pngs/water.png"));
        }
        img.setFitWidth(100);
        img.setFitHeight(100);
        img.setX(x);
        img.setY(y);

            img.setOnMouseEntered((event) -> img.setImage(new Image("file:pngs/tile_hover.png")));

            img.setOnMouseExited((event) -> img.setImage(new Image("file:pngs/tile_def.png")));

            img.setOnMouseClicked((event) -> this.routing());

        this.ap.getChildren().add(img);
    }

    public void routing(){

    }

    //getters & setters
    public void setX_count(int z){ this.x_count = z; }
    public void setY_count(int z){ this.y_count = z; }
    public int getX_count(){ return this.x_count; }
    public int getY_count(){ return this.y_count; }
}
