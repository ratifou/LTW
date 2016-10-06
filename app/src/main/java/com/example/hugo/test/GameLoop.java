package com.example.hugo.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/*
 * Created by hugo on 03/10/2016.
 */

public class GameLoop extends SurfaceView implements SurfaceHolder.Callback {

    private int i;
    private MapInitThread init_thread;
    private RoundManager manager = new RoundManager();

    public GameLoop(Context context) {
        super(context);
        getHolder().addCallback(this);
        Constants.CURRENT_CONTEXT = context;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        init_thread = new MapInitThread(getHolder(), this);
        init_thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        while (true) {
            try {
                init_thread.setRunning(false);
                init_thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean OnTouchEvent(MotionEvent event) {
        manager.receiveEvent(event);
        return true;
    }

    public void update(){
        manager.update();
    }

    public void draw (Canvas canvas){
        super.draw(canvas);
        manager.draw(canvas);
    }
}
