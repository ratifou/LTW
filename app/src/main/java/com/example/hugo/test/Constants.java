package com.example.hugo.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;

import java.util.ArrayList;

/**
 * Created by hugo on 03/10/2016.
 */

public class Constants {
    public static int SCREEN_HEIGHT;
    public static int SCREEN_WIDTH;
    public static Context CURRENT_CONTEXT;
    public static int Map_Block_Size;
    public static int gap = 6;
    public static int MAX_FPS = 25;
    public static Bitmap map_case;
    public static ArrayList<Bitmap> idlemaps = new ArrayList<>();
    public static ArrayList<Bitmap> walk1maps = new ArrayList<>();
    public static ArrayList<Bitmap> walk2maps = new ArrayList<>();
    public static ArrayList<Bitmap> tower_1 = new ArrayList<>();
    public static ArrayList<Bitmap> tower_2 = new ArrayList<>();
    public static ArrayList<Bitmap> tower_3 = new ArrayList<>();
}
