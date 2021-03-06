package com.example.hugo.test;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

/**
 * Created by geoff on 08/10/2016.
 */

public class TowerManager implements Tower {
    private ArrayList<TowerFeature> towerarray;
    private int towerIndex;

    public TowerManager() {
        towerarray = new ArrayList<>();
        towerIndex = 0;
    }

    public void add_tower(int index, int speed, int level, int range, int damage, Rect pos_rec, String name) {
        towerarray.add(new TowerFeature( index, speed, level, range, damage, pos_rec, name));
        towerIndex++;
    }

    public void init() {
        add_tower(0, 0, 0, 0,0, new Rect(), "Empty" );
        add_tower(1, 60/* Par minute */, 1, Constants.Map_Block_Size*3, 30, null, "Mitrailleuse");
        add_tower(2, 20, 1, Constants.Map_Block_Size*6, 100, null, "Canon");
        add_tower(3, 180, 1, Constants.Map_Block_Size*1, 10, null, "Laser");
        add_tower(4, 500, 1, 1000, 250, null, "BAZOOKA");
    }

    @Override
    public void draw(Canvas canvas) {
       /* for (TowerFeature tower : towerarray)
            tower.draw(canvas);*/
    }

    @Override
    public void update() {

    }

    @Override
    public void upgrade() {

    }

    @Override
    public void build() {

    }

    @Override
    public void destroy() {

    }
}
