/**
 * Ellenfél hőse.
 * Kezdetleges formai másolata a játékos irányította hősnek.
 * A főbb cselekményei máshol vannak implementálva.
 */

package com.example.prog1demo.units.unit.Heroes;

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
        static int mana=0;
        static int impCount=0;
        static int houndCount=0;
        static int impArcherCount=0;
        static int genie = 0;

        ImageView img;
        ImageView actual2 = new ImageView(new Image("file:pngs/EvilChimpPokemon.png"));
        ImageView stand = new ImageView(new Image("file:pngs/EvilChimpPokemon.png"));

        public VillianChamp(){}

        public void setImg(String z, AnchorPane anchorPane) {
                this.actual2 = stand;
                actual2.setX(pos_x);
                actual2.setY(pos_y);
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
        public void setImpCount(int z){ impCount = z; }
        public int getImpCount(){ return impCount; }
        public void setImpArcherCount(int z){ impArcherCount = z; }
        public int getImpArcherCount(){ return impArcherCount; }
        public void setHoundCount(int z){ houndCount = z; }
        public int getHoundCount(){ return houndCount; }
        public double getGenieCount(){ return genie; }
        public void setGenieCount(int z){ genie = z; }

        public String getName(){ return "evilChimp"; }
        public int getMana(){ return mana; }
        public void setMana(int asd){ mana = asd; }
}
