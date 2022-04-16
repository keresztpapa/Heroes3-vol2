package com.example.prog1demo.Interfaces;

import com.example.prog1demo.BattleField.Tile;
import com.example.prog1demo.MenuElements.Victory;
import com.example.prog1demo.units.unit.EvilUnits.Genie;
import com.example.prog1demo.units.unit.Heroes.Champions;
import com.example.prog1demo.units.unit.Heroes.VillianChamp;
import com.example.prog1demo.units.unit.*;
import com.example.prog1demo.units.unit.EvilUnits.Hound;
import com.example.prog1demo.units.unit.EvilUnits.Imp;
import com.example.prog1demo.units.unit.EvilUnits.ImpArcher;
import com.example.prog1demo.units.unit.Humans.Archer;
import com.example.prog1demo.units.unit.Humans.Griff;
import com.example.prog1demo.units.unit.Humans.Mage;
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
    static int index=0;
    static int roundCount=0;
    static String logs="";
    Soldier pike;
    Griff griff;
    Archer archer;
    Imp imp;
    Hound hound;
    ImpArcher impArcher;
    VillianChamp evilChimp;
    Champions chimp;
    TextArea logField;
    ArrayList<Generic> round;
    Mage mage;
    Genie genie;

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

        //setup test///////////////////////*********************************************

        ap.setMaxHeight(1000);
        ap.setPrefHeight(1000);
        ap.setMaxWidth(1500);
        ap.setPrefWidth(1500);

    }

    public void generate() {
        chimp = new Champions();
        chimp.setImg("stand",ap);
        chimp.setImageMovX(100);
        chimp.setImageMovY(100);
        chimp.setFireActive(true);

        chimp.setSoldierCount((int) ((Math.random()*20)+1));
        chimp.setGriffCount((int) ((Math.random()*20)+1));
        chimp.setArcherCount((int) ((Math.random()*20)+1));
        chimp.setMageCount((int) ((Math.random()*20)+1));

        this.map[chimp.getPos_x() / 100][chimp.getPos_y() / 100].setGeneric(chimp);
        this.map[chimp.getPos_x() / 100][chimp.getPos_y() / 100].setCrs(false);
        this.map[chimp.getPos_x() / 100][chimp.getPos_y() / 100].setOccupied(true);

        evilChimp = new VillianChamp();
        evilChimp.setImg("stand",ap);
        evilChimp.setImageMovX(600);
        evilChimp.setImageMovY(100);
        this.map[evilChimp.getPos_x() / 100][evilChimp.getPos_y() / 100].setGeneric(evilChimp);
        this.map[evilChimp.getPos_x() / 100][evilChimp.getPos_y() / 100].setCrs(false);
        this.map[evilChimp.getPos_x() / 100][evilChimp.getPos_y() / 100].setOccupied(true);

        evilChimp.setImpCount((int) ((Math.random()*20)+1));
        evilChimp.setImpArcherCount((int) ((Math.random()*20)+1));
        evilChimp.setHoundCount((int) ((Math.random()*20)+1));
        evilChimp.setGenieCount((int) ((Math.random()*20)+1));


        pike = new Soldier(0, 500, ap);
        pike.setImg("stand", ap);
        this.map[pike.getPos_x() / 100][pike.getPos_y() / 100].setGeneric(pike);
        this.map[pike.getPos_x() / 100][pike.getPos_y() / 100].setCrs(false);
        this.map[pike.getPos_x() / 100][pike.getPos_y() / 100].setOccupied(true);

        griff = new Griff(100, 0, ap);
        griff.setImg("stand", ap);
        this.map[griff.getPos_x() / 100][griff.getPos_y() / 100].setGeneric(griff);
        this.map[griff.getPos_x() / 100][griff.getPos_y() / 100].setCrs(false);
        this.map[griff.getPos_x() / 100][griff.getPos_y() / 100].setOccupied(true);

        archer = new Archer(0,200,ap);
        this.map[archer.getPos_x() / 100][archer.getPos_y() / 100].setGeneric(archer);
        this.map[archer.getPos_x() / 100][archer.getPos_y() / 100].setCrs(false);
        this.map[archer.getPos_x() / 100][archer.getPos_y() / 100].setOccupied(true);
        archer.setImg("stand",ap);

        mage = new Mage(0 ,400, ap);
        this.map[mage.getPos_x()/100][mage.getPos_y()/100].setGeneric(mage);
        this.map[mage.getPos_x()/100][mage.getPos_y()/100].setCrs(false);
        this.map[mage.getPos_x()/100][mage.getPos_y()/100].setOccupied(true);
        mage.setImg("stand",ap);


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

        genie = new Genie(500, 500, ap);
        this.map[genie.getPos_x() / 100][genie.getPos_y() / 100].setGeneric(genie);
        this.map[genie.getPos_x() / 100][genie.getPos_y() / 100].setCrs(false);
        this.map[genie.getPos_x() / 100][genie.getPos_y() / 100].setOccupied(true);
        genie.setImg("stand", ap);

        logField = new TextArea(logs);
        logField.setLayoutX(1200);
        logField.setLayoutY(100);
        logField.setPrefHeight(500);
        logField.setPrefWidth(300);
        logField.setText("Logs: \n");

        round = new ArrayList<>();

        round.add(pike);
        round.add(chimp);
        round.add(griff);
        round.add(archer);
        round.add(mage);
        round.add(imp);
        round.add(impArcher);
        round.add(hound);
        round.add(genie);
        round.add(evilChimp);

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
        if(!chimp.isFireActive()) fire.setDisable(true);
        fire.setPrefWidth(75);
        fire.setPrefHeight(50);
        fire.setLayoutX(1225);
        fire.setLayoutY(850);

        Button light = new Button("Thunder");
        if(!chimp.isThunderActive()) light.setDisable(true);
        light.setPrefWidth(75);
        light.setPrefHeight(50);
        light.setLayoutX(1325);
        light.setLayoutY(850);

        Button res = new Button("Res");
        if(!chimp.isResActive()) res.setDisable(true);
        res.setPrefWidth(50);
        res.setPrefHeight(50);
        res.setLayoutX(1425);
        res.setLayoutY(850);

        imp.getActual().setOnMouseClicked((mouseEvent) -> {
            if(imp.getHp() > 0){
                attack(map, round.get(index), imp, ap, logField, round);
            }
            if(round.get(index).getName().equals("Archer")){
                attackWitoutLimit(map, archer, imp, ap, logField, round);
            }
        });
        hound.getActual().setOnMouseClicked((mouseEvent) -> {
            if(hound.getHp() > 0){
                attack(map, round.get(index), hound, ap, logField, round);
            }
            if(round.get(index).getName().equals("Archer")){
                attackWitoutLimit(map, archer, hound, ap, logField, round);
            }
        });
        impArcher.getActual().setOnMouseClicked((mouseEvent) -> {
            if(impArcher.getHp() > 0){
                attack(map, round.get(index), impArcher, ap, logField, round);
            }
            if(round.get(index).getName().equals("Archer")){
                attackWitoutLimit(map, archer, impArcher, ap, logField, round);
            }
        });


        pike.getActual().setOnMouseClicked((mouseEvent) -> {
            if(pike.getHp() > 0){
                attack(map, round.get(index), pike, ap, logField, round);
            }
            if(round.get(index).getName().equals("ImpArcher")){
                attackWitoutLimit(map, impArcher, pike, ap, logField, round);
            }
        });
        griff.getActual().setOnMouseClicked((mouseEvent) -> {
            if(griff.getHp() > 0){
                attack(map, round.get(index), griff, ap, logField, round);
            }
            if(round.get(index).getName().equals("ImpArcher")){
                attackWitoutLimit(map, impArcher, griff, ap, logField, round);
            }
        });
        archer.getActual().setOnMouseClicked((mouseEvent) -> {
            if(archer.getHp() > 0){
                attack(map, round.get(index), archer, ap, logField, round);
            }
            if(round.get(index).getName().equals("ImpArcher")){
                attackWitoutLimit(map, impArcher, archer, ap, logField, round);
            }
        });


        pass.setOnMouseClicked((event) -> {
            rounder.setText(""+roundCount);
            act(index);
            logField.appendText("\n\nIndex:: " +index+"\nRound:: "+ round.get(index).getName());
            index++;
            if(index == 6) index = 0;

            if (archer.getHp() <= 0 && pike.getHp() <= 0 && griff.getHp() <= 0) {
                Victory vc = new Victory();
                vc.endGame("bukta");
                logField.appendText("\n\nVesztettek az emberek");
            }

            if (imp.getHp() <= 0 && hound.getHp() <= 0 && impArcher.getHp() <= 0) {
                Victory vc = new Victory();
                vc.endGame("");
                logField.appendText("\n\nGyőztek az emberek.");
            }
        });
        ap.getChildren().addAll(pass, fire, light, res,rounder, logField);}

    public void act(int asd){
        if(round.get(asd).getName().equals("Pike") || round.get(asd).getName().equals("Griff") || round.get(asd).getName().equals("Archer") || round.get(asd).getName().equals("Mage") || round.get(asd).getName().equals("Hound") || round.get(asd).getName().equals("ImpArcher") || round.get(asd).getName().equals("Genie")){
            move(map, round.get(asd), this.x_count, this.y_count, ap, logField, round);
        }
        if(round.get(asd).getName().equals("chimp") || round.get(asd).getName().equals("evilChimp")){
            spell();
        }
    }

    public void spell(){
        if(round.get(index).getName().equals("Chimp")){
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[j].length; j++) {
                    Tile tl = map[i][j];

                    tl.getImageView().setOnMouseClicked((event) -> fireBall(tl));

                    pike.getActual().setOnMouseClicked((event) -> resurrection(pike));

                    griff.getActual().setOnMouseClicked((event) -> resurrection(griff));

                    archer.getActual().setOnMouseClicked((event) -> resurrection(archer));

                    mage.getActual().setOnMouseClicked((event) -> resurrection(mage));

                    imp.getActual().setOnMouseClicked((event) -> thunderStrike(imp));

                    hound.getActual().setOnMouseClicked((event) -> thunderStrike(hound));

                    impArcher.getActual().setOnMouseClicked((event) -> thunderStrike(impArcher));

                    genie.getActual().setOnMouseClicked((event) -> thunderStrike(genie));
                }
            }
        }
    }

    public void fireBall(Tile tl){
        int radX = map[tl.getPos_x() / 100][tl.getPos_y() / 100].getPos_x();
        int radY = map[tl.getPos_x() / 100][tl.getPos_y() / 100].getPos_y();

        for (int g = 0; g < round.size(); g++) {
            if (round.get(g).getPos_x() <= radX + 150 && round.get(g).getPos_x() >= radX - 150 &&
                    round.get(g).getPos_y() <= radY + 150 && round.get(g).getPos_y() >= radY - 150) {
                round.get(g).setHp((int) (round.get(g).getHp() - chimp.getMagic() * 20));
            }
            if (round.get(g).getHp() <= 0) round.get(g).setImg("dead", ap);
        }
        chimp.setMana(chimp.getMana() - 9);

        act(index);
    }

    public void resurrection(Generic asd){
        if (asd.getHp() <= 0) {
            asd.setHp((int) (asd.getHp() + chimp.getMagic() * 50));
            asd.setImg("stand", ap);
            chimp.setMana(chimp.getMana() - 6);
        }
        act(index);
    }

    public void thunderStrike(Generic asd){
        asd.setHp((int) (asd.getHp() - chimp.getMagic() * 30));
        chimp.setMana(chimp.getMana() - 5);
        System.out.println("megrázta a csúnya "+asd.getName());
        act(index);
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