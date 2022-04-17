/**
 * Az osztály szolgál 'engine'-ként. A konstruktorban automatikusan
 * van generáltatva a pálya, és fel van töltve elérhetetlen mezőkkel is.
 *
 * A Generate()
 *                  intézi az interakciót a pályával,
 *                  itt jönnek be az egységek és azoknak a cselekvései.
 *                  Nem vár a fvg paramétert, mert a többi osztályból ollózza össze a statikus változókat.
 *
 * act()
 * @param unitRoundACtiveIndex
 *                  egy int változót vár paraméterül, a paraméter amit kap mondja meg
 *                  hogy az arraylist-ben melyik indexű elem, hogy reagáljon
 *                  ha a listában az adott indexű elem szüvetséges
 *                  akkor mozoghat illetve támadhat,
 *                  de ha az adott elem ellenséges akkor az algoritmus szabályozza a lépését
 *
 *                  ha pedig a játékos hőse, akkor varázsolni tud, majd attól függően,
 *                  hogy ellenfére kattint e, vagy egy mezőre vagy egy szövetséges egységre
 *
 * spell()
 *                  fvg híváskor leelnőrzi, hogy a soron lévő karakter e a hős
 *                  ha igen, akkor az adott varázslatokból cast-ol egyet kattintástól függően
 *                  Tud feltámasztani, egy darab ellenfelet támadni, és területi sebzést okozni.
 *
 * fireBall()
 * @param tl        egy mező tipusú objectet vár paraméterben
 *
 *                  az az object lesz a robbanásnak a középpontja
 *                  mivel 3*3 mezőben sebződnek a karakterek
 *                  ezért x és y kordinátán is +/- 150 egységben sebez
 *                  ha van elég manája a hősnek
 *                  ha nincs akkor azonnal újra meghívja az act() fv-t
 *                  ha van akkor a varázslat után hívja csak meg
 *                  az act() -el lépünk ki a varázslásból
 *
 * resurrection()
 * @param  gen      Egy generic ősosztályú változót vár.  Amit kattintással kap meg.
 *
 *                  Ha a hősnek van elég manája, akkor egy halott egységét feltámaszthatja.
 *
 * thunderStrike()
 * @param  gen      Egy generic ősosztályú változót vár.  Amit kattintással kap meg.
 *                  Ha, ellenséges egységre kattint a játékos, akkor azt villámcsapás éri.
 *                  De csak ha van elég manája
 *
 * removeDeadUnit()
 * @param  round    Egy arraylist -et kap a fvg.
 *                  Ebből kiválogatja az elesett egységeket a metódus, majd törli azokat.
 *
 *
 */


package com.example.prog1demo.BattleField;

import com.example.prog1demo.Interfaces.Action;
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
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import java.util.ArrayList;

public class Tiles implements Action{
    int x_count;
    int y_count;
    Tile[][] map;
    int i, j;
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
    ArrayList<Generic> round;
    Mage mage;
    Genie genie;

