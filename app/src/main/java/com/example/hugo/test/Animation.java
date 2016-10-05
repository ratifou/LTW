package com.example.hugo.test;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

/**
 * Created by hugo on 05/10/2016.
 **/

public class Animation {
    private Bitmap[] frames;
    private boolean isPlayin = false;
    private int frameIndex;
    private float frameTime;
    private long lastFrame;

    public boolean isPlayin(){
        return this.isPlayin;
    }

    public void play(){
        this.isPlayin = true;
        frameIndex = 0;
        lastFrame = System.currentTimeMillis();
    }

    public void stop(){
        this.isPlayin = false;
    }

    public Animation (Bitmap[] bm, float animtime){
        this.frames = bm;
        frameIndex = 0;

        frameTime = animtime/bm.length;
        lastFrame = System.currentTimeMillis();
    }

    // Permet de gérer l'affichage à la vitesse voulu,
    // Opérateur turner permet de faire la boucle sur le tableau d'animation 0,1,2,0,1,2,0,1,2,0,1,2 ....

    public void update(){
        if (!isPlayin)
            return;

        if (System.currentTimeMillis() - lastFrame > frameTime * 1000){
            frameIndex++;
            frameIndex = frameIndex >= frames.length ? 0 : frameIndex;
        }
    }

    public void draw (Canvas canvas, Point point){
        if (!isPlayin)
            return;
        canvas.drawBitmap(frames[frameIndex], point.x, point.y, new Paint());
    }
}