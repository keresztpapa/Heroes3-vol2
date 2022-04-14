package com.example.prog1demo.Interfaces;

import com.example.prog1demo.BattleField.Tile;
import com.example.prog1demo.units.unit.Heroes.Champions;
import com.example.prog1demo.units.unit.Heroes.VillianChamp;
import com.example.prog1demo.units.unit.*;
import com.example.prog1demo.units.unit.EvilUnits.Hound;
import com.example.prog1demo.units.unit.EvilUnits.Imp;
import com.example.prog1demo.units.unit.EvilUnits.ImpArcher;
import com.example.prog1demo.units.unit.Humans.Archer;
import com.example.prog1demo.units.unit.Humans.Griff;
import com.example.prog1demo.units.unit.Humans.Soldier;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Multiplayer implements Action{
        int x_count;
        int y_count;
        Tile[][] map;
        AnchorPane ap;
        int i, j;
        int unitX;
        int unitY;
        static int index=0;
        static int roundCount=0;
        static String logs="";

        public Multiplayer(int x, int y, AnchorPane anchor){
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
            ap.setMaxHeight(1000);
            ap.setPrefHeight(1000);
            ap.setMaxWidth(1500);
            ap.setPrefWidth(1500);
            Champions chimp = new Champions();
            chimp.setImg("stand",ap);
            chimp.setImageMovX(100);
            chimp.setImageMovY(100);

            chimp.setSoldierCount((int) ((Math.random()*20)+1));
            chimp.setGriffCount((int) ((Math.random()*20)+1));
            chimp.setArcherCount((int) ((Math.random()*20)+1));

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

            evilChimp.setImpCount((int) ((Math.random()*20)+1));
            evilChimp.setImpArcherCount((int) ((Math.random()*20)+1));
            evilChimp.setHoundCount((int) ((Math.random()*20)+1));

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


            TextArea logField = new TextArea(logs);
            logField.setLayoutX(1200);
            logField.setLayoutY(100);
            logField.setPrefHeight(500);
            logField.setPrefWidth(300);
            logField.setText("Logs: \n");

            ArrayList<Generic> round = new ArrayList<>();

            round.add(pike);
            round.add(griff);
            round.add(archer);
            round.add(imp);
            round.add(impArcher);
            round.add(hound);
            round.add(chimp);
            round.add(evilChimp);

            System.out.println("Pike\n"+pike);

            move(map, round.get(index), this.x_count, this.y_count, ap, logField, round);

            TextField rounder = new TextField(""+roundCount);
            rounder.setPrefHeight(50);
            rounder.setPrefWidth(50);
            rounder.setLayoutY(750);
            rounder.setLayoutX(1400);

            Button pass = new Button("Pass");
            pass.setPrefWidth(150);
            pass.setPrefHeight(50);
            pass.setLayoutX(1225);
            pass.setLayoutY(750);

            Button fire = new Button("Fireball");
            fire.setPrefWidth(75);
            fire.setPrefHeight(50);
            fire.setLayoutX(1225);
            fire.setLayoutY(850);

            Button light = new Button("Thunder");
            light.setPrefWidth(75);
            light.setPrefHeight(50);
            light.setLayoutX(1325);
            light.setLayoutY(850);

            Button res = new Button("Res");
            res.setPrefWidth(50);
            res.setPrefHeight(50);
            res.setLayoutX(1425);
            res.setLayoutY(850);

            fire.setOnMouseClicked((event)->{
                System.out.println("fire");
                chimp.setFireActive(true);
            });

            light.setOnMouseClicked((event)->{
                chimp.setThunderActive(true);
            });

            res.setOnMouseClicked((event)->{
                chimp.setResActive(true);
            });

            imp.getActual().setOnMouseClicked((mouseEvent) -> {
                attack(map, round.get(index), imp, ap, this.x_count, this.y_count, logField, round);
                if(imp.getHp()<=0) round.remove(index);
                setActiveIndex(round, rounder, logField);
                removeDeadUnit(round);
            });
            hound.getActual().setOnMouseClicked((mouseEvent) -> {
                attack(map, round.get(index), hound, ap, this.x_count, this.y_count, logField, round);
                if(hound.getHp()<=0) round.remove(index);
                setActiveIndex(round, rounder, logField);
                removeDeadUnit(round);
            });
            impArcher.getActual().setOnMouseClicked((mouseEvent) -> {
                attack(map, round.get(index), impArcher, ap, this.x_count, this.y_count, logField, round);
                if(impArcher.getHp()<=0) round.remove(index);
                setActiveIndex(round, rounder, logField);
                removeDeadUnit(round);
            });

            pike.getActual().setOnMouseClicked((mouseEvent) -> {
                attack(map, round.get(index), pike, ap, this.x_count, this.y_count, logField, round);
                if(pike.getHp()<=0) round.remove(index);
                setActiveIndex(round, rounder, logField);
                removeDeadUnit(round);
            });
            griff.getActual().setOnMouseClicked((mouseEvent) -> {
                attack(map, round.get(index), griff, ap, this.x_count, this.y_count, logField, round);
                if(griff.getHp()<=0) round.remove(index);
                setActiveIndex(round, rounder, logField);
                removeDeadUnit(round);
            });
            archer.getActual().setOnMouseClicked((mouseEvent) -> {
                attack(map, round.get(index), archer, ap, this.x_count, this.y_count, logField, round);
                if(archer.getHp()<=0) round.remove(index);
                setActiveIndex(round, rounder, logField);
                removeDeadUnit(round);
            });


            removeDeadUnit(round);

            pass.setOnMouseClicked((event) -> {
                rounder.setText(""+roundCount);
                setActiveIndex(round, rounder, logField);
                removeDeadUnit(round);
            });
            ap.getChildren().addAll(pass, fire, light, res,rounder, logField);
        }

        public void setActiveIndex(ArrayList<Generic> round, TextField rounder, TextArea logF){
            round.get(index).setActive(false);
            System.out.println(round.size());
            if(index < round.size()-1) {
                index++;
                System.out.println("csökkent " + index + " re");
            }else {
                roundCount++;
                index = 0;
                System.out.println("csökkent " + index + " re");
            }
            rounder.setText(""+roundCount);
        }

        public void removeDeadUnit(ArrayList<Generic> round){
            for(int i=0;i<round.size();i++){
                if(round.get(i).getHp()==0) {
                    round.remove(i);
                }
            }
        }

        public void setOrder(Generic[] arr, Generic[] orderedArr){
            int n = arr.length;
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < n-i-1; j++)
                    if (arr[j].getMoral() > arr[j+1].getMoral()) {
                        Generic temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
            System.arraycopy(arr, 0, orderedArr, 0, arr.length);
        }

        //getters & setters
        public void setX_count(int z){ this.x_count = z; }
        public void setY_count(int z){ this.y_count = z; }
        public int getX_count(){ return this.x_count; }
        public int getY_count(){ return this.y_count; }

}

