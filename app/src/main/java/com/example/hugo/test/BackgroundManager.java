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
import static com.example.hugo.test.Constants.soluce;

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
            for (int j = 0; j < nb_width; j++) {
                grid[i][j] = new TowerFeature(0,
                        new Rect(
                                /* left */ (Constants.Map_Block_Size * j),
                                /* top */  (Constants.gap + Constants.Map_Block_Size * i),
                                /* right */(Constants.Map_Block_Size * (j + 1)),
                                /* bottom */(Constants.gap + (Constants.Map_Block_Size * (i + 1)))
                        ));
                Constants.soluce[i][j] = 2; }
    }

    public void draw(Canvas canvas){
        canvas.drawColor(Color.BLACK);
        for (int i = 0; i < nb_height; i++)
            for (int j = 0; j < nb_width; j++)
                    grid[i][j].draw(canvas);
    }

    public void update(int i, int j){
        grid[i][j].setTowerIndex(grid[i][j].getTowerIndex() + 1);
    }

    public void test_deplacement(){
        for (int i = 0; i < nb_width-1; i++)
            Constants.soluce[0][i] = 1;

        Constants.soluce[0][nb_width-1] = 2;

        for (int i = nb_width-1; i > 0; i--)
            Constants.soluce[1][i] = 3;

        Constants.soluce[1][0] = 2;

        for (int i = 0; i < nb_width; i++)
            Constants.soluce[2][i] = 1;

        Constants.soluce[2][nb_width-1] = 2;

        for (int i = nb_width-1; i > 0; i--)
            Constants.soluce[3][i] = 3;

        Constants.soluce[3][0] = 2;

        for (int i = 0; i < nb_width; i++)
            Constants.soluce[4][i] = 1;

        Constants.soluce[4][nb_width-1] = 2;

        for (int i = nb_width-1; i > 0; i--)
            Constants.soluce[5][i] = 3;

        Constants.soluce[5][0] = 2;

        for (int i = 0; i < nb_width; i++)
            Constants.soluce[6][i] = 1;

        Constants.soluce[6][nb_width-1] = 2;
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

    public void reloadDirection() {

    }
}
