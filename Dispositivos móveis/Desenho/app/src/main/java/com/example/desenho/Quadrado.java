package com.example.desenho;

/*
*  Criado por SLMM em 14/06/22
* */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class Quadrado extends View {

    private final float x;
    private final float y;
    private final Paint mPaint;

    public Quadrado(Context context, float x, float y, Paint mPaint) {
        super(context);
        this.x = x;
        this.y = y;
        this.mPaint = mPaint;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        //Desenha um quadrado
        canvas.drawRect(this.x, this.y, this.x+100, this.y+100, mPaint);

    }
}
