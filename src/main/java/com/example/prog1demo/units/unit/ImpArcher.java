package com.example.prog1demo.units.unit;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class ImpArcher extends Generic{
    AnchorPane anchorPane;
    ImageView actual = new ImageView(new Image("file:pngs/computer_units/imp_archer/imp_archer_stand.png"));
    ImageView stand = new ImageView(new Image("file:pngs/computer_units/imp_archer/imp_archer_stand.png"));
    ImageView dead = new ImageView(new Image("file:pngs/computer_units/imp_archer/imp_archer_death.png"));
    int imgX, imgY;
    static boolean active=false;
    Random rand = new Random();
    static int count;
    static int cost = 2;
    int movement = 4,
        initiative = 3,
        pos_x,
        pos_y;
    static double attMin=2;
    static double attMax=4;
    static double deff=1;
    static double magic =1;
    static double wisdom=1;
    static double moral=1;
    static double luck=1;
    static double crit=0;
    static int hp = 7;

    ImageView[] movement_sprite = {
            new ImageView(new Image("file:pngs/computer_units/imp_archer/move/imp_archer_m1.png")),
            new ImageView(new Image("file:pngs/computer_units/imp_archer/move/imp_archer_m2.png")),
            new ImageView(new Image("file:pngs/computer_units/imp_archer/move/imp_archer_m3.png")),
            new ImageView(new Image("file:pngs/computer_units/imp_archer/move/imp_archer_m4.png")),
            new ImageView(new Image("file:pngs/computer_units/imp_archer/move/imp_archer_m5.png")),
            new ImageView(new Image("file:pngs/computer_units/imp_archer/move/imp_archer_m6.png")),
            new ImageView(new Image("file:pngs/computer_units/imp_archer/move/imp_archer_m7.png")),
            new ImageView(new Image("file:pngs/computer_units/imp_archer/move/imp_archer_m8.png")),
            new ImageView(new Image("file:pngs/computer_units/imp_archer/move/imp_archer_m9.png")),
    };

    ImageView[] attack_sprite = {
            new ImageView(new Image("file:pngs/computer_units/imp_archer/attack/imp_archer_a1.png")),
            new ImageView(new Image("file:pngs/computer_units/imp_archer/attack/imp_archer_a2.png")),
            new ImageView(new Image("file:pngs/computer_units/imp_archer/attack/imp_archer_a3.png")),
            new ImageView(new Image("file:pngs/computer_units/imp_archer/attack/imp_archer_a4.png")),
            new ImageView(new Image("file:pngs/computer_units/imp_archer/attack/imp_archer_a5.png")),
            new ImageView(new Image("file:pngs/computer_units/imp_archer/attack/imp_archer_a6.png")),
    };

    public ImpArcher(){ count= rand.nextInt(100); }

    public ImpArcher(int px, int py, AnchorPane AP){
        this.pos_x = px;
        this.pos_y = py;
        actual.setX(px);
        actual.setY(py);
        actual.setFitWidth(100);
        actual.setFitHeight(100);
        this.anchorPane = AP;
        //AP.getChildren().add(actual);
        this.imgX = px;
        this.imgY = py;
        count= rand.nextInt(100);
    }


    public String toString(){
        return "AttackMin :"+attMin+"\nAttackMax: "+attMax+"\nDeff: "+deff+"\nMagic: "+magic+
                "\nWisdom: "+wisdom+"\nMoral: "+moral+"\nLuck: ";
    }


    public double getAttMin() { return attMin; }
    public void setAttMin(double attack) { attMin = attack; }
    public double getAttMax() { return attMax; }
    public void setAttMax(double attack) { attMax = attack; }
    public double getDeff() { return deff; }
    public void setDeff(double deffense) { deff = deffense; }
    public double getMagic() { return magic; }
    public void setMagic(double magic_power) { magic = magic_power; }
    public double getWisdom() { return wisdom; }
    public void setWisdom(double wisdom) { wisdom = wisdom; }
    public double getMoral() { return moral; }
    public void setMoral(double moral) { moral = moral; }
    public double getLuck() { return luck; }
    public void setLuck(double luck) { luck = luck; }
    public int getHp() { return hp; }
    public void setHp(int  health) { hp = health; }
    public double getCrit(){ return crit; }
    public void setCrit(double asd){ crit = asd; }

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
    public String getName(){ return "ImpArcher"; }
    public void setActive(boolean asd){ active = asd; }
    public boolean isActive(){ return active; }

    public void setImg(ImageView z,AnchorPane anchorPane){
        anchorPane.getChildren().remove(actual);
        this.actual = z;
        anchorPane.getChildren().add(actual);
    }

    public void setImg(String z,AnchorPane anchorPane) {
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
