package com.example.prog1demo;

import com.example.prog1demo.BattleField.Tiles;
import com.example.prog1demo.BattleField.Tile;
import com.example.prog1demo.units.Champions;
import com.example.prog1demo.units.unit.Generic;
import javafx.scene.layout.AnchorPane;

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
                    if(isNeighbour(map,g1,g2, rowCount, colCount)) {
                        g2.setHp(g2.getHp() - g1.getDamage());
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

                    tl.setVictory(true);
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

    default void unitUpdate(Champions chimp, Generic g1, Generic g2, Generic g3){
        int i;
        for(i=0;i<chimp.getAtt();i++) {
            g1.setDamage(g1.getDamage() * 1.1);
            g2.setDamage(g2.getDamage() * 1.1);
            g3.setDamage(g3.getDamage() * 1.1);

        }
        for(i=0;i<chimp.getDeff();i++) {
            g1.setDeff(g1.getDamage() * 1.05);
            g2.setDeff(g2.getDamage() * 1.05);
            g3.setDeff(g3.getDamage() * 1.05);
        }
        for(i=0;i<chimp.getWisdom();i++) chimp.setMana(chimp.getMana()+10);

        for(i=0;i<chimp.getMoral();i++) {
            g1.setInitiative(g1.getInitiative() + 1);
            g2.setInitiative(g2.getInitiative() + 1);
            g3.setInitiative(g3.getInitiative() + 1);
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