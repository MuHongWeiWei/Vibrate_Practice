package com.fly.vibratetest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setTitle("計數器");

        TextView tvVibrate = findViewById(R.id.tv_vibrate);
        final TextView tvCount = findViewById(R.id.tv_count);
        TextView btnPlus = findViewById(R.id.btn_plus);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvCount.setText(String.valueOf(++count));
            }
        });


        tvCount.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                tvCount.setText("0");
                count = 0;
                return true;
            }
        });


        tvVibrate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    vibrator.vibrate(5000);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    vibrator.cancel();
                }
                return true;
            }
        });
    }
}
