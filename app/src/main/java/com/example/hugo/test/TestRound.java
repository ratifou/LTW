package com.example.hugo.test;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.MotionEvent;

/**
 * Created by hugo on 06/10/2016.
 */

public class TestRound implements Round{

    private UnityManager unityManager;
    private BackgroundManager backgroundManager;

    public TestRound() {
        unityManager = new UnityManager();
        backgroundManager = new BackgroundManager(R.drawable.mapcase);
    }
    public void receiveEvent(MotionEvent event) {
        unityManager.setPosition(new Point((int)event .getRawX(),(int)event.getRawY()));
        backgroundManager.update();
        if (event.getAction() == MotionEvent.ACTION_DOWN){
                unityManager.setIndex("Blue Alien");
        }
        else if (event.getAction() == MotionEvent.ACTION_UP){
            unityManager.setIndex("Green Alien");
        }
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
