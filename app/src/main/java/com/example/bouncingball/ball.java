package com.example.bouncingball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;

import static java.lang.String.valueOf;

public class ball extends View {
    Paint p;
    static int x=60;
    static int y=60;
    static int vel_x = 5;
    static int vel_y = 5;

    public ball(Context context, AttributeSet attrs) {
        super(context, attrs);
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        p.setTextSize(80);
        canvas.drawText("DVD",x,y,p);
        invalidate();
    }

    public static void repaint(int w, int h) {
        x += vel_x;
        y += vel_y;
        if (x < 0 || x > w-85) {
            vel_x = - vel_x;
        }
        if (y < 0 || y > h-42) {
            vel_y = -vel_y;

        }
    }
}



