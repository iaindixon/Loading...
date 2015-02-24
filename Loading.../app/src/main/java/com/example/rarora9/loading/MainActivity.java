package com.example.rarora9.loading;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    int width, height;
    int loadWidth = 0, numMilliseconds = 0;
    boolean won = false;

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