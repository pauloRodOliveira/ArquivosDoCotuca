package com.example.findyourself;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.findyourself.classes.HttpsTrustManager;
import com.example.findyourself.classes.Logradouro;
import com.example.findyourself.classes.UsuarioWS;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        textView = findViewById(R.id.text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            HttpsTrustManager.allowAllSSL();
                            Logradouro logradouro = (Logradouro) UsuarioWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", "13069526");
                            textView.setText(logradouro.toString());
                        }catch (Exception e){
                            System.err.println(e.getMessage());
                        }
                    }
                });
            }
        });
    }
}