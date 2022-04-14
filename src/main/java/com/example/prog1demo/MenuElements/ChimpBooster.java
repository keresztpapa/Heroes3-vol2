/**
 * Itt a hősök tulajdoságai állítódnak be.
 * Minden skillpoint egyre drágább, egy skill-ből min 0 és max 10 lehet.
 * Van 2 metódus a setTextBox és a serializeButton
 * Ezekkel tudjuk felgyorsítani a gombok és szövegdobozok létrehozását.
 * Jobb oldalt megjelenik az ellenfél skillpoint-jai, neki random osztott el egy algoritmus 10 pontot.
 */

package com.example.prog1demo.MenuElements;

import com.example.prog1demo.units.unit.Heroes.Champions;
import com.example.prog1demo.units.unit.Heroes.VillianChamp;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class ChimpBooster {

    public void boost(Stage stg) throws IOException {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(1500, 1000);
        InputStream is = Files.newInputStream(Paths.get("pngs/Shop.png"));
        Image bckgr = new Image(is);
        is.close();
        ImageView img = new ImageView(bckgr);
        img.setFitWidth(1500);
        img.setFitHeight(1000);

        Champions chimp = new Champions();

        TextField skillShowOff = new TextField();
        TextField skillText = new TextField();
        TextField attText = new TextField();
        TextField deffText = new TextField();
        TextField magicText = new TextField();
        TextField wisdomText = new TextField();
        TextField moralText = new TextField();
        TextField luckText = new TextField();

        //attack.setText("Attack:: ");
        TextField attack = new TextField();
        TextField defense = new TextField();
        TextField magic = new TextField();
        TextField wisdom = new TextField();
        TextField moral = new TextField();
        TextField luck = new TextField();

        skillShowOff.setText("Skill points:: ");
        skillText.setText(""+chimp.getGold());
        attText.setText(""+chimp.getAtt());
        deffText.setText(""+chimp.getDeff());
        magicText.setText(""+chimp.getMagic());
        wisdomText.setText(""+chimp.getWisdom());
        moralText.setText(""+chimp.getMoral());
        luckText.setText(""+chimp.getLuck());

        Button attackMinus = new Button(" - ");

        double cost = 5.0;

        attackMinus.setOnMouseClicked((event)->{
            if(chimp.getAtt() > 0) {
                chimp.setAtt(chimp.getAtt() - 1);
                chimp.setGold((int) (chimp.getGold() + cost));
                skillText.setText("" + chimp.getGold());
                attText.setText("" + chimp.getAtt());
            }
        });

        Button attackMax = new Button(" + ");

        attackMax.setOnMouseClicked((event)->{
            if(chimp.getGold()-cost> 0 && chimp.getAtt()<10) {
                chimp.setAtt(chimp.getAtt() + 1);
                chimp.setGold((int) (chimp.getGold() - cost*1.1));
                skillText.setText("" + chimp.getGold());
                attText.setText("" + chimp.getAtt());
            }
        });

        Button deffMinus = new Button(" - ");

        deffMinus.setOnMouseClicked((event)->{
            if(chimp.getDeff() > 0) {
                chimp.setDeff(chimp.getDeff() - 1);
                chimp.setGold((int) (chimp.getGold() + cost));
                skillText.setText("" + chimp.getGold());
                deffText.setText("" + chimp.getDeff());
            }
        });

        Button deffMax = new Button(" + ");

        deffMax.setOnMouseClicked((event)->{
            if(chimp.getGold()-cost > 0 && chimp.getDeff() < 10) {
                chimp.setDeff(chimp.getDeff() + 1);
                chimp.setGold((int) (chimp.getGold() - cost*1.1));
                skillText.setText("" + chimp.getGold());
                deffText.setText("" + chimp.getDeff());
            }
        });

        Button magicMin = new Button(" - ");

        magicMin.setOnMouseClicked((event)->{
            if(chimp.getMagic() > 0) {
                chimp.setMagic(chimp.getMagic() - 1);
                chimp.setGold((int) (chimp.getGold() + cost));
                skillText.setText("" + chimp.getGold());
                magicText.setText("" + chimp.getMagic());
            }
        });

        Button magicMax = new Button(" + ");

        magicMax.setOnMouseClicked((event)->{
            if(chimp.getGold()-cost > 0 && chimp.getMagic() < 10) {
                chimp.setMagic(chimp.getMagic() + 1);
                chimp.setGold((int) (chimp.getGold() - cost*1.1));
                skillText.setText("" + chimp.getGold());
                magicText.setText("" + chimp.getMagic());
            }
        });

        Button wisdomMin = new Button(" - ");

        wisdomMin.setOnMouseClicked((event)->{
            if(chimp.getWisdom() > 0) {
                chimp.setWisdom(chimp.getWisdom() - 1);
                chimp.setGold((int) (chimp.getGold() + cost));
                skillText.setText("" + chimp.getGold());
                wisdomText.setText("" + chimp.getWisdom());
            }
        });

        Button wisdomMax = new Button(" + ");

        wisdomMax.setOnMouseClicked((event)->{
            if(chimp.getGold()-cost > 0 && chimp.getWisdom() <10) {
                chimp.setWisdom(chimp.getWisdom() + 1);
                chimp.setGold((int) (chimp.getGold() - cost*1.1));
                skillText.setText("" + chimp.getGold());
                wisdomText.setText("" + chimp.getWisdom());
            }
        });

        Button moralMin = new Button(" - ");

        moralMin.setOnMouseClicked((event)->{
            if(chimp.getMoral() > 0) {
                chimp.setMoral(chimp.getMoral() - 1);
                chimp.setGold((int) (chimp.getGold() + cost));
                skillText.setText("" + chimp.getGold());
                moralText.setText("" + chimp.getMoral());
            }
        });

        Button moralMax = new Button(" + ");

        moralMax.setOnMouseClicked((event)->{
            if(chimp.getGold()-cost > 0 && chimp.getMoral() <10) {
                chimp.setMoral(chimp.getMoral() + 1);
                chimp.setGold((int) (chimp.getGold() - cost*1.1));
                skillText.setText("" + chimp.getGold());
                moralText.setText("" + chimp.getMoral());
            }
        });

        Button luckMin = new Button(" - ");

        luckMin.setOnMouseClicked((event)->{
            if(chimp.getLuck() > 0){
                chimp.setLuck(chimp.getLuck() - 1);
                chimp.setGold((int) (chimp.getGold() + cost));
                skillText.setText("" + chimp.getGold());
                luckText.setText("" + chimp.getLuck());
            }
        });

        Button luckyMax = new Button(" + ");

        luckyMax.setOnMouseClicked((event)->{
            if(chimp.getGold()-cost > 0 && chimp.getLuck() < 10) {
                chimp.setLuck(chimp.getLuck() + 1);
                chimp.setGold((int) (chimp.getGold() - cost*1.1));
                skillText.setText("" + chimp.getGold());
                luckText.setText("" + chimp.getLuck());
            }
        });

        VillianChamp villianChamp = new VillianChamp();

        for(int i=0;i<10;i++){
            Random rand = new Random();
            int randSkill = rand.nextInt(6);
            switch (randSkill) {
                case 0 -> villianChamp.setAtt(villianChamp.getAtt() + 1);
                case 1 -> villianChamp.setDeff(villianChamp.getDamage() + 1);
                case 2 -> villianChamp.setMagic(villianChamp.getMagic() + 1);
                case 3 -> villianChamp.setWisdom(villianChamp.getWisdom() + 1);
                case 4 -> villianChamp.setMoral(villianChamp.getMoral() + 1);
                case 5 -> villianChamp.setLuck(villianChamp.getLuck() + 1);
            }
        }

        TextField villian = new TextField("Villian: ");
        TextField villianAttack = new TextField("Attack: " + villianChamp.getAtt());
        TextField villianDeff = new TextField("Deff: " + villianChamp.getDeff());
        TextField villianMagic = new TextField("Magic: " + villianChamp.getMagic());
        TextField villianWisdom = new TextField("Wisdom: " + villianChamp.getWisdom());
        TextField villianMoral = new TextField("Moral: " + villianChamp.getMoral());
        TextField villianLuck = new TextField("Luck: " + villianChamp.getLuck());

        setTextBox(villian,1000,350);
        setTextBox(villianAttack, 1000, 400);
        setTextBox(villianDeff, 1000, 450);
        setTextBox(villianMagic, 1000, 500);
        setTextBox(villianWisdom, 1000, 550);
        setTextBox(villianMoral, 1000, 600);
        setTextBox(villianLuck, 1000, 650);

        Button toSkills = new Button(" To the skills ");
        toSkills.setPrefHeight(60);
        toSkills.setPrefWidth(120);
        toSkills.setLayoutX(1000);
        toSkills.setLayoutY(800);

        toSkills.setOnMouseClicked((event)->{
            ChampionsPower chimpsPower = new ChampionsPower();
            try {
                chimpsPower.skills(stg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });



        serializeButton(attackMinus, 530, 300);
        serializeButton(attackMax,730 , 300);
        serializeButton(deffMinus, 530,400);
        serializeButton(deffMax, 730,400);
        serializeButton(magicMin, 530,500);
        serializeButton(magicMax, 730,500);
        serializeButton(wisdomMin,530,600);
        serializeButton(wisdomMax, 730,600);
        serializeButton(moralMin,530,700);
        serializeButton(moralMax,730,700);
        serializeButton(luckMin, 530, 800);
        serializeButton(luckyMax, 730, 800);

        setTextBox(attText,600,300);
        setTextBox(deffText,600,400);
        setTextBox(magicText,600,500);
        setTextBox(wisdomText,600,600);
        setTextBox(moralText,600,700);
        setTextBox(luckText,600,800);

        setTextBox(skillText,600,200);
        setTextBox(skillShowOff,400,200);

        attack.setText("Attack:: ");
        setTextBox(attack, 400 ,300);

        defense.setText("Defense:: ");
        setTextBox(defense,400,400);

        magic.setText("Magic:: ");
        setTextBox(magic,400,500);

        wisdom.setText("Wisdom:: ");
        setTextBox(wisdom,400,600);

        moral.setText("Moral:: ");
        setTextBox(moral,400,700);

        luck.setText("Luck:: ");
        setTextBox(luck,400,800);

        root.getChildren().addAll(img, attackMinus, attackMax, deffMinus, deffMax,magicMin
                , magicMax, wisdomMin, wisdomMax, moralMin, moralMax, luckMin, luckyMax, attText,
                deffText, magicText, wisdomText, moralText, luckText, attack, defense,
                magic, wisdom, moral, luck, skillText, skillShowOff, toSkills,
                villianAttack, villianDeff, villianMagic, villianWisdom, villianMoral,
                villianLuck, villian);

        Scene sc = new Scene(root);
        stg.setTitle("Heroes -- Might and Magic 3: Low budget edition :: Skill point defection");
        stg.setScene(sc);
        stg.show();
    }

    public void setTextBox(TextField str, int x, int y){
        str.setBackground(new Background(new BackgroundFill(Color.rgb(243, 243, 243, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        str.setMinHeight(50);
        str.setMaxHeight(50);
        str.setMinWidth(50);
        str.setMaxWidth(100);
        str.setLayoutX(x);
        str.setLayoutY(y);
    }

    public void serializeButton(Button btn, int x_cord, int y_cord){
        btn.setPrefHeight(50);
        btn.setPrefWidth(50);
        btn.setLayoutX(x_cord);
        btn.setLayoutY(y_cord);
    }
}
