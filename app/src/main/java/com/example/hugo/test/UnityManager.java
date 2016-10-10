package com.example.hugo.test;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.animation.*;
import android.view.animation.Animation;

import java.util.ArrayList;

/**
 * Created by hugo on 05/10/2016.
 */

public class UnityManager {
    public ArrayList<UnityFeature> Round1;
    private Point left_top_corner = new Point(0,0);
    private ArrayList<Integer> unitysIndex;

    public UnityManager() {
        this.Round1 = new ArrayList<>();
        unitysIndex = new ArrayList<>();
        this.init();
    }

    public void add_new_unit(ArrayList round, String name, int health, int speed, int index){
        UnityFeature unit = new UnityFeature(left_top_corner, name, health ,speed, index);
        round.add(index, unit);
    }

    public void init(){                              /***/
        add_new_unit(Round1, "Blue Alien", 100, 200,   0 );
        add_new_unit(Round1, "Green Alien", 100, 200,  1 );
        add_new_unit(Round1, "Pink Alien", 100, 200,   2 );
        add_new_unit(Round1, "Yellow Alien", 100, 200, 3 );
    }                                                /***/
                                                  /* Index */
    public void setIndex(String name){
        if (name.equals(("Blue Alien").toString()))
            unitysIndex.add(0, 1);
        else if (name.equals(("Green Alien").toString()))
            unitysIndex.add(1, 1);
        else if (name.equals(("Pink Alien").toString()))
            unitysIndex.add(2, 1);
        else if (name.equals(("Yellow Alien").toString()))
            unitysIndex.add(3, 1);
    }

    public void setPosition(Point position) {
        for (int i = 0; i < unitysIndex.size(); i++)
            Round1.get(unitysIndex.get(i)).setPosition(position);
    }

    public void draw(Canvas canvas){
        for (int i = 0; i < unitysIndex.size(); i++)
            Round1.get(unitysIndex.get(i)).draw(canvas);
    }

    public void update(){
        for (int i = 0; i < unitysIndex.size(); i++)
            Round1.get(unitysIndex.get(i)).update();
    }
}
