/**
 * Interface amiben implementálva vannak a harctéren történt események.
 *
 * isNeighbour()
 * @param map           a 2D Tile object tömb, ami harctérként funkcionál
 * @param g1            az első számú egység, ő az aktuális konfliktusban a támadó fél
 * @param g2            a második számú egység, a konfliktusban, ő szenvedi el a sebzést
 * @param rowCount      a 2D tömb sorának számai
 * @param colCount      a 2D tömb oszlopainak számai
 *
 * @return              visszaadja azt, hogy 2 egység szomszédos e
 *
 * attack()
 * ha az isNeighbour igazzal tér vissza,
 * akkor a hős megtámadja az adott egységet
 *
 * @param map           a 2D Tile object tömb, ami harctérként funkcionál
 * @param g1            az első számú egység, ő az aktuális konfliktusban a támadó fél
 * @param g2            a második számú egység, a konfliktusban, ő szenvedi el a sebzést
 * @param rowCount      a 2D tömb sorának számai
 * @param colCount      a 2D tömb oszlopainak számai
 *
 *
 * attackWitoutLimit()
 *  ha az isNeighbour hamissal tér vissza.
 *  és a támadó egység távolsági harcos
 *  akkor támadhat egyszer, nem figyelve a távolságra
 *
 * @param map           a 2D Tile object tömb, ami harctérként funkcionál
 * @param g1            az első számú egység, ő az aktuális konfliktusban a támadó fél
 * @param g2            a második számú egység, a konfliktusban, ő szenvedi el a sebzést
 * @param rowCount      a 2D tömb sorának számai
 * @param colCount      a 2D tömb oszlopainak számai
 *
 *
 * move()
 * Az aktuális egység mozgásáért felelős method.
 * Az egység 1-essével lépked a megadott célfelé, amíg az el nem éri azt,
 * vagy ki nem fogy a mozgásából
 *
 * @param map           a 2D Tile object tömb, ami harctérként funkcionál
 * @param g1            az első számú egység, ő az aktuális konfliktusban a támadó fél
 * @param g2            a második számú egység, a konfliktusban, ő szenvedi el a sebzést
 * @param rowCount      a 2D tömb sorának számai
 * @param colCount      a 2D tömb oszlopainak számai
 *
 *
 * place()
 * A csatát megelőző jatékos egységeinek elhelyezése.
 *
 * @param map           a 2D Tile object tömb, ami harctérként funkcionál
 * @param generic       az egység amit le akarunk tenni
 * @param rowCount      a 2D tömb sorának számai
 * @param colCount      a 2D tömb oszlopainak számai
 *
 *
 * unitUpdate()
 * Frissíti a játékan lévő egységek pontjait a hős képességeit beszámítva.
 *
 * @param chimp         a játékos által irányított hős
 * @param evilChimp     a számítógép által irányított hős
 * @param pike          a gyalogos, közelharci egység (player)
 * @param griff         a griff egysége (player)
 * @param archer        a távolsági egység (player)
 * @param imp           a gyalogos, közelharci egység, (computer)
 * @param hound         a 'griff' megfelelője (computer)
 * @param impArcher     az íjász megfelelője (computer)
 */


package com.example.prog1demo;

import com.example.prog1demo.BattleField.Tiles;
import com.example.prog1demo.BattleField.Tile;
import com.example.prog1demo.units.Champions;
import com.example.prog1demo.units.VillianChamp;
import com.example.prog1demo.units.unit.Generic;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.Random;

public interface Action {

    default boolean isNeighbour(Tile[][] map, Generic g1, Generic g2, int rowCount, int colCount){
        int x1 = g1.getPos_x()/100,
            y1 = g1.getPos_y()/100,

            x2 = g2.getPos_x()/100,
            y2 = g2.getPos_y()/100;

        if(x1<12 && map[x1][y1].getPos_x()+100 == map[x2][y2].getPos_x()) return true;
        if(x1<12 && map[x1][y1].getPos_x()-100 == map[x2][y2].getPos_x()) return true;
        if(y1<10 && map[x1][y1].getPos_y()+100 == map[x2][y2].getPos_y()) return true;
        if(y1<10 && map[x1][y1].getPos_y()-100 == map[x2][y2].getPos_y()) return true;

/*
        if(y1<10 && map[x1][y1].getPos_y()+101 == map[x2][y2].getPos_y() &&
                x1<12 && map[x1][y1].getPos_x()+101 == map[x2][y2].getPos_x()) return true;

        if(y1<10 && map[x1][y1].getPos_y()+101 == map[x2][y2].getPos_y() &&
                x1<12 && map[x1][y1].getPos_x()-99 == map[x2][y2].getPos_x()) return true;

        if(y1<10 && map[x1][y1].getPos_y()-99 == map[x2][y2].getPos_y() &&
                x1<12 && map[x1][y1].getPos_x()+99 == map[x2][y2].getPos_x()) return true;

        if(y1<10 && map[x1][y1].getPos_y()-99 == map[x2][y2].getPos_y() &&
                x1<12 && map[x1][y1].getPos_x()+101 == map[x2][y2].getPos_x()) return true;

        System.out.println("Pike X: "+g1.getPos_x());
        System.out.println("Pike Y: "+g1.getPos_y());
        System.out.println("imp X: "+g2.getPos_x());
        System.out.println("IMP Y: "+g2.getPos_y());
*/
        System.out.println("messze vagy");
        return false;
    }

