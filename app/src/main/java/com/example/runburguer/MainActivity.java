package com.example.runburguer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar bProgreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relaciona();
        bProgreso.setVisibility(View.VISIBLE);




        Toast.makeText(getApplicationContext(),"PASA A MENÚ PRINCIPAL", Toast.LENGTH_SHORT).show();


        Thread logo = new Thread(){

            public void run(){
                try{
                    int tiempo=0;
                    while(tiempo<5000){
                        sleep(100);
                        tiempo=tiempo+100;
                    }
                    Intent i=new Intent(MainActivity.this, Login.class);
                    startActivity(i);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    finish();
                }
            }
        };

        logo.start();

    }

    private void relaciona(){
        bProgreso = findViewById(R.id.cargainicio);
    }

    }
