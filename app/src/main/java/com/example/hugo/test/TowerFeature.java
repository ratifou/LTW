package com.example.hugo.test;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

import static com.example.hugo.test.Constants.tower_1;
import static com.example.hugo.test.Constants.tower_2;
import static com.example.hugo.test.Constants.tower_3;

/**
 * Created by geoff on 08/10/2016.
 */

public class TowerFeature {
    private int towerIndex;
    private Rect pos_rec;
    private int color = 0;
    private int attack_speed;
    private int level;
    private int range;
    private int attack_damage;
    public enum type {neutral, fire, frost, electric, wind};
    private String name;

    private ArrayList<Bitmap> levelbitmaps;

    public TowerFeature(int index, Rect pos){
        this.towerIndex = index;
        this.pos_rec = pos;
    }

    public TowerFeature(int index,int speed, int level, int range, int damage, Rect pos_rec, String name){
        this.towerIndex = index;
        this.attack_damage = damage;
        this.attack_speed = speed;
        this.level = level;
        this.range = range;
        this.name = name;
        this.pos_rec = pos_rec;
        levelbitmaps = new ArrayList<>();
        this.build_visual();
    }

    public void build_visual (){
        levelbitmaps.add(0 ,tower_1.get(towerIndex));
        levelbitmaps.add(1 ,tower_2.get(towerIndex));
        levelbitmaps.add(2 ,tower_3.get(towerIndex));
    }

    public void draw(Canvas canvas){
        if (towerIndex == 0)
            canvas.drawBitmap(Constants.map_case, null, pos_rec, new Paint());
        else
            canvas.drawBitmap(tower_1.get(towerIndex % 3), null, pos_rec, new Paint());
    }

    public void update(){
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void upgrade(){
        this.level++;
        this.range *= 1.5;
        this.attack_speed *= 1.5;
        this.attack_damage *= 1.5;
    }

    public Rect getPos_rec() {
        return pos_rec;
    }

    public int getTowerIndex() {
        return towerIndex;
    }

    public void setTowerIndex(int towerIndex) {
        this.towerIndex = towerIndex;
    }
}
