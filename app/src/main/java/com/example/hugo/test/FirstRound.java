package com.example.hugo.test;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.MotionEvent;

/**
 * Created by hugo on 06/10/2016.
 */

public class FirstRound implements Round{

    private UnityManager unityManager;
    private BackgroundManager backgroundManager;



    public FirstRound() {
        unityManager = new UnityManager();
        backgroundManager = new BackgroundManager(R.drawable.mapcase);
    }
    public void receiveEvent(MotionEvent event) {
        unityManager.setPosition(new Point((int)event .getRawX(),(int)event.getRawY()));
        //    backgroundManager.update(); Gestion clique construction de tour
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            unityManager.setIndex("Blue Alien");
    }

    public void reload() {
    }

    public void draw(Canvas canvas) {
        backgroundManager.draw(canvas);
        unityManager.draw(canvas);
    }

    public void update() {
        unityManager.update();
    }
}
