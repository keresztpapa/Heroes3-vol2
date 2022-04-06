package com.example.prog1demo.units;

import com.example.prog1demo.Action;
import javafx.scene.image.ImageView;

public class Champions implements Action {
    int att=1;
    int deff=1;
    int magic_power=1;
    int wisdom=1;
    int moral=1;
    int luck=1;
    int pos_x;
    int pos_y;
    ImageView img;
    static int gold;

    static int soldierCount=0;
    static int griffCount=0;
    static int archerCount=0;


    public Champions(int attack, int deffense, int magic, int wisd, int mor, int lucky, int px, int py){
        this.att = attack;
        this.deff = deffense;
        this.magic_power = magic;
        this.wisdom = wisd;
        this.moral = mor;
        this.luck = lucky;
        this.pos_x = px;
        this.pos_y = py;
    }

    public Champions(int x){ gold = x; }
    public Champions(){}

    //getters + setters
    public int getAtt() { return att; }
    public void setAtt(int att) { this.att = att; }
    public int getDeff() { return deff; }
    public void setDeff(int deff) { this.deff = deff; }
    public int getMagic_power() { return magic_power; }
    public void setMagic_power(int magic_power) { this.magic_power = magic_power; }
    public int getWisdom() { return wisdom; }
    public void setWisdom(int wisdom) { this.wisdom = wisdom; }
    public int getMoral() { return moral; }
    public void setMoral(int moral) { this.moral = moral; }
    public int getLuck() { return luck; }
    public void setLuck(int luck) { this.luck = luck; }
    public void setPos_x(int x) { this.pos_x = x; }
    public void setPos_y(int y) { this.pos_y = y; }
    public int getPos_x(){ return this.pos_x; }
    public int getPos_y(){ return this.pos_y; }
    public ImageView getImg(){ return this.img; }
    public void setGold(int z){ gold = z; }
    public int getGold(){ return gold; }
}
