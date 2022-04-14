/**
 * A hősünknek tudunk varázslatot venni.
 * Itt a skills() megjeleníti a 3 varázslat képét, árát és mana költségét.
 * A varázslatok nevére kattintva megvehető a spell.
 * Ezután a Shop-ra kattintva a shop jelenik meg.
 */
package com.example.prog1demo.MenuElements;

import com.example.prog1demo.units.unit.Heroes.Champions;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ChampionsPower {

    public void skills(Stage stg) throws IOException{
        AnchorPane root = new AnchorPane();
        root.setPrefSize(1500, 1000);
        InputStream is = Files.newInputStream(Paths.get("pngs/Shop.png"));
        Image bckgr = new Image(is);
        is.close();
        ImageView img = new ImageView(bckgr);
        img.setFitWidth(1500);
        img.setFitHeight(1000);

        Champions chimp = new Champions();

        ImageView fireBall = new ImageView(new Image("file:pngs/powers/fireball.png"));
        ImageView thunderStrike = new ImageView(new Image("file:pngs/powers/lightning-strike.png"));
        ImageView ressurection = new ImageView(new Image("file:pngs/powers/cross.png"));

        fireBall.setX(150);
        fireBall.setY(150);
        fireBall.setFitHeight(200);
        fireBall.setFitWidth(200);

        thunderStrike.setX(400);
        thunderStrike.setY(150);
        thunderStrike.setFitHeight(200);
        thunderStrike.setFitWidth(200);

        ressurection.setX(650);
        ressurection.setY(150);
        ressurection.setFitHeight(200);
        ressurection.setFitWidth(200);

        Button buyFireBall = new Button(" Fireball ");
        buyFireBall.setPrefWidth(100);
        buyFireBall.setPrefHeight(50);
        buyFireBall.setLayoutX(200);
        buyFireBall.setLayoutY(400);

        TextField fireBallMana = new TextField("Mana: 5");
        fireBallMana.setLayoutX(200);
        fireBallMana.setLayoutY(500);
        fireBallMana.setPrefWidth(100);

        TextField fireBallCost = new TextField("Cost: 60");
        fireBallCost.setLayoutX(200);
        fireBallCost.setLayoutY(600);
        fireBallCost.setPrefWidth(100);

        buyFireBall.setOnMouseClicked((event)->{
            if(chimp.getGold() > 60) chimp.setGold(chimp.getGold()-60);
            chimp.setFire(true);
            System.out.println(chimp.getGold());
        });

        Button buyThunderStrike = new Button(" Thunderbolt ");
        buyThunderStrike.setPrefWidth(150);
        buyThunderStrike.setPrefHeight(50);
        buyThunderStrike.setLayoutX(425);
        buyThunderStrike.setLayoutY(400);

        TextField thunderStrikeMana = new TextField("Mana: 9");
        thunderStrikeMana.setLayoutX(425);
        thunderStrikeMana.setLayoutY(500);
        thunderStrikeMana.setPrefWidth(100);

        TextField thunderStrikeCost = new TextField("Cost: 120");
        thunderStrikeCost.setLayoutX(425);
        thunderStrikeCost.setLayoutY(600);
        thunderStrikeCost.setPrefWidth(100);

        buyThunderStrike.setOnMouseClicked((event)->{
            if(chimp.getGold() > 120) chimp.setGold(chimp.getGold()-120);
            chimp.setThunder(true);
        });

        Button buyResurection = new Button(" Resurrection ");
        buyResurection.setPrefWidth(150);
        buyResurection.setPrefHeight(50);
        buyResurection.setLayoutX(650);
        buyResurection.setLayoutY(400);

        TextField resurrectMana = new TextField("Mana: 6");
        resurrectMana.setLayoutX(650);
        resurrectMana.setLayoutY(500);
        resurrectMana.setPrefWidth(100);

        TextField resurrectCost = new TextField("Cost: 120");
        resurrectCost.setLayoutX(650);
        resurrectCost.setLayoutY(600);
        resurrectCost.setPrefWidth(100);

        buyResurection.setOnMouseClicked((event)->{
            if(chimp.getGold() > 120) chimp.setGold(chimp.getGold()-120);
            chimp.setRes(true);
        });

        Button toShop = new Button(" SHOP ");
        toShop.setPrefHeight(60);
        toShop.setPrefWidth(75);
        toShop.setLayoutX(700);
        toShop.setLayoutY(700);

        toShop.setOnMouseClicked((event)->{
            Preparation prep = new Preparation();
            try {
                prep.init(stg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        root.getChildren().addAll(img, fireBall, thunderStrike, ressurection, toShop, buyFireBall, buyResurection, buyThunderStrike,
                                fireBallMana,fireBallCost, thunderStrikeMana, thunderStrikeCost, resurrectCost,resurrectMana);
        Scene sc = new Scene(root);
        stg.setTitle("Heroes -- Might and Magic 3: Low budget edition :: I have the POWERRRR");
        stg.setScene(sc);
        stg.show();
    }
}
