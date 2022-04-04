package com.example.prog1demo.units.unit;

import com.example.prog1demo.units.Champions;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Objects;

public class Soldier{

        ImageView stand = new ImageView(new Image("file:pngs/player_units/pike/pike_stand.png"));
        ImageView dead = new ImageView(new Image("file:pngs/player_units/pike/pike_dead.png"));
        int imgX, imgY;

        int cost = 2,
            damage = 1,
            hp = 3,
            movement = 4,
            initiative = 8,
            pos_x,
            pos_y;

        ImageView[] movement_sprite = {
                new ImageView(new Image("file:pngs/player_units/pike/movement/pike_m1.png")),
                new ImageView(new Image("file:pngs/player_units/pike/movement/pike_m2.png")),
                new ImageView(new Image("file:pngs/player_units/pike/movement/pike_m3.png")),
                new ImageView(new Image("file:pngs/player_units/pike/movement/pike_m4.png")),
                new ImageView(new Image("file:pngs/player_units/pike/movement/pike_m5.png")),
                new ImageView(new Image("file:pngs/player_units/pike/movement/pike_m6.png"))
        };

        ImageView[] attack_sprite = {
                new ImageView(new Image("file:pngs/player_units/pike/attack/pike_a1.png")),
                new ImageView(new Image("file:pngs/player_units/pike/attack/pike_a2.png")),
                new ImageView(new Image("file:pngs/player_units/pike/attack/pike_a3.png")),
                new ImageView(new Image("file:pngs/player_units/pike/attack/pike_a4.png")),
                new ImageView(new Image("file:pngs/player_units/pike/attack/pike_a5.png")),
        };

        public Soldier(int px, int py, AnchorPane AP){
            this.pos_x = px;
            this.pos_y = py;
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
        public ImageView getImg(){ return this.stand; }
        public void setImageMovX(int asd){ stand.setX(asd); }
        public void setImageMovY(int asd){ stand.setY(asd); }
        public int getPos_x() { return this.pos_x; }
        public int getPos_y(){ return this.pos_y; }
        public void setPos_x(int z) { this.pos_x = z; }
        public void setPos_y(int z){ this.pos_y = z; }
}