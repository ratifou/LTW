package com.example.hugo.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;

import static com.example.hugo.test.Constants.SCREEN_HEIGHT;
import static com.example.hugo.test.Constants.gap;
import static com.example.hugo.test.Constants.idlemaps;
import static com.example.hugo.test.Constants.nb_height;
import static com.example.hugo.test.Constants.walk1maps;
import static com.example.hugo.test.Constants.walk2maps;

/**
 * Created by hugo on 05/10/2016.
 */

public class UnityFeature /* implements Unity */{

    private Point position;
    private String name;
    private int health;
    private int speed;
    private Animation animations;

    public  UnityFeature(Point point/*, String name, int hp,*/, int speed, int index){
        this.position = point;
      /*  this.name = name;
        this.health = hp;*/
        this.speed = speed;

        Bitmap[] idle = {idlemaps.get(index)};
        Bitmap[] walk_right = {idlemaps.get(index), walk1maps.get(index), walk2maps.get(index)};
/*
**      Flip on vertical axe a Bitmap Image
 */
        Matrix m = new Matrix();
        m.preScale(-1, 1);
        Bitmap walk1 = Bitmap.createBitmap(walk1maps.get(index), 0, 0, walk1maps.get(index).getWidth(), walk1maps.get(index).getHeight(), m, false);
        Bitmap walk2 = Bitmap.createBitmap(walk2maps.get(index), 0, 0, walk2maps.get(index).getWidth(), walk2maps.get(index).getHeight(), m, false);

        Bitmap[] walk_left = {idlemaps.get(index), walk1, walk2};
        animations = new Animation(walk_left, walk_right, idle, 0.5f);
        animations.setSpeed(speed);

    }

    public void update() {
//        int i = position.x / Constants.Map_Block_Size;
//        int j = (position.y - Constants.gap )/ Constants.Map_Block_Size;
//        int way = Constants.soluce[j][i];
        animations.update();
    }

    public Animation getAnimations() {
        return animations;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void draw(Canvas canvas) {
        animations.draw(canvas, position);
        position = animations.getPoint();
    }

    public boolean is_on_map(){
        if (this.position.y >= (Constants.gap +( Constants.nb_height * Constants.Map_Block_Size)))
            return false;
        else
            return true;
    }
}
