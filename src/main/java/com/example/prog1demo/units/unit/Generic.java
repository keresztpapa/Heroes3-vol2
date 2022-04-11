package com.example.prog1demo.units.unit;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Generic {
    AnchorPane anchorPane;
    int cost = 2;
    double damage = 1;
    int hp = 0;
    double deff = 1;
    int movement = 4;
    int initiative = 7;
    int pos_x;
    int pos_y;
    int count=0;
    ImageView actual = new ImageView();
    ImageView stand = new ImageView();
    ImageView dead = new ImageView();
    double attMin=1;
    double attMax=1;
    double magic =1;
    double wisdom=1;
    double moral=1;
    double luck=1;
    double crit=0;
    static boolean active=false;

    public Generic(){}

    public Generic(AnchorPane ap){
        this.anchorPane = ap;
    }

    ImageView[] movement_sprite = {};

    ImageView[] attack_sprite = {};


    public int getCost() { return cost; }
    public void setCost(int cost) { this.cost = cost; }
    public double getDamage() { return damage; }
    public void setDamage(double damage) { this.damage = damage; }

    //getters + setters
    public double getAttMin() { return attMin; }
    public void setAttMin(double attack) { this.attMin = attack; }
    public double getAttMax() { return attMax; }
    public void setAttMax(double attack) { this.attMax = attack; }
    public double getDeff() { return deff; }
    public void setDeff(double deffense) { this.deff = deffense; }
    public double getMagic() { return magic; }
    public void setMagic(double magic_power) { this.magic = magic_power; }
    public double getWisdom() { return wisdom; }
    public void setWisdom(double wisdom) { this.wisdom = wisdom; }
    public double getMoral() { return moral; }
    public void setMoral(double moral) { this.moral = moral; }
    public double getLuck() { return luck; }
    public void setLuck(double luck) { this.luck = luck; }
    public int getHp() { return hp; }
    public void setHp(int  health) { this.hp = health; }
    public double getCrit(){ return this.crit; }
    public void setCrit(double asd){ this.crit = asd; }
    public int getCount(){ return this.count; }

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
    public String getName(){ return ""; }
    public void setActive(boolean asd){ active = asd; }
    public boolean isActive(){ return active; }


    public void setImg(ImageView z, AnchorPane anchorPane){
            anchorPane.getChildren().remove(actual);
            this.actual = z;
            anchorPane.getChildren().add(actual);
    }

    public void setImg(String z, AnchorPane anchorPane) {
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
