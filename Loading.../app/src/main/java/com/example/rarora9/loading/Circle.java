package com.example.rarora9.loading;
/**
 * Created by iain on 2/20/15.
 */
import android.graphics.Paint;
import static android.graphics.Color.BLUE;
import java.util.Random;

public class Circle {

    //Local Variables
    private int xCoord;
    private int yCoord;
    private int radius;

    //Objects
    private Paint paint = new Paint();
    private Random randWidth = new Random();
    private Random randHeight = new Random();

    //Default Constructor
    public Circle(){
        xCoord = randWidth.nextInt(MainActivity.width-50);
//        xCoord = 100;
        yCoord = randHeight.nextInt(MainActivity.height-50);
//        yCoord = 100;
        radius = 50;
        paint.setColor(BLUE);
    }

    //Constructor
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

    //Setter Methods
    public void setxCoord(int xCo) { this.xCoord = xCo; }
    public void setyCoord(int yCo) { this.yCoord = yCo; }
    public void setRadius(int rad) { this.radius = rad; }
}

//
//Circle[] circle = new Circle[10];
//
//for(int i = 0; i < 10; i++) {
//    circle[i] = new Circle();
//    canvas.drawCircle(circle[i].getXCoord(),circle[i].getyCoord(),circle[i].getRadius(),circle[i].getPaint());
//}