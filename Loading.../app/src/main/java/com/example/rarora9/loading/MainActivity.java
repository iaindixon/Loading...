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

            super.draw(canvas, mapView, true);

            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

            paint.setStrokeWidth(2);
            paint.setColor(android.graphics.Color.RED);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setAntiAlias(true);

            Point point1_draw = new Point();
            Point point2_draw = new Point();
            Point point3_draw = new Point();

            mapView.getProjection().toPixels(point1, point1_draw);
            mapView.getProjection().toPixels(point2, point2_draw);
            mapView.getProjection().toPixels(point3, point3_draw);

            Path path = new Path();
            path.setFillType(Path.FillType.EVEN_ODD);
            path.moveTo(point1_draw.x,point1_draw.y);
            path.lineTo(point2_draw.x,point2_draw.y);
            path.lineTo(point3_draw.x,point3_draw.y);
            path.lineTo(point1_draw.x,point1_draw.y);
            path.close();

            canvas.drawPath(path, paint);

//canvas.drawLine(point1_draw.x,point1_draw.y,point2_draw.x,point2_draw.y, paint);

            return true;

            if(won) {
                paint.setTextSize(100);
                paint.setTextAlign(Paint.Align.CENTER);
                canvas.drawText("You Won!", width/2, height/4, paint);
            }
        }
    }
}