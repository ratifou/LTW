package com.example.hugo.test;

import android.graphics.Point;
import android.view.animation.*;
import android.view.animation.Animation;

import java.util.ArrayList;

/**
 * Created by hugo on 05/10/2016.
 */

public class UnityManager {

    private ArrayList<UnityFeature> Round1;
    private ArrayList<UnityFeature> Round2;
    private ArrayList<UnityFeature> Round3;
    private Point left_top_corner = new Point(0,0);

    public UnityManager() {
        this.Round1 = new ArrayList<>();
        this.Round2 = new ArrayList<>();
        this.Round3 = new ArrayList<>();
    }

    public void add_new_unit(ArrayList round, String name, int health, int speed, int index){
        UnityFeature unit = new UnityFeature(left_top_corner, name, health ,speed);
        round.add(index, unit);
    }

    public void init(){
        add_new_unit(Round1, "Unit_11", 100, 200, 0);
        // add unit_ movement
        add_new_unit(Round1, "Unit_12", 125, 350, 1);
        add_new_unit(Round1, "Unit_13", 200, 200, 2);
        add_new_unit(Round1, "Unit_14", 500, 100, 3);

        add_new_unit(Round2, "Unit_21", 100, 200, 0);
        add_new_unit(Round2, "Unit_22", 125, 350, 1);
        add_new_unit(Round2, "Unit_23", 200, 200, 2);
        add_new_unit(Round2, "Unit_24", 500, 100, 3);

        add_new_unit(Round3, "Unit_31", 100, 200, 0);
        add_new_unit(Round3, "Unit_32", 125, 350, 1);
        add_new_unit(Round3, "Unit_33", 200, 200, 2);
        add_new_unit(Round3, "Unit_34", 500, 100, 3);
    }
}
