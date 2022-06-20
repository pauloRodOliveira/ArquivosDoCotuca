package com.example.desenho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtAcao, txtForma;
    private FrameLayout main;
    private Button btnApagar, btnQuadrado, btnBola, btnOval, btnReta, btnAzul, btnVerde, btnVermelho;
    private int escolha;
    private boolean estadoApagar = false;
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Botão para apagar;
        btnApagar = findViewById(R.id.btnApagar);

        //Botões para escolher a cor do desenho:
        btnAzul = findViewById(R.id.btnAzul);
        btnVerde = findViewById(R.id.btnVerde);
        btnVermelho = findViewById(R.id.btnVermelho);

        //Botões para escolher a forma do desenho
        btnQuadrado = findViewById(R.id.btnQuadrado);
        btnBola   = findViewById(R.id.btnBola);
        btnOval = findViewById(R.id.btnOval);
        btnReta = findViewById(R.id.btnReta);

        //Textos que indicam a ação ("Pintar" ou "Apagar") e a forma do do desenho
        txtForma = findViewById(R.id.forma);
        txtAcao = findViewById(R.id.acao);

        //Obtendo o id da view
        main = findViewById(R.id.frameLayout);

        //Botões para escolher a cor
        btnAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPaint.setColor(0x000FF);
            }
        });

        btnVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPaint.setColor(0xFF5bFAA0);
            }
        });

        btnVermelho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPaint.setColor(0xFF0000);
            }
        });

        //Botões para escolher a forma
        btnQuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escolha = 0;
                txtForma.setText("Quadrado");
            }
        });

        btnBola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escolha = 1;
                txtForma.setText("Bola");
            }
        });

        btnOval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escolha = 2;
                txtForma.setText("Oval");
            }
        });

        btnReta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escolha = 3;
                txtForma.setText("Reta");
            }
        });

        //Botão que apaga todas as formas desenhadas de acordo com o número da escolha
        btnApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!estadoApagar) {
                    estadoApagar = true;
                    txtAcao.setText("Apagar");
                    if(main.getChildCount() > 0){
                        for (int i = main.getChildCount(); i>=0; i--){
                            View vi = main.getChildAt(i);
                            if (vi instanceof Bola && escolha == 1){
                                main.removeViewAt(i);
                            }
                            if (vi instanceof Quadrado && escolha == 0){
                                main.removeViewAt(i);
                            }
                            if (vi instanceof Oval && escolha == 2){
                                main.removeViewAt(i);
                            }
                            if (vi instanceof Reta && escolha == 3){
                                main.removeViewAt(i);
                            }
                        }
                    }
                }
                if(estadoApagar){
                    estadoApagar = false;
                    txtAcao.setText("Pintar");
                }
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                switch (escolha){
                    case 0:
                        main.addView(new Quadrado(this,
                                event.getX(),
                                event.getY(), mPaint));
                    break;
                    case 1:
                        main.addView(new Bola(this,
                                event.getX(),
                                event.getY(),
                                40, mPaint));
                        break;
                    case 2:
                        main.addView(new Oval(this,
                                event.getX(),
                                event.getY(), mPaint));
                        break;
                    case 3:
                        main.addView(new Reta(this,
                                event.getX(),
                                event.getY(), mPaint));
                        break;
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                return true;
        }

        return true;
    }
}