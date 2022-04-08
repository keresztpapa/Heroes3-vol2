package com.example.prog1demo;

import com.example.prog1demo.units.unit.Generic;

public interface Action {
    default void attack(Generic g1, Generic g2){
        g2.setHp(g2.getHp()-g1.getDamage());
        System.out.println("Alany HP: "+g2.getHp());
    }

}
