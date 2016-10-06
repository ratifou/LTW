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
    private int unityIndex;

    public UnityManager() {
        this.Round1 = new ArrayList<>();
        this.unityIndex = 0;
        this.init();
    }

    public void add_new_unit(ArrayList round, String name, int health, int speed, int index, int id_idle, int id_walk1, int id_walk2){
        UnityFeature unit = new UnityFeature(left_top_corner, name, health ,speed, id_idle, id_walk1,id_walk2);
        round.add(index, unit);
    }

    public void init(){                              /***/
        add_new_unit(Round1, "Blue Alien", 100, 200,   0 ,R.drawable.alienblue, R.drawable.alienblue_walk1, R.drawable.alienblue_walk2);
        add_new_unit(Round1, "Green Alien", 100, 200,  1 ,R.drawable.aliengreen, R.drawable.aliengreen_walk1, R.drawable.aliengreen_walk2);
        add_new_unit(Round1, "Pink Alien", 100, 200,   2 ,R.drawable.alienpink, R.drawable.alienpink_walk1, R.drawable.alienpink_walk2);
        add_new_unit(Round1, "Yellow Alien", 100, 200, 3 ,R.drawable.alienyellow, R.drawable.alienyellow_walk1, R.drawable.alienyellow_walk2);
    }                                                /***/
                                                  /* Index */
    public void setIndex(String name){
        if (name.equals(("Blue Alien").toString()))
            unityIndex = 0;
        else if (name.equals(("Green Alien").toString()))
            unityIndex = 1;
        else if (name.equals(("Pink Alien").toString()))
            unityIndex = 2;
        else if (name.equals(("Yellow Alien").toString()))
            unityIndex = 3;
    }

    public void setPosition(Point position) {
        Round1.get(unityIndex).setPosition(position);
    }

    public void draw(Canvas canvas){
        Round1.get(unityIndex).draw(canvas);
    }

    public void update(){
        Round1.get(unityIndex).update();
    }
}
