package com.example.hugo.test;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import static com.example.hugo.test.Constants.idlemaps;
import static com.example.hugo.test.Constants.walk1maps;
import static com.example.hugo.test.Constants.walk2maps;

/*
 * Created by hugo on 03/10/2016.
 */

public class GameLoop extends SurfaceView implements SurfaceHolder.Callback {

    private MapInitThread init_thread;
    private RoundManager manager;
    private int bitmapsIndex = 0;

    public GameLoop(Context context) {
        super(context);
        getHolder().addCallback(this);
        Constants.CURRENT_CONTEXT = context;
        BitmapFactory bf = new BitmapFactory();

        idlemaps.add(bitmapsIndex, bf.decodeResource(context.getResources() ,R.drawable.alienblue));
        walk1maps.add(bitmapsIndex, bf.decodeResource(context.getResources(), R.drawable.alienblue_walk1));
        walk2maps.add(bitmapsIndex, bf.decodeResource(context.getResources(), R.drawable.alienblue_walk2));
        bitmapsIndex++;

        idlemaps.add(bitmapsIndex, bf.decodeResource(context.getResources() ,R.drawable.aliengreen));
        walk1maps.add(bitmapsIndex, bf.decodeResource(context.getResources(), R.drawable.aliengreen_walk1));
        walk2maps.add(bitmapsIndex, bf.decodeResource(context.getResources(), R.drawable.aliengreen_walk2));
        bitmapsIndex++;

        idlemaps.add(bitmapsIndex, bf.decodeResource(context.getResources() ,R.drawable.alienpink));
        walk1maps.add(bitmapsIndex, bf.decodeResource(context.getResources(), R.drawable.alienpink_walk1));
        walk2maps.add(bitmapsIndex, bf.decodeResource(context.getResources(), R.drawable.alienpink_walk2));
        bitmapsIndex++;

        idlemaps.add(bitmapsIndex, bf.decodeResource(context.getResources() ,R.drawable.alienyellow));
        walk1maps.add(bitmapsIndex, bf.decodeResource(context.getResources(), R.drawable.alienyellow_walk1));
        walk2maps.add(bitmapsIndex, bf.decodeResource(context.getResources(), R.drawable.alienyellow_walk2));
        bitmapsIndex++;
        manager = new RoundManager();
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
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
