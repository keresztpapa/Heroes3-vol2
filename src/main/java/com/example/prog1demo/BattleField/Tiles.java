/**
 * Az osztály szolgál 'engine'-ként. A konstruktorban automatikusan van generáltatva a pálya, és fel van töltve elérhetetlen mezőkkel is.
 *
 * A Generate() intézi az interakciót a pályával, itt jönnek be az egységek és azoknak a cselekvései.
 *
 * A setActiveIndex() egy segítő fv, ennek az egyetlen feladata, hogy a körökre osztott egységeknél
 * lép egyet a sorrendben, ha az egység megtámadott valamit vagy a játékos passzolni szeretne.
 *
 * @param round     ArrayList a hősök sorrendjéről
 * @param rounder   A kört kijelző TextBox, ami frissül, ha egy karakter befejezte a körét
 *
 */


package com.example.prog1demo.BattleField;

import com.example.prog1demo.Interfaces.Action;
import com.example.prog1demo.MenuElements.Victory;
import com.example.prog1demo.units.unit.Heroes.Champions;
import com.example.prog1demo.units.unit.Heroes.VillianChamp;
import com.example.prog1demo.units.unit.*;
import com.example.prog1demo.units.unit.EvilUnits.Hound;
import com.example.prog1demo.units.unit.EvilUnits.Imp;
import com.example.prog1demo.units.unit.EvilUnits.ImpArcher;
import com.example.prog1demo.units.unit.Humans.Archer;
import com.example.prog1demo.units.unit.Humans.Griff;
import com.example.prog1demo.units.unit.Humans.Soldier;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class Tiles implements Action{
    int x_count;
    int y_count;
    Tile[][] map;
    int i, j;
    int unitX;
    int unitY;
    static int index=0;
    static int roundCount=0;
    static String logs="";
    AnchorPane ap;
    Soldier pike;
    Griff griff;
    Archer archer;
    Imp imp;
    Hound hound;
    ImpArcher impArcher;
    VillianChamp evilChimp;
    Champions chimp;
    TextArea logField;


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
        chimp = new Champions();
        chimp.setImg("stand",ap);
        chimp.setPos_x(100);
        chimp.setPos_y(0);
        chimp.setImageMovX(100);
        chimp.setImageMovY(100);
        this.map[chimp.getPos_x() / 100][chimp.getPos_y() / 100].setGeneric(chimp);
        this.map[chimp.getPos_x() / 100][chimp.getPos_y() / 100].setCrs(false);
        this.map[chimp.getPos_x() / 100][chimp.getPos_y() / 100].setOccupied(true);

        evilChimp = new VillianChamp();
        evilChimp.setImg("stand",ap);
        evilChimp.setPos_x(1100);
        evilChimp.setPos_y(0);
        evilChimp.setImageMovX(600);
        evilChimp.setImageMovY(100);
        this.map[evilChimp.getPos_x() / 100][evilChimp.getPos_y() / 100].setGeneric(evilChimp);
        this.map[evilChimp.getPos_x() / 100][evilChimp.getPos_y() / 100].setCrs(false);
        this.map[evilChimp.getPos_x() / 100][evilChimp.getPos_y() / 100].setOccupied(true);

        pike = new Soldier(0, 500, ap);
        griff = new Griff(100, 0, ap);
        archer = new Archer(0,200,ap);

        imp = new Imp(300, 300, ap);
        this.map[imp.getPos_x() / 100][imp.getPos_y() / 100].setGeneric(imp);
        this.map[imp.getPos_x() / 100][imp.getPos_y() / 100].setCrs(false);
        this.map[imp.getPos_x() / 100][imp.getPos_y() / 100].setOccupied(true);
        imp.setImg("stand", ap);

        hound = new Hound(700, 600, ap);
        this.map[hound.getPos_x() / 100][hound.getPos_y() / 100].setGeneric(hound);
        this.map[hound.getPos_x() / 100][hound.getPos_y() / 100].setCrs(false);
        this.map[hound.getPos_x() / 100][hound.getPos_y() / 100].setOccupied(true);
        hound.setImg("stand", ap);

        impArcher = new ImpArcher(500, 400, ap);
        this.map[impArcher.getPos_x() / 100][impArcher.getPos_y() / 100].setGeneric(impArcher);
        this.map[impArcher.getPos_x() / 100][impArcher.getPos_y() / 100].setCrs(false);
        this.map[impArcher.getPos_x() / 100][impArcher.getPos_y() / 100].setOccupied(true);
        impArcher.setImg("stand", ap);

        logField = new TextArea(logs);
        logField.setLayoutX(1200);
        logField.setLayoutY(100);
        logField.setPrefHeight(500);
        logField.setPrefWidth(300);
        logField.setText("Logs: \n");

/*
        Generic[] arr = {pike, griff, archer, imp, impArcher, hound, chimp, evilChimp};
        Generic[] finalArr = {pike, griff, archer, imp, impArcher, hound, chimp, evilChimp};
        setOrder(arr, finalArr);

        for (Generic generic : finalArr) System.out.println(generic.getName()+generic.getMoral());
*/

        ArrayList<Generic> round = new ArrayList<>();

        if(chimp.getSoldierCount() > 0) {
            round.add(pike);
            pike.setImg("stand", ap);
            this.map[pike.getPos_x() / 100][pike.getPos_y() / 100].setGeneric(pike);
            this.map[pike.getPos_x() / 100][pike.getPos_y() / 100].setCrs(false);
            this.map[pike.getPos_x() / 100][pike.getPos_y() / 100].setOccupied(true);
        }
        if(chimp.getArcherCount() > 0) {
            round.add(archer);
            archer.setImg("stand",ap);
            this.map[archer.getPos_x() / 100][archer.getPos_y() / 100].setGeneric(archer);
            this.map[archer.getPos_x() / 100][archer.getPos_y() / 100].setCrs(false);
            this.map[archer.getPos_x() / 100][archer.getPos_y() / 100].setOccupied(true);
        }
        if(chimp.getGriffCount() > 0) {
            round.add(griff);
            griff.setImg("stand", ap);
            this.map[griff.getPos_x() / 100][griff.getPos_y() / 100].setGeneric(griff);
            this.map[griff.getPos_x() / 100][griff.getPos_y() / 100].setCrs(false);
            this.map[griff.getPos_x() / 100][griff.getPos_y() / 100].setOccupied(true);
        }

        round.add(imp);
        round.add(impArcher);
        round.add(hound);
        //round.add(chimp);
        //round.add(evilChimp);

        if (archer.getHp() <= 0 && pike.getHp() <= 0 && griff.getHp() <= 0) {
            Victory vc = new Victory();
            vc.endGame("bukta");
        }

        if (imp.getHp() <= 0 && hound.getHp() <= 0 && impArcher.getHp() <= 0) {
            Victory vc = new Victory();
            vc.endGame("");
        }

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
            if(imp.getHp()>0){
                attack(map, round.get(index), imp, ap, logField, round);
                if (imp.getHp() <= 0) round.remove(index);
                setActiveIndex(round, rounder, logField);
                removeDeadUnit(round);
            }
        });
        hound.getActual().setOnMouseClicked((mouseEvent) -> {
            if(hound.getHp()>0){
                attack(map, round.get(index), hound, ap, logField, round);
                if (hound.getHp() <= 0) round.remove(index);
                setActiveIndex(round, rounder, logField);
                removeDeadUnit(round);
            }
        });
        impArcher.getActual().setOnMouseClicked((mouseEvent) -> {
            if(impArcher.getHp()>0) {
                attack(map, round.get(index), impArcher, ap,logField, round);
                if (impArcher.getHp() <= 0) round.remove(index);
                setActiveIndex(round, rounder, logField);
                removeDeadUnit(round);
            }
        });

        removeDeadUnit(round);

        pass.setOnMouseClicked((event) -> {
            rounder.setText(""+roundCount);
            setActiveIndex(round, rounder, logField);
            removeDeadUnit(round);
        });


        move(map, round.get(index),this.x_count, this.y_count,ap,logField, round);


        ap.getChildren().addAll(pass, fire, light, res,rounder, logField);
    }

    public void setActiveIndex(ArrayList<Generic> round, TextField rounder, TextArea logF){
        if(index < round.size()-1) {
            index++;
        }else {
            roundCount++;
            index = 0;
        }

        if (archer.getHp() <= 0 && pike.getHp() <= 0 && griff.getHp() <= 0) {
            Victory vc = new Victory();
            vc.endGame("bukta");
        }

        if (imp.getHp() <= 0 && hound.getHp() <= 0 && impArcher.getHp() <= 0) {
            Victory vc = new Victory();
            vc.endGame("");
        }

        if(Objects.equals(round.get(index).getName(), "Imp") ||
           Objects.equals(round.get(index).getName(), "Hound") ||
           Objects.equals(round.get(index).getName(), "ImpArcher")){

            AImove(map, round, round.get(index), ap, logF);
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
    public void setIndex(int asd){ index = asd; }
    public int getIndex(){ return index; }
    public void setX_count(int z){ this.x_count = z; }
    public void setY_count(int z){ this.y_count = z; }
    public int getX_count(){ return this.x_count; }
    public int getY_count(){ return this.y_count; }

}