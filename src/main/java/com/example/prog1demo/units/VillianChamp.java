/**
 * Ellenfél hőse.
 * Kezdetleges formai másolata a játékos irányította hősnek.
 * A főbb cselekményei máshol vannak implementálva.
 */

package com.example.prog1demo.units;

import com.example.prog1demo.Interfaces.Action;
import com.example.prog1demo.units.unit.Generic;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class VillianChamp extends Generic implements Action {
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
        static boolean fire=true;
        static boolean thunder=true;
        static boolean res=false;

        static int soldierCount=0;
        static int griffCount=0;
        static int archerCount=0;

        ImageView img;
        ImageView actual2 = new ImageView(new Image("file:pngs/EvilChimpPokemon.png"));
        ImageView stand = new ImageView(new Image("file:pngs/EvilChimpPokemon.png"));
        public VillianChamp(int attack, int deffense, int mgc, int wisd, int mor, int lucky){
            att = attack;
            deff = deffense;
            magic = mgc;
            wisdom = wisd;
            moral = mor;
            luck = lucky;
            pos_x = 700;
            pos_y = 700;
        }

        public VillianChamp(int x){ gold = x; }
        public VillianChamp(){}

        public void setImg(String z, AnchorPane anchorPane) {
                this.actual2 = stand;
                actual2.setX(pos_x);
                actual2.setY(pos_y);
                //anchorPane.getChildren().add(actual2);
        }

        //getters + setters
        public double getAtt() { return att; }
        public void setAtt(double attack) { att = attack; }
        public double getDeff() { return deff; }
        public void setDeff(double dff) { deff = dff; }
        public double getMagic() { return magic; }
        public void setMagic(double mgc_pwr) { magic = mgc_pwr; }
        public double getWisdom() { return wisdom; }
        public void setWisdom(double wsdm) { wisdom = wsdm; }
        public double getMoral() { return moral; }
        public void setMoral(double mrl) { moral = mrl; }
        public double getLuck() { return luck; }
        public void setLuck(double lck) { luck = lck; }
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
