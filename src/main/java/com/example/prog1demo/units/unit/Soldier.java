package com.example.prog1demo.units.unit;

import com.example.prog1demo.units.UnitBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Soldier extends UnitBase {

        ImageView stand = new ImageView(new Image("file:pngs/player_units/pike/pike_stand.png"));
        ImageView dead = new ImageView(new Image("file:pngs/player_units/pike/pike_dead.png"));
        int imgX, imgY;

        ImageView[] movement_sprite = {
                new ImageView(new Image("file:pngs/player_units/pike/pike_m1.png")),
                new ImageView(new Image("file:pngs/player_units/pike/pike_m2.png")),
                new ImageView(new Image("file:pngs/player_units/pike/pike_m3.png")),
                new ImageView(new Image("file:pngs/player_units/pike/pike_m4.png")),
                new ImageView(new Image("file:pngs/player_units/pike/pike_m5.png")),
                new ImageView(new Image("file:pngs/player_units/pike/pike_m6.png"))
        };

        ImageView[] attack_sprite = {
                new ImageView(new Image("file:pngs/player_units/pike/pike_a1.png")),
                new ImageView(new Image("file:pngs/player_units/pike/pike_a2.png")),
                new ImageView(new Image("file:pngs/player_units/pike/pike_a3.png")),
                new ImageView(new Image("file:pngs/player_units/pike/pike_a4.png")),
                new ImageView(new Image("file:pngs/player_units/pike/pike_a5.png")),
        };

        public Soldier(int attack, int deffense, int magic, int wisd, int mor, int lucky, int px, int py, AnchorPane AP){
            super(attack,deffense,magic,wisd,mor,lucky,px,py);
            stand.setX(px);
            stand.setY(py);
            stand.setFitWidth(100);
            stand.setFitHeight(100);
            AP.getChildren().add(stand);
            this.imgX = px;
            this.imgY = py;
        }

        public int getImgX(){ return (int) stand.getX(); }
        public int getImgY(){ return (int) stand.getY(); }
        @Override
        public ImageView getImg(){ return this.stand; }
        public void setImageMovX(int asd){ stand.setX(asd); }
        public void setImageMovY(int asd){ stand.setY(asd); }
}



/*
        public void move(int endPosX, AnchorPane AP){
            while(this.getPos_x() <= endPosX){
                this.setPos_x(this.getPos_x()+1);
                stand.setX(this.getPos_x());
                AP.getChildren().add(stand);
            }
            while(this.getPos_x() >= endPosX){
                this.setPos_x(this.getPos_x()-1);
                stand.setX(this.getPos_x());
                AP.getChildren().add(stand);
            }
        }

 */