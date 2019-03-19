package com.example.bouncingball;

import android.app.Activity;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.TextView;


public class MainActivity extends Activity {
    int w ;
    int h ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        w = size.x;
        h= size.y;
        Thread t = new Thread(new ClockThread(new Handler()));
        t.start();
    }

    class ClockThread implements Runnable {
        private Handler handler;

        public ClockThread(Handler h) {
            handler = h;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ball.repaint(w,h);
                        }
                    });
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch b
                }
            }
        }
    }
}
