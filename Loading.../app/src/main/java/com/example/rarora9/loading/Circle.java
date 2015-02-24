package com.example.rarora9.loading; /**
 * Created by iain on 2/20/15.
 */
import android.graphics.Paint;
import static android.graphics.Color.BLUE;

public class Circle {

    private int xCoord;
    private int yCoord;
    private int radius;
    private Paint paint;

    {
        paint = new Paint();
    }

    public Circle(){
        xCoord = 100;
        yCoord = 100;
        radius = 50;
        paint.setColor(BLUE);
    }

    public Circle(int x, int y, int rad, Paint pai){
        xCoord = x;
        yCoord = y;
        radius = rad;
        paint = pai;
    }

    //Getter Methods
    public int getXCoord(){
        return xCoord;
    }
    public int getyCoord(){
        return yCoord;
    }
    public int getRadius(){
        return radius;
    }
    public Paint getPaint(){
        return paint;
    }


}
