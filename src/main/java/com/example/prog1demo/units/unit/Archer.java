package com.example.prog1demo.units.unit;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Archer {
    int cost;
    int dmg;
    int hp;
    int movement;
    int initiative;
    int pos_x;
    int pos_y;
    int imgX, imgY;

    ImageView stand = new ImageView(new Image("file:pngs/player_units/griff/griff_stand.png"));
    ImageView dead = new ImageView(new Image("file:pngs/player_units/griff/griff_dead.png"));
    ImageView[] movement_sprite = {
            new ImageView(new Image("file:pngs/player_units/griff/movement/griff_a1.png")),
            new ImageView(new Image("file:pngs/player_units/griff/movement/griff_a2.png")),
            new ImageView(new Image("file:pngs/player_units/griff/movement/griff_a3.png")),
            new ImageView(new Image("file:pngs/player_units/griff/movement/griff_a4.png")),
            new ImageView(new Image("file:pngs/player_units/griff/movement/griff_a5.png")),
            new ImageView(new Image("file:pngs/player_units/griff/movement/griff_a6.png")),
            new ImageView(new Image("file:pngs/player_units/griff/movement/griff_a7.png")),
    };
    ImageView[] attack_sprite = {
            new ImageView(new Image("file:pngs/player_units/griff/attack/griff_m1.png")),
            new ImageView(new Image("file:pngs/player_units/griff/attack/griff_m2.png")),
            new ImageView(new Image("file:pngs/player_units/griff/attack/griff_m3.png")),
            new ImageView(new Image("file:pngs/player_units/griff/attack/griff_m4.png")),
            new ImageView(new Image("file:pngs/player_units/griff/attack/griff_m5.png")),
            new ImageView(new Image("file:pngs/player_units/griff/attack/griff_m6.png")),
            new ImageView(new Image("file:pngs/player_units/griff/attack/griff_m7.png")),
            new ImageView(new Image("file:pngs/player_units/griff/attack/griff_m8.png"))
    };

    public Archer(int px, int py, AnchorPane AP){
        this.pos_x = px;
        this.pos_y = px;
        stand.setX(px);
        stand.setY(py);
        stand.setFitWidth(100);
        stand.setFitHeight(100);
        AP.getChildren().add(stand);
        this.imgX = px;
        this.imgY = py;
    }



    public int getCost() { return cost; }
    public void setCost(int cost) { this.cost = cost; }
    public int getDmg() { return dmg; }
    public void setDmg(int dmg) { this.dmg = dmg; }
    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }
    public int getMovement() { return movement; }
    public void setMovement(int movement) { this.movement = movement; }
    public int getInitiative() { return initiative; }
    public void setInitiative(int initiative) { this.initiative = initiative; }
    public int getPos_x() { return this.pos_x; }
    public int getPos_y(){ return this.pos_y; }
    public void setPos_x(int z) { this.pos_x = z; }
    public void setPos_y(int z){ this.pos_y = z; }
}
