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

        serializeButton(attackMinus, 350, 350);
        serializeButton(attackMax, 450, 350);
        serializeButton(deffMinus, 350,450);
        serializeButton(deffMax, 450,450);
        serializeButton(magicMin, 350,550);
        serializeButton(magicMax, 450,550);
        serializeButton(wisdomMin,350,650);
        serializeButton(wisdomMax, 350,650);
        serializeButton(moralMin,350,750);
        serializeButton(moralMax,450,750);
        serializeButton(luckMin, 350, 850);
        serializeButton(luckyMax, 450, 850);

        attText.setText(""+chimp.getAtt());
        attText.setBackground(new Background(new BackgroundFill(Color.rgb(243, 243, 243, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        attText.setMinHeight(50);
        attText.setMaxHeight(50);
        attText.setMinWidth(50);
        attText.setMaxWidth(50);
        attText.setLayoutX(400);
        attText.setLayoutY(350);

        deffText.setBackground(new Background(new BackgroundFill(Color.rgb(243, 243, 243, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        magicText.setBackground(new Background(new BackgroundFill(Color.rgb(243, 243, 243, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        wisdomText.setBackground(new Background(new BackgroundFill(Color.rgb(243, 243, 243, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        moralText.setBackground(new Background(new BackgroundFill(Color.rgb(243, 243, 243, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        luckText.setBackground(new Background(new BackgroundFill(Color.rgb(243, 243, 243, 0.9), new CornerRadii(5.0), new Insets(-5.0))));

        txt.setText(str);
        txt.setMinHeight(50);
        txt.setMaxHeight(50);
        txt.setMinWidth(50);
        txt.setMaxWidth(50);
        txt.setLayoutX(x_cord);
        txt.setLayoutY(y_cord);


        serializeText(deffText, 400, 450, ""+chimp.getDeff());
        serializeText(magicText, 400, 550, ""+chimp.getMagic_power());
        serializeText(wisdomText, 400, 650, ""+chimp.getWisdom());
        serializeText(moralText, 400, 750, ""+chimp.getMoral());
        serializeText(luckText, 400, 750, ""+chimp.getLuck());

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
