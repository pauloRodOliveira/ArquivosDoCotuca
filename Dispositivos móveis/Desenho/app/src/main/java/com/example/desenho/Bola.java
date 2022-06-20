package com.example.desenho;

/*
*  Criado por SLMM em 14/06/22
* */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Bola extends View {

    private final float x;
    private final float y;
    private final int r;
    private final Paint mPaint;

    public Bola(Context context, float x, float y, int r, Paint mPaint) {
        super(context);
        this.x = x;
        this.y = y;
        this.r = r;
        this.mPaint = mPaint;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        //Desenha um circulo
        canvas.drawCircle(x,y,r,mPaint);

    }
}
