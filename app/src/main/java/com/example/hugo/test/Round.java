package com.example.hugo.test;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * Created by hugo on 06/10/2016.
 */

public interface Round {
     void update();
     void draw(Canvas canvas);
     void reload();
     void receiveEvent(MotionEvent event);
}
