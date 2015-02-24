package com.example.rarora9.loading;

/**
 * Created by rarora9 on 2/24/15.
 */

import android.graphics.Color;
import android.graphics.Paint;
import java.util.Random;

public class Square {

    private int left;
    private int top;
    private int right;
    private int bottom;
    private Paint paint;
    private Random random = new Random();

    public Square() {
        int spawnSide = random.nextInt(4);

        if(spawnSide == 0) {

        } else if(spawnSide == 1) {

        } else if(spawnSide == 2) {

        } else if (spawnSide == 3) {

        }
        
        left = 0;
        top = 0;
        right = 10;
        bottom = 10;
        paint = new Paint();
        paint.setColor(Color.GREEN);
    }

    public Square(int l, int t, int r, int b, Paint p) {
        left = l;
        top = t;
        right = r;
        bottom = b;
        paint = p;
    }

    public int getLeft() {
        return left;
    }

    public int getTop() {
        return top;
    }

    public int getRight() {
        return right;
    }

    public int getBottom() {
        return bottom;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setLeft(int l) {
        left = l;
    }

    public void setTop(int t) {
        top = t;
    }

    public void setRight(int r) {
        right = r;
    }

    public void setBottom(int b) {
        bottom = b;
    }

    public void setPaint(Paint p) {
        paint = p;
    }
}
