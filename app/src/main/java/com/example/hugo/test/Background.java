package com.example.hugo.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

/**
 * Created by hugo on 05/10/2016.
 */

public class Background {
    private boolean walkable;
    private int towerIndex;
    private Rect rect;
    private Bitmap content;

    public Background(boolean walk, int index, Rect rect){
        this.walkable = walk;
        this.towerIndex = index;
        this.rect = rect;
    }
    public void update(){
     /*   switch(towerIndex){
            case 0:

        }*/
    }

    public Bitmap getContent() {
        return content;
    }

    public Rect getRect() {
        return rect;
    }

    public void setContent(Bitmap bitmap) {
        this.content = bitmap;
    }

    public void setWalkable(boolean walkable){
        this.walkable = walkable;
    }

    public void setTowerIndex(int towerIndex){
        this.towerIndex = towerIndex;
    }

    public void setRec(Rect rec) {
        this.rect = rec;
    }
}
