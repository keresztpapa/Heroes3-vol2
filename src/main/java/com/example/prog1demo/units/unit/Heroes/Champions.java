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

package com.example.prog1demo.units.unit.Heroes;

import com.example.prog1demo.BattleField.Tile;
import com.example.prog1demo.units.unit.Generic;
import com.example.prog1demo.Interfaces.Action;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Champions extends Generic implements Action{
    static double att=1;
    static double deff=1;
    static double magic =1;
    static double wisdom=1;
    static double moral=1;
    static double luck=1;
    static int pos_x;
    static int pos_y;
    static int gold;
    static int mana=0;
    static boolean fire=false;
    static boolean thunder=false;
    static boolean res=false;

    static boolean fireActive=false;
    static boolean thunderActive=false;
    static boolean resActive=false;

    static int soldierCount=0;
    static int griffCount=0;
    static int archerCount=0;
    static int mageCount=0;

    ImageView img;

    ImageView actual = new ImageView(new Image("file:pngs/ChimpPokemon.png"));
    ImageView stand = new ImageView(new Image("file:pngs/ChimpPokemon.png"));

    public Champions(int x){ gold = x; }
    public Champions(){}

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
    public void setGold(int z){ gold = z; }
    public int getGold(){ return gold; }
    public void setSoldierCount(int z){ soldierCount = z; }
    public int getSoldierCount(){ return soldierCount; }
    public void setArcherCount(int z){ archerCount = z; }
    public int getArcherCount(){ return archerCount; }
    public void setGriffCount(int z){ griffCount = z; }
    public int getGriffCount(){ return griffCount; }
    public int getMageCount(){ return mageCount; }
    public void setMageCount(int z){ mageCount = z; }
    public String getName(){ return "Chimp"; }

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
}
