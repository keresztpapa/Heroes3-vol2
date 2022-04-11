package com.example.prog1demo.BattleField;

import com.example.prog1demo.Action;
import com.example.prog1demo.units.Champions;
import com.example.prog1demo.units.VillianChamp;
import com.example.prog1demo.units.unit.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
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
    int roundCount=0;


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
        Champions chimp = new Champions();
        chimp.setImg("stand",ap);
        chimp.setImageMovX(100);
        chimp.setImageMovY(100);
        this.map[chimp.getPos_x() / 100][chimp.getPos_y() / 100].setGeneric(chimp);
        this.map[chimp.getPos_x() / 100][chimp.getPos_y() / 100].setCrs(false);
        this.map[chimp.getPos_x() / 100][chimp.getPos_y() / 100].setOccupied(true);

        VillianChamp evilChimp = new VillianChamp();
        evilChimp.setImg("stand",ap);
        evilChimp.setImageMovX(600);
        evilChimp.setImageMovY(100);
        this.map[evilChimp.getPos_x() / 100][evilChimp.getPos_y() / 100].setGeneric(evilChimp);
        this.map[evilChimp.getPos_x() / 100][evilChimp.getPos_y() / 100].setCrs(false);
        this.map[evilChimp.getPos_x() / 100][evilChimp.getPos_y() / 100].setOccupied(true);

        Soldier pike = new Soldier(0, 500, ap);
        pike.setImg("stand", ap);
        this.map[pike.getPos_x() / 100][pike.getPos_y() / 100].setGeneric(pike);
        this.map[pike.getPos_x() / 100][pike.getPos_y() / 100].setCrs(false);
        this.map[pike.getPos_x() / 100][pike.getPos_y() / 100].setOccupied(true);

        Griff griff = new Griff(100, 0, ap);
        griff.setImg("stand", ap);
        this.map[griff.getPos_x() / 100][griff.getPos_y() / 100].setGeneric(griff);
        this.map[griff.getPos_x() / 100][griff.getPos_y() / 100].setCrs(false);
        this.map[griff.getPos_x() / 100][griff.getPos_y() / 100].setOccupied(true);

        Archer archer = new Archer(0,200,ap);
        this.map[archer.getPos_x() / 100][archer.getPos_y() / 100].setGeneric(archer);
        this.map[archer.getPos_x() / 100][archer.getPos_y() / 100].setCrs(false);
        this.map[archer.getPos_x() / 100][archer.getPos_y() / 100].setOccupied(true);
        archer.setImg("stand",ap);

        Imp imp = new Imp(300, 300, ap);
        this.map[imp.getPos_x() / 100][imp.getPos_y() / 100].setGeneric(imp);
        this.map[imp.getPos_x() / 100][imp.getPos_y() / 100].setCrs(false);
        this.map[imp.getPos_x() / 100][imp.getPos_y() / 100].setOccupied(true);
        imp.setImg("stand", ap);

        Hound hound = new Hound(700, 600, ap);
        this.map[hound.getPos_x() / 100][hound.getPos_y() / 100].setGeneric(hound);
        this.map[hound.getPos_x() / 100][hound.getPos_y() / 100].setCrs(false);
        this.map[hound.getPos_x() / 100][hound.getPos_y() / 100].setOccupied(true);
        hound.setImg("stand", ap);

        ImpArcher impArcher = new ImpArcher(500, 400, ap);
        this.map[impArcher.getPos_x() / 100][impArcher.getPos_y() / 100].setGeneric(impArcher);
        this.map[impArcher.getPos_x() / 100][impArcher.getPos_y() / 100].setCrs(false);
        this.map[impArcher.getPos_x() / 100][impArcher.getPos_y() / 100].setOccupied(true);
        impArcher.setImg("stand", ap);

        ArrayList<Generic> round = new ArrayList<Generic>();
        round.add(pike);
        round.add(griff);
        round.add(archer);
        round.add(imp);
        round.add(impArcher);
        round.add(hound);
        round.add(chimp);
        round.add(evilChimp);

        move(map, round.get(index), this.x_count, this.y_count, ap);

        /*
        imp.getActual().setOnMouseClicked((event) -> attack(map, round.get(index), imp, ap, this.x_count, this.y_count));
        hound.getActual().setOnMouseClicked((event) -> attack(map, round.get(index), imp, ap, this.x_count, this.y_count));
        impArcher.getActual().setOnMouseClicked((event) -> attack(map, round.get(index), imp, ap, this.x_count, this.y_count));
*/
        Button next_turn = new Button("next turn");
        next_turn.setPrefWidth(150);
        next_turn.setPrefHeight(50);
        next_turn.setLayoutX(1250);
        next_turn.setLayoutY(650);

        imp.getActual().setOnMouseClicked((mouseEvent) -> {
            attack(map, round.get(index), imp, ap, this.x_count, this.y_count);
            if(imp.getHp()<=0) round.remove(index);
            if(imp.getHp() <= 0 && hound.getHp() <= 0 && impArcher.getHp() <= 0) {
                Menu menu = new Menu();
            }
        });
        hound.getActual().setOnMouseClicked((mouseEvent) -> {
            attack(map, round.get(index), hound, ap, this.x_count, this.y_count);
            if(hound.getHp()<=0) round.remove(index);
            if(imp.getHp() <= 0 && hound.getHp() <= 0 && impArcher.getHp() <= 0) {
                Menu menu = new Menu();
            }
        });
        impArcher.getActual().setOnMouseClicked((mouseEvent) -> {
            attack(map, round.get(index), impArcher, ap, this.x_count, this.y_count);
            if(impArcher.getHp()<=0) round.remove(index);
            if(imp.getHp() <= 0 && hound.getHp() <= 0 && impArcher.getHp() <= 0) {
                Menu menu = new Menu();
            }
        });

        next_turn.setOnMouseClicked((event) -> {
            roundCount++;
            setActiveIndex(round);
            if(imp.getHp() <= 0 && hound.getHp() <= 0 && impArcher.getHp() <= 0) {
                Menu menu = new Menu();
            }
        });



        ap.getChildren().add(next_turn);
    }

    public void setActiveIndex(ArrayList<Generic> round){
        round.get(index).setActive(false);
        switch (index){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                index++;
                System.out.println("csökkent "+index+" re");
                round.get(index).setActive(true);
                move(map, round.get(index), this.x_count, this.y_count, ap);
                break;
            case 7:
                index=0;
                System.out.println("csökkent "+index+" re");
                round.get(index).setActive(true);
                move(map, round.get(index), this.x_count, this.y_count, ap);
                break;
        }
    }

    //getters & setters
    public void setX_count(int z){ this.x_count = z; }
    public void setY_count(int z){ this.y_count = z; }
    public int getX_count(){ return this.x_count; }
    public int getY_count(){ return this.y_count; }

}