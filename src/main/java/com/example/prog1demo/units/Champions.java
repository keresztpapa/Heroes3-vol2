/**
 * A hős osztálya
 * FireBall()
 * A hősnek az első varázslata.
 * Kattintás következtében egy 3*3-as sugarú körben robbanást szenvednek el az egységek.
 *
 * @param map           a harctér átadása, 2D Tile object tömb
 * @param centerX       a mezőben lévő X kordináta, a robbanás központjának
 * @param centerY       a mezőben lévő Y kordináta, a robbanás központjának
 * @param units         ArrayList a játékban lévő, mezőn elhelyezett karakterekről
 * @param anchorPane    a felület ami módosul amin lefut a method
 *
 * Lightning()
 * A hős második varázslata.
 * A kiválasztott egységet villámcsapást szenved el.
 *
 * @param unit          a kiválasztott egység, ami elszenvedi a támadást
 *
 * Ressurection()
 * A hős utolsó varázslata, képes feltámasztani vele egy adott karakterét.
 *
 * @param unit          az egység amit feltámaszt,
 *
 */

package com.example.prog1demo.units;

import com.example.prog1demo.BattleField.Tile;
import com.example.prog1demo.units.unit.Generic;
import com.example.prog1demo.Action;
import javafx.scene.image.Image;
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

    static boolean fireActive=false;
    static boolean thunderActive=false;
    static boolean resActive=false;

    static boolean active=false;
    static int soldierCount=0;
    static int griffCount=0;
    static int archerCount=0;

    ImageView img;

    ImageView actual = new ImageView(new Image("file:pngs/ChimpPokemon.png"));
    ImageView stand = new ImageView(new Image("file:pngs/ChimpPokemon.png"));

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
                units.get(i).setHp((int) (units.get(i).getHp()-magic*20));
            }
            if(units.get(i).getHp()<=0) units.get(i).setImg("dead", anchorPane);
        }
        System.out.println("FIRE FIRE FIRE");
        mana-=9;
    }

    public void lightning(Generic unit){
        unit.setHp((int) (unit.getHp()-magic*30));
        mana-=5;
    }

    public void ressurrect(Generic unit, AnchorPane anchorPane){
        if(unit.getName().equals("Archer") || unit.getName().equals("Griff") || unit.getName().equals("Pike")){
           if(unit.getHp()<=0){
               unit.setHp((int) (unit.getHp()+magic*50));
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

    public boolean isFireActive(){ return fireActive; }
    public void setFireActive(boolean asd){ fireActive = asd; }
    public boolean isThunderActive() { return thunderActive; }
    public void setThunderActive(boolean asd) { thunderActive = asd; }
    public boolean isResActive() { return resActive; }
    public void setResActive(boolean asd){ resActive = asd; }

    public void setImg(String z, AnchorPane anchorPane) {
            anchorPane.getChildren().remove(actual);
            this.actual = stand;
            actual.setX(pos_x);
            actual.setY(pos_y);
            anchorPane.getChildren().add(actual);
    }

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