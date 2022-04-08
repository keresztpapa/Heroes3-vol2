package com.example.prog1demo.units.unit;

import com.example.prog1demo.Action;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Generic {
    AnchorPane anchorPane;
    int cost = 2;
    int damage = 1;
    int hp = 3;
    int movement = 4;
    int initiative = 8;
    int pos_x;
    int pos_y;
    ImageView actual;
    ImageView stand;
    ImageView dead;

    ImageView[] movement_sprite = {};

    ImageView[] attack_sprite = {};


    public int getCost() { return cost; }
    public void setCost(int cost) { this.cost = cost; }
    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; }
    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }
    public int getMovement() { return movement; }
    public void setMovement(int movement) { this.movement = movement; }
    public int getInitiative() { return initiative; }
    public void setInitiative(int initiative) { this.initiative = initiative; }
    public int getImgX(){ return (int) this.actual.getX(); }
    public int getImgY(){ return (int) this.actual.getY(); }
    public ImageView getActual(){ return this.actual; }
    public void setImageMovX(int asd){ actual.setX(asd); }
    public void setImageMovY(int asd){ actual.setY(asd); }
    public int getPos_x() { return this.pos_x; }
    public int getPos_y(){ return this.pos_y; }
    public void setPos_x(int z) { this.pos_x = z; }
    public void setPos_y(int z){ this.pos_y = z; }
    public ImageView[] getWalk(){ return this.movement_sprite; }
    public ImageView getWalk(int z){ return this.movement_sprite[z]; }
    public ImageView getAttack(int z) { return this.attack_sprite[z]; }
    public ImageView[] getAttack(){ return this.movement_sprite; }


    public void setImg(ImageView z){
        anchorPane.getChildren().remove(actual);
        this.actual = z;
        anchorPane.getChildren().add(actual);
    }

    public void setImg(String z) {
        if ("dead".equals(z)) {
            anchorPane.getChildren().remove(actual);
            this.actual = dead;
            actual.setX(this.pos_x);
            actual.setY(this.pos_y);
            anchorPane.getChildren().add(actual);
        } else {
            anchorPane.getChildren().remove(actual);
            this.actual = stand;
            actual.setX(this.pos_x);
            actual.setY(this.pos_y);
            anchorPane.getChildren().add(actual);
        }
    }

}
