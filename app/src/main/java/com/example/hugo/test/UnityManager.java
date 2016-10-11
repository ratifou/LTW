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
    private int unitysIndex;

    public UnityManager() {
        this.Round1 = new ArrayList<>();
        unitysIndex = -1;
        this.init();
    }

    public void add_new_unit(ArrayList round, String name, int health, int speed, int index){
        UnityFeature unit = new UnityFeature(left_top_corner, name, health ,speed, index);
        round.add(index, unit);
    }

    public void init(){                              /***/
        add_new_unit(Round1, "Blue Alien",   200,   10,  0 );
        add_new_unit(Round1, "Green Alien",  200,   20,  1 );
        add_new_unit(Round1, "Pink Alien",   200,   30,  2 );
        add_new_unit(Round1, "Yellow Alien", 200,   40,  3 );
    }                                                /***/
                                                  /* Index */
    public void setIndex(String name){
        if (name.equals(("Blue Alien").toString()))
            unitysIndex = 0;
        else if (name.equals(("Green Alien").toString()))
            unitysIndex = 1;
        else if (name.equals(("Pink Alien").toString()))
            unitysIndex = 2;
        else if (name.equals(("Yellow Alien").toString()))
            unitysIndex = 3;
    }

    public void setPosition (Point position) {
            Round1.get(unitysIndex).setPosition(position);
    }

    public void draw(Canvas canvas){
    //    for (int i = 0; i < unitysIndex.size(); i++)
        if (unitysIndex >= 0)
            Round1.get(unitysIndex).draw(canvas);
    }

    public void update(){
      //  for (int i = 0; i < unitysIndex.size(); i++)
        if (unitysIndex >= 0)
            Round1.get(unitysIndex).update();
    }
}
