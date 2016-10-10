package com.example.hugo.test;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

/**
 * Created by geoff on 08/10/2016.
 */

public class TowerFeature {
    private int towerIndex;
    private int attack_speed;
    private int level;
    private int range;
    private int attack_damage;
    private enum type{neutral, fire, frost, electric, wind};
    private Rect pos_rec;
    private String name;

    private ArrayList<Bitmap> levelbitmaps;

    public TowerFeature(int index,int speed, int level, int range, int damage, Rect pos_rec, String name){
        this.towerIndex = index;
        this.attack_damage = damage;
        this.attack_speed = speed;
        this.level = level;
        this.range = range;
        this.name = name;
        levelbitmaps = new ArrayList<Bitmap>();
        this.pos_rec = pos_rec;
        this.build_visual();
    }

    // Ajouter a Constants :
    //      ArrayList<Bitmap> tower_1;
    //      ArrayList<Bitmap> tower_2;
    //      ArrayList<Bitmap> tower_3;
    public void build_visual (){
        levelbitmaps.add(0 ,tower_1.get(towerIndex));
        levelbitmaps.add(1 ,tower_2.get(towerIndex));
        levelbitmaps.add(2 ,tower_3.get(towerIndex));
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(levelbitmaps.get(level-1), null, pos_rec, new Paint());
    }

    public void update(){
        this.level++;
        this.range *= 1.5;
        this.attack_speed *= 1.5;
        this.attack_damage *= 1.5;
    }

    public int getAttack_damage() {
        return attack_damage;
    }

    public void setAttack_damage(int attack_damage) {
        this.attack_damage = attack_damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttack_speed() {
        return attack_speed;
    }

    public void setAttack_speed(int attack_speed) {
        this.attack_speed = attack_speed;
    }
}
