package com.example.hugo.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by hugo on 05/10/2016.
 */

public class BackgroundManager extends SurfaceView implements SurfaceHolder.Callback {
    private Background[][] grid ;

    public BackgroundManager(Context context){
        super(context);
        getHolder().addCallback(this);
        // Background de 120*120
        for (int i = 0; i < 14; i++)
            for (int j = 0; j < 9; j++)
                grid[i][j] = new Background(true, 0,
                        new Rect(
                                /* left */ (Constants.Map_Block_Size * i),
                                /* top */  (40 + Constants.Map_Block_Size * j),
                                /* right */(Constants.Map_Block_Size * (i + 1)),
                                /* bottom */(40 + (Constants.Map_Block_Size * (j + 1)))
                        ));
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void draw(Canvas canvas){

    }

    public void update(){

    }
}
