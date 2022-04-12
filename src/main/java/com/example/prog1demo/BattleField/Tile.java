/**
 * Ez az osztály a harcmező alapja.
 * Maga a mező egy 2D tömb ami ebből az objektumokból áll elő.
 * Itt a getterek és setterek után, még van egy setImg fv.
 * Ezzel be lehet állítani egy egy mezőnek a képét.
 * SetImage()
 * @param str    a stringből amit kap paraméterben beállítja az adott mezőnek a képét
 *
 * giveImageFeed()
 * @param  str  a paraméterben kapott stringet átadja a setImage()-nek
 *
 * Ez a fv módosítja a képet annak fejében, hogy az egér a mező fölött van e (hover effect)
 */

package com.example.prog1demo.BattleField;

import com.example.prog1demo.units.unit.Generic;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Objects;

public class Tile {
    int movTo_x;
    int movTo_y;
    int pos_x;
    public int pos_y;
    AnchorPane ap;
    ImageView img;
    String pic;
    boolean crossable;
    static int handbreak=0;
    boolean occupied=false;
    Generic gen = new Generic();
    static boolean victory = false;

    public Tile(int x, int y, AnchorPane anchor, boolean crs){
        this.pos_x = x;
        this.pos_y = y;
        this.ap=anchor;
        this.crossable = crs;
        Generic gen = new Generic(ap);
    }

    public void setImg(String str){
        switch (str) {
            case "def" -> this.img = new ImageView(new Image("file:pngs/tile_def.png"));
            case "hover" -> this.img = new ImageView(new Image("file:pngs/tile_hover.png"));
            case "water" -> this.img = new ImageView(new Image("file:pngs/water.png"));
            case "mov" -> this.img = new ImageView(new Image("file:pngs/mov.png"));
        }
    }

    public void giveImageFeed(String str){
        setImg(str);
        img.setFitWidth(100);
        img.setFitHeight(100);
        img.setX(this.pos_x);
        img.setY(this.pos_y);

            img.setOnMouseEntered((event) -> {
                this.movTo_x = (int) img.getX();
                this.movTo_y = (int) img.getY();
                if(!Objects.equals(this.pic, "water")){
                    this.img.setImage(new Image("file:pngs/tile_hover.png"));
                    this.pic="hover";
                }
            });

            img.setOnMouseExited((event) -> {
                if(!Objects.equals(this.pic, "water")){
                    img.setImage(new Image("file:pngs/tile_def.png"));
                    this.pic="def";
                }
            });
            this.ap.getChildren().add(img);
    }

    //getters & setters
    public void setGeneric(Generic asd){ this.gen = asd; }
    public Generic getGen() { return this.gen; }

    public boolean isOccupied() { return this.occupied; }
    public void setOccupied(boolean asd){ this.occupied = asd; }

    public int getHandbreak(){ return handbreak; }
    public void setHandbreak(int z){ handbreak = z; }
    public int getPos_x(){ return this.pos_x; }
    public int getPos_y(){ return this.pos_y; }
    public void setMovTo_x(int z){ this.movTo_x = z; }
    public void setMovTo_y(int z){ this.movTo_y = z; }
    public int getImgX(){ return (int) this.img.getX(); }
    public int getImgY(){ return (int) this.img.getY(); }
    public int getMovTo_x(){ return this.movTo_x; }
    public int getMovTo_y(){ return  this.movTo_y; }
    public String getPic() { return this.pic; }
    public void setPic(String z){ this.pic = z; }
    public void setCrs(boolean z){ this.crossable = z; }
    public boolean getCrs(){ return this.crossable; }
    public Tile getTile(){ return this; }
    public ImageView getImageView(){ return this.img; }
    public String toString(){
        return "tile";
    }
    public boolean isVictory(){ return victory; }
    public void setVictory(boolean asd){ victory = asd; }
}