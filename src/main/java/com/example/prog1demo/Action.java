package com.example.prog1demo;

import com.example.prog1demo.BattleField.Tile;
import com.example.prog1demo.units.unit.Generic;

public interface Action {
    default void attack(Generic g1, Generic g2){
        g2.setHp(g2.getHp()-g1.getDamage());
        System.out.println("Alany HP: "+g2.getHp());
        if(g2.getHp()<=0) g2.setImg("dead");
        System.out.println("dead");
    }

    default void move(Tile[][] map, Generic generic, int rowCount, int colCount){
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
                        generic.setImg(generic.getWalk(spriteCounter));
                        generic.setPos_x(generic.getPos_x()+1);
                        generic.setImageMovX(generic.getPos_x());
                        if(generic.getPos_x() == tl.getMovTo_x() && !tl.getCrs()) generic.setPos_x(generic.getPos_x()+100);
                        if(map[0][0].getHandbreak() == 399) break;
                        map[0][0].setHandbreak(map[0][0].getHandbreak()+1);
                        spriteCounter++;
                    }
                    map[0][0].setHandbreak(0);
                    while(generic.getPos_x() >= tl.getMovTo_x() && tl.getCrs()){
                        if(spriteCounter > generic.getWalk().length-1) spriteCounter = 0;
                        generic.setImg(generic.getWalk(spriteCounter));
                        generic.setPos_x(generic.getPos_x()-1);
                        generic.setImageMovX(generic.getPos_x());
                        if(generic.getPos_x() == tl.getMovTo_x() && !tl.getCrs()) generic.setPos_x(generic.getPos_x()-100);
                        if(map[0][0].getHandbreak() == 399) break;
                        map[0][0].setHandbreak(map[0][0].getHandbreak()+1);
                        spriteCounter++;
                    }
                    map[0][0].setHandbreak(0);
                    while(generic.getPos_y() <= tl.getMovTo_y() && tl.getCrs()){
                        if(spriteCounter > generic.getWalk().length-1) spriteCounter = 0;
                        generic.setImg(generic.getWalk(spriteCounter));
                        generic.setPos_y(generic.getPos_y()+1);
                        generic.setImageMovY(generic.getPos_y());
                        if(generic.getPos_y() == tl.getMovTo_y() && !tl.getCrs()) generic.setPos_y(generic.getPos_y()+100);
                        if(map[0][0].getHandbreak() == 399) break;
                        map[0][0].setHandbreak(map[0][0].getHandbreak()+1);
                        spriteCounter++;
                    }
                    map[0][0].setHandbreak(0);
                    while(generic.getPos_y() >= tl.getMovTo_y() && tl.getCrs()){
                        if(spriteCounter > generic.getWalk().length-1) spriteCounter = 0;
                        generic.setImg(generic.getWalk(spriteCounter));
                        generic.setPos_y(generic.getPos_y()-1);
                        generic.setImageMovY(generic.getPos_y());
                        if(generic.getPos_y() == tl.getPos_x() && !tl.getCrs()) generic.setPos_y(generic.getPos_y()-100);
                        if(map[0][0].getHandbreak() == 399) break;
                        map[0][0].setHandbreak(map[0][0].getHandbreak()+1);
                        spriteCounter++;
                    }
                    map[0][0].setHandbreak(0);
                    generic.setImg("stand");
                    generic.setImageMovX(generic.getPos_x());
                    generic.setImageMovY(generic.getPos_y());

                });
            }
        }

    }
}
