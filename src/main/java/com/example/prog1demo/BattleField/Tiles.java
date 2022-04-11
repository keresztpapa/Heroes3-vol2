package com.example.prog1demo.BattleField;

import com.example.prog1demo.Action;
import com.example.prog1demo.units.Champions;
import com.example.prog1demo.units.unit.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    static int index=0;


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

    public void generate() {

        Soldier pike = new Soldier(0, 0, ap);
        pike.setImg("stand", ap);
        this.map[pike.getPos_x() / 100][pike.getPos_y() / 100].setGeneric(pike);
        this.map[pike.getPos_x() / 100][pike.getPos_y() / 100].setCrs(false);
        this.map[pike.getPos_x() / 100][pike.getPos_y() / 100].setOccupied(true);

        Griff griff = new Griff(100, 0, ap);
        griff.setImg("stand", ap);
        this.map[griff.getPos_x() / 100][griff.getPos_y() / 100].setGeneric(griff);
        this.map[griff.getPos_x() / 100][griff.getPos_y() / 100].setCrs(false);
        this.map[griff.getPos_x() / 100][griff.getPos_y() / 100].setOccupied(true);

        Imp imp = new Imp(300, 300, ap);
        this.map[imp.getPos_x() / 100][imp.getPos_y() / 100].setGeneric(imp);
        this.map[imp.getPos_x() / 100][imp.getPos_y() / 100].setCrs(false);
        this.map[imp.getPos_x() / 100][imp.getPos_y() / 100].setOccupied(true);
        imp.setImg("stand", ap);

        ArrayList<Generic> round = new ArrayList<Generic>();
        round.add(pike);
        round.add(griff);
        round.add(imp);

        move(map, round.get(index), this.x_count, this.y_count, ap);

        imp.getActual().setOnMouseClicked((event) -> attack(map, round.get(index), imp, ap, this.x_count, this.y_count));

        Button next_turn = new Button("next turn");
        next_turn.setPrefWidth(150);
        next_turn.setPrefHeight(50);
        next_turn.setLayoutX(1250);
        next_turn.setLayoutY(650);

        next_turn.setOnMouseClicked((event) -> {
            setActiveIndex(round);
            System.out.println("ez biza next turn");
        });

        ap.getChildren().add(next_turn);
    }

    public void setActiveIndex(ArrayList<Generic> round){
        round.get(index).setActive(false);
        switch (index){
            case 0:
                index++;
                System.out.println("nőtt "+index+" re");
                round.get(index).setActive(true);
                move(map, round.get(index), this.x_count, this.y_count, ap);
                break;

            case 1:
                index--;
                System.out.println("csökkent "+index+" re");
                round.get(index).setActive(true);
                move(map, round.get(index), this.x_count, this.y_count, ap);
                break;
        }
    }

        /*
    public int giveActiveIndex(ArrayList<Generic> round){

        int i=0;
        while(i < round.size()) {
            if(round.get(i).isActive()) {
                System.out.println("Visszad: "+i);
                if(i == 0) System.out.println("pike");
                if(i == 1) System.out.println("Griff");
                return i;
            }
            i++;
        }
        return 0;
    }

            public void setActiveIndex(ArrayList<Generic> round, int index){
        switch (index){
            case 0:
                round.get(0).setActive(false);
                round.get(1).setActive(true);
                break;
            case 1:
                round.get(1).setActive(false);
                round.get(0).setActive(true);
                break;
        }
    }


        */


    //getters & setters
    public void setX_count(int z){ this.x_count = z; }
    public void setY_count(int z){ this.y_count = z; }
    public int getX_count(){ return this.x_count; }
    public int getY_count(){ return this.y_count; }

}