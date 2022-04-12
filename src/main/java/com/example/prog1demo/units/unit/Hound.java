/**
 * A számítógép egységeiből a Griffnek a megfelelője
*  Főként statikus változói vannak
*  És ImageView tömbjei
*
*  Rendelekzik egy toString() metódussal,
*  @return      az objektum értékeit adja visssza
*
*  setImg()
*  @param z     abban az esetben ha az ImageView értékét direkt szeretnénk megadni
*
*               beállítja az aktuális sprite -ját az object -nek állapottól függően
*
*  setImg()
*  @param z     Overload -olható az előző metódus,
*              ha String-ként adjuk a paramétert akkor annak fejében állítja be a sprite-ot
*/
package com.example.prog1demo.units.unit;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class Hound extends Generic{
    AnchorPane anchorPane;
    ImageView actual = new ImageView(new Image("file:pngs/computer_units/hound/hound_stand.png"));
    ImageView stand = new ImageView(new Image("file:pngs/computer_units/hound/hound_stand.png"));
    ImageView dead = new ImageView(new Image("file:pngs/computer_units/hound/hound_death.png"));
    int imgX, imgY;
    static double attMin=5;
    static double attMax=10;
    static double deff=1;
    static double magic =1;
    static double wisdom=1;
    static double moral=1;
    static double luck=1;
    static double crit=0;
    Random rand = new Random();
    static int count;
    static int cost = 2;
    int movement = 4,
        initiative = 1,
        pos_x,
        pos_y;
    static int hp = 30;
    static boolean active=false;

    ImageView[] movement_sprite = {
            new ImageView(new Image("file:pngs/computer_units/hound/move/hound_m1.png")),
            new ImageView(new Image("file:pngs/computer_units/hound/move/hound_m2.png")),
            new ImageView(new Image("file:pngs/computer_units/hound/move/hound_m3.png")),
            new ImageView(new Image("file:pngs/computer_units/hound/move/hound_m4.png")),
            new ImageView(new Image("file:pngs/computer_units/hound/move/hound_m5.png")),
            new ImageView(new Image("file:pngs/computer_units/hound/move/hound_m6.png")),
            new ImageView(new Image("file:pngs/computer_units/hound/move/hound_m7.png")),
    };

    ImageView[] attack_sprite = {
            new ImageView(new Image("file:pngs/computer_units/hound/attack/hound_a1.png")),
            new ImageView(new Image("file:pngs/computer_units/hound/attack/hound_a2.png")),
            new ImageView(new Image("file:pngs/computer_units/hound/attack/hound_a3.png")),
            new ImageView(new Image("file:pngs/computer_units/hound/attack/hound_a4.png")),
            new ImageView(new Image("file:pngs/computer_units/hound/attack/hound_a5.png")),
            new ImageView(new Image("file:pngs/computer_units/hound/attack/hound_a6.png")),
            new ImageView(new Image("file:pngs/computer_units/hound/attack/hound_a7.png")),
    };

    public Hound(){  count= rand.nextInt(100);  }

    public Hound(int px, int py, AnchorPane AP){
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
    public String getName(){ return "Hound"; }
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
