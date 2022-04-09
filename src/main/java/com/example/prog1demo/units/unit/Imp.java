package com.example.prog1demo.units.unit;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Imp extends Generic{
    AnchorPane anchorPane;
    ImageView actual = new ImageView(new Image("file:pngs/computer_units/imp/imp_stand.png"));
    ImageView stand = new ImageView(new Image("file:pngs/computer_units/imp/imp_stand.png"));
    ImageView dead = new ImageView(new Image("file:pngs/computer_units/imp/imp_death.png"));
    int imgX, imgY;

    static int count=0;
    int     cost = 2,
            movement = 4,
            initiative = 8,
            pos_x,
            pos_y;

    double damage = 1;
    double hp = 3;

    ImageView[] movement_sprite = {
            new ImageView(new Image("file:pngs/computer_units/imp/move/imp_m1.png")),
            new ImageView(new Image("file:pngs/computer_units/imp/move/imp_m2.png")),
            new ImageView(new Image("file:pngs/computer_units/imp/move/imp_m3.png")),
            new ImageView(new Image("file:pngs/computer_units/imp/move/imp_m4.png")),
            new ImageView(new Image("file:pngs/computer_units/imp/move/imp_m5.png")),
            new ImageView(new Image("file:pngs/computer_units/imp/move/imp_m6.png")),
            new ImageView(new Image("file:pngs/computer_units/imp/move/imp_m7.png")),
            new ImageView(new Image("file:pngs/computer_units/imp/move/imp_m8.png")),
            new ImageView(new Image("file:pngs/computer_units/imp/move/imp_m9.png")),
    };

    ImageView[] attack_sprite = {
            new ImageView(new Image("file:pngs/computer_units/imp/attack/imp_a1.png")),
            new ImageView(new Image("file:pngs/computer_units/imp/attack/imp_a2.png")),
            new ImageView(new Image("file:pngs/computer_units/imp/attack/imp_a3.png")),
            new ImageView(new Image("file:pngs/computer_units/imp/attack/imp_a4.png")),
            new ImageView(new Image("file:pngs/computer_units/imp/attack/imp_a5.png")),
            new ImageView(new Image("file:pngs/computer_units/imp/attack/imp_a6.png")),
    };

    public Imp(int px, int py, AnchorPane AP){
        this.pos_x = px;
        this.pos_y = py;
        actual.setX(px);
        actual.setY(py);
        actual.setFitWidth(100);
        actual.setFitHeight(100);
        this.anchorPane = AP;
        this.imgX = px;
        this.imgY = py;
    }



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
    public int getCount(){ return count; }
    public void setCount(int z){ count = z; }

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
