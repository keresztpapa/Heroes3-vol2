package com.example.prog1demo.BattleField;

import com.example.prog1demo.Action;
import com.example.prog1demo.units.Champions;
import com.example.prog1demo.units.unit.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.Objects;

import static com.example.prog1demo.BattleField.Tile.victory;
import static java.lang.Thread.sleep;

public class Tiles implements Action {
    int x_count;
    int y_count;
    Tile[][] map;
    AnchorPane ap;
    int i, j;
    int unitX;
    int unitY;

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

        Soldier pike = new Soldier(0,0, ap);
        pike.setImg("stand", ap);
        this.map[pike.getPos_x()/100][pike.getPos_y()/100].setGeneric(pike);
        this.map[pike.getPos_x()/100][pike.getPos_y()/100].setCrs(false);
        this.map[pike.getPos_x()/100][pike.getPos_y()/100].setOccupied(true);

        Imp imp = new Imp(300, 300, ap);
        this.map[imp.getPos_x()/100][imp.getPos_y()/100].setGeneric(imp);
        this.map[imp.getPos_x()/100][imp.getPos_y()/100].setCrs(false);
        this.map[imp.getPos_x()/100][imp.getPos_y()/100].setOccupied(true);
        imp.setImg("stand", ap);

        //move(map, pike, this.x_count, this.y_count, ap);
        action(map, pike, imp,this.x_count, this.y_count, ap);
        //imp.getActual().setOnMouseClicked((event) -> attack(pike, imp, ap));

        //action(map, pike, imp, this.x_count, this.y_count, ap);
        //System.out.println("mouse click detected! " + mouseEvent.getTarget().getClass().getName()); -----> mouse click detected! javafx.scene.image.ImageView
        //move(map, pike, this.x_count, this.y_count, ap);
        //imp.getActual().setOnMouseClicked((event) -> attack(pike, imp, ap));
        //attack(pike, imp, ap);


        //if (soruce instanceof Button) {  //check that the source is really a button
/*
        ap.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            System.out.println("mouse click detected! " + mouseEvent.getPickResult());

        });
*/

        //move(map, pike, this.x_count, this.y_count);

        /*
        Archer arc = new Archer(200, 200, ap);
        arc.setImg("stand");

        Griff griff = new Griff(100, 400, ap);
        griff.setImg("stand");

        Imp imp = new Imp(300, 300, ap);
        imp.setImg("stand");

        ImpArcher impArc = new ImpArcher(700, 0, ap);
        impArc.setImg("stand");

        Hound hound = new Hound(700, 100, ap);
        hound.setImg("stand");

        ArrayList<Generic> round = new ArrayList<Generic>();
        round.add(pike);
        round.add(arc);
        round.add(griff);
        round.add(imp);
        round.add(impArc);
        round.add(hound);


        move(map, round.get(3), this.x_count, this.y_count);

        */

    }
//imp.getActual().setOnMouseClicked((event) -> attack(pike, imp));
//place(map, pike, this.x_count, this.y_count, ap);

    //getters & setters
    public void setX_count(int z){ this.x_count = z; }
    public void setY_count(int z){ this.y_count = z; }
    public int getX_count(){ return this.x_count; }
    public int getY_count(){ return this.y_count; }

}

        /*

        Generic[] init_array = {pike, arc, griff, imp, impArc, hound};

        for(int i=0;i< init_array.length;i++) {
            System.out.println(init_array[i].getName()+"  "+init_array[i].getInitiative());
        }

        Champions chimp = new Champions();

        unitUpdate(chimp, pike, arc, griff);

        System.out.println("\n\n\n\n");

        for(int i=0;i< init_array.length;i++){
            for(int j=1;j< init_array.length;j++){
                Generic gen = null;
                if(init_array[j].getInitiative() > init_array[i].getInitiative()){
                    gen = init_array[j];
                    init_array[j] = gen;
                    init_array[i] = init_array[j];
                }
            }
        }

        System.out.println("sorted");
        for(int i=0;i< init_array.length;i++) {
            System.out.println(init_array[i].getName()+"  "+init_array[i].getInitiative());
        }

        */