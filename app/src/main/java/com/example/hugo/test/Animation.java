package com.example.hugo.test;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

/**
 * Created by hugo on 05/10/2016.
 **/

public class Animation {
    private Bitmap[] frames_left;
    private Bitmap[] frames_right;
    private Bitmap[] frames_down;
    private int framesdefinitions = 2;
    private int move_index;
    private int frameIndex;
    private float frameTime;
    private long lastFrame;
    private Point point;
    private int speed;

    public Animation (Bitmap[] bm_left, Bitmap[] bm_right,Bitmap[] bm_down, float animtime){
        this.frames_left = bm_left;
        this.frames_right = bm_right;
        this.frames_down = bm_down;
        frameIndex = 0;
        frameTime = animtime/framesdefinitions;
        lastFrame = System.currentTimeMillis();
    }

    public void setMove_index(int value){
        move_index = value;
        frameIndex = 0;
    }

    //  1 : Droite
    //  2 : Bas
    //  3 : Gauche
    //  4 : Haut ( default else)

    public Bitmap[] get_Frames(){
        switch (move_index) {
            case 1:
                return frames_right;
            case 2:
                return frames_down;
            case 3:
                return frames_left;
            default:
                return null;
        }
    }

    public void update(){
        if (System.currentTimeMillis() - lastFrame > (frameTime * 1000)){
            frameIndex++;
            frameIndex = frameIndex >= framesdefinitions ? 0 : frameIndex;
        }
    }

    public void draw (Canvas canvas, Point position){
        Bitmap[] drawable = get_Frames();
        Point point = set_direction(position);
        canvas.drawBitmap(drawable[frameIndex], point.x, point.y, null);
        this.point = point;
        lastFrame = System.currentTimeMillis();
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private Point set_direction(Point point) {
        // Valeur de 10 a modifié pour faire gestion vitesse agréable
       switch (move_index) {
           case 1:      // Droite
               return new Point(point.x + speed, point.y);
           case 2:      // Bas
               return new Point(point.x, point.y + speed);
           case 3:      // Gauche
               return new Point(point.x - speed, point.y);
           case 4:      // Haut
               return new Point(point.x, point.y - speed);
           default:
               return null;
       }
    }

    public Point getPoint() {
        return point;
    }
}