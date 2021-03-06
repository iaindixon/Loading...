package com.example.rarora9.loading;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    static int width, height;
    int loadWidth = 0, numMilliseconds = 0;
    boolean won = false;
    boolean enemiesSetUp = false;
    Square[] squares = new Square[25];
    Random random = new Random();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = new MyView(this);
        setContentView(view);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(width != 0) {
                    if ((numMilliseconds % 100) == 0 && loadWidth <= width) {
                        loadWidth += (width / 100);
                    } else if (loadWidth >= width) {
                        won = true;
                    }
                }

                view.postInvalidate();
                numMilliseconds++;
            }
        }, 0, 1);
    }

    public class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            width = canvas.getWidth();
            height = canvas.getHeight();
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            canvas.drawPaint(paint);

            if(!enemiesSetUp) {
                for(int i = 0; i < 25; i++) {
                    squares[i] = new Square();
                }

                enemiesSetUp = true;
            } else {
                for(int i = 0; i < 25; i++) {
                    int direction = random.nextInt(4);

                    if(direction == 0) { //move left
                        squares[i].setLeft(squares[i].getLeft() - 10);
                        squares[i].setRight(squares[i].getRight() - 10);
                    } else if(direction == 1) { //move up
                        squares[i].setTop(squares[i].getTop() - 10);
                        squares[i].setBottom(squares[i].getBottom() - 10);
                    } else if(direction == 2) { //move right
                        squares[i].setLeft(squares[i].getLeft() + 10);
                        squares[i].setRight(squares[i].getRight() + 10);
                    } else if(direction == 3) { //move down
                        squares[i].setTop(squares[i].getTop() + 10);
                        squares[i].setBottom(squares[i].getBottom() + 10);
                    }

                    canvas.drawRect(squares[i].getLeft(), squares[i].getTop(), squares[i].getRight(), squares[i].getBottom(), squares[i].getPaint());
                }
            }

            paint.setColor(Color.LTGRAY);
            canvas.drawRect(0, 0, width, height/20, paint);
            paint.setColor(Color.GREEN);
            canvas.drawRect(0, 0, loadWidth, height/20, paint);
            paint.setColor(Color.WHITE);
            canvas.drawCircle(width/2, height/2, width/20, paint);

            if(won) {
                paint.setTextSize(100);
                paint.setTextAlign(Paint.Align.CENTER);
                canvas.drawText("You Won!", width/2, height/4, paint);
            }
        }
    }
}