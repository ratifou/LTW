package com.example.hugo.test;

import android.graphics.Canvas;
import android.graphics.Point;

/**
 * Created by hugo on 05/10/2016.
 */

public class AnimationManager  {
    private Animation[] animations;
    private int animationIndex = 0;

    public AnimationManager(Animation[] animations){
        this.animations = animations;
    }

    public void playAnim(int index){
        for (int i = 0; i < animations.length; i++){
            if (i == animationIndex)
                if (!animations[animationIndex].isPlayin())
                    animations[i].play();
            else
                animations[i].stop();
        }
        animationIndex = index;
    }

    public void draw (Canvas canvas, Point point) {
        if (animations[animationIndex].isPlayin())
            animations[animationIndex].draw(canvas, point);
    }
    public void update(){
        if (animations[animationIndex].isPlayin())
            animations[animationIndex].update();
    }
}
