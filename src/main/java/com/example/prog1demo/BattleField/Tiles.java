package com.example.prog1demo.BattleField;

import com.example.prog1demo.units.unit.Soldier;
import javafx.scene.layout.AnchorPane;
import static java.lang.Thread.sleep;

public class Tiles {
    int x_count;
    int y_count;
    Tile[][] map;
    AnchorPane ap;
    int i, j;

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

    //int attack, int deffense, int magic, int wisd, int mor, int lucky, int px, int py
    public void generate(){

        int sor = (int) (Math.random() * (2)+1);
        int oszlop = (int) (Math.random()*(7)+1);

        Soldier pike = new Soldier(sor*100,oszlop*100, ap);

        

        /*
        for (i=0; i < this.x_count; i++) {
            for (j = 0; j < this.y_count; j++) {
                map[i][j].getImageView().setOnMouseClicked((event) ->{
                    System.out.println(map[i][j].getImgX());
                });
            }
        }*/


        /*
        pike.getImg().setOnMouseClicked((event) -> {
            System.out.println("PosX: "+pike.getPos_x()+"\nPosY: "+pike.getPos_y());
        });


        for(int h=0;h<100;h++) {
            pike.setPos_x(pike.getPos_x() + 1);
            System.out.println(pike.getPos_x());
            pike.setImageMovX(pike.getImgX());
        }*/
    }

    //getters & setters
    public void setX_count(int z){ this.x_count = z; }
    public void setY_count(int z){ this.y_count = z; }
    public int getX_count(){ return this.x_count; }
    public int getY_count(){ return this.y_count; }
}