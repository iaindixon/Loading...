package com.example.rarora9.loading; /**
 * Created by iain on 2/20/15.
 */
import android.graphics.Color;

public class Circle {

    private int xCoord;
    private int yCoord;
    private int radius;
    private int color;

    public Circle(){
        xCoord = 0;
        yCoord = 0;
        radius = 0;
        color = Color.GREEN;
    }

    public Circle(int x, int y, int rad, int col){
        xCoord = x;
        yCoord = y;
        radius = rad;
        color = col;
    }

    public int getXCoord(){
        return xCoord;
    }

    public int getyCoord(){
        return yCoord;
    }

    public int getRadius(){
        return radius;
    }

    public int getColor(){
        return color;
    }


}
