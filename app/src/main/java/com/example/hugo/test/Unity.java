package com.example.hugo.test;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.animation.*;

/**
 * Created by hugo on 05/10/2016.
 */

public interface Unity {
     void update();
     void draw(Canvas canvas);

     Point get_position(UnityFeature unit);
     int get_next_direction(UnityFeature unit);
     Animation get_animation(UnityFeature unit, int index);
}
