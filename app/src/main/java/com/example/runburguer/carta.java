package com.example.runburguer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class carta extends AppCompatActivity {
    TextView muestra;
    String nombre, apellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta);
        muestra =(TextView) findViewById(R.id.nusu2);
        nombre = getIntent().getExtras().getString("nombre");
        apellido = getIntent().getExtras().getString("apellido");
        muestra.setText(""+nombre+" "+apellido);

    }
}