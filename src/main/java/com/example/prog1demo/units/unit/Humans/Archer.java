/**
 * Íjász oszttálya
 * Főként statikus változói vannak
 * És ImageView tömbjei
 *
 * Rendelekzik egy toString() metódussal,
 * @return      az objektum értékeit adja visssza
 *
 * setImg()
 * @param z     abban az esetben ha az ImageView értékét direkt szeretnénk megadni
 *
 *              beállítja az aktuális sprite -ját az object -nek állapottól függően
 *
 * setImg()
 * @param z     Overload -olható az előző metódus,
 *              ha String-ként adjuk a paramétert akkor annak fejében állítja be a sprite-ot
 *
 */

package com.example.prog1demo.units.unit.Humans;

import com.example.prog1demo.units.unit.Generic;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Archer extends Generic {
    int cost;
    static int hp;
    int movement;
    int initiative=0;
    int pos_x;
    int pos_y;
    int imgX, imgY;
    static int count=0;
    static boolean active=false;
    static double attMin=2;
    static double attMax=4;
    static double deff=1;
    static double magic =1;
    static double wisdom=1;
    static double moral=1;
    static double luck=1;
    static double crit=1;

    AnchorPane anchorPane;
    ImageView actual = new ImageView(new Image("file:pngs/player_units/archer/archer_stand.png"));
    ImageView stand = new ImageView(new Image("file:pngs/player_units/archer/archer_stand.png"));
    ImageView dead = new ImageView(new Image("file:pngs/player_units/archer/archer_dead.png"));
    ImageView[] movement_sprite = {
            new ImageView(new Image("file:pngs/player_units/archer/movement/archer_a1.png")),
            new ImageView(new Image("file:pngs/player_units/archer/movement/archer_a2.png")),
            new ImageView(new Image("file:pngs/player_units/archer/movement/archer_a3.png")),
            new ImageView(new Image("file:pngs/player_units/archer/movement/archer_a4.png")),
            new ImageView(new Image("file:pngs/player_units/archer/movement/archer_a5.png")),
            new ImageView(new Image("file:pngs/player_units/archer/movement/archer_a6.png")),
            new ImageView(new Image("file:pngs/player_units/archer/movement/archer_a7.png")),
    };
    ImageView[] attack_sprite = {
            new ImageView(new Image("file:pngs/player_units/archer/attack/archer_m1.png")),
            new ImageView(new Image("file:pngs/player_units/archer/attack/archer_m2.png")),
            new ImageView(new Image("file:pngs/player_units/archer/attack/archer_m3.png")),
            new ImageView(new Image("file:pngs/player_units/archer/attack/archer_m4.png")),
            new ImageView(new Image("file:pngs/player_units/archer/attack/archer_m5.png")),
            new ImageView(new Image("file:pngs/player_units/archer/attack/archer_m6.png")),
            new ImageView(new Image("file:pngs/player_units/archer/attack/archer_m7.png")),
            new ImageView(new Image("file:pngs/player_units/archer/attack/archer_m8.png")),
            new ImageView(new Image("file:pngs/player_units/archer/attack/archer_m9.png")),
            new ImageView(new Image("file:pngs/player_units/archer/attack/archer_m10.png")),
            new ImageView(new Image("file:pngs/player_units/archer/attack/archer_m11.png")),
            new ImageView(new Image("file:pngs/player_units/archer/attack/archer_m12.png")),

    };

    public Archer(){}

    public Archer(int px, int py, AnchorPane AP){
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
    }

    public String toString(){
        return "AttackMin :"+attMin+"\nAttackMax: "+attMax+"\nDeff: "+deff+"\nMagic: "+magic+
                "\nWisdom: "+wisdom+"\nMoral: "+moral+"\nLuck: "+luck;
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
    public void setWisdom(double wsdm) { wisdom = wsdm; }
    public double getMoral() { return moral; }
    public void setMoral(double mrl) { moral = mrl; }
    public double getLuck() { return luck; }
    public void setLuck(double lck) { luck = lck; }
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
    public String getName(){ return "Archer"; }
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
