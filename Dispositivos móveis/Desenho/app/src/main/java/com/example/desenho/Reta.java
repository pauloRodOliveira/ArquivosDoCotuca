package com.example.desenho;

/*
*  Criado por SLMM em 14/06/22
* */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Reta extends View {

    private final float x;
    private final float y;
    private final Paint mPaint;

    public Reta(Context context, float x, float y, Paint mPaint) {
        super(context);
        this.x = x;
        this.y = y;
        this.mPaint = mPaint;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        //Desenhando uma reta que começa onde o usuário clicou
        canvas.drawLine(x, y, x+100, y, mPaint);

    }
}
