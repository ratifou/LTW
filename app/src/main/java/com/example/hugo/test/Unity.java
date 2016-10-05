package com.example.hugo.test;

import android.graphics.Point;
import android.view.animation.*;

/**
 * Created by hugo on 05/10/2016.
 */

public interface Unity {
    public void update();
    public void draw();

    public Point get_position(UnityFeature unit);
    public int get_next_direction(UnityFeature unit);
    public Animation get_animation(UnityFeature unit, int index);
    public boolean is_dead(UnityFeature unit);
}