    default void attack(Tile[][] map, Generic g1, Generic g2, AnchorPane anchorPane, int rowCount, int colCount){

                double minAtt = g1.getAttMin();
                double maxAtt = g1.getAttMax();
                double dmg = Math.random() * (maxAtt - minAtt + 1) + minAtt;
                double dmgCritChance = Math.random()*(100+1+1)+1;
                    if(isNeighbour(map,g1,g2, rowCount, colCount)) {
                        if(dmgCritChance > 5){
                            g2.setHp((int) (g2.getHp() - dmg)*2);
                        }else{
                            g2.setHp((int) (g2.getHp() - dmg));
                        }
                        System.out.println("Alany HP: " + g2.getHp());
                        if (g2.getHp() <= 0) g2.setImg("dead", anchorPane);
                        System.out.println("sebzett");
                        if (g2.getName() == "Griff" && g1.getName() != "ImpArcher") {
                            attack(map, g2, g1, anchorPane, rowCount, colCount);
                        }
                    }

    }

    //archer
    default void attackWitoutLimit(Tile[][] map, Generic g1, Generic g2, AnchorPane anchorPane, int rowCount, int colCount){
        double minAtt = g1.getAttMin();
        double maxAtt = g1.getAttMax();
        double dmg = Math.random() * (maxAtt - minAtt + 1) + minAtt;
        if(!isNeighbour(map,g1,g2, rowCount, colCount)) {
            g2.setHp((int) (g2.getHp() - dmg));
            System.out.println("Alany HP: " + g2.getHp());
            if (g2.getHp() <= 0) g2.setImg("dead", anchorPane);
            System.out.println("sebzett");
            if (g2.getName() == "Griff" && g1.getName() != "ImpArcher") {
                attack(map, g2, g1, anchorPane, rowCount, colCount);
            }
        }
    }


