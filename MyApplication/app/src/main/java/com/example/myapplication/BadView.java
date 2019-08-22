package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class BadView extends View {
    private static final String TAG = "BadView";

    public static final float NO_TOUCH = -1;


    public static final float startX = 100;
    public static final float startY = 100;
    public static volatile float eventX = NO_TOUCH;
    public static volatile float eventY = NO_TOUCH;
    static Path sPath = new Path();
    static Paint sPaint = new Paint();


    public BadView(Context context) {
        super(context);
    }

    public BadView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void clear() {
        eventX = NO_TOUCH;
        eventY = NO_TOUCH;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        paint.setStrokeJoin(Paint.Join.MITER);
//        Path path=new Path();
//        path.moveTo(100,100);
//        path.lineTo(300,100);
//        path.lineTo(100,300);
//        canvas.drawPath(path,paint);
        if (eventX == NO_TOUCH || eventY == NO_TOUCH) {
            sPath = new Path();
            sPaint.reset();
            sPaint.setStrokeWidth(50);
            sPaint.setTextSize(200);
            sPaint.setColor(Color.RED);
            canvas.drawText("使用画笔", startX, startY + 100, sPaint);
        } else {
            sPaint.reset();
            sPaint.setStrokeWidth(50);
            sPaint.setStyle(Paint.Style.STROKE);
            sPaint.setStrokeCap(Paint.Cap.ROUND);
            sPaint.setColor(Color.RED);
            canvas.drawPath(sPath, sPaint);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        eventX = event.getX();
        eventY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                sPath.moveTo(eventX, eventY);
                sPath.lineTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_MOVE:
                sPath.lineTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_UP:
//                eventX = NO_TOUCH;
//                eventY = NO_TOUCH;
//                break;
        }
//        Log.d(TAG, "onTouchEvent: "+"eventX="+eventX+" eventY="+eventY);
        invalidate();
        return true;
    }
}
