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
        backgroundManager = new BackgroundManager();
    }

    public void receiveEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (event.getRawY() < Constants.SCREEN_HEIGHT * 0.2)
                unityManager.setIndex("Blue Alien");
            else if (event.getRawY() < Constants.SCREEN_HEIGHT * 0.4)
                unityManager.setIndex("Green Alien");
            else if (event.getRawY() < Constants.SCREEN_HEIGHT * 0.6)
                unityManager.setIndex("Pink Alien");
            else if (event.getRawY() < Constants.SCREEN_HEIGHT * 0.8)
                unityManager.setIndex("Yellow Alien");
        }
        unityManager.setPosition(new Point((int) event.getRawX(), 0));
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
