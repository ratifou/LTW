import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.example.hugo.test.Constants;
import com.example.hugo.test.GameLoop;

public class Working extends Thread {
    private SurfaceHolder surfaceHolder;
    private GameLoop gameLoop;
    private Canvas canvas;
    private boolean running = false;
    private static int MAX_FPS = 30;

    long frameTime;
    long sleepTime;
    long targetTime = 1000 / Constants.MAX_FPS;

    public Working(SurfaceHolder sf, GameLoop gl){
        super();
        this.surfaceHolder = sf;
        this.gameLoop = gl;
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
