package com.example.prog1demo.units;

import com.example.prog1demo.BattleField.Tile;
import com.example.prog1demo.units.unit.Generic;
import com.example.prog1demo.Action;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.Objects;

public class Champions extends Generic implements Action{
    static double att=1;
    static double deff=1;
    static double magic =1;
    static double wisdom=1;
    static double moral=1;
    static double luck=1;
    static int pos_x;
    static int pos_y;
    static double skillPoint=10.0;
    static int gold;
    static int mana=0;
    static boolean fire=false;
    static boolean thunder=false;
    static boolean res=false;

    static int soldierCount=0;
    static int griffCount=0;
    static int archerCount=0;

    ImageView img;

    public Champions(int attack, int deffense, int mgc, int wisd, int mor, int lucky, int px, int py){
        att = attack;
        deff = deffense;
        magic = mgc;
        wisdom = wisd;
        moral = mor;
        luck = lucky;
        pos_x = px;
        pos_y = py;
    }

    public Champions(int x){ gold = x; }
    public Champions(){}

    public void fireBall(Tile[][] map, int centerX, int centerY, ArrayList<Generic> units, AnchorPane anchorPane){
        int radX = map[centerX][centerY].getPos_x();
        int radY = map[centerX][centerY].getPos_y();
        for(int i=0;i<units.size();i++){
            if(units.get(i).getPos_x() <= radX+150 && units.get(i).getPos_x() >= radX-150 &&
                    units.get(i).getPos_y() <= radY+150 && units.get(i).getPos_y() >= radY-150){
                units.get(i).setHp(units.get(i).getHp()-magic*20);
            }
            if(units.get(i).getHp()<=0) units.get(i).setImg("dead", anchorPane);
        }
        mana-=9;
    }

    public void lightning(Generic unit){
        unit.setHp(unit.getHp()-magic*30);
        mana-=5;
    }

    public void ressurrect(Generic unit, AnchorPane anchorPane){
        if(unit.getName().equals("Archer") || unit.getName().equals("Griff") || unit.getName().equals("Pike")){
           if(unit.getHp()<=0){
               unit.setHp(unit.getHp()+magic*50);
               unit.setImg("stand",anchorPane);
           }
        }
    }



    //getters + setters
    public double getAtt() { return att; }
    public void setAtt(double att) { Champions.att = att; }
    public double getDeff() { return deff; }
    public void setDeff(double deff) { Champions.deff = deff; }
    public double getMagic() { return magic; }
    public void setMagic(double magic_power) { Champions.magic = magic_power; }
    public double getWisdom() { return wisdom; }
    public void setWisdom(double wisdom) { Champions.wisdom = wisdom; }
    public double getMoral() { return moral; }
    public void setMoral(double moral) { Champions.moral = moral; }
    public double getLuck() { return luck; }
    public void setLuck(double luck) { Champions.luck = luck; }
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

    public int getMana(){ return mana; }
    public void setMana(int asd){ mana = asd; }

    public void setFire(boolean asd){ fire = asd; }
    public void setThunder(boolean asd){ thunder = asd; }
    public void setRes(boolean asd){ res = asd; }

    public boolean getFire(){ return fire; }
    public boolean getThunder(){ return thunder; }
    public boolean getRes(){ return res; }
}

/*
        if((centerX < 12 && map[centerX-1][centerY].isOccupied()) &&
        (centerX < 12 && map[centerX+1][centerY].isOccupied()) &&
        (centerY < 10 && map[centerX][centerY-1].isOccupied()) &&
        (centerY < 10 && map[centerX][centerY-1].isOccupied()) &&
        (centerY < 10 && centerX < 12 && map[centerX-1][centerY-1].isOccupied()) &&
        (centerY < 10 && centerX < 12 && map[centerX-1][centerY+1].isOccupied()) &&
        (centerY < 10 && centerX < 12 && map[centerX+1][centerY-1].isOccupied()) &&
        (centerY < 10 && centerX < 12 && map[centerX+1][centerY+1].isOccupied())){
        */