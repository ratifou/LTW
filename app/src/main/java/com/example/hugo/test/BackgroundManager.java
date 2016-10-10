package com.example.hugo.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

/**
 * Created by hugo on 05/10/2016.
 */

public class BackgroundManager{
    public Background[][] grid = new Background[14][9];

    public BackgroundManager(int id_empty){
        BitmapFactory bf = new BitmapFactory();
        Bitmap bmp = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), id_empty);
        Constants.gap = Constants.SCREEN_HEIGHT / 48;
        Constants.Map_Block_Size = Constants.SCREEN_WIDTH / 9;
        for (int i = 0; i < 14; i++)
            for (int j = 0; j < 9; j++){
                Log.i("Test double boucle", "Validé !");
                Background bg = new Background(true, 0,
                        new Rect(
                                /* left */ (Constants.Map_Block_Size * i),
                                /* top */  (40 + Constants.Map_Block_Size * j),
                                /* right */(Constants.Map_Block_Size * (i + 1)),
                                /* bottom */(40 + (Constants.Map_Block_Size * (j + 1)))
                        ));
                grid[i][j] = bg;
                grid[i][j].setTowerIndex(0);
                grid[i][j].setContent(bmp); }
    }

    public void init(int id_empty) {
    }

    public void draw(Canvas canvas){
        for (int i = 0; i < 14; i++)
            for (int j = 0; j < 9; j++){
                canvas.drawBitmap(grid[i][j].getContent(), null, grid[i][j].getRect(), new Paint());}
    }

    public void update(){
     /*   for (int i = 0; i < 14; i++)
            for (int j = 0; j < 9; j++)
                 grid[i][j].update();*/
    }
}
