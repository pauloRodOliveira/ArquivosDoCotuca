package com.example.desenho;

/*
*  Criado por SLMM em 14/06/22
* */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Oval extends View {

    private final float x;
    private final float y;
    private final Paint mPaint;

    public Oval(Context context, float x, float y, Paint mPaint) {
        super(context);
        this.x = x;
        this.y = y;
        this.mPaint = mPaint;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        //Desenha uma forma oval
        canvas.drawOval(x, y, x+100, y+60, mPaint);
    }
}
