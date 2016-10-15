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
    public ArrayList<UnityFeature> Inventaire;
    private Point left_top_corner = new Point(0, 0);

    public UnityManager() {
        this.Round1 = new ArrayList<>();
        this.Inventaire = new ArrayList<>();
        this.init();
    }

    public void add_new_unit(ArrayList round/*, String name, int health*/, int speed, int index) {
        UnityFeature unit = new UnityFeature(left_top_corner/*, name, health*/, speed, index);
        round.add(unit);
    }

    public void init() {                                /***/
        add_new_unit(Inventaire/*, "Blue Alien",   200*/, 5, 0);
        add_new_unit(Inventaire/*, "Green Alien",  200*/, 10, 1);
        add_new_unit(Inventaire/*, "Pink Alien",   200*/, 15, 2);
        add_new_unit(Inventaire/*, "Yellow Alien", 200*/, 20, 3);
    }                                                   /***/
                                                     /* Index */

    public void setIndex(String name, int x) {
        if (name.equals(("Blue Alien").toString()))
            add_new_unit(Round1, 5, 0);
        else if (name.equals(("Green Alien").toString()))
            add_new_unit(Round1, 10, 1);
        else if (name.equals(("Pink Alien").toString()))
            add_new_unit(Round1, 15, 2);
        else if (name.equals(("Yellow Alien").toString()))
            add_new_unit(Round1, 20, 3);
        Round1.get(Round1.size()- 1).getAnimations().setMove_index(2);
        Round1.get(Round1.size()- 1).setPosition(new Point(x, Constants.gap));
        System.out.println("NEW UNIT ADDED !");
    }

    public void draw(Canvas canvas) {
        for (UnityFeature unity : Round1)
            unity.draw(canvas);
    }

    public void update() {
        for (UnityFeature unity : Round1) {
            unity.update();
            if (unity.is_on_map() == false) {
                Round1.remove(unity);
                System.out.println("NEW UNIT REMOVED !");
            }
        }
    }
}
