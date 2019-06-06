package com.luciana.techpain;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;


public class Body1 extends View {


    public LayoutParams params;
    private CustomPath path = new CustomPath();
    private Paint brush = new Paint();
    public Mirror mirror;
    int gender, imagemGS;
    Button btn_lado;
    //public Canvas canva = new Canvas();

    public Body1(Context context, int lado) {
        super(context);

        brush.setAntiAlias(true);
        brush.setColor(Color.BLUE);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(8f);
        mirror = new Mirror();
       // gender = DataBase.getInstance().paciente.gender; //mulher = 1, homem = 2 //lado 1 = frente --- lado 2 = tras
        gender = 1;
        imagemGS = gender + lado;
        btn_lado = (Button) findViewById(R.id.btn_lado);

        params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        if (lado == 1 && gender == 1){ //lado 1 = frente // gender 1 = mulher
            setBackground(ContextCompat.getDrawable(context, R.drawable.female));
            Log.i("BODY1", "switch mulher frente");
        } else if (lado == 2 && gender == 1){ // lado 1 = tras // gender 1 = mulher
            setBackground(ContextCompat.getDrawable(context, R.drawable.maleback));
            Log.i("BODY1", "switch mulher tras");
        } else if (lado == 1 && gender == 2){ // lado 1 = frente // gender 2 = homem
            setBackground(ContextCompat.getDrawable(context, R.drawable.malefront));
            Log.i("BODY1", "switch homem frente");
        } else { // lado 2 = tras // gender 2 = homem
            setBackground(ContextCompat.getDrawable(context, R.drawable.maleback));
            Log.i("BODY1", "switch homem tras");
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
