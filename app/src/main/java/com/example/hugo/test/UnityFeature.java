package com.example.hugo.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;

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
    // Animation;

    public  UnityFeature(Point point, String name, int hp, int speed){
        this.position = point;
        this.name = name;
        this.health = hp;
        this.speed = speed;

        BitmapFactory bf = new BitmapFactory();
        Bitmap idleIMG  = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.war3icone);
        Bitmap walk1 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.walk1);
        Bitmap walk2 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.walk2);

        idle = new Animation(new Bitmap[]{idleIMG}, 2.f);
        walk_right = new Animation(new Bitmap[]{walk1, walk2}, 0.5f);
/*
**      Flip on vertical axe a Bitmap Image
 */
        Matrix m = new Matrix();
        m.preScale(-1, 1);
        walk1 = Bitmap.createBitmap(walk1, 0, 0, walk1.getWidth(), walk1.getHeight(), m, false);
        walk2 = Bitmap.createBitmap(walk2, 0, 0, walk2.getWidth(), walk2.getHeight(), m, false);

        walk_left = new Animation(new Bitmap[]{walk1, walk2}, 0.5f);

        animManager = new AnimationManager(new Animation[]{idle, walk_right, walk_left/* nord, sud */});
    }

    public void update() {
        int state = get_next_direction(this);
        animManager.playAnim(state);
        animManager.update();
    }

    @Override
    public void draw(Canvas canvas) {
        animManager.draw(canvas, position);
    }

    @Override
    public boolean is_dead(UnityFeature unit) {
        return false;
    }

    @Override
    public Point get_position(UnityFeature unit) {
        return null;
    }

    @Override
    public int get_next_direction(UnityFeature unit) {
        return 0;
    }

    @Override
    public Animation get_animation(UnityFeature unit, int index) {
        return null;
    }
}
