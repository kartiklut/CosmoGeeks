package com.example.cosmologygeeks;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ArrangeActivity extends AppCompatActivity {

    private ViewGroup mainLayout;
    private ImageView image,image1,image2,image3,image4,image5,image6,image7,image8;
    private Button button;
    ImageView img;
    private int xDelta;
    private int yDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrange);
        mainLayout = (RelativeLayout) findViewById(R.id.main);
        image = (ImageView) findViewById(R.id.image);
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        image5 = (ImageView) findViewById(R.id.image5);
        image6 = (ImageView) findViewById(R.id.image6);
        image7 = (ImageView) findViewById(R.id.image7);
        image8 = (ImageView) findViewById(R.id.image8);
        button=findViewById(R.id.b1);
        final ImageView img=(ImageView)findViewById(R.id.img1);

        image.setOnTouchListener(onTouchListener());
        image1.setOnTouchListener(onTouchListener());
        image2.setOnTouchListener(onTouchListener());
        image3.setOnTouchListener(onTouchListener());
        image4.setOnTouchListener(onTouchListener());
        image5.setOnTouchListener(onTouchListener());
        image6.setOnTouchListener(onTouchListener());
        image7.setOnTouchListener(onTouchListener());
        image8.setOnTouchListener(onTouchListener());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ArrangeActivity.this, "Better Try Again!!", Toast.LENGTH_SHORT).show();
                img.setBackgroundResource(R.drawable.solvedsystem);
            }
        });
    }

    private View.OnTouchListener onTouchListener() {
        return new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;
                        break;

                    case MotionEvent.ACTION_UP:
                        Toast.makeText(ArrangeActivity.this,
                                "Good!!", Toast.LENGTH_SHORT)
                                .show();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                                .getLayoutParams();
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;
                        view.setLayoutParams(layoutParams);
                        break;
                }

                mainLayout.invalidate();
                return true;
            }
        };

    }
}
