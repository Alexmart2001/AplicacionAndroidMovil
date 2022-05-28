package com.example.runburguer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Reservas extends AppCompatActivity {
Button volvo;
    TextView muestra;
    String nombre, apellido;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);
    muestra =(TextView) findViewById(R.id.nusu2);
    nombre = getIntent().getExtras().getString("nombre");
    apellido = getIntent().getExtras().getString("apellido");
    muestra.setText(""+nombre+" "+apellido);


        volvo = findViewById(R.id.button2);
        volvo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent volv = new Intent(Reservas.this, MenuPrincipal.class);
            startActivity(volv);
            Toast.makeText(getApplicationContext(),"PASA A MENU PRINCIPAL", Toast.LENGTH_SHORT).show();
        }
    });

    }
}