    public Tiles(int x, int y, AnchorPane anchor){
        String str;
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
        mage = new Mage(100, 400, ap);

        evilChimp.setImpCount((int) ((Math.random()*20)+1));
        evilChimp.setImpArcherCount((int) ((Math.random()*20)+1));
        evilChimp.setHoundCount((int) ((Math.random()*20)+1));
        evilChimp.setGenieCount((int) ((Math.random()*20)+1));

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

/*
        Generic[] arr = {pike, griff, archer, imp, impArcher, hound, chimp, evilChimp};
        Generic[] finalArr = {pike, griff, archer, imp, impArcher, hound, chimp, evilChimp};
        setOrder(arr, finalArr);

        for (Generic generic : finalArr) System.out.println(generic.getName()+generic.getMoral());
*/

        round = new ArrayList<>();

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
        if(chimp.getMageCount() > 0){
            round.add(mage);
            mage.setImg("stand",ap);
            this.map[mage.getPos_x()/100][mage.getPos_y()/100].setGeneric(mage);
            this.map[mage.getPos_x()/100][mage.getPos_y()/100].setCrs(false);
            this.map[mage.getPos_x()/100][mage.getPos_y()/100].setOccupied(true);
        }

        round.add(chimp);
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
            if(round.get(index).getName().equals("Archer") && imp.getHp()>0){
                attackWitoutLimit(map, archer, imp, ap, logField, round);
                removeDeadUnit(round);
            } else if(imp.getHp()>0){
                attack(map, round.get(index), imp, ap, logField, round);
                removeDeadUnit(round);
            }
        });
        hound.getActual().setOnMouseClicked((mouseEvent) -> {
            if(round.get(index).getName().equals("Archer") && hound.getHp()>0){
                attackWitoutLimit(map, archer, hound, ap, logField, round);
                removeDeadUnit(round);
            } else if(hound.getHp()>0){
                attack(map, round.get(index), hound, ap, logField, round);
                removeDeadUnit(round);
            }
        });
        impArcher.getActual().setOnMouseClicked((mouseEvent) -> {
            if(round.get(index).getName().equals("Archer") && impArcher.getHp() > 0){
                attackWitoutLimit(map, archer, impArcher, ap, logField, round);
                removeDeadUnit(round);
            } else if(impArcher.getHp()>0) {
                attack(map, round.get(index), impArcher, ap,logField, round);
                removeDeadUnit(round);
            }
        });

        pass.setOnMouseClicked((event) -> {
            rounder.setText(""+roundCount);
            act(index);
            logField.appendText("\n\nIndex:: " +index+"\n"+round.get(index).getName());
            index++;
            if(index == round.size()) index = 0;

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
        ap.getChildren().addAll(pass, fire, light, res,rounder, logField);
    }

    public void act(int unitRoundIndex){
        if(round.get(unitRoundIndex).getName().equals("Pike") || round.get(unitRoundIndex).getName().equals("Griff") ||
                round.get(unitRoundIndex).getName().equals("Archer") || round.get(unitRoundIndex).getName().equals("Mage") ){
            move(map, round.get(unitRoundIndex), this.x_count, this.y_count, ap, logField, round);
        }
        if (round.get(unitRoundIndex).getName().equals("Imp") || round.get(unitRoundIndex).getName().equals("Hound") ||
                round.get(unitRoundIndex).getName().equals("ImpArcher") || round.get(unitRoundIndex).getName().equals("Genie")){
            AImove(map, round ,round.get(unitRoundIndex), ap, logField);
        }
        if(round.get(unitRoundIndex).getName().equals("Chimp")){
            spell();
        }
    }

    public void spell(){
        if(round.get(index).getName().equals("Chimp")){
            for (Tile[] tiles : map) {
                for (int j = 0; j < map[j].length; j++) {
                    Tile tl = tiles[j];

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
        if(chimp.getMana()>=9) {
            int radX = map[tl.getPos_x() / 100][tl.getPos_y() / 100].getPos_x();
            int radY = map[tl.getPos_x() / 100][tl.getPos_y() / 100].getPos_y();
            logField.appendText("Fireball happened at X: " + radX + "\nY: " + radY + "\n killed");
            for (Generic generic : round) {
                if (generic.getPos_x() <= radX + 150 && generic.getPos_x() >= radX - 150 &&
                        generic.getPos_y() <= radY + 150 && generic.getPos_y() >= radY - 150) {
                    generic.setHp((int) (generic.getHp() - chimp.getMagic() * 20));
                }
                if (generic.getHp() <= 0) {
                    generic.setImg("dead", ap);
                    logField.appendText("\n"+generic.getName());
                }
            }

            chimp.setMana(chimp.getMana() - 9);
        }else{
            logField.appendText("\n not enough mana\n");
        }
        act(index);
    }

    public void resurrection(Generic gen){
        logField.appendText("Resurrected :");
        if(chimp.getMana() >= 6){
            if (gen.getHp() <= 0) {
                gen.setHp((int) (gen.getHp() + chimp.getMagic() * 50));
                gen.setImg("stand", ap);
                chimp.setMana(chimp.getMana() - 6);
                logField.appendText(" "+gen.getName());
            }
        }else{
            logField.appendText("\n not enough mana\n");
        }
        act(index);
    }

    public void thunderStrike(Generic gen){
        if(chimp.getMana() >= 5){
            logField.appendText("Thunderstriked "+gen.getName());
            gen.setHp((int) (gen.getHp() - chimp.getMagic() * 30));
            chimp.setMana(chimp.getMana() - 5);
            System.out.println("megrázta a csúnya " + gen.getName());
        }else{
            logField.appendText("\n not enough mana\n");
        }
        act(index);
    }

    public void removeDeadUnit(ArrayList<Generic> round){
        for(int i=0;i<round.size();i++){
            if(round.get(i).getHp()<=0) {
                round.remove(i);
            }
        }
    }

}