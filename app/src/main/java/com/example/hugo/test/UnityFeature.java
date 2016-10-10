package com.example.hugo.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;

import static com.example.hugo.test.Constants.idlemaps;
import static com.example.hugo.test.Constants.walk1maps;
import static com.example.hugo.test.Constants.walk2maps;

/**
 * Created by hugo on 05/10/2016.
 */

public class UnityFeature implements Unity {

    private Point position;
    private String name;
    private int health;
    private int speed;

    private Animation idle;
    private Animation walk_right;
    private Animation walk_left;
    private AnimationManager animManager;

    public  UnityFeature(Point point, String name, int hp, int speed, int index){
        this.position = point;
        this.name = name;
        this.health = hp;
        this.speed = speed;


        idle = new Animation(new Bitmap[]{idlemaps.get(index)}, 1.f);
        walk_right = new Animation(new Bitmap[]{walk1maps.get(index), walk2maps.get(index)}, 2.f);
/*
**      Flip on vertical axe a Bitmap Image
 */
        Matrix m = new Matrix();
        m.preScale(-1, 1);
        Bitmap walk1 = Bitmap.createBitmap(walk1maps.get(index), 0, 0, walk1maps.get(index).getWidth(), walk1maps.get(index).getHeight(), m, false);
        Bitmap walk2 = Bitmap.createBitmap(walk2maps.get(index), 0, 0, walk2maps.get(index).getWidth(), walk2maps.get(index).getHeight(), m, false);

        walk_left = new Animation(new Bitmap[]{walk1, walk2}, 2.f);

        animManager = new AnimationManager(new Animation[]{idle, walk_right, walk_left});
    }

    public void update() {
        int state = get_next_direction(this);
        animManager.playAnim(state);
        animManager.update();
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public void draw(Canvas canvas) {
        animManager.draw(canvas, position);
    }

    @Override
    public Point get_position(UnityFeature unit) {
        return null;
    }

    @Override
    public int get_next_direction(UnityFeature unit) {return 1;}
    @Override
    public Animation get_animation(UnityFeature unit, int index) {
        return null;
    }
}