    default void move(Tile[][] map, Generic generic, int rowCount, int colCount, AnchorPane anchorPane){
        int i, j;
        for (i = 0; i < rowCount; i++) {
            for (j = 0; j < colCount; j++) {
                Tile tl = map[i][j];

                tl.getImageView().setOnMouseClicked((event) ->{
                    map[generic.getPos_x()/100][generic.getPos_y()/100].setOccupied(false);
                    map[generic.getPos_x()/100][generic.getPos_y()/100].setCrs(true);

                    int spriteCounter = 0;
                    System.out.println("\n\ngetMovToX:"+tl.getMovTo_x()+"\n\n getMovToY "+tl.getMovTo_y());
                    System.out.println("Crossable "+tl.getCrs());

                    while(generic.getPos_x() <= tl.getMovTo_x() && tl.getCrs()){
                        if(spriteCounter > generic.getWalk().length-1) spriteCounter = 0;
                        generic.setImg(generic.getWalk(spriteCounter), anchorPane);
                        generic.setPos_x(generic.getPos_x()+1);
                        generic.setImageMovX(generic.getPos_x());
                        if(generic.getPos_x() == tl.getMovTo_x() && !tl.getCrs())  generic.setPos_x(generic.getPos_x()+100);
                        if(map[0][0].getHandbreak() == 400) break;
                        map[0][0].setHandbreak(map[0][0].getHandbreak()+1);
                        spriteCounter++;
                    }
                    map[0][0].setHandbreak(0);
                    while(generic.getPos_x() >= tl.getMovTo_x() && tl.getCrs()){
                        if(spriteCounter > generic.getWalk().length-1) spriteCounter = 0;
                        generic.setImg(generic.getWalk(spriteCounter), anchorPane);
                        generic.setPos_x(generic.getPos_x()-1);
                        generic.setImageMovX(generic.getPos_x());
                        if(generic.getPos_x() == tl.getMovTo_x() && !tl.getCrs()) generic.setPos_x(generic.getPos_x()-100);
                        if(map[0][0].getHandbreak() == 400) break;
                        map[0][0].setHandbreak(map[0][0].getHandbreak()+1);
                        spriteCounter++;
                    }
                    map[0][0].setHandbreak(0);
                    while(generic.getPos_y() <= tl.getMovTo_y() && tl.getCrs()){
                        if(spriteCounter > generic.getWalk().length-1) spriteCounter = 0;
                        generic.setImg(generic.getWalk(spriteCounter), anchorPane);
                        generic.setPos_y(generic.getPos_y()+1);
                        generic.setImageMovY(generic.getPos_y());
                        if(generic.getPos_y() == tl.getMovTo_y() && !tl.getCrs()) generic.setPos_y(generic.getPos_y()+100);
                        if(map[0][0].getHandbreak() == 400) break;
                        map[0][0].setHandbreak(map[0][0].getHandbreak()+1);
                        spriteCounter++;
                    }
                    map[0][0].setHandbreak(0);
                    while(generic.getPos_y() >= tl.getMovTo_y() && tl.getCrs()){
                        if(spriteCounter > generic.getWalk().length-1) spriteCounter = 0;
                        generic.setImg(generic.getWalk(spriteCounter), anchorPane);
                        generic.setPos_y(generic.getPos_y()-1);
                        generic.setImageMovY(generic.getPos_y());
                        if(generic.getPos_y() == tl.getPos_x() && !tl.getCrs()) generic.setPos_y(generic.getPos_y()-100);
                        if(map[0][0].getHandbreak() == 400) break;
                        map[0][0].setHandbreak(map[0][0].getHandbreak()+1);
                        spriteCounter++;
                    }

                    map[0][0].setHandbreak(0);
                    generic.setImg("stand", anchorPane);
                    generic.setImageMovX(generic.getPos_x());
                    generic.setImageMovY(generic.getPos_y());

                    tl.setCrs(false);
                    tl.setOccupied(true);
                });
            }
        }

    }

    default void place(Tile[][] map, Generic generic, int rowCount, int colCount, AnchorPane ap){
        for(int i=0;i<rowCount;i++){
            for (int j=0;j<colCount;j++){
                Tile tl = map[i][j];
                tl.getImageView().setOnMouseEntered((event)->{
                    generic.setImageMovX(tl.getPos_x());
                    generic.setImageMovY(tl.getPos_y());
                });
                tl.getImageView().setOnMouseExited((event)->{
                    ap.getChildren().remove(generic);
                });
                tl.getImageView().setOnMouseClicked((event)->{
                    generic.setImageMovY(tl.getMovTo_y());
                    generic.setImageMovX(tl.getMovTo_x());
                    generic.setPos_x(tl.getMovTo_x());
                    generic.setPos_y(tl.getMovTo_y());

                });
            }
        }
    }

