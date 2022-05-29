package com.example.runburguer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.KeyEvent;

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


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==event.KEYCODE_BACK){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to exit?")
                    .setPositiveButton("si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent (Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        }
                    })
            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.dismiss();
                }
            });
            builder.show();
        }
        return super.onKeyDown(keyCode, event);

    }
}
