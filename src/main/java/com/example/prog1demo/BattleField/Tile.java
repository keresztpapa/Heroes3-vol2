package com.example.prog1demo.BattleField;

import com.example.prog1demo.Action;
import com.example.prog1demo.units.UnitBase;
import com.example.prog1demo.units.unit.Soldier;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Objects;

public class Tile {
    int     start_x,
            start_y,
            end_x,
            end_y,
            row,
            col;
    AnchorPane ap;
    ImageView img;
    String pic=null;
    boolean crossable;
    UnitBase unib;

    public Tile(int x, int y, AnchorPane anchor, boolean crs){
        this.row = x;
        this.col = y;
        this.ap=anchor;
        this.crossable = crs;
        //this.unib = null;
    }
/*
    public Tile(int x, int y, AnchorPane anchor, boolean crs, UnitBase u){
        this.row = x;
        this.col = y;
        this.ap=anchor;
        this.crossable = crs;
        this.unib = u;
    }
*/
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
                if(!Objects.equals(this.pic, "water")){
                    this.img.setImage(new Image("file:pngs/tile_hover.png"));
                    this.pic="hover";
                }
                //routing();
            });

            img.setOnMouseExited((event) -> {
                if(!Objects.equals(this.pic, "water")){
                    img.setImage(new Image("file:pngs/tile_def.png"));
                    this.pic="def";
                }
            });

            img.setOnMouseClicked((event) -> {
                this.start_x = (int) img.getX();
                this.start_y = (int) img.getY();
                System.out.println("String: "+this.pic+"\n");
                System.out.println("X: "+this.start_x+"\nY:"+this.start_y);
                //unib.move();

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
    public String getPic() { return this.pic; }
    public void setPic(String z){ this.pic = z; }
    public void setCrs(boolean z){ this.crossable = z; }
    public boolean getCrs(){ return this.crossable; }

}