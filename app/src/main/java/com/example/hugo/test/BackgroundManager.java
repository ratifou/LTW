package com.example.hugo.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.hugo.test.Constants.nb_height;
import static com.example.hugo.test.Constants.nb_width;

/**
 * Created by hugo on 05/10/2016.
 */

public class BackgroundManager{
    public TowerFeature[][] grid = new TowerFeature[nb_height][nb_width];
    private ArrayList<TowerFeature> ref = new ArrayList<>();

    public BackgroundManager(){
        Constants.gap = Constants.SCREEN_HEIGHT / 48;
        Constants.Map_Block_Size = Constants.SCREEN_WIDTH / nb_width;
        for (int i = 0; i < nb_height; i++)
            for (int j = 0; j < nb_width; j++)
                grid[i][j] = new TowerFeature(0,
                        new Rect(
                                /* left */ (Constants.Map_Block_Size * j),
                                /* top */  (Constants.gap + Constants.Map_Block_Size * i),
                                /* right */(Constants.Map_Block_Size * (j + 1)),
                                /* bottom */(Constants.gap + (Constants.Map_Block_Size * (i + 1)))
                        ));
    }

    public void draw(Canvas canvas){
        for (int i = 0; i < nb_height; i++)
            for (int j = 0; j < nb_width; j++) {
             /*   if (grid[i][j].getTowerIndex() == 0)
                    canvas.drawBitmap(Constants.map_case, null, grid[i][j].getPos_rec(), new Paint());
                else*/
                    grid[i][j].draw(canvas);
            }
    }

    public void update(int i, int j){
        //grid[i][j].setTowerIndex(1);
        grid[j][i].setColor(1);
    }

    public boolean is_right_ok(int i, int j) {
        if (i >= (Constants.nb_width / 2)) {
            for (int n = i; n <= nb_width; n++)
                if (grid[n][j+1].getTowerIndex() == 0)
                    return true;
            for (int n = i; n != 0; n--)
                if (grid[n][j+1].getTowerIndex() == 0)
                    return true;
        } else { // Optimisation compliqué pour gagner a peine 1 nanoseconde je pense
            for (int n = i; n != 0; n--)
                if (grid[n][j+1].getTowerIndex() == 0)
                    return true;
            for (int n = i; n <= nb_width; n++)
                if (grid[n][j+1].getTowerIndex() == 0)
                    return true;
        }
        return false;
    }
}
