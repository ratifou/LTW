package com.example.hugo.test;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;

/**
 * Created by hugo on 06/10/2016.
 */

public class RoundManager implements Round {
    private ArrayList<Round> roundManager;
    public static int roundIndex;

    public RoundManager(){
        this.roundManager = new ArrayList<>();
        this.addRound(new FirstRound());
        roundIndex = 0;
    }

    public void addRound(Round round){
        this.roundManager.add(0, round);
    }

    @Override
    public void receiveEvent(MotionEvent event) {
        roundManager.get(roundIndex).receiveEvent(event);
    }

    @Override
    public void reload() {
        roundIndex = 0;
    }

    @Override
    public void draw(Canvas canvas) {
        roundManager.get(roundIndex).draw(canvas);
    }

    @Override
    public void update() {
        roundManager.get(roundIndex).update();
    }
}
