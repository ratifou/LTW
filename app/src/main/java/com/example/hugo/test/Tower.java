package com.example.hugo.test;

import android.graphics.Canvas;

/**
 * Created by hugo on 05/10/2016.
 */

public interface Tower {
     void upgrade();
     void build();
     void destroy();
     void update();
     void draw(Canvas canvas);
}
