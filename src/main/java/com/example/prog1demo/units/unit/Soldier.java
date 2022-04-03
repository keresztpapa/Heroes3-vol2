package com.example.prog1demo.units.unit;

import com.example.prog1demo.units.UnitBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Soldier extends UnitBase {

        ImageView stand = new ImageView(new Image("file:pngs/player_units/pike/pike_stand.png"));
        ImageView dead = new ImageView(new Image("file:pngs/player_units/pike/pike_dead.png"));

        ImageView[] movement_sprite = {
                new ImageView(new Image("file:pngs/player_units/pike/pike_m1.png")),
                new ImageView(new Image("file:pngs/player_units/pike/pike_m2.png")),
                new ImageView(new Image("file:pngs/player_units/pike/pike_m3.png")),
                new ImageView(new Image("file:pngs/player_units/pike/pike_m4.png")),
                new ImageView(new Image("file:pngs/player_units/pike/pike_m5.png")),
                new ImageView(new Image("file:pngs/player_units/pike/pike_m6.png"))
        };

        ImageView[] attack_sprite = {
                new ImageView(new Image("file:pngs/player_units/pike/pike_a1.png")),
                new ImageView(new Image("file:pngs/player_units/pike/pike_a2.png")),
                new ImageView(new Image("file:pngs/player_units/pike/pike_a3.png")),
                new ImageView(new Image("file:pngs/player_units/pike/pike_a4.png")),
                new ImageView(new Image("file:pngs/player_units/pike/pike_a5.png")),
        };



        public Soldier(int attack, int deffense, int magic, int wisd, int mor, int lucky, int px, int py, AnchorPane AP){
            super(attack,deffense,magic,wisd,mor,lucky,px,py);
            AP.getChildren().add(stand);
        }

}
