package com.example.rarora9.loading;

/**
 * Created by iain on 2/24/15.
 */
import android.graphics.Paint;

import static android.graphics.Color.RED;

public class Triangle {

    private Paint paint;

    {
        paint = new Paint();
    }

    public Triangle(){
        paint.setColor(RED);
    }

    public Triangle(Paint pai){
        paint = pai;
    }

    public Paint getPaint(){
        return paint;
    }


}
