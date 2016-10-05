package com.example.hugo.test;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by hugo on 03/10/2016.
 */

public class MapInitThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private GameLoop gameLoop;
    public Canvas canvas;
    public Bitmap bitmap;
    private boolean running = false;
    public static int MAX_FPS = 30;

    long frameTime;
    long sleepTime;
    long targetTime = 1000 / MAX_FPS;

    public MapInitThread(SurfaceHolder sf, GameLoop gl, Bitmap bp){
        super();
        this.surfaceHolder = sf;
        this.gameLoop = gl;
        this.bitmap = bp;
        this.running = true;
    }

    public void setRunning(boolean bool){
        this.running =  bool;
    }
    public void run(){
        //Bla bla pour mesurer les fps;
        long startTime = System.currentTimeMillis();
        canvas = null;

        while(running) {
            canvas = null;
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gameLoop.draw(canvas);
                    this.gameLoop.update();
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            frameTime = System.currentTimeMillis() - startTime;
            sleepTime = targetTime - frameTime;
            if (sleepTime > 0)
                try {
                    sleep(sleepTime);
                } catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}
