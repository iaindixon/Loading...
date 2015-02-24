package com.example.rarora9.loading;

/**
 * Created by iain on 2/24/15.
 */
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import static android.graphics.Color.RED;

public class Triangle {

    private Paint paint;
    private Point one = new Point();
    private Point two = new Point();
    private Point three = new Point();


    {
        paint = new Paint();

    }

    //Default Constructor
    public Triangle(){
        paint.setColor(RED);
    }

//    public Triangle(Color col) {paint.setColor(Color.col);}

    //Setter Methods
    public void setTriangle(Paint pai){
        this.paint = pai;
    }
    public void setOne(Point one) {
        this.one = one;
    }
    public void setTwo(Point two) {
        this.two = two;
    }
    public void setThree(Point three) {
        this.three = three;
    }

    //Getter Methods
    public Paint getPaint(){
        return paint;
    }
    public Point getOne() {
        return one;
    }
    public Point getTwo() {
        return two;
    }
    public Point getThree() {
        return three;
    }
}
