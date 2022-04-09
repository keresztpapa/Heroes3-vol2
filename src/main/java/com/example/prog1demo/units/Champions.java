package com.example.prog1demo.units;

import com.example.prog1demo.units.unit.Generic;
import com.example.prog1demo.Action;
import javafx.scene.image.ImageView;

public class Champions extends Generic implements Action{
    static int att=1;
    static int deff=1;
    static int magic_power=1;
    static int wisdom=1;
    static int moral=1;
    static int luck=1;
    static int pos_x;
    static int pos_y;
    static double skillPoint=10.0;
    static int gold;

    static boolean fire=false;
    static boolean thunder=false;
    static boolean res=false;

    static int soldierCount=0;
    static int griffCount=0;
    static int archerCount=0;

    ImageView img;

    public Champions(int attack, int deffense, int magic, int wisd, int mor, int lucky, int px, int py){
        att = attack;
        deff = deffense;
        magic_power = magic;
        wisdom = wisd;
        moral = mor;
        luck = lucky;
        pos_x = px;
        pos_y = py;
    }

    public Champions(int x){ gold = x; }
    public Champions(){}

    //getters + setters
    public int getAtt() { return att; }
    public void setAtt(int att) { Champions.att = att; }
    public int getDeff() { return deff; }
    public void setDeff(int deff) { Champions.deff = deff; }
    public int getMagic_power() { return magic_power; }
    public void setMagic_power(int magic_power) { Champions.magic_power = magic_power; }
    public int getWisdom() { return wisdom; }
    public void setWisdom(int wisdom) { Champions.wisdom = wisdom; }
    public int getMoral() { return moral; }
    public void setMoral(int moral) { Champions.moral = moral; }
    public int getLuck() { return luck; }
    public void setLuck(int luck) { Champions.luck = luck; }
    public void setPos_x(int x) { pos_x = x; }
    public void setPos_y(int y) { pos_y = y; }
    public int getPos_x(){ return pos_x; }
    public int getPos_y(){ return pos_y; }
    public ImageView getImg(){ return this.img; }
    public void setGold(int z){ gold = z; }
    public int getGold(){ return gold; }
    public void setSoldierCount(int z){ soldierCount = z; }
    public int getSoldierCount(){ return soldierCount; }
    public void setArcherCount(int z){ archerCount = z; }
    public int getArcherCount(){ return archerCount; }
    public void setGriffCount(int z){ griffCount = z; }
    public int getGriffCount(){ return griffCount; }
    public double getSkillPoint(){ return skillPoint; }
    public void setSkillPoint(double z){ skillPoint = z; }

    public void setFire(boolean asd){ fire = asd; }
    public void setThunder(boolean asd){ thunder = asd; }
    public void setRes(boolean asd){ res = asd; }

    public boolean getFire(){ return fire; }
    public boolean getThunder(){ return thunder; }
    public boolean getRes(){ return res; }
}
