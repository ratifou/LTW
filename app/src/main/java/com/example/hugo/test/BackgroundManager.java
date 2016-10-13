package com.example.hugo.test;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hugo on 05/10/2016.
 */

public class BackgroundManager{
    public TowerFeature[][] grid = new TowerFeature[14][9];
    private ArrayList<TowerFeature> ref = new ArrayList<>();

    public BackgroundManager(){
        Constants.gap = Constants.SCREEN_HEIGHT / 48;
        Constants.Map_Block_Size = Constants.SCREEN_WIDTH / 9;
        for (int i = 0; i < 14; i++)
            for (int j = 0; j < 9; j++)
                grid[i][j] = new TowerFeature(0,
                        new Rect(
                                /* left */ (Constants.Map_Block_Size * j),
                                /* top */  (Constants.gap + Constants.Map_Block_Size * i),
                                /* right */(Constants.Map_Block_Size * (j + 1)),
                                /* bottom */(Constants.gap + (Constants.Map_Block_Size * (i + 1)))
                        ));
    }

    public void draw(Canvas canvas){
        for (int i = 0; i < 14; i++)
            for (int j = 0; j < 9; j++) {
                if (grid[i][j].getTowerIndex() == 0)
                    canvas.drawBitmap(Constants.map_case, null, grid[i][j].getPos_rec(), new Paint());
                else
                    grid[i][j].draw(canvas);
            }
    }

    public void update(int i, int j){
        //grid[i][j].setTowerIndex(1);
        Toast.makeText(Constants.CURRENT_CONTEXT, "Clique sur case. I :" + i + " J :" + j, Toast.LENGTH_SHORT).show();
    }
}
