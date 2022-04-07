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

        Button attackMinus = new Button(" - ");
        Button attackMax = new Button(" + ");
        Button deffMinus = new Button(" - ");
        Button deffMax = new Button(" + ");
        Button magicMin = new Button(" - ");
        Button magicMax = new Button(" + ");
        Button wisdomMin = new Button(" - ");
        Button wisdomMax = new Button(" + ");
        Button moralMin = new Button(" - ");
        Button moralMax = new Button(" + ");
        Button luckMin = new Button(" - ");
        Button luckyMax = new Button(" + ");

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

        attText.setText("Att"+chimp.getAtt());
        attText.setBackground(new Background(new BackgroundFill(Color.rgb(243, 243, 243, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        attText.setMinHeight(50);
        attText.setMaxHeight(50);
        attText.setMinWidth(50);
        attText.setMaxWidth(50);
        attText.setLayoutX(400);
        attText.setLayoutY(150);

        deffText.setText("deff"+chimp.getDeff());
        deffText.setBackground(new Background(new BackgroundFill(Color.rgb(243, 243, 243, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        deffText.setMinHeight(50);
        deffText.setMaxHeight(50);
        deffText.setMinWidth(50);
        deffText.setMaxWidth(50);
        deffText.setLayoutX(400);
        deffText.setLayoutY(250);

        magicText.setText("mag"+chimp.getMagic_power());
        magicText.setBackground(new Background(new BackgroundFill(Color.rgb(243, 243, 243, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        magicText.setMinHeight(50);
        magicText.setMaxHeight(50);
        magicText.setMinWidth(50);
        magicText.setMaxWidth(50);
        magicText.setLayoutX(400);
        magicText.setLayoutY(350);

        wisdomText.setText("wis"+chimp.getWisdom());
        wisdomText.setBackground(new Background(new BackgroundFill(Color.rgb(243, 243, 243, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        wisdomText.setMinHeight(50);
        wisdomText.setMaxHeight(50);
        wisdomText.setMinWidth(50);
        wisdomText.setMaxWidth(50);
        wisdomText.setLayoutX(400);
        wisdomText.setLayoutY(450);

        moralText.setText("mor"+chimp.getMoral());
        moralText.setBackground(new Background(new BackgroundFill(Color.rgb(243, 243, 243, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        moralText.setMinHeight(50);
        moralText.setMaxHeight(50);
        moralText.setMinWidth(50);
        moralText.setMaxWidth(50);
        moralText.setLayoutX(400);
        moralText.setLayoutY(550);

        luckText.setText("luc"+chimp.getLuck());
        luckText.setBackground(new Background(new BackgroundFill(Color.rgb(243, 243, 243, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        luckText.setMinHeight(50);
        luckText.setMaxHeight(50);
        luckText.setMinWidth(50);
        luckText.setMaxWidth(50);
        luckText.setLayoutX(400);
        luckText.setLayoutY(650);

/*
        ImageView griff = new ImageView(new Image("file:pngs/player_units/griff/griff_stand.png"));
        griff.setX(400);
        griff.setY(200);

        griffText = new TextField(":: "+champ.getGriffCount());
        griffText.setBackground(new Background(new BackgroundFill(Color.rgb(243, 243, 243, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        griffText.setMinHeight(50);
        griffText.setMaxHeight(50);
        griffText.setMinWidth(50);
        griffText.setMaxWidth(50);
        griffText.setLayoutX(425);
        griffText.setLayoutY(350);*/


        root.getChildren().add(attackMinus);
        root.getChildren().add(attackMax);
        root.getChildren().add(deffMinus);
        root.getChildren().add(deffMax);
        root.getChildren().add(magicMin);
        root.getChildren().add(magicMax);
        root.getChildren().add(wisdomMin);
        root.getChildren().add(wisdomMax);
        root.getChildren().add(moralMin);
        root.getChildren().add(moralMax);
        root.getChildren().add(luckMin);
        root.getChildren().add(luckyMax);
        root.getChildren().add(attText);
        root.getChildren().add(deffText);
        root.getChildren().add(magicText);
        root.getChildren().add(wisdomText);
        root.getChildren().add(moralText);
        root.getChildren().add(luckText);

        Scene sc = new Scene(root);
        stg.setTitle("Heroes -- Might and Magic 3: Low budget edition :: Skill point defection");
        stg.setScene(sc);
        stg.show();
    }


    public void serializeButton(Button btn, int x_cord, int y_cord){
        btn.setPrefHeight(50);
        btn.setPrefWidth(50);
        btn.setLayoutX(x_cord);
        btn.setLayoutY(y_cord);
    }
}
