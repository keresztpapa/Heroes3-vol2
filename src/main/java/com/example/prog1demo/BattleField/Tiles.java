package com.example.prog1demo.BattleField;

import com.example.prog1demo.Action;
import com.example.prog1demo.units.unit.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.util.Objects;

import static java.lang.Thread.sleep;

public class Tiles implements Action {
    int x_count;
    int y_count;
    Tile[][] map;
    AnchorPane ap;
    int i, j;
    static int handbreak=0;

    public Tiles(int x, int y, AnchorPane anchor){
        String str=null;
        this.x_count = x;
        this.y_count = y;
        this.ap=anchor;
        this.map = new Tile[x][y];

             for (i=0;i<this.x_count;i++) {
                for (j = 0; j < this.y_count; j++) {
                    this.map[i][j] = new Tile(100 * i, j * 100, ap, true);
                    if ((int) (Math.random() * (100 + 1)) % 10 == 0) {
                        str = "water";
                        map[i][j].setPic("water");
                        this.map[i][j].setCrs(false);
                    } else {
                        str = "def";
                        map[i][j].setPic("def");
                    }
                    this.map[i][j].giveImageFeed(str);
                }
            }
    }

    public void generate(){
        int sor = (int) (Math.random() * (2)+1);
        int oszlop = (int) (Math.random()*(7)+1);
        int randX = (int) (Math.random() * 2);
        int randY = (int) (Math.random() * 7);

        Soldier pike = new Soldier(0,0, ap);
        pike.setImg("stand");

        Imp imp = new Imp(300, 300, ap);
        imp.setImg("stand");
        /*
        //int rand = (int)(Math.random() * range) + min;
        Archer archer = new Archer(map[randX][1].getImgX(), map[1][randY].getImgY(), ap);
        archer.setImg("stand");

        randX = (int) (Math.random() * 2);
        randY = (int) (Math.random() * 7);
        Griff griffin = new Griff(randX*100, randY*100, ap);
        griffin.setImg("stand");





        randX = (int) (Math.random() * 7)+5;
        randY = (int) (Math.random() * 7);
        ImpArcher impArcher = new ImpArcher(randX*100, randY*100, ap);
        impArcher.setImg("stand");


        randX = (int) (Math.random() * 7)+5;
        randY = (int) (Math.random() * 7);
        Hound hound = new Hound(randX*100, randY*100, ap);
        hound.setImg("stand");
         */
        for (i = 0; i < this.x_count; i++) {
            for (j = 0; j < this.y_count; j++) {



                Tile tl = map[i][j];
                tl.getImageView().setOnMouseClicked((event) ->{
                    int spriteCounter = 0;
                    System.out.println("\n\ngetMovToX:"+tl.getMovTo_x()+"\n\n getMovToY "+tl.getMovTo_y());
                    System.out.println("Crossable "+tl.getCrs());

                    while(pike.getPos_x() <= tl.getMovTo_x() && tl.getCrs()){
                        if(spriteCounter > pike.getWalk().length-1) spriteCounter = 0;
                        pike.setImg(pike.getWalk(spriteCounter));
                        pike.setPos_x(pike.getPos_x()+1);
                        pike.setImageMovX(pike.getPos_x());
                        if(pike.getPos_x() == tl.getMovTo_x() && !tl.getCrs()) pike.setPos_x(pike.getPos_x()+100);
                        if(handbreak == 399) break;
                        handbreak++;
                        spriteCounter++;
                    }
                    handbreak = 0;
                    while(pike.getPos_x() >= tl.getMovTo_x() && tl.getCrs()){
                        if(spriteCounter > pike.getWalk().length-1) spriteCounter = 0;
                        pike.setImg(pike.getWalk(spriteCounter));
                        pike.setPos_x(pike.getPos_x()-1);
                        pike.setImageMovX(pike.getPos_x());
                        if(pike.getPos_x() == tl.getMovTo_x() && !tl.getCrs()) pike.setPos_x(pike.getPos_x()-100);
                        if(handbreak == 399) break;
                        handbreak++;
                        spriteCounter++;
                    }
                    handbreak = 0;
                    while(pike.getPos_y() <= tl.getMovTo_y() && tl.getCrs()){
                        if(spriteCounter > pike.getWalk().length-1) spriteCounter = 0;
                        pike.setImg(pike.getWalk(spriteCounter));
                        pike.setPos_y(pike.getPos_y()+1);
                        pike.setImageMovY(pike.getPos_y());
                        if(pike.getPos_y() == tl.getMovTo_y() && !tl.getCrs()) pike.setPos_y(pike.getPos_y()+100);
                        if(handbreak == 399) break;
                        handbreak++;
                        spriteCounter++;
                    }
                    handbreak = 0;
                    while(pike.getPos_y() >= tl.getMovTo_y() && tl.getCrs()){
                        if(spriteCounter > pike.getWalk().length-1) spriteCounter = 0;
                        pike.setImg(pike.getWalk(spriteCounter));
                        pike.setPos_y(pike.getPos_y()-1);
                        pike.setImageMovY(pike.getPos_y());
                        if(pike.getPos_y() == tl.pos_y && !tl.getCrs()) pike.setPos_y(pike.getPos_y()-100);
                        if(handbreak == 399) break;
                        handbreak++;
                        spriteCounter++;
                    }
                    handbreak = 0;
                    pike.setImg("stand");
                    pike.setImageMovX(pike.getPos_x());
                    pike.setImageMovY(pike.getPos_y());

                });

            imp.getActual().setOnMouseClicked((event) -> attack(pike, imp));

            }
        }
    }

    //getters & setters
    public void setX_count(int z){ this.x_count = z; }
    public void setY_count(int z){ this.y_count = z; }
    public int getX_count(){ return this.x_count; }
    public int getY_count(){ return this.y_count; }
}