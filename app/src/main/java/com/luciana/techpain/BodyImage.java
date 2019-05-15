package com.luciana.techpain;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class BodyImage extends ImageView {


    public BodyImage(Context context) {
        super(context);
    }
    public class BoardView extends ImageView
    {
        public BoardView(Context context)
        {
            super(context);
        }

        protected void onDraw(Canvas canvas)
        {
            Paint paint = new Paint();
            setImageResource(R.drawable.board);
            paint.setColor(Color.BLUE);
            canvas.drawText(x.getName(), x.getX(), x.getY(), paint);
        }
    }
}
