package com.example.prog1demo.MenuElements;

import com.example.prog1demo.units.Champions;
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

public class ChimpBooster {

    public void boost(Stage stg) throws IOException {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(1000, 800);
        InputStream is = Files.newInputStream(Paths.get("pngs/Shop.png"));
        Image bckgr = new Image(is);
        is.close();
        ImageView img = new ImageView(bckgr);
        img.setFitWidth(1000);
        img.setFitHeight(800);

        Champions chimp = new Champions();

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

        attText.setText(""+chimp.getAtt());
        deffText.setText(""+chimp.getDeff());
        magicText.setText(""+chimp.getMagic_power());
        wisdomText.setText(""+chimp.getWisdom());
        moralText.setText(""+chimp.getMoral());
        luckText.setText(""+chimp.getLuck());

        Button attackMinus = new Button(" - ");

        attackMinus.setOnMouseClicked((event)->{
            chimp.setAtt(chimp.getAtt()-1);
            chimp.setSkillPoint(chimp.getSkillPoint()+1);
            attText.setText(""+chimp.getAtt());
        });

        Button attackMax = new Button(" + ");

        attackMax.setOnMouseClicked((event)->{
            chimp.setAtt(chimp.getAtt()+1);
            chimp.setSkillPoint(chimp.getSkillPoint()-1);
            attText.setText(""+chimp.getAtt());
        });

        Button deffMinus = new Button(" - ");

        deffMinus.setOnMouseClicked((event)->{
            chimp.setDeff(chimp.getDeff()-1);
            chimp.setSkillPoint(chimp.getSkillPoint()+1);
            deffText.setText(""+chimp.getDeff());
        });

        Button deffMax = new Button(" + ");

        deffMax.setOnMouseClicked((event)->{
            chimp.setDeff(chimp.getDeff()+1);
            chimp.setSkillPoint(chimp.getSkillPoint()-1);
            deffText.setText(""+chimp.getDeff());
        });

        Button magicMin = new Button(" - ");

        magicMin.setOnMouseClicked((event)->{
            chimp.setMagic_power(chimp.getMagic_power()-1);
            chimp.setSkillPoint(chimp.getSkillPoint()+1);
            magicText.setText(""+chimp.getMagic_power());
        });

        Button magicMax = new Button(" + ");

        magicMax.setOnMouseClicked((event)->{
            chimp.setMagic_power(chimp.getMagic_power()+1);
            chimp.setSkillPoint(chimp.getSkillPoint()-1);
            magicText.setText(""+chimp.getMagic_power());
        });

        Button wisdomMin = new Button(" - ");

        wisdomMin.setOnMouseClicked((event)->{
            chimp.setWisdom(chimp.getWisdom()-1);
            chimp.setSkillPoint(chimp.getSkillPoint()+1);
            wisdomText.setText(""+chimp.getWisdom());
        });

        Button wisdomMax = new Button(" + ");

        wisdomMax.setOnMouseClicked((event)->{
            chimp.setWisdom(chimp.getWisdom()+1);
            chimp.setSkillPoint(chimp.getSkillPoint()-1);
            wisdomText.setText(""+chimp.getWisdom());
        });

        Button moralMin = new Button(" - ");

        moralMin.setOnMouseClicked((event)->{
            chimp.setMoral(chimp.getMoral()-1);
            chimp.setSkillPoint(chimp.getSkillPoint()+1);
            moralText.setText(""+chimp.getMoral());
        });

        Button moralMax = new Button(" + ");

        moralMax.setOnMouseClicked((event)->{
            chimp.setMoral(chimp.getMoral()+1);
            chimp.setSkillPoint(chimp.getSkillPoint()-1);
            moralText.setText(""+chimp.getMoral());
        });

        Button luckMin = new Button(" - ");

        luckMin.setOnMouseClicked((event)->{
            chimp.setLuck(chimp.getLuck()-1);
            chimp.setSkillPoint(chimp.getSkillPoint()+1);
            luckText.setText(""+chimp.getLuck());
        });

        Button luckyMax = new Button(" + ");

        luckyMax.setOnMouseClicked((event)->{
            chimp.setLuck(chimp.getLuck()+1);
            chimp.setSkillPoint(chimp.getSkillPoint()-1);
            luckText.setText(""+chimp.getLuck());
        });

        serializeButton(attackMinus, 300, 150);
        serializeButton(attackMax, 500, 150);
        serializeButton(deffMinus, 300,250);
        serializeButton(deffMax, 500,250);
        serializeButton(magicMin, 300,350);
        serializeButton(magicMax, 500,350);
        serializeButton(wisdomMin,300,450);
        serializeButton(wisdomMax, 500,450);
        serializeButton(moralMin,300,550);
        serializeButton(moralMax,500,550);
        serializeButton(luckMin, 300, 650);
        serializeButton(luckyMax, 500, 650);

        setTextBox(attText,400,150);
        setTextBox(deffText,400,250);
        setTextBox(magicText,400,350);
        setTextBox(wisdomText,400,450);
        setTextBox(moralText,400,550);
        setTextBox(luckText,400,650);

        attack.setText("Attack:: ");
        setTextBox(attack, 150 ,150);

        defense.setText("Defense:: ");
        setTextBox(defense,150,250);

        magic.setText("Magic:: ");
        setTextBox(magic,150,350);

        wisdom.setText("Wisdom:: ");
        setTextBox(wisdom,150,450);

        moral.setText("Moral:: ");
        setTextBox(moral,150,550);

        luck.setText("Luck:: ");
        setTextBox(luck,150,650);

        root.getChildren().addAll(img, attackMinus, attackMax, deffMinus, deffMax,magicMin
        , magicMax, wisdomMin, wisdomMax, moralMin, moralMax, luckMin, luckyMax, attText,
                deffText, magicText, wisdomText, moralText, luckText, attack, defense,
                magic, wisdom, moral, luck);

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
        str.setMaxWidth(75);
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