    default void unitUpdate(Champions chimp, VillianChamp evilChimp, Generic pike, Generic griff, Generic archer, Generic imp, Generic hound, Generic impArcher){
        int i;

        pike.setAttMin(pike.getAttMin()*chimp.getSoldierCount());
        pike.setAttMax(pike.getAttMax()*chimp.getSoldierCount());
        pike.setHp((pike.getHp()*chimp.getSoldierCount()));

        archer.setAttMin(archer.getAttMin()*chimp.getArcherCount());
        archer.setAttMax(archer.getAttMax()*chimp.getArcherCount());
        archer.setHp((archer.getHp()*chimp.getArcherCount()));

        griff.setAttMin(griff.getAttMin()*chimp.getGriffCount());
        griff.setAttMax(griff.getAttMax()*chimp.getGriffCount());
        griff.setHp((griff.getHp()*chimp.getGriffCount()));

        imp.setAttMin(imp.getAttMin()*imp.getCount());
        imp.setAttMax(imp.getAttMax()*imp.getCount());
        imp.setHp((imp.getHp()*imp.getCount()));

        hound.setAttMin(hound.getAttMin()*hound.getCount());
        hound.setAttMax(hound.getAttMax()*hound.getCount());
        hound.setHp((hound.getHp()*hound.getCount()));

        impArcher.setAttMin(impArcher.getAttMin()*impArcher.getCount());
        impArcher.setAttMax(impArcher.getAttMax()*impArcher.getCount());
        impArcher.setHp((impArcher.getHp()*impArcher.getCount()));


        for(i=0;i<chimp.getAtt();i++) {
            pike.setDamage(pike.getDamage() * 1.1);
            griff.setDamage(griff.getDamage() * 1.1);
            archer.setDamage(archer.getDamage() * 1.1);
        }
        for(i=0;i<evilChimp.getAtt();i++){
            imp.setDamage(imp.getDamage() * 1.1);
            hound.setDamage(hound.getDamage() * 1.1);
            impArcher.setDamage(impArcher.getDamage() * 1.1);
        }
        for(i=0;i<chimp.getDeff();i++) {
            pike.setDeff(pike.getDamage() * 1.05);
            griff.setDeff(griff.getDamage() * 1.05);
            archer.setDeff(archer.getDamage() * 1.05);
        }
        for (i=0;i<evilChimp.getDeff();i++){
            imp.setDeff(imp.getDamage() * 1.05);
            hound.setDeff(hound.getDamage() * 1.05);
            impArcher.setDeff(impArcher.getDamage() * 1.05);
        }

        for(i=0;i<chimp.getWisdom();i++) chimp.setMana(chimp.getMana()+10);
        for(i=0;i<evilChimp.getWisdom();i++) evilChimp.setMana(evilChimp.getMana()+10);

        for(i=0;i<chimp.getMoral();i++) {
            pike.setInitiative(pike.getInitiative() + 1);
            griff.setInitiative(griff.getInitiative() + 1);
            archer.setInitiative(archer.getInitiative() + 1);
        }
        for(i=0;i<evilChimp.getMoral();i++) {
            imp.setInitiative(imp.getInitiative() + 1);
            hound.setInitiative(hound.getInitiative() + 1);
            impArcher.setInitiative(impArcher.getInitiative() + 1);
        }
        for(i=0;i<chimp.getLuck();i++) {
            pike.setCrit(pike.getCrit()*1.05);
            griff.setCrit(griff.getCrit()*1.05);
            archer.setCrit(archer.getCrit()*1.05);
        }
        for(i=0;i<evilChimp.getLuck();i++) {
            imp.setCrit(imp.getCrit()*1.05);
            hound.setCrit(hound.getCrit()*1.05);
            impArcher.setCrit(hound.getCrit()*1.05);
        }
    }

    default void action(Tile[][] map, Generic g1, Generic g2, int rowCount, int colCount, AnchorPane ap){



        /*for(int i=0;i<rowCount;i++){
            for (int j=0;j<colCount;j++){
                Tile tl = map[i][j];
                tl.getImageView().setOnMouseClicked((event)->{
                    if(tl.isOccupied()){
                        attack(g1, g2,ap);
                        if(g2.getHp()<=0) {
                            map[g1.getPos_x()/100][g1.getPos_y()/100].setOccupied(false);
                            map[g1.getPos_x()/100][g1.getPos_y()/100].setCrs(true);
                        }
                    }else{
                        map[g1.getPos_x()/100][g1.getPos_y()/100].setOccupied(false);
                        map[g1.getPos_x()/100][g1.getPos_y()/100].setCrs(true);
                        move(map,g1,rowCount,colCount,ap);
                    }
                });
            }
        } */
    }

    default void doMagic(Tile[][] map, int rowCount, int colCount, AnchorPane anchorPane, ArrayList<Generic> round){
        int i, j;
        Champions chimp = new Champions();
        for (i = 0; i < rowCount; i++) {
            for (j = 0; j < colCount; j++) {
                Tile tl = map[i][j];
                if(chimp.getFire()) {
                    tl.getImageView().setOnMouseClicked((event) -> {
                        chimp.fireBall(map, tl.getMovTo_x(), tl.getMovTo_y(), round,anchorPane);
                    });
                }
            }
        }
    }



}


/*


    default void action(Tile[][] map, Generic g1, Generic g2, int rowCount, int colCount, AnchorPane ap){
        for(int i=0;i<rowCount;i++){
            for (int j=0;j<colCount;j++){
                Tile tl = map[i][j];

                tl.getImageView().setOnMouseClicked((event)->{
                    if(!tl.getCrs() && tl.isOccupied()){
                        attack(g1, g2,ap);
                    }else{
                        move(map,g1,rowCount,colCount,ap);
                    }
                });

            }
        }
    }
 */