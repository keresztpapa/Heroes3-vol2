package com.example.prog1demo.BattleField;

import com.example.prog1demo.units.unit.Soldier;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Objects;

public class Tile {
    int     movTo_x,
            movTo_y,
            pos_x,
            pos_y;
    AnchorPane ap;
    ImageView img;
    String pic;
    boolean crossable;

    public Tile(int x, int y, AnchorPane anchor, boolean crs){
        this.pos_x = x;
        this.pos_y = y;
        this.ap=anchor;
        this.crossable = crs;
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


            img.setOnMouseClicked((event) -> {
            /*
                this.movTo_x = (int) img.getX();
                this.movTo_y = (int) img.getY();
                System.out.println("String: "+this.pic+"\n");
                System.out.println("X: "+this.movTo_x +"\nY:"+this.movTo_y);
            */

            });

            this.ap.getChildren().add(img);
    }

    //getters & setters
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
}