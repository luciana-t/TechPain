package com.luciana.techpain;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;


public class Body1 extends View {

        public LayoutParams params;
        private CustomPath path = new CustomPath();
        private Paint brush = new Paint();
        public Mirror mirror;
        int gender, side, imagemGS;
        //public Canvas canva = new Canvas();

        public Body1(Context context) {
            super(context);

            brush.setAntiAlias(true);
            brush.setColor(Color.BLUE);
            brush.setStyle(Paint.Style.STROKE);
            brush.setStrokeJoin(Paint.Join.ROUND);
            brush.setStrokeWidth(8f);
            mirror = new Mirror();
            gender = 1; //mulher = 1, homem = 0      //devem receber do bd.
            side = 10; // frente = 10, tras = 0
            imagemGS = gender + side;

            params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            switch (imagemGS){
                case 0: // homem tras
                    setBackground(ContextCompat.getDrawable(context, R.drawable.maleback));
                case 1: // mulher tras
                    setBackground(ContextCompat.getDrawable(context, R.drawable.maleback));
                case 10: // homem frente
                    setBackground(ContextCompat.getDrawable(context, R.drawable.malefront));
                case 11: // mulher frente
                    setBackground(ContextCompat.getDrawable(context, R.drawable.female));
            }
        }


        public void reset(){
            mirror = new Mirror();
            invalidate();
            path.rewind();
        }
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float pointX = event.getX();
            float pointY = event.getY();


            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(pointX, pointY);
                    return true;
                case MotionEvent.ACTION_MOVE:
                    path.lineTo(pointX, pointY);
                    break;
                default:
                    return false;
            }
            postInvalidate();
            return false;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawPath(path, brush);
        }


    }
