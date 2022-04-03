package com.example.prog1demo.units;

public class UnitBase {
    int att=1;
    int deff=1;
    int magic_power=1;
    int wisdom=1;
    int moral=1;
    int luck=1;
    int pos_x;
    int pos_y;

    public UnitBase(int attack, int deffense, int magic, int wisd, int mor, int lucky, int pos_x, int pos_y){
        this.att = attack;
        this.deff = deffense;
        this.magic_power = magic;
        this.wisdom = wisd;
        this.moral = mor;
        this.luck = lucky;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }

    //getters + setters
    public int getAtt() { return att; }
    public void setAtt(int att) { this.att = att; }
    public int getDeff() { return deff; }
    public void setDeff(int deff) { this.deff = deff; }
    public int getMagic_power() { return magic_power; }
    public void setMagic_power(int magic_power) { this.magic_power = magic_power; }
    public int getWisdom() { return wisdom; }
    public void setWisdom(int wisdom) { this.wisdom = wisdom; }
    public int getMoral() { return moral; }
    public void setMoral(int moral) { this.moral = moral; }
    public int getLuck() { return luck; }
    public void setLuck(int luck) { this.luck = luck; }
    public void setPos_x(int x) { this.pos_x = x; }
    public void setPos_y(int y) { this.pos_y = y; }
    public int getPos_x(){ return this.pos_x; }
    public int getPos_y(){ return this.pos_y; }
}
