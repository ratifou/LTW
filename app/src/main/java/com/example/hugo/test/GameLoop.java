package com.example.hugo.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/*
 * Created by hugo on 03/10/2016.
 */

public class GameLoop extends SurfaceView implements SurfaceHolder.Callback {

    private MapInitThread init_thread;
    private UnityManager unityManager;
    private int x;
    private int y;
    private int i;

    int nb_block_width = (Constants.SCREEN_WIDTH - ((Constants.gap*5)/4))
            / (Constants.Map_Block_Size + ((Constants.gap*5)/4));

    int nb_block_height = (Constants.SCREEN_HEIGHT - Constants.gap)
            / (Constants.Map_Block_Size + Constants.gap);

    BitmapFactory bf = new BitmapFactory();
    Bitmap map_block = bf.decodeResource(this.getResources(), R.drawable.mapcase);

    public GameLoop(Context context) {
        super(context);

        getHolder().addCallback(this);

        Constants.CURRENT_CONTEXT = context;
    }

    @Override
    /*
    Wall O*O*O*O*O Wall => 1 gap de moins que le nombre de case, donc retirer un gap !
        O = > 5 Background
        * =)> 4 Gap
     */
    public void surfaceCreated(SurfaceHolder holder) {
      //  stop_cpt = nb_block_height * nb_block_width;
        x = 0;
        y = 0;
        init_thread = new MapInitThread(getHolder(), this, map_block);
        unityManager.init();
        init_thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
    /*      1080 * 1920
    **      X = 9
    **      Y = 14
     */
    public void update(){
    /*    if (stop_cpt == 0 )
            init_thread.setRunning(false);
        else
        {// Gérer cas terminal ( Celui proche du mur sans gap après
            if (x / Constants.Map_Block_Size < nb_block_width)
                x += Constants.Map_Block_Size + ((5 * Constants.gap) / 4);
            else
                x = ((5 * Constants.gap) / 4);

            if (y == Constants.Map_Block_Size % nb_block_height && x == ((5 * Constants.gap) / 4))
                y += Constants.Map_Block_Size + Constants.gap;
            stop_cpt++;
        }*/
        if (i < 18 )
        {
            if (x == 3)
            {

                y++;
                x=0;
            }
            else
                x++;

            this.i++;
        }
    }

    public void draw (Canvas canvas){
        canvas.drawBitmap(init_thread.bitmap, 0, 0, new Paint());
        canvas.drawBitmap(init_thread.bitmap, 110, 0, new Paint());
        canvas.drawBitmap(init_thread.bitmap, 220, 0, new Paint());
        canvas.drawBitmap(init_thread.bitmap, 330, 0, new Paint());

        canvas.drawBitmap(init_thread.bitmap, 0, 120, new Paint());
        canvas.drawBitmap(init_thread.bitmap, 110, 120, new Paint());
        canvas.drawBitmap(init_thread.bitmap, 220, 120, new Paint());
        canvas.drawBitmap(init_thread.bitmap, 330, 120, new Paint());

        canvas.drawBitmap(init_thread.bitmap, 0, 240, new Paint());
        canvas.drawBitmap(init_thread.bitmap, 110, 240, new Paint());
        canvas.drawBitmap(init_thread.bitmap, 220, 240, new Paint());
        canvas.drawBitmap(init_thread.bitmap, 330, 240, new Paint());

        canvas.drawBitmap(init_thread.bitmap, 0, 360, new Paint());
        canvas.drawBitmap(init_thread.bitmap, 110, 360, new Paint());
        canvas.drawBitmap(init_thread.bitmap, 220, 360, new Paint());
        canvas.drawBitmap(init_thread.bitmap, 330, 360, new Paint());

        canvas.drawBitmap(init_thread.bitmap, 0, 480, new Paint());
        canvas.drawBitmap(init_thread.bitmap, 110, 480, new Paint());
        canvas.drawBitmap(init_thread.bitmap, 220, 480, new Paint());
        canvas.drawBitmap(init_thread.bitmap, 330, 480, new Paint());

        canvas.drawBitmap(init_thread.bitmap, 0, 600, new Paint());
        canvas.drawBitmap(init_thread.bitmap, 110, 600, new Paint());
        canvas.drawBitmap(init_thread.bitmap, 220, 600, new Paint());
        canvas.drawBitmap(init_thread.bitmap, 330, 600, new Paint());
    }
}
