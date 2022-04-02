package com.example.prog1demo.BattleField;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Tiles {
    int x_count;
    int y_count;
    AnchorPane ap;

    public Tiles(int x, int y, AnchorPane anchor){
        this.x_count = x;
        this.y_count = y;
        this.ap=anchor;
    }

    public void generateMap(){
        ImageView img;

        for (int i=0;i<this.x_count;i++){
            for (int j=0;j<this.y_count;j++){
                img = new ImageView(new Image("file:pngs/tile_def.png"));
                img.setFitWidth(100);
                img.setFitHeight(100);
                img.setX(i*100);
                img.setY(j*100);

                    ImageView img_hover = new ImageView(new Image("file:pngs/tile_hover.png"));
                    img_hover.setFitWidth(100);
                    img_hover.setFitHeight(100);
                    img_hover.setX(img.getX());
                    img_hover.setY(img.getY());

                img.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> ap.getChildren().add(img_hover));

                img.addEventHandler(MouseEvent.MOUSE_EXITED, e -> ap.getChildren().remove(img_hover));

                /*
        public void handle(MouseEvent me) {
            System.out.println(me.getEventType());
                if(me.getEventType() == MouseEvent.MOUSE_ENTERED_TARGET || me.getEventType() == MouseEvent.MOUSE_MOVED) {
                    nejButton.setDisable(true);
                }
                else if((me.getEventType() == MouseEvent.MOUSE_EXITED) || (me.getEventType() == MouseEvent.MOUSE_EXITED_TARGET) )nejButton.setDisable(false);
    }
                * */

                /*
                ImageView finalImg = img;

                img.setOnMouseEntered((event) -> {
                    System.out.println("enter\nx:"+ finalImg.getX()+"\ny: "+ finalImg.getY());
                    ImageView img_hover;
                    img_hover = new ImageView(new Image("file:pngs/tile_hover.png"));
                    img_hover.setFitWidth(100);
                    img_hover.setFitHeight(100);
                    img_hover.setX(finalImg.getX());
                    img_hover.setY(finalImg.getY());
                    ap.getChildren().add(img_hover);
                });


                img.setOnMouseExited((event) -> {
                    System.out.println("enter\nx:"+ finalImg.getX()+"\ny: "+ finalImg.getY());
                    ImageView img_def;
                    img_def = new ImageView(new Image("file:pngs/tile_def.png"));
                    img_def.setFitWidth(100);
                    img_def.setFitHeight(100);
                    img_def.setX(finalImg.getX());
                    img_def.setY(finalImg.getY());

                    ap.getChildren().add(img_def);
                });*/


                ap.getChildren().add(img);
            }
        }
    }

    public void makeGrass(){

    }

    public void makeWater(){

    }

    //getters & setters
    public void setX_count(int z){ this.x_count = z; }
    public void setY_count(int z){ this.y_count = z; }
    public int getX_count(){ return this.x_count; }
    public int getY_count(){ return this.y_count; }

}