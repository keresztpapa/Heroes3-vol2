package com.example.prog1demo.BattleField;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Tiles {
    int x_count;
    int y_count;
    Tile[][] map;
    AnchorPane ap;

    ImageView img_hover;
    ImageView img;

    public Tiles(int x, int y, AnchorPane anchor){
        this.x_count = x;
        this.y_count = y;
        this.ap=anchor;
        this.map = new Tile[x][y];
            for (int i=0;i<this.x_count;i++){
                for (int j=0;j<this.y_count;j++){
                    this.map[i][j] = new Tile(100*i,j*100,ap);
                }
            }
    }

    public void generateMap(){
        for (int i=0;i<this.x_count;i++){
            for (int j=0;j<this.y_count;j++){
                this.map[i][j].giveImageFeed("def", i*100, j*100);
            }
        }
    }

    //getters & setters
    public void setX_count(int z){ this.x_count = z; }
    public void setY_count(int z){ this.y_count = z; }
    public int getX_count(){ return this.x_count; }
    public int getY_count(){ return this.y_count; }
}

/*
                img = new ImageView(new Image("file:pngs/tile_def.png"));
                img.setFitWidth(100);
                img.setFitHeight(100);
                img.setX(i*100);
                img.setY(j*100);

                img.setOnMouseEntered((event) -> {
                    System.out.println("enter\nx:"+ img.getX()+"\ny: "+ img.getY());
                    //ImageView img_hover;
                    img_hover = new ImageView(new Image("file:pngs/tile_hover.png"));
                    img_hover.setFitWidth(100);
                    img_hover.setFitHeight(100);
                    img_hover.setX(img.getX());
                    img_hover.setY(img.getY());
                    ap.getChildren().add(img_hover);
                });

                img.setOnMouseExited((event) -> {
                    ap.getChildren().remove(img_hover);
                });

                ap.getChildren().add(img);

 */


/*
                    System.out.println("enter\nx:"+ finalImg.getX()+"\ny: "+ finalImg.getY());
                    ImageView img_def;
                    img_def = new ImageView(new Image("file:pngs/tile_def.png"));
                    img_def.setFitWidth(100);
                    img_def.setFitHeight(100);
                    img_def.setX(finalImg.getX());
                    img_def.setY(finalImg.getY());
*/

                /*
                ImageView img_hover = new ImageView(new Image("file:pngs/tile_hover.png"));
                img_hover.setFitWidth(100);
                img_hover.setFitHeight(100);
                img_hover.setX(img.getX());
                img_hover.setY(img.getY());

                img.setOnMouseEntered((event) -> ap.getChildren().add(img_hover));

                img.setOnMouseExited((event)  -> ap.getChildren().remove(img_hover));
               */