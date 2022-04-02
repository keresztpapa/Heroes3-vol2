package com.example.prog1demo.BattleField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Tile {
    int     start_x,
            start_y,
            end_x,
            end_y,
            row,
            col;
    AnchorPane ap;
    ImageView img;

    public Tile(int x, int y, AnchorPane anchor){
        this.row = x;
        this.col = y;
        this.ap=anchor;
    }

    public void setImg(String str){
        switch (str) {
            case "def" -> img = new ImageView(new Image("file:pngs/tile_def.png"));
            case "hover" -> img = new ImageView(new Image("file:pngs/tile_hover.png"));
            case "water" -> img = new ImageView(new Image("file:pngs/water.png"));
        }
    }

    public void giveImageFeed(String str, int x, int y){
        this.setImg(str);
        img.setFitWidth(100);
        img.setFitHeight(100);
        img.setX(x);
        img.setY(y);

            img.setOnMouseEntered((event) -> {
                this.end_x = (int) img.getX();
                this.end_y = (int) img.getY();
                img.setImage(new Image("file:pngs/tile_hover.png"));
                //routing();
            });

            img.setOnMouseExited((event) -> img.setImage(new Image("file:pngs/tile_def.png")));

            img.setOnMouseClicked((event) -> {
                this.start_x = (int) img.getX();
                this.start_y = (int) img.getY();
            });

        this.ap.getChildren().add(img);
    }

    //getters & setters
    public void setRow(int z){ this.row = z; }
    public void setCol(int z){ this.col = z; }
    public void setStart_x(int z){ this.start_x = z; }
    public void setStart_y(int z){ this.start_y = z; }
    public void setEnd_x(int z){ this.end_x = z; }
    public void setEnd_y(int z){ this.end_y = z; }
    public int getRow(){ return this.row; }
    public int getCol(){ return this.col; }
    public int getStart_x(){ return this.start_x; }
    public int getStart_y(){ return  this.start_y; }
    public int getEnd_x(){ return this.end_x; }
    public int getEnd_y(){ return this.end_y; }
}


/*
public void routing(){
        img.setImage(new Image("file:pngs/tile_hover.png"));

        for (int i=0;i<this.row;i++){
            for (int j=0;j<this.col;j++){

                //ballra fent
                if(this.start_x <= this.end_x){
                    if (this.start_y <= this.end_y){
                        img.setImage(new Image("file:pngs/tile_hover.png"));
                    }
                }

                //ballra lent
                if(this.start_x <= this.end_x){
                    if (this.start_y >= this.end_y){
                        img.setImage(new Image("file:pngs/tile_hover.png"));
                    }
                }

                //jobbra fent
                if(this.start_x >= this.end_x){
                    if (this.start_y <= this.end_y){
                        img.setImage(new Image("file:pngs/tile_hover.png"));
                    }
                }

                //jobbra lent
                if(this.start_x >= this.end_x){
                    if (this.start_y >= this.end_y){
                        img.setImage(new Image("file:pngs/tile_hover.png"));
                    }
                }

            }
        }
 */