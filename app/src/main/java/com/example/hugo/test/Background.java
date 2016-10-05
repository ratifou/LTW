package com.example.hugo.test;

import android.graphics.Rect;

/**
 * Created by hugo on 05/10/2016.
 */

public class Background {
    private boolean walkable;
    private int towerIndex;
    private Rect rec;

    public Background(boolean walk, int index, Rect rect){
        this.walkable = walk;
        this.towerIndex = index;
        this.rec = rect;
    }

    public void setWalkable(boolean walkable){
        this.walkable = walkable;
    }

    public void setTowerIndex(int towerIndex){
        this.towerIndex = towerIndex;
    }

    public void setRec(Rect rec) {
        this.rec = rec;
    }
}
